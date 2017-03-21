package asttree;

import visitor.Visitor;

public class RegularExpressionMatrixRef extends AbstractRegularExpression implements RegularExpression {
	private Expression expression;
	private Expression rowIndex; 
	private Expression columnIndex;
	
	public RegularExpressionMatrixRef(int column, int line, Expression expression, Expression rowIndex, Expression columnIndex) {
		super(column, line);
		this.expression = expression; 
		this.rowIndex = rowIndex; 
		this.columnIndex = columnIndex;
		// TODO Auto-generated constructor stub
	}
	

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public Expression getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Expression rowIndex) {
		this.rowIndex = rowIndex;
	}

	public Expression getColumnIndex() {
		return columnIndex;
	}

	public void setColumnIndex(Expression columnIndex) {
		this.columnIndex = columnIndex;
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
		return "Matrix reference node";
	}

}
