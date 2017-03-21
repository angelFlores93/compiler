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
		if (getType().compareTo("int") == 0) return true;
		else return false;
	}
	@Override
	public boolean isBasico (){
		return true;
	}
	/*@Override
	public Type aritmetical(){
		
	}*/
	@Override
	public Type aritmetical(Type type){
		if (type != null){
			if (getType().compareTo(((TypeNormal) type).getType()) == 0)
				return this;
			if (getType().compareTo("int") == 0 && ((TypeNormal) type).getType().compareTo("char") == 0)
				return this;
			if (getType().compareTo("double") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
				return this;
			if (getType().compareTo("char") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
				return type;
		}
		return new TypeError(0, 0, "Caused by: variable not defined");
	}
	@Override 
	public Type comparacion(Type type){
		if (getType().compareTo( ((TypeNormal)type).getType()) == 0)
			if (getType().compareTo("int") == 0)
				return this;
		return new TypeError(0, 0, "");
	}
	@Override 
	public Type logical(){
		if (getType().compareTo("int") == 0)
			return this;
		return new TypeError(0, 0, "");
	}
	@Override 
	public Type logical (Type type){
		return comparacion(type);
	}
	@Override
	public Type castTo(Type type){
		if (getType().compareTo(((TypeNormal) type).getType()) == 0)
			return this;
		if (getType().compareTo("int") == 0 && ((TypeNormal) type).getType().compareTo("char") == 0)
			return this;
		if (getType().compareTo("double") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		if (getType().compareTo("char") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		return new TypeError(0, 0, "");
	}
	@Override
	public Type invocation(){
		return this;
	}
	@Override
	public Type promotionTo(Type type){
		if (getType().compareTo(((TypeNormal) type).getType()) == 0)
			return this;
		if (getType().compareTo("int") == 0 && ((TypeNormal) type).getType().compareTo("char") == 0)
			return this;
		if (getType().compareTo("double") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		if (getType().compareTo("char") == 0 && ((TypeNormal) type).getType().compareTo("int") == 0)
			return this;
		return new TypeError(0, 0, "");
	}
}
