package ej1;

import java.util.ArrayList;

public class Nodo {
	int valor;
	ArrayList<Adyacente> adyacentes ;

	public Nodo(int valor) {
		adyacentes = new ArrayList<Adyacente>();
		this.valor = valor;
	}

	public ArrayList<Adyacente> getAdyacentes() {
		return adyacentes;
	}

	public Adyacente getAdyacenteAt(int pos){
		return adyacentes.get(pos);
	}

	public Adyacente getAdyacente(int valor){
		for (Adyacente adyacente : adyacentes) {
			if (adyacente.getDestino().getValor() == valor){
				return adyacente;
			}
		}
		return null;
	}

	public int getValor() {
		return valor;
	}

	public void addAdyacente(Adyacente ady) {
		adyacentes.add(ady);
	}

}
