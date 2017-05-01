package visitor;

import tablasimbolos.TablaSimbolos;

import java.util.ArrayList;
import java.util.List;

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
import asttree.TypeError;
import asttree.TypeSpecialStruct;

public class VisitorIdentifier extends AbstractVisitor{
	private TablaSimbolos simbolos = TablaSimbolos.getTablaSimbolos();
	private List<TypeError> errorList;
	public VisitorIdentifier(List<TypeError> errorList){
		this.errorList = errorList;
	}
	@Override 
	public Object visit(Program program, Object param) {
		super.visit(program, null);
		simbolos.printGlobal();
		simbolos.printLocal();
		return null;
		
	}
	@Override
	public Object visit(Function function, Object param) {
		//simbolos.reset();
		simbolos.setAmbito(0);
		function.getDefinition().accept(this, null);
		simbolos.setAmbito(1);
		for(InstructionDefinition inst : function.getDefinitions()){
			inst.accept(this, null);
		}
		for(Instruction inst : function.getInstructions()){
			inst.accept(this, null);
		}
		simbolos.printLocal();
		//simbolos.reset();
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
		regularExpressionArrayRef.getExpression().accept(this, null);
		regularExpressionArrayRef.getIndex().accept(this, null);

		return null;
	}

	@Override
	public Object visit(
			RegularExpressionFunctionRef regularExpressionFunctionRef,
			Object param) {
		regularExpressionFunctionRef.getExpression().accept(this, null);
		for (Expression defs : regularExpressionFunctionRef.getParameters()){
			
			defs.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter,
			Object param) {
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef,
			Object param) {
		regularExpressionMatrixRef.getExpression().accept(this, null);
		regularExpressionMatrixRef.getRowIndex().accept(this, null);
		regularExpressionMatrixRef.getColumnIndex().accept(this, null);
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal,
			Object param) {
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef,
			Object param) {
		boolean found = false;
		regularExpressionStructRef.getLeft().accept(this, null);
		InstructionDefinition exp = simbolos.buscar(((RegularExpressionVariable) (regularExpressionStructRef.getLeft())).getName());
		List<InstructionDefinition> list = ((TypeSpecialStruct)exp.getType()).getBody();
		for (InstructionDefinition def : list){
			if (((RegularExpressionVariable)def.getName()).getName().compareTo(((RegularExpressionVariable)regularExpressionStructRef.getRight()).getName()) == 0){
				found = true; 
				break;
			}
		}
		if (!found){
			errorList.add(new TypeError(regularExpressionStructRef.getColumn(), regularExpressionStructRef.getLine(), "ERROR: (line " + regularExpressionStructRef.getLine()+" column " + regularExpressionStructRef.getColumn() +")" + " Variable " + ((RegularExpressionVariable)regularExpressionStructRef.getRight()).getName() + " not defined"));
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable,
			Object param) {
		boolean local = false;
		boolean global = false;
		if (simbolos.buscarReferenciasLocal(regularExpressionVariable.getName()) != null){
			local = true;
		}if (simbolos.buscarReferenciasGlobales(regularExpressionVariable.getName()) != null){
			global = true;
		}
		if (!(global || local)){
			errorList.add(new TypeError(regularExpressionVariable.getColumn(), regularExpressionVariable.getLine(), "ERROR: (line " + regularExpressionVariable.getLine()+" column " + regularExpressionVariable.getColumn() +")" + " Variable " + regularExpressionVariable.getName() + " not defined"));
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
			boolean defined = false; 
			if (simbolos.buscarAmbitoActual(((RegularExpressionVariable)instructionDefinition.getName()).getName()) != null){
				defined = true;
			}
			if (defined){
				errorList.add(new TypeError(instructionDefinition.getColumn(), instructionDefinition.getLine(), "ERROR: (line " + instructionDefinition.getLine() +" column " + instructionDefinition.getColumn() +"): Variable "+((RegularExpressionVariable)instructionDefinition.getName()).getName()+" already Defined"));
			}
			else {
				if (simbolos.insertar(instructionDefinition, simbolos.getAmbito())){
					
				}
			}
			
			
			
		}
		return super.visit(instructionDefinition, null);
	}

}
