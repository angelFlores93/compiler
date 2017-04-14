package visitor;

import java.util.List;

import asttree.ArithmeticExpression;
import asttree.BinaryExpression;
import asttree.CastExpression;
import asttree.InstructionAsignation;
import asttree.InstructionDefinition;
import asttree.RegularExpressionArrayRef;
import asttree.RegularExpressionFunctionRef;
import asttree.RegularExpressionInt;
import asttree.RegularExpressionLetter;
import asttree.RegularExpressionMatrixRef;
import asttree.RegularExpressionReal;
import asttree.RegularExpressionStructRef;
import asttree.RegularExpressionVariable;
import asttree.TypeError;
import asttree.TypeFunction;
import asttree.TypeNormal;

public class VisitorLValue extends AbstractVisitor{
	private List<TypeError> errorList;
	public VisitorLValue(List<TypeError> errorList){
		this.errorList = errorList; 
	}
	@Override
	public Object visit(InstructionAsignation instructionAsignation,
			Object param) {
		
		instructionAsignation.getLeft().accept(this, null);
		instructionAsignation.getRight().accept(this, null);
		
		if (!instructionAsignation.getLeft().getLvalue()){
			errorList.add(new TypeError(instructionAsignation.getColumn(), instructionAsignation.getLine(), ("ERROR: (line " + instructionAsignation.getLine()+" column " + instructionAsignation.getColumn() +") Assignation not allowed for left term (not lvalue)")));
		}
		return null;
	}

	@Override
	public Object visit(BinaryExpression binaryExpression, Object param) {
		binaryExpression.setLvalue(false);
		return null;
	}

	@Override
	public Object visit(RegularExpressionArrayRef regularExpressionArrayRef, Object param) {
		regularExpressionArrayRef.setLvalue(false);
		return null;
	}

	@Override
	public Object visit(RegularExpressionFunctionRef regularExpressionFunctionRef, Object param) {
		regularExpressionFunctionRef.setLvalue(false);
		return null;
	}

	@Override
	public Object visit(RegularExpressionInt regularExpressionInt, Object param) {
		regularExpressionInt.setLvalue(false);
		return null;
	}

	@Override
	public Object visit(RegularExpressionLetter regularExpressionLetter, Object param) {
		regularExpressionLetter.setLvalue(false);
		return null;
	}

	@Override
	public Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef, Object param) {
		regularExpressionMatrixRef.setLvalue(true);
		return null;
	}

	@Override
	public Object visit(RegularExpressionReal regularExpressionReal, Object param) {
		regularExpressionReal.setLvalue(true);
		return null;
	}

	@Override
	public Object visit(RegularExpressionStructRef regularExpressionStructRef, Object param) {
		regularExpressionStructRef.setLvalue(true);
		return null;
	}

	@Override
	public Object visit(RegularExpressionVariable regularExpressionVariable, Object param) {
		
		if (regularExpressionVariable.getType() instanceof TypeNormal)
			regularExpressionVariable.setLvalue(true);
		else{
			regularExpressionVariable.setLvalue(false);
		}
		
		
		return null;
	}
	@Override
	public Object visit(InstructionDefinition instructionDefinition,
			Object param) {
		//System.out.println(instructionDefinition.toString());
		instructionDefinition.getType().accept(this, null);
		if(instructionDefinition.getType() instanceof TypeFunction){
			if (instructionDefinition.getName() != null)
				instructionDefinition.getName().setLvalue(false);
		}else
		{
			instructionDefinition.getName().accept(this, null);
		}
		
		return null;
	}
	@Override
	public Object visit(CastExpression castExpression, Object param) {
		castExpression.setLvalue(false);
		return null;
	}

	@Override
	public Object visit(ArithmeticExpression arithmeticExpression, Object param) {
		arithmeticExpression.setLvalue(false);
		return null;
	}
	
}
