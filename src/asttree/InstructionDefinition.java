package asttree;

import visitor.Visitor;

public class InstructionDefinition extends AbstractASTNode implements Instruction {
	private Type type; 
	private Expression name; 
	private int ambito;
	private int direction;
	public InstructionDefinition(int column, int line, Type type, Expression name) {
		super(column, line);
		this.type = type; 
		this.name = name; 
		
		// TODO Auto-generated constructor stub
	}
	

	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public int getAmbito() {
		return ambito;
	}

	public void setAmbito(int ambito) {
		this.ambito = ambito;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Expression getName() {
		return name;
	}

	public void setName(Expression name) {
		this.name = name;
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
		return "Definition node";
	}

}
