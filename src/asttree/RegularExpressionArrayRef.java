package asttree;

import visitor.Visitor;

public class RegularExpressionArrayRef extends AbstractRegularExpression implements RegularExpression {
	private Expression expression; 
	private Expression index;
	 
	public RegularExpressionArrayRef(int column, int line, Expression expression, Expression index) {
		super(column, line);
		this.expression = expression; 
		this.index = index;
		// TODO Auto-generated constructor stub
	}

	

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public Expression getIndex() {
		return index;
	}

	public void setIndex(Expression index) {
		this.index = index;
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
		return "Array reference node";
	}
	
}
