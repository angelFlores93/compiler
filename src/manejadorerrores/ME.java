package manejadorerrores;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import asttree.TypeError;

public class ME {

	private ME()  {}
	
	private static ME instancia=new ME();
	
	public static ME getME() { return instancia; }

	private List<TypeError> errores=new ArrayList<TypeError>();
	
	public void addError(TypeError error) {
		errores.add(error);
	}
	
	public void mostrarErrores(PrintStream out) {
		for (int i=0;i<errores.size();i++)
			out.println(errores.get(i).getError());
	}
	
	public boolean huboErrores() {
		return errores.size()>0;
	}
}
