package tpe2;

import java.util.ArrayList;

public class Nodo {
	String valor;
	ArrayList<Adyacente> adyacentes ;

	public Nodo(String valor) {
		adyacentes = new ArrayList<Adyacente>();
		this.valor = valor;
	}

	public void addAdyacente(Adyacente ady) {
		if (!adyacentes.contains(ady)) {			
			adyacentes.add(ady);
		}else {
			Adyacente ad = getAdyacente(ady.getDestino().getValor());
			ad.setPeso(ad.getPeso()+1);
			
		}
	}

	public Adyacente getAdyacente(String valor){
		for (Adyacente adyacente : adyacentes) {
			if (adyacente.getDestino().getValor().equals(valor)){
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

	public String getValor() {
		return valor;
	}

	public String imprimirAdyacentes() {
		String retorno="";
		for (Adyacente adyacente : adyacentes) {
			retorno += valor+" -> "+ adyacente.destino.getValor()+"[label=\""+adyacente.getPeso()+"\",weight=\""+adyacente.getPeso()+"\"];\n"; 
		}
		return retorno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Nodo other = (Nodo) obj;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
		
}
