package asttree;

import visitor.Visitor;

public class TypeSpecialMatrix extends AbstractType implements TypeSpecial {
	private Type type; 
	private int rows;
	private int columns;
	public TypeSpecialMatrix(int column, int line, Type type, int rows, int columns) {
		super(column, line);
		this.type = type;
		this.rows = rows; 
		this.columns = columns;  
		// TODO Auto-generated constructor stub
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
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
	public Type matrixAccess(Type type, Type type2){
		return getType();
	}
	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit(this,param);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Matrix type node";
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return getType().getOffset()*getRows()*getColumns();
	}

}
