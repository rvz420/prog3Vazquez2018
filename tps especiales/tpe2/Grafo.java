package tpe2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class Grafo {

	private ArrayList<Nodo> vertices;

	public Grafo(){
		vertices=new ArrayList<Nodo>();
	}

	public void addVertice(String valor){
		Nodo aIngresar = new Nodo(valor);
		if (!vertices.contains(aIngresar))
			vertices.add(aIngresar);
	}

	public Nodo buscarVertice(String valor){
		for (Nodo nodo : vertices) {
			if (valor.equals(nodo.getValor())){
				return nodo;
			}
		}
		return null;
	}

	public int cantAristas(){
		int aristas = 0;
		for (Nodo  nodo : vertices) {
			aristas += nodo.getAdyacentes().size();
		}
		return aristas;
	}

	public int cantVertices(){
		return vertices.size();
	}

	public boolean existeArista(String i, String j){
		try {
			return buscarVertice(i).tengoDestinoA(j);
		} catch (Exception e) {
			return false;
		}
	}

	private ArrayList<Nodo> getGenerosLuegoDeBuscar(Nodo nodoActual,Hashtable<Nodo, EstadoVisita> tablaVisita){
		ArrayList<Nodo> retorno = new ArrayList<Nodo>();

		if (tablaVisita.get(nodoActual) != EstadoVisita.VISITADO) {
			retorno.add(nodoActual);
			tablaVisita.put(nodoActual,EstadoVisita.VISITADO);
		}

		if (!nodoActual.getAdyacentes().isEmpty()) {
			for (Adyacente ady : nodoActual.getAdyacentes()) {
				if (tablaVisita.get(ady.getDestino()) != EstadoVisita.VISITADO) {
					retorno.addAll(getGenerosLuegoDeBuscar(ady.getDestino(),tablaVisita));
				}
			}	
		}
		return retorno;
	}

	public ArrayList<Nodo> getGenerosLuegoDeBuscar(String nodo){
		Hashtable<Nodo, EstadoVisita> tablaVisita = new Hashtable<Nodo, EstadoVisita>();
		Nodo n = this.buscarVertice(nodo);
		tablaVisita.put(n,EstadoVisita.VISITADO);
		return getGenerosLuegoDeBuscar(n, tablaVisita);
	}

	public ArrayList<String> getNmasBuscadosDe(int cant, String genero) {  //Devuelve los mas buscados entre los adyacentes del nodo parametro
		Nodo n = buscarVertice(genero);
		if (n != null) {			
			ArrayList<String> retorno = new ArrayList<String>();
			ArrayList<Adyacente> adyacentesMasBuscados = n.getAdyacentesMasBuscados(cant);
			for (Adyacente adyacente : adyacentesMasBuscados) {
				retorno.add(adyacente.getDestino().getValor());
			}
			return retorno;
		}
		return new ArrayList<String>();
	}

	private boolean generosAfines(Adyacente actual, Nodo padre, Grafo g, Hashtable<String, EstadoVisita> tablaVisita){

		boolean retorno = false;
		Nodo nodoActual = actual.getDestino();

		if (padre.getValor().equals(nodoActual.getValor())) {
			tablaVisita.put(nodoActual.getValor(), EstadoVisita.NO_VISITADO);
			return true;
		}

		for (Adyacente ady : nodoActual.getAdyacentes()) {
			if(tablaVisita.get(ady.getDestino().getValor()) != EstadoVisita.VISITADO) {
				tablaVisita.put(ady.getDestino().getValor(), EstadoVisita.VISITADO);
				if(generosAfines(ady, padre, g, tablaVisita)) {
					g.addVertice(nodoActual.getValor());
					if (!g.buscarVertice(nodoActual.getValor()).tengoDestinoA(ady.getDestino().getValor())) {
						g.insertarArista(nodoActual.getValor(), ady.getDestino().getValor(), ady.getPeso());
					}
					tablaVisita.put(ady.getDestino().getValor(), EstadoVisita.NO_VISITADO);
					retorno = true;
				}
				
			}
		}
		tablaVisita.put(nodoActual.getValor(), EstadoVisita.NO_VISITADO);
		return retorno;
	}

	public Grafo generosAfines(String inicial){
		Grafo retorno = new Grafo();
		Nodo n = this.buscarVertice(inicial);

		retorno.addVertice(inicial);

		for (Adyacente ady : n.getAdyacentes()) {
			Hashtable<String, EstadoVisita> tablaVisita= new Hashtable<String, EstadoVisita>();
			if (generosAfines(ady,n, retorno, tablaVisita)) {
				retorno.addVertice(ady.getDestino().getValor());
				retorno.insertarArista(inicial, ady.getDestino().getValor(), ady.getPeso());
			}
		}

		return retorno;
	}

	public void insertarArista(String i, String j){
		Adyacente ady = new Adyacente (buscarVertice(j));
		buscarVertice(i).addAdyacente(ady);
	}

	public void insertarArista(String i, String j, double peso){
		Adyacente ady = new Adyacente (buscarVertice(j), peso);
		buscarVertice(i).addAdyacente(ady);
	}

	@Override
	public String toString() {
		String retorno ="digraph{\n";
		for (Nodo v : vertices) {
			if (!v.getAdyacentes().isEmpty()) {
				retorno += v.imprimirAdyacentes();
			}else {
				retorno += v.getValor()+";\n";
			}
		}
		return retorno+="}";
	}


}