package asttree;

import visitor.Visitor;

public class InstructionAsignation extends AbstractASTNode implements Instruction {

	private Expression left;
	private Expression right;
	
	public InstructionAsignation(int column, int line, Expression left, Expression right) {
		super (column, line);
		this.left = left; 
		this.right = right;
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
		return super.getLine();
	}
	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return super.getColumn();
	}
	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit(this,param);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Assignation Node";
	}
	
	
}
