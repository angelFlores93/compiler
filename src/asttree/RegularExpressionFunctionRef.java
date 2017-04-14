package asttree;

import java.util.List;

import visitor.Visitor;

public class RegularExpressionFunctionRef extends AbstractRegularExpression implements RegularExpression {
	private Expression expression; 
	private List <RegularExpression> parameters; 
	
	public RegularExpressionFunctionRef(int column, int line, Expression expression, List<RegularExpression> parameters) {
		super(column, line);
		this.expression = expression;
		this.parameters = parameters; 
		// TODO Auto-generated constructor stub
	}

	

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public List<RegularExpression> getParameters() {
		return parameters;
	}

	public void setParameters(List<RegularExpression> parameters) {
		this.parameters = parameters;
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
		return "Function reference node";
	}

}
