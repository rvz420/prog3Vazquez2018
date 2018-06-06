package tpe2;

import java.util.ArrayList;

public class Nodo {
	private String valor;
	private ArrayList<Adyacente> adyacentes;

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

	public ArrayList<Adyacente> getAdyacentesMasBuscados(int n) {
		if(n > adyacentes.size()) {
			return new ArrayList<Adyacente>();
		}else{
			ArrayList<Adyacente> aux = new ArrayList<Adyacente>(adyacentes);
			ArrayList<Adyacente> retorno = new ArrayList<Adyacente>();
			Adyacente adMayor;
			for (int i = 0; i < n; i++) {
				double mayor = Integer.MIN_VALUE;
				adMayor = null;
				for (Adyacente adyacente : aux) {
					if(adyacente.getPeso() > mayor) {
						mayor = adyacente.getPeso();
						adMayor = adyacente;
					}
				}
				aux.remove(adMayor);
				retorno.add(adMayor);
			}
			return retorno;
		}
	}

	public String getValor() {
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	public String imprimirAdyacentes() {
		String retorno="";
		for (Adyacente adyacente : adyacentes) {
			retorno += valor+" -> "+ adyacente.getDestino().getValor()+"[label=\""+adyacente.getPeso()+"\",weight=\""+adyacente.getPeso()+"\"];\n"; 
		}
		return retorno;
	}
	
	public boolean tengoDestinoA(String i) {
		for (Adyacente ady : adyacentes) {
			if (ady.getDestino().getValor().equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}

}
