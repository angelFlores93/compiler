package asttree;

public interface Expression extends AST {
	public boolean getLvalue();
	public void setLvalue(boolean lValue);
	public void setType (Type type);
	public Type getType();
	
}
