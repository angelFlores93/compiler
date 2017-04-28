package CodeGeneration;

import asttree.AST;
import asttree.ArithmeticExpression;
import asttree.BinaryExpression;
import asttree.CastExpression;
import asttree.RegularExpressionArrayRef;
import asttree.RegularExpressionFunctionRef;
import asttree.RegularExpressionInt;
import asttree.RegularExpressionLetter;
import asttree.RegularExpressionMatrixRef;
import asttree.RegularExpressionReal;
import asttree.RegularExpressionStructRef;
import asttree.RegularExpressionVariable;
import visitor.AbstractVisitor;

public class VisitorCodeGeneration extends AbstractVisitor{
	private String outputFile;
	public VisitorCodeGeneration(String outputFile, AST root){
		this.outputFile = outputFile; 
		
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
