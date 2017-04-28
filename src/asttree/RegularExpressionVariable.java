package asttree;

import visitor.Visitor;

public class RegularExpressionVariable extends AbstractRegularExpression implements RegularExpression {
	private String name; 
	private int direction;
	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public RegularExpressionVariable(int column, int line, String name) {
		super(column, line);
		this.name = name ;
	
		// TODO Auto-generated constructor stub
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Variable Node";
	}
	

}
