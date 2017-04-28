package asttree;

import java.util.List;

import visitor.Visitor;

public class TypeFunction extends AbstractType implements Type {
	private Type type; 
	private List<InstructionDefinition>parameters; 
	public TypeFunction(int column, int line,Type type, List<InstructionDefinition> parameters) {
		super(column, line);
		this.type = type;
		this.parameters = parameters; 
		// TODO Auto-generated constructor stub
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<InstructionDefinition> getParameters() {
		return parameters;
	}

	public void setParameters(List<InstructionDefinition> parameters) {
		this.parameters = parameters;
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
		return visitor.visit(this, param);
	}

	@Override
	public boolean isLogical() {
		if (getType() instanceof TypeNormal) {
			return getType().isLogical();	
		}
		return false; 
	}

	@Override
	public boolean isBasico() {
		if (getType() instanceof TypeNormal) {
			return getType().isBasico();	
		}
		return false; 
	}

	@Override
	public Type aritmetical() {
		if (getType() instanceof TypeNormal) {
			return getType().aritmetical();	
		}
		return null;
	}

	@Override
	public Type aritmetical(Type type) {
		if (getType() instanceof TypeNormal) {
			return getType().aritmetical(type);	
		}
		return null;
	}

	@Override
	public Type comparacion(Type type) {
		if (getType() instanceof TypeNormal) {
			return getType().comparacion(type);	
		}
		return null;
	}

	@Override
	public Type logical() {
		if (getType() instanceof TypeNormal) {
			return getType().logical();	
		}
		return null;
	}

	@Override
	public Type logical(Type type) {
		if (getType() instanceof TypeNormal) {
			return getType().logical(type);	
		}
		return null;
	}


	@Override
	public Type invocation() {
		if (getType() instanceof TypeNormal) {
			return getType().invocation();	
		}
		return null;
	}

	

	@Override
	public String toString() {
		return "Function type"; 
	}

	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

}
