package ej1;

import java.util.ArrayList;

public class Nodo {
	int valor;
	ArrayList<Adyacente> adyacentes ;

	public Nodo(int valor) {
		adyacentes = new ArrayList<Adyacente>();
		this.valor = valor;
	}

	public void addAdyacente(Adyacente ady) {
		adyacentes.add(ady);
	}

	public Adyacente getAdyacente(int valor){
		for (Adyacente adyacente : adyacentes) {
			if (adyacente.getDestino().getValor() == valor){
				return adyacente;
			}
		}
		return null;
	}

	public Adyacente getAdyacenteAt(int pos){
		return adyacentes.get(pos);
	}

	public ArrayList<Adyacente> getAdyacentes() {
		return adyacentes;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}
	
	
	
}
