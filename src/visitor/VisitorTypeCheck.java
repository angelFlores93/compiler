package visitor;

import tablasimbolos.TablaSimbolos;

import java.util.ArrayList;
import java.util.List;

import asttree.*;
public class VisitorTypeCheck extends AbstractVisitor{
	private TablaSimbolos simbolos = TablaSimbolos.getTablaSimbolos();
	private List<TypeError> errorList = new ArrayList<TypeError>();
	public VisitorTypeCheck(List<TypeError> errorList){
		this.errorList = errorList; 
	}
	@Override
	public Object visit(InstructionInput instructionInput, Object param) {
		//System.out.println(instructionInput.toString());
		instructionInput.getExpression().accept(this, null);
		Type type = instructionInput.getExpression().getType();
		if (type != null){
			if (type instanceof TypeNormal){
				if (((TypeNormal)type).getType().compareTo("int") != 0){
					errorList.add(new TypeError(instructionInput.getColumn(), instructionInput.getLine(), ("ERROR: (line " + instructionInput.getLine() + " column " + instructionInput.getColumn() + ") Can't read a non-integer")));
				}
			}else{
				errorList.add(new TypeError(instructionInput.getColumn(), instructionInput.getLine(), ("ERROR: (line " + instructionInput.getLine() + " column " + instructionInput.getColumn() + ") Can't read a non-integer")));
			}
					
		}else{
			errorList.add(new TypeError(instructionInput.getColumn(), instructionInput.getLine(), ("ERROR: (line " + instructionInput.getLine() + " column " + instructionInput.getColumn() + ") Can't read a non-integer")));
		}
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression,
			Object param) {
		System.out.println("visiting AE");
		arithmeticExpression.getLeft().accept(this, null);
		arithmeticExpression.getRight().accept(this, null);
		System.out.println(arithmeticExpression.getRight().getType());
		Type type = arithmeticExpression.getLeft().getType().aritmetical(arithmeticExpression.getRight().getType());
		
		if (type == null){
			errorList.add(new TypeError(arithmeticExpression.getColumn(), arithmeticExpression.getLine(), ("ERROR: (line " + arithmeticExpression.getLine() + " column " + arithmeticExpression.getColumn() + ") Incompatible types")));
		}else
			arithmeticExpression.setType(type); 
		return null;
	}

	
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		System.out.println("visiting BE");
		Type type;
		binaryExpression.getLeft().accept(this, null);
		if(binaryExpression.getRight() != null) {
			binaryExpression.getRight().accept(this, null);
			System.out.println(binaryExpression.getLeft().getType().isLogical() && binaryExpression.getRight().getType().isLogical());
			if (binaryExpression.getLeft().getType().isLogical() && binaryExpression.getRight().getType().isLogical()){
				type = binaryExpression.getLeft().getType().logical(binaryExpression.getRight().getType());
				
				binaryExpression.setType(type);
			}
			else{
				errorList.add(new TypeError(binaryExpression.getColumn(), binaryExpression.getLine(), ("ERROR: (line " + binaryExpression.getLeft().getLine() + " column " + binaryExpression.getLeft().getColumn() + ") Invalid comparisson between types")));
			}
			
		}
		else{
			if (binaryExpression.getLeft().getType().isLogical()){
				type = binaryExpression.getLeft().getType().logical();
				if (type == null)
					errorList.add(new TypeError(binaryExpression.getColumn(), binaryExpression.getLine(), ("ERROR: (line " + binaryExpression.getLine() + " column " + binaryExpression.getColumn() + ") Invalid operator to type")));
				else
					binaryExpression.setType(type);
	
			}
		}
		return null;
	}

	
	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef,
			Object param) {
		System.out.println("visiting ARef");
		regularExpressionArrayRef.getExpression().accept(this, null);
		regularExpressionArrayRef.getIndex().accept(this, null);
		Type type = regularExpressionArrayRef.getExpression().getType().arrayAccess(regularExpressionArrayRef.getIndex().getType());
		if (type == null){
			errorList.add(new TypeError(regularExpressionArrayRef.getColumn(), regularExpressionArrayRef.getLine(), ("ERROR: (line " + regularExpressionArrayRef.getLine() + " column " + regularExpressionArrayRef.getColumn() + ") Invalid type")));
		}else{
			regularExpressionArrayRef.setType(type);
		}
		return null;
	}
	@Override
	public Object visit(Function function, Object param) {
		//System.out.println(function.toString());
		System.out.println("visiting Function");
		function.getDefinition().accept(this, null);
		Type functionType = function.getDefinition().getType();
		System.err.println(functionType);
		if (!function.getDefinitions().isEmpty())
			for(InstructionDefinition inst : function.getDefinitions()){
				inst.accept(this, null);
			}
		if (!function.getInstructions().isEmpty())
			for(Instruction inst : function.getInstructions()){
				inst.accept(this, null);
			}
		System.err.println("here");
		function.getReturnStm().accept(this, param);
		System.err.println("here");
		Type returnType = function.getReturnStm().getType();
		System.out.println(returnType);
		if (((TypeNormal)functionType).getType().compareTo(((TypeNormal)returnType).getType()) == 0){
			Type newType = new TypeFunction(function.getColumn(), function.getLine(),functionType, function.getDefinitions());
			function.setType(newType);
			function.getDefinition().setType(newType);
		}else{
			errorList.add(new TypeError(function.getColumn(), function.getLine(), ("ERROR: (line " + function.getLine() + " column " + function.getColumn() + ") Incompatible types between function and return statement")));
		}
		return null;
	}
	@Override
	public Object visit(InstructionReturn instructionReturn, Object param) {
		//System.out.println (instructionReturn.toString());
		System.out.println("visiting return stm");
		instructionReturn.getExpression().accept(this, null);
		
		instructionReturn.setType(instructionReturn.getExpression().getType());
		return null;
	}
	
	@Override
	public Object visit(
			RegularExpressionFunctionRef regularExpressionFunctionRef,
			Object param) {
		System.out.println("visiting FRef");
		regularExpressionFunctionRef.getExpression().accept(this, null);
		
		System.out.println(regularExpressionFunctionRef.getExpression().getType());
		TypeFunction t= (TypeFunction) regularExpressionFunctionRef.getExpression().getType(); 
		System.out.println(t.getParameters().size() +" "+regularExpressionFunctionRef.getParameters().size());
		if (t.getParameters().size() != regularExpressionFunctionRef.getParameters().size()){
			errorList.add(new TypeError(regularExpressionFunctionRef.getColumn(), regularExpressionFunctionRef.getLine(), ("ERROR: (line " + regularExpressionFunctionRef.getLine() + " column " + regularExpressionFunctionRef.getColumn() + ") Wrong number of parameters")));
		}
		
		
		for (Expression defs : regularExpressionFunctionRef.getParameters()){
			
			defs.accept(this, null);
		}
		if (t.getParameters().size() == regularExpressionFunctionRef.getParameters().size()){
			for (int i = 0; i < t.getParameters().size(); i++){
				if (((TypeNormal)t.getParameters().get(i).getType()).getType().compareTo( ((TypeNormal)regularExpressionFunctionRef.getParameters().get(i).getType()).getType()) != 0){
					errorList.add(new TypeError(regularExpressionFunctionRef.getColumn(), regularExpressionFunctionRef.getLine(), ("ERROR: (line " + regularExpressionFunctionRef.getLine() + " column " + regularExpressionFunctionRef.getColumn() + ") Incompatible parameter type")));
				}
			}
		}
		InstructionDefinition def = simbolos.buscarReferenciasGlobales(((RegularExpressionVariable)regularExpressionFunctionRef.getExpression()).getName());
		if (def != null){
			Type type = regularExpressionFunctionRef.getExpression().getType().invocation();
			regularExpressionFunctionRef.setType(type);
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		System.out.println("visiting int");
		regularExpressionInt.setType(new TypeNormal (regularExpressionInt.getColumn(), regularExpressionInt.getLine(), "int"));
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter,
			Object param) {
		System.out.println("visiting letter");
		regularExpressionLetter.setType(new TypeNormal (regularExpressionLetter.getColumn(), regularExpressionLetter.getLine(), "char"));
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef,
			Object param) {
		System.out.println("visiting MRef");
		regularExpressionMatrixRef.getExpression().accept(this, null);
		regularExpressionMatrixRef.getRowIndex().accept(this, null);
		regularExpressionMatrixRef.getColumnIndex().accept(this, null);
		Type type = regularExpressionMatrixRef.getExpression().getType().matrixAccess(regularExpressionMatrixRef.getRowIndex().getType(), regularExpressionMatrixRef.getColumnIndex().getType());
		regularExpressionMatrixRef.setType(type);
		if (type == null){
			errorList.add(new TypeError(regularExpressionMatrixRef.getColumn(), regularExpressionMatrixRef.getLine(), ("ERROR: (line " + regularExpressionMatrixRef.getLine() + " column " + regularExpressionMatrixRef.getColumn() + ") Invalid type")));
		}else{
			regularExpressionMatrixRef.setType(type);
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal,
			Object param) {
		System.out.println("visiting double");
		regularExpressionReal.setType(new TypeNormal (regularExpressionReal.getColumn(), regularExpressionReal.getLine(), "double"));
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef,
			Object param) {
		System.out.println("visiting Sref");
		regularExpressionStructRef.getLeft().accept(this, null);
		regularExpressionStructRef.getRight().accept(this, null);
		Type type = regularExpressionStructRef.getLeft().getType().structAccess(regularExpressionStructRef.getRight().getType());
		if (type == null){
			errorList.add(new TypeError(regularExpressionStructRef.getColumn(), regularExpressionStructRef.getLine(), ("ERROR: (line " + regularExpressionStructRef.getLine() + " column " + regularExpressionStructRef.getColumn() + ") Invalid type")));
		}else{
			regularExpressionStructRef.setType(type);
		}
		return null;
	}
	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		instructionDefinition.getType().accept(this, null);
		if (instructionDefinition.getName() != null)
			instructionDefinition.getName().setType(instructionDefinition.getType());
		instructionDefinition.setType(instructionDefinition.getType());
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable,
			Object param) {
		
		InstructionDefinition def = simbolos.buscar(regularExpressionVariable.getName());
		System.err.println(def);
		regularExpressionVariable.setType(def.getType());

		
		return null;
	}


	@Override
	public Object visit(CastExpression castExpression, Object param) {
		return null;
	}
	@Override
	public Object visit(InstructionAsignation instructionAsignation,
			Object param) {
		System.out.println("visiting Iasi");
		instructionAsignation.getLeft().accept(this, null);
		
		instructionAsignation.getRight().accept(this, null);
		Type type = instructionAsignation.getLeft().getType().promotionTo(instructionAsignation.getRight().getType());
		System.err.println(type);
		if (type == null){
			errorList.add(new TypeError(instructionAsignation.getColumn(), instructionAsignation.getLine(), ("ERROR: (line " + instructionAsignation.getLine() + " column " + instructionAsignation.getColumn() + ") Incompatible types")));
		}
		
		return null;
	}
	
}
