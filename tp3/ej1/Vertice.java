package ej1;

import java.util.HashSet;

public class Vertice<T extends Comparable<T>>{

	private T data;
	HashSet<Integer> aristas;

	public Vertice() {
		aristas = new HashSet<Integer>();
	}

	public void agregarArista(Integer i) {
		aristas.add(i);
	}

	public T getData(T) {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int compareTo(T o) {
		return data.compareTo(o);
	}

}
