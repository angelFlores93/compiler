package asttree;

import visitor.Visitor;

public class CastExpression extends AbstractRegularExpression implements Expression{
	private Type finalType;
	private Expression expression;
	
	public CastExpression(int column, int line, Type type, Expression expression) {
		super(column, line);
		this.finalType = type; 
		this.expression = expression;
		// TODO Auto-generated constructor stub
	}

	

	public Type getFinalType() {
		return finalType;
	}

	public void setFinalType(Type finalType) {
		this.finalType = finalType;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit(this, null);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Cast Node";
	}

}
