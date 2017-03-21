package asttree;

import visitor.Visitor;

public class ArithmeticExpression extends AbstractRegularExpression implements Expression {
	private Expression left; 
	private Expression right;
	private char operation;
	 
	
	public ArithmeticExpression(int column, int line,  Expression left, Expression right, char operation) {
		super(column, line);
		this.left = left; 
		this.right = right;
		this.operation = operation;
		// TODO Auto-generated constructor stub
	}
	
	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public Expression getLeft() {
		return left;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	public Expression getRight() {
		return right;
	}

	public void setRight(Expression right) {
		this.right = right;
	}


	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit (this, null);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aritmetic node: " + getOperation();
	}

}
