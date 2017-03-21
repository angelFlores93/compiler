package asttree;

import java.util.List;

import visitor.Visitor;

public class TypeSpecialStruct extends AbstractType implements TypeSpecial {
	private List<InstructionDefinition> body;
	public TypeSpecialStruct(int column, int line, List<InstructionDefinition> body) {
		super(column, line);
		this.body = body;
		// TODO Auto-generated constructor stub
	}

	public List<InstructionDefinition> getBody() {
		return body;
	}

	public void setBody(List<InstructionDefinition> body) {
		this.body = body;
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
	public Type structAccess(Type type){
		return type;
	}
	
	@Override
	public Object accept(Visitor visitor, Object param) {
		// TODO Auto-generated method stub
		return visitor.visit(this,param);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Struct Type Node" ;
	}

}
