package tpe2;

public class Adyacente {

	private Nodo destino;
	private double peso;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adyacente other = (Adyacente) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		return true;
	}
	
	
}