package visitor;

import asttree.*;

public abstract class AbstractVisitor implements Visitor {
	public Object visit(Program program, Object param) {
		//System.out.println (program.toString());
		for (InstructionDefinition defs : program.getDefinitions()){
			defs.accept(this, null);
		}
		for (Function funcs : program.getFunctions()){
			funcs.accept(this, null);
		}
		for (Instruction inst : program.getInstructions()){
			inst.accept(this, null);
		}
		return null;
	}
	@Override
	public Object visit(CallParameter callParameter, Object param) {
		//System.out.println(callParameter.toString());
		for (Expression parameter : callParameter.getParameters()){
			parameter.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(Function function, Object param) {
		//System.out.println(function.toString());
		function.getDefinition().accept(this, null);
		if (!function.getDefinitions().isEmpty())
			for(InstructionDefinition inst : function.getDefinitions()){
				inst.accept(this, null);
			}
		if (!function.getInstructions().isEmpty())
			for(Instruction inst : function.getInstructions()){
				inst.accept(this, null);
			}
		return null;
	}

	@Override
	public Object visit(InstructionAsignation instructionAsignation,
			Object param) {
		//System.out.println(instructionAsignation.toString());
		instructionAsignation.getLeft().accept(this, null);
		instructionAsignation.getRight().accept(this, null);

		return null;
	}

	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		//System.out.println(instructionDefinition.toString());
		instructionDefinition.getType().accept(this, null);
		if (instructionDefinition.getName() != null)
			instructionDefinition.getName().accept(this, null);
		return null;
	}

	@Override
	public Object visit(InstructionFunctionCall instructionFunctionCall,
			Object param) {
		//System.out.println(instructionFunctionCall.toString());
		instructionFunctionCall.getExpression().accept(this, null);
		for (CallParameter inst : instructionFunctionCall.getParameters()){
			inst.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(InstructionIf instructionIf, Object param) {
		//System.out.println(instructionIf.toString());
		instructionIf.getCondition().accept(this, null);
		for (Instruction inst : instructionIf.getInstructionsIf()){
			if (inst != null)
				inst.accept(this, null);
		}
		if (instructionIf.getInstructionsElse() != null){
			for (Instruction inst : instructionIf.getInstructionsElse()){
				if (inst != null)
					inst.accept(this, null);
			}
		}
		return null;
	}

	@Override
	public Object visit(InstructionInput instructionInput, Object param) {
		//System.out.println(instructionInput.toString());
		instructionInput.getExpression().accept(this, null);
		return null;
	}

	@Override
	public Object visit(InstructionPrint instructionPrint, Object param) {
		//System.out.println (instructionPrint.toString());
		instructionPrint.getExpression().accept(this, null);
		return null;
	}

	@Override
	public Object visit(InstructionReturn instructionReturn, Object param) {
		//System.out.println (instructionReturn.toString());
		instructionReturn.getExpression().accept(this, null);
		return null;
	}

	@Override
	public Object visit(InstructionWhile instructionWhile, Object param) {
		//System.out.println (instructionWhile.toString());
		instructionWhile.getCondition().accept(this, null);
		for (Instruction inst : instructionWhile.getInstructions()){
			inst.accept(this, null);
		}
		return null;
	}
	@Override
	public Object visit(TypeNormal typeNormal, Object param) {
		//System.out.println(typeNormal.toString());
		
		return null;
	}

	@Override
	public Object visit(TypeSpecialArray typeSpecialArray, Object param) {
		//System.out.println(typeSpecialArray.toString());
		typeSpecialArray.getType().accept(this, null);
		//System.out.println("Size: " + typeSpecialArray.getSize());
		return null;
	}

	@Override
	public Object visit(TypeSpecialMatrix typeSpecialMatrix, Object param) {
		//System.out.println(typeSpecialMatrix.toString());
		typeSpecialMatrix.getType().accept(this, null);
		//System.out.println ("Rows" + typeSpecialMatrix.getRows() + " Columns: " + typeSpecialMatrix.getColumns());
		return null;
	}

	@Override
	public Object visit(TypeSpecialStruct typeSpecialStruct, Object param) {
		//System.out.println(typeSpecialStruct.toString());
		for (InstructionDefinition defs : typeSpecialStruct.getBody()){
			defs.accept(this, null);
		}
		return null;
	}

}
