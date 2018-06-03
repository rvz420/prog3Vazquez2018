package tpe2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

	int tamanio;
	ArrayList<Nodo> vertices;

	public Grafo(){
		vertices=new ArrayList<Nodo>();
		tamanio = 0;
	}

	public void addVertice(String valor){
		Nodo aIngresar = new Nodo(valor);
		if (!vertices.contains(aIngresar))
			vertices.add(aIngresar);
	}

	public ArrayList<Nodo> bfs(Nodo inicial) {
		ArrayList<Nodo> retorno = new ArrayList<Nodo>();
		Hashtable<Nodo, EstadoVisita> tablaVisita = new Hashtable<Nodo, EstadoVisita>();
		for (Nodo v : vertices) {
			tablaVisita.put(v, EstadoVisita.NO_VISITADO);
		}
		tablaVisita.put(inicial, EstadoVisita.VISITADO);
		Queue<Nodo> cola = new LinkedList<Nodo>();
		cola.add(inicial);
		while (!cola.isEmpty()) {
			Nodo u = cola.remove();
			retorno.add(u);
			for (Adyacente vecino : u.getAdyacentes()) {
				if (tablaVisita.get(vecino.getDestino()) == EstadoVisita.NO_VISITADO ) {
					tablaVisita.put(vecino.getDestino(), EstadoVisita.VISITADO);
					cola.add(vecino.getDestino());
				}
			}
		}
		return retorno;
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
	
	private void dfs_caminoMasLargo(Nodo n, Nodo j, ArrayList<Nodo> caminoActual, ArrayList<Nodo> caminoMasLargo) {
        caminoActual.add(n);
        if (n.getAdyacentes().size() > 0 && !n.equals(j)) {
            for (Adyacente vecino : n.getAdyacentes()) {
                dfs_caminoMasLargo(vecino.getDestino(), j, caminoActual, caminoMasLargo);
            }

        } else if (n.equals(j)){
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }

        }
        caminoActual.remove(n); //se remueve la n para que no repita
    }

    private boolean dfs_visit(Nodo v, Hashtable<String, EstadoVisita> tablaVisita) {
		
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
	
	public ArrayList<Nodo> encontrarCaminoMasLargo(Nodo i, Nodo j){
        ArrayList<Nodo> caminoMasLargo = new ArrayList<Nodo>();

        if(i.equals(j)) {
            return caminoMasLargo;
        }

        for (Adyacente vecino : i.getAdyacentes()) {
            dfs_caminoMasLargo(vecino.getDestino(), j, new ArrayList<Nodo>(), caminoMasLargo);
        }

        return caminoMasLargo;
    }
	
	public boolean esCiclicoRecursivo(){
		Hashtable<String, EstadoVisita> tablaVisita = new Hashtable<String, EstadoVisita>();
		for (Nodo nodo : vertices)
			tablaVisita.put(nodo.getValor(), EstadoVisita.NO_VISITADO);
		
		for (Nodo nodo : vertices)
			if ((tablaVisita.get(nodo.getValor()) == EstadoVisita.NO_VISITADO))
				if (dfs_visit(nodo, tablaVisita)){
					return true;
				}
		return false;
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
			if (!v.adyacentes.isEmpty()) {
				retorno += v.imprimirAdyacentes();
			}else {
				retorno += v.getValor()+";\n";
			}
		}
		return retorno+="}";
	}
	
	
}