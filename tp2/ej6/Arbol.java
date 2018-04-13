package ej6;

public class Arbol {
	
	Nodo raiz;

	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public boolean isEmpty() {
		return this.raiz == null;
	}
	
	private boolean hasElem(Nodo raizActual, Comparable o) {
		if (raizActual != null) {
			if (raizActual.getInfo().equals(o)) {
				return true;
			}else if (raizActual.getInfo().compareTo(o) < 0) {
				return hasElem(raizActual.izq, o);
			}else {
				return hasElem(raizActual.der, o);
			}
		}
		return false;
	}
	
	public boolean hasElem(Comparable o) {
		return hasElem(raiz, o);
	}
	
	public void insert(Comparable o) {
		if (this.raiz == null)
			this.raiz = new Nodo(o);
		else
			insert(this.raiz, o);
	}
	
	private void insert(Nodo raizActual, Comparable o) {
		if(o.compareTo(raizActual.getInfo()) < 0) {
			if (raizActual.getIzq() == null) {
				raizActual.setIzq(new Nodo(o));
			}else {
				insert(raizActual.getIzq(), o);
			}
		}else if (raizActual.getDer() == null) {
			raizActual.setDer(new Nodo(o));
		}
			
		else
			insert(raizActual.getDer(), o);
	}
	
	public void printPosOrder() {
		
	}
	
	public void printInOrder() {
		
	}

	public void printPreOrder() {
	
	}
	
}
