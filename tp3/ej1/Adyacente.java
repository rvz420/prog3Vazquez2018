package ej1;

public class Adyacente {

	Nodo destino;
	double peso;

	public Adyacente(Nodo destino) {
		this.destino = destino;
		this.peso = 1;
	}

	public Adyacente(Nodo destino, double peso) {
		this.destino = destino;
		this.peso = peso;
	}

	public Nodo getDestino() {
		return destino;
	}

	public double getPeso() {
		return peso;
	}

	public void setDestino(Nodo destino) {
		this.destino = destino;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}