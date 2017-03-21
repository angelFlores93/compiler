package visitor;

import asttree.*;

public class VisitorPrettyPrinter extends AbstractVisitor{

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression,
			Object param) {
		System.out.println(arithmeticExpression.toString());
		arithmeticExpression.getLeft().accept(this, null);
		arithmeticExpression.getRight().accept(this, null);
		
		return null;
	}

	
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		System.out.println(binaryExpression.toString());
		binaryExpression.getLeft().accept(this, null);
		if(binaryExpression.getRight() != null) 
			binaryExpression.getRight().accept(this, null);
		return null;
	}

	
	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef,
			Object param) {
		System.out.println (regularExpressionArrayRef.toString());
		regularExpressionArrayRef.getExpression().accept(this, null);
		regularExpressionArrayRef.getIndex().accept(this, null);
		return null;
	}

	@Override
	public Object visit(
			RegularExpressionFunctionRef regularExpressionFunctionRef,
			Object param) {
		System.out.println (regularExpressionFunctionRef.toString());
		regularExpressionFunctionRef.getExpression().accept(this, null);
		for (Expression defs : regularExpressionFunctionRef.getParameters()){
			
			defs.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		System.out.println(regularExpressionInt.toString() +  "Value: " + regularExpressionInt.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter,
			Object param) {
		System.out.println(regularExpressionLetter.toString() +  "Value: " + regularExpressionLetter.getValue());		
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef,
			Object param) {
		System.out.println(regularExpressionMatrixRef.toString());
		regularExpressionMatrixRef.getExpression().accept(this, null);
		regularExpressionMatrixRef.getRowIndex().accept(this, null);
		regularExpressionMatrixRef.getColumnIndex().accept(this, null);
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal,
			Object param) {
		System.out.println(regularExpressionReal.toString() +  "Value: " + regularExpressionReal.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef,
			Object param) {
		System.out.println(regularExpressionStructRef.toString());
		regularExpressionStructRef.getLeft().accept(this, null);
		regularExpressionStructRef.getRight().accept(this, null);
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable,
			Object param) {
		System.out.println(regularExpressionVariable.toString() + " Value: " + regularExpressionVariable.getName());
		
		return null;
	}


	@Override
	public Object visit(CastExpression castExpression, Object param) {
		// TODO Auto-generated method stub
		System.out.println(castExpression.toString());
		castExpression.getFinalType().accept(this, null);
		castExpression.getExpression().accept(this, null);
		return null;
	}
	

	

}
