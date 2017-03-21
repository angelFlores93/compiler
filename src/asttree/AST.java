package asttree;

import visitor.Visitor;

public interface AST {
	public int getLine();	
	public int getColumn();	
	public abstract Object accept(Visitor visitor,Object param);
}
