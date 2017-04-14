package visitor;
import asttree.*;

public interface Visitor {
	Object visit(BinaryExpression binaryExpression, Object param);
	Object visit(CallParameter callParameter, Object param);
	Object visit(Function function, Object param);
	Object visit(InstructionAsignation instructionAsignation, Object param);
	Object visit(InstructionDefinition instructionDefinition, Object param);
	Object visit(InstructionFunctionCall instructionFunctionCall, Object param);
	Object visit(InstructionIf instructionIf, Object param);
	Object visit(InstructionInput instructionInput, Object param);
	Object visit(InstructionPrint instructionPrint, Object param);
	Object visit(InstructionReturn instructionReturn, Object param);
	Object visit(InstructionWhile instructionWhile, Object param);
	Object visit(Program program, Object param);
	Object visit(RegularExpressionArrayRef regularExpressionArrayRef,
			Object param);
	Object visit(RegularExpressionFunctionRef regularExpressionFunctionRef,
			Object param);
	Object visit(RegularExpressionInt regularExpressionInt, Object param);
	Object visit(RegularExpressionLetter regularExpressionLetter, Object param);
	Object visit(RegularExpressionMatrixRef regularExpressionMatrixRef,
			Object param);
	Object visit(RegularExpressionReal regularExpressionReal, Object param);
	Object visit(RegularExpressionStructRef regularExpressionStructRef,
			Object param);
	Object visit(RegularExpressionVariable regularExpressionVariable,
			Object param);
	Object visit(TypeSpecialArray typeSpecialArray, Object param);
	Object visit(TypeSpecialMatrix typeSpecialMatrix, Object param);
	Object visit(TypeSpecialStruct typeSpecialStruct, Object param);
	Object visit(CastExpression castExpression, Object param);
	Object visit(ArithmeticExpression arithmeticExpression, Object param);
	Object visit(TypeNormal typeNormal, Object param);
	Object visit(TypeFunction typeFunction, Object param);

}
