package asttree;

public abstract class AbstractASTNode implements AST {

	private int column;
	private int line;
	
	
	public AbstractASTNode(int column, int line) {
		this.column = column;
		this.line = line;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return line;
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return column;
	}
	@Override	
	public abstract String toString();
}
