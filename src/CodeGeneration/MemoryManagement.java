package CodeGeneration;

import asttree.ArithmeticExpression;
import asttree.BinaryExpression;
import asttree.CastExpression;
import asttree.InstructionDefinition;
import asttree.Program;
import asttree.RegularExpressionArrayRef;
import asttree.RegularExpressionFunctionRef;
import asttree.RegularExpressionInt;
import asttree.RegularExpressionLetter;
import asttree.RegularExpressionMatrixRef;
import asttree.RegularExpressionReal;
import asttree.RegularExpressionStructRef;
import asttree.RegularExpressionVariable;
import visitor.AbstractVisitor;

public class MemoryManagement extends AbstractVisitor {
	private int pointer = 0;
	private boolean global = true; 
	public Object visit(Program program, Object param) {
		//System.out.println (program.toString());
		for (InstructionDefinition defs : program.getDefinitions()){
			defs.accept(this, null);
		}
		setGlobal(false);
		for (int i = program.getFunctions().size()-1; i >= 0; i--){
			program.getFunctions().get(i).accept(this, null);
		}
		
		return null;
	}
	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		//System.out.println(instructionDefinition.toString());
		instructionDefinition.getType().accept(this, null);
		if (instructionDefinition.getName() != null)
			instructionDefinition.getName().accept(this, null);
		if (global){
			
			instructionDefinition.setDirection(pointer);
			
			pointer += instructionDefinition.getType().getOffset();
			System.out.println("Variable: "+ ((RegularExpressionVariable)instructionDefinition.getName()).getName()+ " Direction: " + instructionDefinition.getDirection());
		}
		return null;
	}
	public  void setGlobal (boolean flag){
		global = flag;
	}
	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionFunctionRef regularExpressionFunctionRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(CastExpression castExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {
		// TODO Auto-generated method stub
		return null;
	}
}
