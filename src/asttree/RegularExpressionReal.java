package asttree;

import visitor.Visitor;

public class RegularExpressionReal extends AbstractRegularExpression implements RegularExpression {
	private double value; 
	
	public RegularExpressionReal(int column, int line, double value) {
		super(column, line);
		this.value = value; 
		// TODO Auto-generated constructor stub
	}
	
	

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
		return "Real Constant Node" ;
	}

}
