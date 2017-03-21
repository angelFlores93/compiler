package asttree;

import visitor.Visitor;

public class RegularExpressionLetter extends AbstractRegularExpression implements RegularExpression {
	private String value; 
	
	public RegularExpressionLetter(int column, int line, String value) {
		super(column, line);
		
		this.value = value.substring(1,	2); 
		// TODO Auto-generated constructor stub
	}

	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		return "Char Constant Node";
	}

}
