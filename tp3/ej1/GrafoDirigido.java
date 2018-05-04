package ej1;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")

public class GrafoDirigido {
	
	ArrayList<Vertice> vertices;

	public GrafoDirigido() {
		this.vertices = new ArrayList<Vertice>();
	}

	public void agregarVertice (Vertice v) {
		vertices.add(v);
	}


	public void agregarArista( Vertice deVertice, Vertice aVertice) {
		deVertice.agregarArista(aVertice.g);
	}

}
