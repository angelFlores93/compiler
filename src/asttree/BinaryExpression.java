package asttree;

import visitor.Visitor;

public class BinaryExpression extends AbstractRegularExpression implements Expression {
	private Expression left; 
	private Expression right;
	private String operation; 
	private String label;
	
	public BinaryExpression(int column, int line, Expression left, Expression right, String operation) {
		super(column, line);
		this.left = left; 
		this.right = right;
		this.operation = operation;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
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
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit(this, param);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Binary Expression: " + getOperation();
	}

}
