// =======================================================
// L�xico, sint�ctico, Sem�ntico, Generador de c�digo, etc
import sintactico.Sintactico;
import visitor.*;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import lexico.Lexico;

import java.io.File;
// ===================
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import CodeGeneration.Instructions;
import CodeGeneration.VisitorCodeGeneration;
import asttree.AST;
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
			if (errors.size() > 0){
				for (TypeError error : errors){
					System.err.println(error.getError());
				}
				return;
			}
			System.err.println("__________________Calling TypeCheck Visitor_________________");
			sintactico.ast.accept(new VisitorTypeCheck(errors), null);
			if (errors.size() > 0){
				for (TypeError error : errors){
					System.err.println(error.getError());
				}
				return;
			}
			System.err.println("__________________Calling LValue Visitor_________________");
			sintactico.ast.accept(new VisitorLValue(errors), null);
			if (errors.size() > 0){
				for (TypeError error : errors){
					System.err.println(error.getError());
				}
				return;
			}
			
			System.err.println("__________________Calling CodeGeneration Visitor_________________");
			PrintWriter writer = new PrintWriter("code.j", "UTF-8");
			sintactico.ast.accept(new Instructions(writer), null);
			writer.close();
			
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