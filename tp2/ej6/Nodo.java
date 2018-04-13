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

	public Comparable getInfo() {
		return info;
	}

	public void setInfo(Comparable info) {
		this.info = info;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public Nodo getDer() {
		return der;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}
	
	
}
