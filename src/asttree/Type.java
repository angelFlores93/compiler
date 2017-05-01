package asttree;

public interface Type extends AST{
	public boolean isLogical();
	public boolean isBasico ();
	public Type aritmetical();
	public Type aritmetical(Type type);
	public Type comparacion(Type type);
	public Type logical();
	public Type logical (Type type);
	public Type arrayAccess(Type type);
	public Type matrixAccess(Type type, Type type2);
	public Type structAccess(Type type);
	public Type castTo(Type type);
	public Type invocation();
	public Type promotionTo(Type type);
	public String getPrefix();
	public int getOffset();
	public String getPrintType();
}
