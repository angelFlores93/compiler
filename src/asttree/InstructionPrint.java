package asttree;

import visitor.Visitor;

public class InstructionPrint extends AbstractASTNode implements Instruction {
	private Expression expression; 
	public InstructionPrint(int column, int line, Expression expression ) {
		
		super(column, line);
		this.expression = expression ; 
		// TODO Auto-generated constructor stub
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
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
		return "Print Node";
	}

}
