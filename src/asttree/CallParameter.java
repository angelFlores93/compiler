package asttree;

import java.util.List;

import visitor.Visitor;

public class CallParameter extends AbstractASTNode{
	private List<Expression> parameters; 
	
	public CallParameter (int column, int line, List<Expression> parameters){
		super(column, line);
		this.parameters = parameters; 
	}
	
	public List<Expression> getParameters() {
		return parameters;
	}

	public void setParameters(List<Expression> parameters) {
		this.parameters = parameters;
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
		return "Call Parameter node";
	}

}
