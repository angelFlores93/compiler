package CodeGeneration;

import java.util.HashMap;
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
import visitor.AbstractVisitor;

public class Instructions extends AbstractVisitor{
	private Direction dir = new Direction();
	private Value val = new Value(dir);
	private int pointer = 0; 
	private Map<String,String> map = new HashMap<String, String>();
	private boolean global = true;
	private int globalSize; 
	private int labelIndex = 0; 
	private int whileIndex = 0; 
	private int ifIndex = 0; 
	public Instructions(){
		map.put("+", "add");
		map.put("-", "sub");
		map.put("*", "mul");
		map.put("/", "div");
		map.put("%", "rem");
		map.put("<", "if_cmplt");
		map.put("<=", "if_cmple");
		map.put(">=", "if_cmpge");
		map.put(">", "if_cmpgt");
		map.put("!=", "if_cmpeq");
		map.put("==", "if_cmpne");
	}
	public static void out(String text){
		System.out.println(text);
	}
	public Object visit(Program program, Object param) {
		//System.out.println (program.toString());
		out(".class public simple\n.super java/lang/Object\n.method public <init>()V\naload_0\ninvokespecial java/lang/Object/<init>()V"
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
		
		return null;
	}
	
	@Override
	public Object visit(InstructionAsignation instructionAsignation,
			Object param) {
		//System.out.println(instructionAsignation.toString());
		out(";Line " + instructionAsignation.getLine());
		instructionAsignation.getLeft().accept(dir, param);
		instructionAsignation.getRight().accept(val, param);
		out(instructionAsignation.getLeft().getType().getPrefix() + "store " + ((RegularExpressionVariable)instructionAsignation.getLeft()).getDirection());
		return null;
	}
	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		//System.out.println(instructionDefinition.toString());
		
		instructionDefinition.getType().accept(this, null);
		if (instructionDefinition.getName() != null){
			instructionDefinition.getName().accept(this, null);
			
				((RegularExpressionVariable)instructionDefinition.getName()).setDirection(pointer);
				pointer = pointer +1;
		}
		if (global){
			out(";Line: " +instructionDefinition.getLine());
			out (";Variable " +((RegularExpressionVariable)instructionDefinition.getName()).getName() + ": (direccion " +((RegularExpressionVariable) instructionDefinition.getName()).getDirection() + ")");
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
		out(instructionInput.getExpression().getType().getPrefix()+ "store " + ((RegularExpressionVariable)instructionInput.getExpression()).getDirection());
		return null;
	}
	@Override
	public Object visit(InstructionPrint instructionPrint, Object param) {
		//System.out.println (instructionPrint.toString());
		out (";Line: " + instructionPrint.getLine());
		instructionPrint.getExpression().accept(val, param); // load variable
		out("getstatic java/lang/System/out Ljava/io/PrintStream;"); 
		out("swap"); 
		out("invokevirtual java/io/PrintStream/println(I)V");
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
		//System.out.println(arithmeticExpression.toString());
		out(";Line: " + arithmeticExpression.getLine());
		arithmeticExpression.getLeft().accept(val, null); // load var
		arithmeticExpression.getRight().accept(val, null); // load var
		out(arithmeticExpression.getType().getPrefix() + map.get(arithmeticExpression.getOperation()));
		return null;
	}
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		//System.out.println(binaryExpression.toString());
		out(";Line: " + binaryExpression.getLine());
		binaryExpression.getLeft().accept(val, null); // load var
		
		if(binaryExpression.getRight() != null) 
			binaryExpression.getRight().accept(val, null); // load var
		binaryExpression.setLabel("be"+labelIndex++);
		out(map.get(binaryExpression.getOperation()) + " " +binaryExpression.getLabel());
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
		out(instructionIf.getCondition().getLabel() + ":");
		for (Instruction inst : instructionIf.getInstructionsIf()){
			if (inst != null)
				inst.accept(this, param);
		}
		return null;
	}
	@Override
	public Object visit(InstructionWhile instructionWhile, Object param) {
		//System.out.println (instructionWhile.toString());
		out(";Line: "+instructionWhile.getLine());
		out("while_label" + whileIndex++);
		instructionWhile.getCondition().accept(val, param);
		out ("goto label" + whileIndex);
		out (instructionWhile.getCondition().getLabel() + ":");
		for (Instruction inst : instructionWhile.getInstructions()){
			inst.accept(this, param);
			out("goto label" + (whileIndex-1));
		}
		out("label"+whileIndex + ":");
		
		return null;
	}
	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionFunctionRef regularExpressionFunctionRef, Object param) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CastExpression castExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
