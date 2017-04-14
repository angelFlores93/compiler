// =======================================================
// Léxico, sintáctico, Semántico, Generador de código, etc
import sintactico.Sintactico;
import visitor.*;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import lexico.Lexico;


// ===================
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import asttree.TypeError;

public class Main 
{

	public static void main(String args[]) throws IOException {
	    if (args.length !=1)
		{	
	    	
			System.err.println("__________________________________________________________");
	        System.err.println("Usage: CALCULATOR  inputFile.exp");
			return;
	    }
	        
		FileReader fileReader=null;
		try {
			fileReader = new FileReader(args[0]);
		} catch(IOException io) 
		{
			System.err.println("__________________________________________________________");
			System.err.println("Source File: "+args[0]+" not Found!!!!!.");
			System.err.println("__________________________________________________________");
			return;
		}
		
		System.err.println("__________________Creating Scanner_____________________________");
		Lexico lexico = new Lexico(fileReader);
		System.err.println("__________________Creating Parser from Scanner_________________");
		Sintactico sintactico = new Sintactico(lexico);
		
		System.err.println("__________________Running Parser_______________________________");
		try {
			sintactico.run();
			System.err.println("__________________Calling Identifier Visitor_________________");
			List<TypeError> errors = new ArrayList<TypeError>();
			sintactico.ast.accept(new VisitorIdentifier(errors),null);
			System.err.println("__________________Calling LValue Visitor_________________");
			sintactico.ast.accept(new VisitorLValue(errors), null);
			for (TypeError error : errors){
				System.err.println(error.getError());
			}
			IntrospectorModel model=new IntrospectorModel("Program", sintactico.ast);
			new IntrospectorTree("Introspector", model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		
		//System.err.println("__________________Calling TypeCheck Visitor_________________");
		
		//sintactico.ast.accept(new VisitorTypeCheck(),null);
		// * The AST is shown
		
		

	}

}