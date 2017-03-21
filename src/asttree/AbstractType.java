package asttree;

import visitor.Visitor;

public abstract class AbstractType extends AbstractASTNode implements Type {

	public AbstractType(int column, int line) {
		super(column, line);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLogical() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBasico() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type aritmetical() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type aritmetical(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type comparacion(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type logical() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type logical(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type arrayAccess(Type type) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Type matrixAccess(Type type, Type type2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type structAccess(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type castTo(Type type) {
		// TODO Auto-generated method stub
		return new TypeError(0, 0, "");
	}

	@Override
	public Type invocation() {
		// TODO Auto-generated method stub
		return new TypeError(0, 0, "");
	}

	@Override
	public Type promotionTo(Type type) {
		// TODO Auto-generated method stub
		return new TypeError(0, 0, "");
	}

}
