package asttree;

import java.util.List;

import visitor.Visitor;

public class Program extends AbstractASTNode{
	private List<InstructionDefinition> definitions;
	private List<Function> functions;
	private List<Instruction> instructions;
	public Program(int column, int line,List<InstructionDefinition> definitions,List<Function> functions,List<Instruction> instructions) {
		super(column, line);
		this.definitions = definitions;
		this.functions = functions;
		this.instructions = instructions;
		
		// TODO Auto-generated constructor stub
	}
	
	public List<InstructionDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<InstructionDefinition> definitions) {
		this.definitions = definitions;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
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
		return "Program node";
	}
}
