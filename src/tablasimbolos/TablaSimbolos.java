package tablasimbolos;

import java.util.*;

import asttree.*;


public class TablaSimbolos {
	
	private int ambito = 0; //0 - global , 1 - local
	private List<Map<String,InstructionDefinition>> tabla;
	private static TablaSimbolos simbolos = new TablaSimbolos();
	private TablaSimbolos() {
		tabla = new ArrayList<Map<String,InstructionDefinition>>();
		tabla.add(new HashMap <String, InstructionDefinition>());
		tabla.add(new HashMap <String, InstructionDefinition>());
		
	}
	
	public List<Map<String, InstructionDefinition>> getTabla() {
		return tabla;
	}

	public void setTabla(List<Map<String, InstructionDefinition>> tabla) {
		this.tabla = tabla;
	}

	public static TablaSimbolos getTablaSimbolos (){
		return simbolos;
	}
	
	public int getAmbito() {
		return ambito;
	}

	public void setAmbito(int ambito) {
		this.ambito = ambito;
	}

	public void set() {
		
	}

	public void reset() {
		tabla.remove(1);
		tabla.add(new HashMap <String, InstructionDefinition>());
	}
	
	public boolean insertar(InstructionDefinition simbolo, int index) {
		RegularExpressionVariable aux = (RegularExpressionVariable)simbolo.getName();
		if (buscarAmbitoActual(aux.getName()) == null){
			tabla.get(index).put(aux.getName(), simbolo);
			
			return true;
		}
		return false;
	}

	public InstructionDefinition buscarReferenciasLocal(String id) {
		return buscarAmbitoActual(id);
	}
	public InstructionDefinition buscarReferenciasGlobales(String id) {
		Map <String, InstructionDefinition> map;
		map = tabla.get(0);
		
		if (map.containsKey(id))
			return map.get(id);
		return null;
	}
	public InstructionDefinition buscar(String id) {
		int i; 
		Map<String,InstructionDefinition>map;
		for (i = 1; i>0; i--){
			map = simbolos.getTabla().get(i);
			if (map.containsKey(id))
				return (InstructionDefinition) map.get(id);
		}
		return null;
	}
	public InstructionDefinition buscarAmbitoActual(String id) {
		Map <String, InstructionDefinition> map = tabla.get(1);
		if (map.containsKey(id))
			return map.get(id);
		return null;
	}
	public void printLocal(){
		System.err.println("Local map size: " + tabla.get(1).size());
		Map <String, InstructionDefinition> defs =  tabla.get(1);
		
		for (InstructionDefinition d : defs.values()){
			System.err.println("Variable: " +((RegularExpressionVariable) d.getName()).getName() );
		}
	}
	public void print (){
		System.err.println("Global map size: " + tabla.get(0).size());
		Map <String, InstructionDefinition> defs =  tabla.get(0);
		for (InstructionDefinition d : defs.values()){
			System.err.println("Variable: " +((RegularExpressionVariable) d.getName()).getName() );
		}
		
	}
}
