package asttree;

import visitor.Visitor;

public class AbstractRegularExpression extends AbstractASTNode implements Expression {
	private boolean lValue;
	private Type type;
	public AbstractRegularExpression(int column, int line) {
		super(column, line);
		// TODO Auto-generated constructor stub
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
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getLvalue() {
		// TODO Auto-generated method stub
		return this.lValue;
	}

	@Override
	public void setLvalue(boolean lValue) {
		// TODO Auto-generated method stub
		this.lValue = lValue;
	}

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Type getType() {
		return this.type;
		
	}
	

}
