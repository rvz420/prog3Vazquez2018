package ej1;

import java.util.ArrayList;

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
	
	public Nodo buscarVertice(int valor){
		for (Nodo nodo : vertices) {
			if (valor == nodo.getValor()){
				return nodo;
			}
		}
		return null;
}
	
}