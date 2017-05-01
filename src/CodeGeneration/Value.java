package CodeGeneration;

import asttree.ArithmeticExpression;
import asttree.BinaryExpression;
import asttree.CastExpression;
import asttree.RegularExpressionArrayRef;
import asttree.RegularExpressionFunctionRef;
import asttree.RegularExpressionInt;
import asttree.RegularExpressionLetter;
import asttree.RegularExpressionMatrixRef;
import asttree.RegularExpressionReal;
import asttree.RegularExpressionStructRef;
import asttree.RegularExpressionVariable;
import visitor.AbstractVisitor;

public class Value extends AbstractVisitor{
	private Direction dir; 
	private int labelIndex = 0; 
	public Value(Direction dir){
		this.dir = dir; 
	}
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		//System.out.println(binaryExpression.toString());
		Instructions.out(";Line: " + binaryExpression.getLine());
		binaryExpression.getLeft().accept(this, null); // load var
		
		if(binaryExpression.getRight() != null) 
			binaryExpression.getRight().accept(this, null); // load var
		binaryExpression.setLabel("be"+labelIndex++);
		Instructions.out(Instructions.map.get(String.valueOf(binaryExpression.getOperation())) + " " +binaryExpression.getLabel());
		return null;
	}

	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef, Object param) {
		
		return null;
	}

	@Override
	public Object visit(RegularExpressionFunctionRef regularExpressionFunctionRef, Object param) {
		Instructions.out("invokestatic " + Instructions.OUTPUT_NAME + "." + (((RegularExpressionVariable)regularExpressionFunctionRef.getExpression()).getName()) + "()" + regularExpressionFunctionRef.getType().getPrintType()); 
	
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		Instructions.out("ldc " + regularExpressionInt.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter, Object param) {
		Instructions.out("ldc \"" + regularExpressionLetter.getValue() + "\"");
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal, Object param) {
		Instructions.out("ldc " + regularExpressionReal.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable, Object param) {
		Instructions.out(regularExpressionVariable.getType().getPrefix() + "load " + Instructions.vars.get(regularExpressionVariable.getName()));
		return null;
	}

	@Override
	public Object visit(CastExpression castExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression,
			Object param) {
		//System.out.println(arithmeticExpression.toString());
		Instructions.out(";Line: " + arithmeticExpression.getLine());
		arithmeticExpression.getLeft().accept(this, null); // load var
		arithmeticExpression.getRight().accept(this, null); // load var
		Instructions.out(arithmeticExpression.getType().getPrefix() + Instructions.map.get(String.valueOf(arithmeticExpression.getOperation())));
		return null;
	}
}
