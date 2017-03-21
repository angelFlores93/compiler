package asttree;

import visitor.Visitor;

public class RegularExpressionInt extends AbstractRegularExpression implements RegularExpression {
	private int value; 
	
	public RegularExpressionInt(int column, int line, int value) {
		super(column, line);
		this.value = value; 
		// TODO Auto-generated constructor stub
	}



	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
		return "Integer Constant Node";
	}

}
