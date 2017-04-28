package asttree;



public class TypeError extends AbstractType implements Type {
	private String error;
	
	public TypeError(int column, int line, String error) {
		super(column, line);
		this.error = error;
		// TODO Auto-generated constructor stub
	}
	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Error Type";
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
