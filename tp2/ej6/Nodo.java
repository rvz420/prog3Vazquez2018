package ej6;

public class Nodo {
	
	Comparable info;
	Nodo izq;
	Nodo der;
	

	
	public Nodo(Comparable info) {
		this.info = info;
		this.izq = null;
		this.der = null;
	}

	public Nodo getDer() {
		return der;
	}

	public Comparable getInfo() {
		return info;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}

	public void setInfo(Comparable info) {
		this.info = info;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	@Override
	public String toString() {
		return ""+info;
	}
	
}
