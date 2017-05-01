package asttree;

import visitor.Visitor;

public class TypeSpecialArray extends AbstractType implements TypeSpecial {
	private Type type; 
	private int size;
	public TypeSpecialArray(int column, int line, Type type, int size ) {
		super(column, line); 
		this.type = type; 
		this.size = size;
		
		// TODO Auto-generated constructor stub
	}
	

	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getLine() {
		return super.getLine();
	}

	@Override
	public int getColumn() {
		return super.getColumn();
	}


	@Override
	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this,param);
	}
	@Override
	public Type arrayAccess(Type type){
		return getType();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Array Type node" ;
	}


	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return getType().getOffset()*getSize();
	}


	@Override
	public String getPrintType() {
		// TODO Auto-generated method stub
		return null;
	}

}
