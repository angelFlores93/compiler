package asttree;

import java.util.List;

import visitor.Visitor;

public class Function extends AbstractASTNode implements Instruction{
	private InstructionDefinition definition;
	private List<InstructionDefinition> definitions; 
	private List<Instruction> instructions; 
	
	public Function(int column, int line, 
			InstructionDefinition definition, List<InstructionDefinition> definitions,
			List<Instruction> instructions) {
		super(column, line); 
		this.definitions = definitions;
		this.definition = definition; 
		this.instructions = instructions; 
		
		// TODO Auto-generated constructor stub
	}


	public InstructionDefinition getDefinition() {
		return definition;
	}



	public void setDefinition(InstructionDefinition definition) {
		this.definition = definition;
	}



	public List<InstructionDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<InstructionDefinition> definitions) {
		this.definitions = definitions;
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
		return "Function defined";
	}


}
