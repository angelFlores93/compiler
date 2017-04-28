package asttree;

import visitor.Visitor;

public class TypeNormal extends AbstractType{
	private String type;
	public TypeNormal(int column, int line, String type) {
		super(column, line);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}

	public void setTsype(String type) {
		this.type = type;
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
		return visitor.visit(this, param);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Normal Type node: " + getType();
	}
	@Override
	public boolean isLogical(){
		if (getType() == null) return false; 
		if (getType().compareTo("int") == 0) return true;
		else return false;
	}
	@Override
	public boolean isBasico (){
		return true;
	}
	@Override
	public Type aritmetical(Type type){
		if (type != null && getType() != null){
			if (getType().compareTo(((TypeNormal) type).getType()) == 0)
				return this;
			if (getType().compareTo("int") == 0 && ((TypeNormal) type).getType().compareTo("char") == 0)
				return this;
			if (getType().compareTo("double") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
				return this;
			if (getType().compareTo("char") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
				return type;
		}
		return null;
	}
	@Override 
	public Type comparacion(Type type){
		if (getType() != null && type != null)
			if (getType().compareTo( ((TypeNormal)type).getType()) == 0)
				if (getType().compareTo("int") == 0)
					return this;
		return null;
	}
	@Override 
	public Type logical(){
		if (getType() != null)
			if (getType().compareTo("int") == 0)
				return this;
		return null;
	}
	@Override 
	public Type logical (Type type){
		if (getType() != null && type != null)
			return comparacion(type);
		return null;
	}
	@Override
	public Type castTo(Type type){
		if (getType() == null || type == null) return null;
		if (getType().compareTo(((TypeNormal) type).getType()) == 0)
			return this;
		if (getType().compareTo("int") == 0 && ((TypeNormal) type).getType().compareTo("char") == 0)
			return this;
		if (getType().compareTo("double") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		if (getType().compareTo("char") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		return null;
	}
	@Override
	public Type invocation(){
		return this;
	}
	@Override
	public Type promotionTo(Type type){
		if (getType() == null || type == null) return null;
		if (getType().compareTo(((TypeNormal) type).getType()) == 0)
			return this;
		if (getType().compareTo("int") == 0 && ((TypeNormal) type).getType().compareTo("char") == 0)
			return this;
		if (getType().compareTo("double") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		if (getType().compareTo("char") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		return null;
	}
	public String getPrefix(){
		if (getType().compareTo("int") == 0) return "i"; 
		if (getType().compareTo("double") == 0) return "f";
		if (getType().compareTo("char") == 0) return "";
		return null; 
	}

	@Override
	public int getOffset() {
		if (getType().compareTo("int") == 0) return 2; 
		if (getType().compareTo("double") == 0) return 4;
		if (getType().compareTo("char") == 0) return 1;
		return 0;
	}
}
