package asttree;

import java.util.List;

import visitor.Visitor;

public class InstructionIf extends AbstractASTNode implements Instruction {
	private BinaryExpression condition; 
	private List<Instruction> instructionsIf;
	private List<Instruction> instructionsElse;
	
	public InstructionIf(int column, int line, BinaryExpression condition,
			List<Instruction> instructionsIf, List<Instruction> instructionsElse) {
		super(column, line);
		this.condition = condition;
		this.instructionsIf = instructionsIf;
		this.instructionsElse = instructionsElse;
	}
	
	public BinaryExpression getCondition() {
		return condition;
	}

	public void setCondition(BinaryExpression condition) {
		this.condition = condition;
	}

	public List<Instruction> getInstructionsIf() {
		return instructionsIf;
	}

	public void setInstructionsIf(List<Instruction> instructionsIf) {
		this.instructionsIf = instructionsIf;
	}

	public List<Instruction> getInstructionsElse() {
		return instructionsElse;
	}

	public void setInstructionsElse(List<Instruction> instructionsElse) {
		this.instructionsElse = instructionsElse;
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
		return "If Node";
	}
	
	
}
