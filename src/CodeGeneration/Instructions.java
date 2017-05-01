package CodeGeneration;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import asttree.ArithmeticExpression;
import asttree.BinaryExpression;
import asttree.CastExpression;
import asttree.Expression;
import asttree.Function;
import asttree.Instruction;
import asttree.InstructionAsignation;
import asttree.InstructionDefinition;
import asttree.InstructionIf;
import asttree.InstructionInput;
import asttree.InstructionPrint;
import asttree.InstructionReturn;
import asttree.InstructionWhile;
import asttree.Program;
import asttree.RegularExpression;
import asttree.RegularExpressionArrayRef;
import asttree.RegularExpressionFunctionRef;
import asttree.RegularExpressionInt;
import asttree.RegularExpressionLetter;
import asttree.RegularExpressionMatrixRef;
import asttree.RegularExpressionReal;
import asttree.RegularExpressionStructRef;
import asttree.RegularExpressionVariable;
import asttree.TypeFunction;
import asttree.TypeNormal;
import asttree.TypeSpecialArray;
import visitor.AbstractVisitor;

public class Instructions extends AbstractVisitor{
	private Direction dir = new Direction();
	private Value val = new Value(dir);
	private int pointer = 0; 
	public static Map<String,String> map = new HashMap<String, String>();
	public static Map<String,Integer> vars= new HashMap<String, Integer>();
	private boolean global = true;
	private int globalSize; 
	private int endLabel = 0; 
	private int whileIndex = 0; 
	private int ifIndex = 0; 
	private static PrintWriter outFile; 
	public static String OUTPUT_NAME = "compiler";
	
	public Instructions(Writer outFile){
		map.put("+", "add");
		map.put("-", "sub");
		map.put("*", "mul");
		map.put("/", "div");
		map.put("%", "rem");
		map.put("<", "if_icmplt");
		map.put("<=", "if_icmple");
		map.put(">=", "if_icmpge");
		map.put(">", "if_icmpgt");
		map.put("!=", "if_icmpne");
		map.put("==", "if_icmpeq");
		this.outFile = new PrintWriter(outFile); 
		
	}
	public static void out(String text){
		System.out.println(text);
		outFile.println(text);
	}
	
	@Override
	public Object visit(Program program, Object param) {
		//System.out.println (program.toString());
		out(".class public "+OUTPUT_NAME+"\n.super java/lang/Object\n.method public <init>()V\naload_0\ninvokespecial java/lang/Object/<init>()V"
				+"\nreturn\n.end method\n");
		
		for (InstructionDefinition defs : program.getDefinitions()){
			defs.accept(this, null);
		}
		global = false;
		globalSize = pointer;
		for (Function funcs : program.getFunctions()){
			funcs.accept(this, null);
		}
		out(".method public static main([Ljava/lang/String;)V\n.limit stack 5\n.limit locals 100\n");
		for (Instruction inst : program.getInstructions()){
			inst.accept(this, null);
		}
		out("return\n.end method");
		Iterator it = vars.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.err.println(pair.getKey() + " -> " + pair.getValue());
			it.remove();
		}
		it = map.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.err.println(pair.getKey() + " -> " + pair.getValue());
			it.remove();
		}
		return null;
	}
	@Override
	public Object visit(Function function, Object param) {
		//System.out.println(function.toString());
		function.getDefinition().accept(this, null);
		if (!function.getDefinitions().isEmpty())
			for(InstructionDefinition inst : function.getDefinitions()){
				inst.accept(this, null);
			}
		out(".method public static " + ((RegularExpressionVariable)function.getDefinition().getName()).getName() + "()"+((TypeFunction)function.getType()).getType().getPrintType() );
		out (".limit locals 10");
		out (".limit stack 10");
		if (!function.getInstructions().isEmpty())
			for(Instruction inst : function.getInstructions()){
				inst.accept(this, null);
			}
		
		function.getReturnStm().accept(this, param);
		out(".end method");
		return null;
	}
	@Override
	public Object visit(InstructionAsignation instructionAsignation,
			Object param) {
		//System.out.println(instructionAsignation.toString());
		out(";Line " + instructionAsignation.getLine());
		
		String s = (String)instructionAsignation.getLeft().accept(dir, param);
		
		instructionAsignation.getRight().accept(val, param);
		
		out(instructionAsignation.getLeft().getType().getPrefix() + "store " + vars.get(((RegularExpressionVariable)instructionAsignation.getLeft()).getName()));
		
		
		return null;
	}
	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		//System.out.println(instructionDefinition.toString());
		
		instructionDefinition.getType().accept(this, null);
		if (instructionDefinition.getName() != null){
			instructionDefinition.getName().accept(this, null);
			if (instructionDefinition.getName().getType() instanceof TypeSpecialArray){
				for (int i = 0; i < ((TypeSpecialArray)instructionDefinition.getName().getType()).getSize(); i++){
					vars.put(((RegularExpressionVariable)instructionDefinition.getName()).getName()+i, pointer++);
				}
			}else{
				vars.put(((RegularExpressionVariable)instructionDefinition.getName()).getName(), pointer++);
			}
			
		}
		if (global){
			out(";Line: " +instructionDefinition.getLine());
			out (";Variable " +((RegularExpressionVariable)instructionDefinition.getName()).getName() + ": (direccion " + vars.get(((RegularExpressionVariable)instructionDefinition.getName()).getName()) + ")");
		}
		
		return null;
	}
	@Override
	public Object visit(InstructionInput instructionInput, Object param) {
		//System.out.println(instructionInput.toString());
		out (";Line: " + instructionInput.getLine());
		instructionInput.getExpression().accept(dir, param); // load variable
			
		out("getstatic java/lang/System/in Ljava/io/InputStream;");
        out("invokevirtual java/io/InputStream/read()I ");
        out("ldc 48");
        out("isub");
		out(instructionInput.getExpression().getType().getPrefix()+ "store " + vars.get(((RegularExpressionVariable)instructionInput.getExpression()).getName()));
		return null;
	}
	@Override
	public Object visit(InstructionPrint instructionPrint, Object param) {
		//System.out.println (instructionPrint.toString());
		out (";Line: " + instructionPrint.getLine());
		instructionPrint.getExpression().accept(val, param); // load variable
		out("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
		out("swap"); 
		out("invokevirtual java/io/PrintStream/println("+instructionPrint.getExpression().getType().getPrintType()+")V");
		return null;
	}
	@Override
	public Object visit(InstructionReturn instructionReturn, Object param) {
		//System.out.println (instructionReturn.toString());
		out (";Line: " + instructionReturn.getLine());
		instructionReturn.getExpression().accept(val, param); // load variable
		out(instructionReturn.getExpression().getType().getPrefix() + "return");
		return null;
	}
	@Override
	public Object visit(ArithmeticExpression arithmeticExpression,
			Object param) {
		return null;
	}
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		
		return null;
	}
	@Override
	public Object visit(InstructionIf instructionIf, Object param) {
		
		out(";Line: " + instructionIf.getLine());
		//System.out.println(instructionIf.toString());
		instructionIf.getCondition().accept(val, param);
		if (instructionIf.getInstructionsElse() != null){
			for (Instruction inst : instructionIf.getInstructionsElse()){
				if (inst != null)
					inst.accept(this, param);
			}
		}
		out("goto endLabel" + endLabel);
		out(instructionIf.getCondition().getLabel() + ":");
		for (Instruction inst : instructionIf.getInstructionsIf()){
			if (inst != null)
				inst.accept(this, param);
		}
		out("endLabel"+endLabel++ +":");
		return null;
	}
	@Override
	public Object visit(InstructionWhile instructionWhile, Object param) {
		//System.out.println (instructionWhile.toString());
		out(";Line: "+instructionWhile.getLine());
		out("while_label" + whileIndex++ + ":");
		instructionWhile.getCondition().accept(val, param);
		out ("goto while_label" + whileIndex);
		out (instructionWhile.getCondition().getLabel() + ":");
		for (Instruction inst : instructionWhile.getInstructions()){
			inst.accept(this, param);
			
		}
		out("goto while_label" + (whileIndex-1));
		out("while_label"+whileIndex + ":");
		
		return null;
	}
	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionFunctionRef regularExpressionFunctionRef, Object param) {
		out(regularExpressionFunctionRef.getType().toString());
		out("invokestatic " + OUTPUT_NAME + "." + (((RegularExpressionVariable)regularExpressionFunctionRef.getExpression()).getName()) + "()"); 
		regularExpressionFunctionRef.getExpression().accept(val, param);
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable, Object param) {
		return null;
	}
	@Override
	public Object visit(CastExpression castExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
