package asttree;

import java.util.List;

import visitor.Visitor;

public class InstructionWhile extends AbstractASTNode implements Instruction {
	private BinaryExpression condition;
	private List<Instruction> instructions;
	
	

	public InstructionWhile(int column, int line, BinaryExpression condition, List<Instruction> instructions) {
		super(column, line);
		this.condition = condition; 
		this.instructions = instructions; 
		// TODO Auto-generated constructor stub
	}

	public BinaryExpression getCondition() {
		return condition;
	}

	public void setCondition(BinaryExpression condition) {
		this.condition = condition;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return super.getLine();
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return super.getLine();
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit(this,param);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "While node";
	}
}
