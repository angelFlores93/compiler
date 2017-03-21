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
		sintactico.run();
		IntrospectorModel model=new IntrospectorModel("Program", sintactico.ast);
		new IntrospectorTree("Introspector", model);
		//System.err.println("__________________Calling PrettyPrint Visitor_________________");
		
		//sintactico.ast.accept(new VisitorIdentifier(),null);
		
		//System.err.println("__________________Calling TypeCheck Visitor_________________");
		
		//sintactico.ast.accept(new VisitorTypeCheck(),null);
		// * The AST is shown
		
		

	}

}