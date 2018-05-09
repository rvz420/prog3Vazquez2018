package ej1;

import java.util.ArrayList;
import java.util.Hashtable;

public class Grafo {

	int tamanio;
	ArrayList<Nodo> vertices;

	public Grafo(){
		vertices=new ArrayList<Nodo>();
		tamanio = 0;
	}

	public void addVertice(int valor){
		vertices.add(new Nodo(valor));
	}

	public int cantVertices(){
		return vertices.size();
	}

	public int cantAristas(){
		int aristas = 0;
		for (Nodo  nodo : vertices) {
			aristas += nodo.getAdyacentes().size();
		}
		return aristas;
	}

	public void insertarArista(int i, int j){
		Adyacente ady = new Adyacente (buscarVertice(j));
		buscarVertice(i).addAdyacente(ady);
	}

	public void insertarArista(int i, int j, double peso){
		Adyacente ady = new Adyacente (buscarVertice(j), peso);
		buscarVertice(i).addAdyacente(ady);
	}

	public Nodo buscarVertice(int valor){
		for (Nodo nodo : vertices) {
			if (valor == nodo.getValor()){
				return nodo;
			}
		}
		return null;
	}
	
	public boolean esCiclicoRecursivo(){
		Hashtable<Integer, EstadoVisita> tablaVisita = new Hashtable<Integer, EstadoVisita>();
		for (Nodo nodo : vertices)
			tablaVisita.put(nodo.getValor(), EstadoVisita.NO_VISITADO);
		
		for (Nodo nodo : vertices)
			if ((tablaVisita.get(nodo.getValor()) == EstadoVisita.NO_VISITADO))
				if (dfs_visit(nodo, tablaVisita)){
					return true;
				}
		return false;
	}
	
	private boolean dfs_visit(Nodo v, Hashtable<Integer, EstadoVisita> tablaVisita) {
		
		tablaVisita.put(v.getValor(), EstadoVisita.EXPLORANDO);
		
		for (Adyacente vecino : v.getAdyacentes()) {
			if(tablaVisita.get(vecino.getDestino().getValor())==EstadoVisita.NO_VISITADO) {
				return dfs_visit(vecino.getDestino(),tablaVisita);
			} else if (tablaVisita.get(v.getValor()) == EstadoVisita.EXPLORANDO){
				return true;
			}
		}
		
		tablaVisita.put(v.getValor(), EstadoVisita.VISITADO);
		return false;		
	}
	
}