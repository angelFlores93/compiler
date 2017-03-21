package visitor;

import tablasimbolos.TablaSimbolos;
import asttree.ArithmeticExpression;
import asttree.BinaryExpression;
import asttree.CastExpression;
import asttree.Expression;
import asttree.Function;
import asttree.Instruction;
import asttree.InstructionDefinition;
import asttree.Program;
import asttree.RegularExpressionArrayRef;
import asttree.RegularExpressionFunctionRef;
import asttree.RegularExpressionInt;
import asttree.RegularExpressionLetter;
import asttree.RegularExpressionMatrixRef;
import asttree.RegularExpressionReal;
import asttree.RegularExpressionStructRef;
import asttree.RegularExpressionVariable;

public class VisitorIdentifier extends AbstractVisitor{
	private TablaSimbolos simbolos = TablaSimbolos.getTablaSimbolos();
	@Override 
	public Object visit(Program program, Object param) {
		super.visit(program, null);
		simbolos.print();
		simbolos.printLocal();
		return null;
		
	}
	@Override
	public Object visit(Function function, Object param) {
		simbolos.reset();
		simbolos.setAmbito(0);
		//System.out.println(function.toString());
		function.getDefinition().accept(this, null);
		simbolos.setAmbito(1);
		for(InstructionDefinition inst : function.getDefinitions()){
			inst.accept(this, null);
		}
		for(Instruction inst : function.getInstructions()){
			inst.accept(this, null);
		}
		simbolos.printLocal();
		simbolos.reset();
		return null;
	}
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		binaryExpression.getLeft().accept(this, null);
		if(binaryExpression.getRight() != null) 
			binaryExpression.getRight().accept(this, null);
		return null;
	}

	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef,
			Object param) {
		//System.out.println (regularExpressionArrayRef.toString());
		regularExpressionArrayRef.getExpression().accept(this, null);
		regularExpressionArrayRef.getIndex().accept(this, null);

		return null;
	}

	@Override
	public Object visit(
			RegularExpressionFunctionRef regularExpressionFunctionRef,
			Object param) {
		//System.out.println (regularExpressionFunctionRef.toString());
		regularExpressionFunctionRef.getExpression().accept(this, null);
		for (Expression defs : regularExpressionFunctionRef.getParameters()){
			
			defs.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		//System.out.println(regularExpressionInt.toString() +  "Value: " + regularExpressionInt.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter,
			Object param) {
		//System.out.println(regularExpressionLetter.toString() +  "Value: " + regularExpressionLetter.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef,
			Object param) {
		//System.out.println(regularExpressionMatrixRef.toString());
		regularExpressionMatrixRef.getExpression().accept(this, null);
		regularExpressionMatrixRef.getRowIndex().accept(this, null);
		regularExpressionMatrixRef.getColumnIndex().accept(this, null);
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal,
			Object param) {
		//System.out.println(regularExpressionReal.toString() +  "Value: " + regularExpressionReal.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef,
			Object param) {
		//System.out.println(regularExpressionStructRef.toString());
		regularExpressionStructRef.getLeft().accept(this, null);
		regularExpressionStructRef.getRight().accept(this, null);
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable,
			Object param) {
		//System.out.println(regularExpressionVariable.toString() + " Value: " + regularExpressionVariable.getName());
		boolean local = false;
		boolean global = false;
		if (simbolos.buscarReferenciasLocal(regularExpressionVariable.getName()) != null){
			local = true;
		}if (simbolos.buscarReferenciasGlobales(regularExpressionVariable.getName()) != null){
			global = true;
		}
		if (!(global || local)){
			System.err.println("ERROR: (line " + regularExpressionVariable.getLine()+" column " + regularExpressionVariable.getColumn() +")" + " Variable " + regularExpressionVariable.getName() + " not defined");
		}
		return null;
	}

	@Override
	public Object visit(CastExpression castExpression, Object param) {
		//System.out.println(castExpression.toString());
		castExpression.getFinalType().accept(this, null);
		castExpression.getExpression().accept(this, null);
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {
		arithmeticExpression.getLeft().accept(this, null);
		arithmeticExpression.getRight().accept(this, null);
		
		return null;
	}
	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		if (instructionDefinition.getName() != null){
			boolean local = false;
			boolean global = false;
			if (simbolos.buscarReferenciasLocal(((RegularExpressionVariable)instructionDefinition.getName()).getName()) != null){
				local = true;
			}if (simbolos.buscarReferenciasGlobales(((RegularExpressionVariable)instructionDefinition.getName()).getName()) != null){
				global = true;
			}
			if ((global && local)){
				
					System.err.println("ERROR: (line " + instructionDefinition.getLine()+" column " + instructionDefinition.getColumn() +")" +" Variable " +
						((RegularExpressionVariable)instructionDefinition.getName()).getName() 
						+" already exist ");
			}
			else {
				if (simbolos.insertar(instructionDefinition, simbolos.getAmbito())){
					//System.err.println("Variable " +
				//((RegularExpressionVariable)instructionDefinition.getName()).getName() 
				//+" added ");
				}
			}
			
			
			
		}
		return super.visit(instructionDefinition, null);
	}

}
