package visitor;

import tablasimbolos.TablaSimbolos;
import asttree.*;
public class VisitorTypeCheck extends AbstractVisitor{
	private TablaSimbolos simbolos = TablaSimbolos.getTablaSimbolos();
	@Override
	public Object visit(ArithmeticExpression arithmeticExpression,
			Object param) {
		
		arithmeticExpression.getLeft().accept(this, null);
		arithmeticExpression.getRight().accept(this, null);
		arithmeticExpression.setLvalue(false);
		
		Type type = arithmeticExpression.getLeft().getType().aritmetical(arithmeticExpression.getRight().getType());
		arithmeticExpression.setType(type);
		setError(type, "ERROR: (line:" + arithmeticExpression.getLine() + " column: " + arithmeticExpression.getColumn() + ") " +((TypeError)type).getError() );
		printError(type); 
		return null;
	}

	
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		
		Type type;
		binaryExpression.setLvalue(false);
		binaryExpression.getLeft().accept(this, null);
		if(binaryExpression.getRight() != null) {
			binaryExpression.getRight().accept(this, null);
			type = binaryExpression.getLeft().getType().logical(binaryExpression.getRight().getType());
			if (binaryExpression.getLeft().getType().isLogical() && binaryExpression.getRight().getType().isLogical()){
				binaryExpression.setType(type);
				setError(type, "ERROR: (line:" + binaryExpression.getLine() + " column: " + binaryExpression.getColumn() + ") " );
				printError(type);
			}
			else{
				binaryExpression.setType(type);
				setError(type, "ERROR: (line:" + binaryExpression.getLine() + " column: " + binaryExpression.getColumn()  + ") ");
				printError(type);
			}
			
		}
		else{
			if (binaryExpression.getLeft().getType().isLogical()){
				binaryExpression.setType(binaryExpression.getLeft().getType().logical());
				setError(binaryExpression.getLeft().getType().logical(), "ERROR: (line:" + binaryExpression.getLine() + " column: " + binaryExpression.getColumn()  + ") " );
				printError(binaryExpression.getLeft().getType().logical());
			}
		}
		
		return null;
	}

	
	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef,
			Object param) {
		
		regularExpressionArrayRef.getExpression().accept(this, null);
		regularExpressionArrayRef.getIndex().accept(this, null);
		regularExpressionArrayRef.setLvalue(true);
		Type type = regularExpressionArrayRef.getExpression().getType().arrayAccess(regularExpressionArrayRef.getIndex().getType());
		regularExpressionArrayRef.setType(type);

		setError(type, "ERROR: (line:" + regularExpressionArrayRef.getLine() + " column: " + regularExpressionArrayRef.getColumn() + ") " );
		printError(type);
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
		regularExpressionFunctionRef.setLvalue(false);
		InstructionDefinition def = simbolos.buscar(((RegularExpressionVariable)regularExpressionFunctionRef.getExpression()).getName());
		if (def != null){
			Type type = regularExpressionFunctionRef.getExpression().getType().invocation();
			regularExpressionFunctionRef.setType(type);
			setError(type, "ERROR: (line:" + regularExpressionFunctionRef.getLine() + " column: " + regularExpressionFunctionRef.getColumn()  + ") ");
			printError(type);
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		
		regularExpressionInt.setLvalue(false);
		regularExpressionInt.setType(new TypeNormal (regularExpressionInt.getColumn(), regularExpressionInt.getLine(), "int"));
		
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter,
			Object param) {
		
		regularExpressionLetter.setLvalue(false);
		regularExpressionLetter.setType(new TypeNormal (regularExpressionLetter.getColumn(), regularExpressionLetter.getLine(), "char"));
		
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef,
			Object param) {
		
		regularExpressionMatrixRef.getExpression().accept(this, null);
		regularExpressionMatrixRef.getRowIndex().accept(this, null);
		regularExpressionMatrixRef.getColumnIndex().accept(this, null);
		regularExpressionMatrixRef.setLvalue(true);
		Type type = regularExpressionMatrixRef.getExpression().getType().matrixAccess(regularExpressionMatrixRef.getRowIndex().getType(), regularExpressionMatrixRef.getColumnIndex().getType());
		regularExpressionMatrixRef.setType(type);
		setError(type, "ERROR: (line:" + regularExpressionMatrixRef.getLine() + " column: " + regularExpressionMatrixRef.getColumn() + ") " );
		printError(type);
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal,
			Object param) {
		
		regularExpressionReal.setLvalue(false);
		regularExpressionReal.setType(new TypeNormal (regularExpressionReal.getColumn(), regularExpressionReal.getLine(), "double"));
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef,
			Object param) {
		
		regularExpressionStructRef.getLeft().accept(this, null);
		regularExpressionStructRef.getRight().accept(this, null);
		regularExpressionStructRef.setLvalue(true);
		Type type = regularExpressionStructRef.getLeft().getType().structAccess(regularExpressionStructRef.getRight().getType());
		regularExpressionStructRef.setType(type);
		setError(type, "ERROR: (line:" + regularExpressionStructRef.getLine() + " column: " + regularExpressionStructRef.getColumn()  + ") ");
		printError(type);
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable,
			Object param) {
		InstructionDefinition def = simbolos.buscar(regularExpressionVariable.getName());
		if (def != null){
			if (def.getType() instanceof TypeNormal)
				regularExpressionVariable.setLvalue(true);
			else
				regularExpressionVariable.setLvalue(false);
		regularExpressionVariable.setType(def.getType());
		System.out.println(((RegularExpressionVariable)def.getName()).getName() + " " + def.getType().toString());
		}
		
			
		
		
		return null;
	}


	@Override
	public Object visit(CastExpression castExpression, Object param) {
		
		castExpression.getFinalType().accept(this, null);
		castExpression.getExpression().accept(this, null);
		castExpression.setLvalue(true);
		Type type = castExpression.getFinalType().castTo(castExpression.getExpression().getType());
		castExpression.setType(type);
		setError(type, "ERROR: (line:" + castExpression.getLine() + " column: " + castExpression.getColumn()  + ") ");
		printError(type);
		return null;
	}
	@Override
	public Object visit(InstructionAsignation instructionAsignation,
			Object param) {
		
		instructionAsignation.getLeft().accept(this, null);
		if (!instructionAsignation.getLeft().getLvalue())
			System.err.println("ERROR: (line " + instructionAsignation.getLine()+" column " + instructionAsignation.getColumn() +")" + " Variable cannot be used in this context: ASSIGNATION");
		instructionAsignation.getRight().accept(this, null);
		
		if (instructionAsignation.getLeft().getLvalue()){
			System.out.println(instructionAsignation.getLeft().getType().toString());
			Type type = instructionAsignation.getLeft().getType().promotionTo(instructionAsignation.getRight().getType());
			System.err.println( instructionAsignation.getLine());
			setError(type, "ERROR: (line:" + instructionAsignation.getLine() + " column: " + instructionAsignation.getColumn() + ") " );
			printError(type);
			
			
		}
		
		return null;
	}
	public void setError(Type type, String error){
		if (type instanceof TypeError){
			((TypeError)type).setError(error);
		}
	}
	public void printError(Type type){
		if (type instanceof TypeError){
			System.err.println(((TypeError)type).getError()  );
		}
	}
}
