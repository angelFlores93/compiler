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
	public Value(Direction dir){
		this.dir = dir; 
	}
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		// TODO Auto-generated method stub
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
		Instructions.out("s" + regularExpressionInt.getType().getPrefix() + "push " + regularExpressionInt.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter, Object param) {
		Instructions.out("s" + regularExpressionLetter.getType().getPrefix() + "push " + regularExpressionLetter.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal, Object param) {
		Instructions.out("s" + regularExpressionReal.getType().getPrefix() + "push " + regularExpressionReal.getValue());
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable, Object param) {
		Instructions.out(regularExpressionVariable.getType().getPrefix() + "load " + regularExpressionVariable.getDirection());
		return null;
	}

	@Override
	public Object visit(CastExpression castExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

}
