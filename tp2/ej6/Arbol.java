package ej6;

import java.util.ArrayList;
import java.util.List;

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

	private Boolean hasElem(Nodo raizActual, Comparable o) {

		if (raizActual != null) {
			if (raizActual.getInfo().equals(o)) {
				return true;
			}else if (raizActual.getInfo().compareTo(o) > 0) {
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
		}else {
			if (raizActual.getDer() == null) {
				raizActual.setDer(new Nodo(o));
			}else {
				insert(raizActual.getDer(), o);
			}

		}

	}


	public int getHeight() {
		return getHeight(this.raiz);
	}

	private int getHeight(Nodo n) {
		if (n == null) {
			return -1;
		}

		int lefth = getHeight(n.getIzq());
		int righth = getHeight(n.getDer());

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}

	public List<Nodo> getLongestBranch () {
		return getLongestBranch(this.raiz);
	}

	private List<Nodo> getLongestBranch(Nodo n) {
		List<Nodo> retorno = new ArrayList<Nodo>();
		if (n != null) {
			int lefth = getHeight(n.getIzq());
			int righth = getHeight(n.getDer());
			retorno.add(n);
			if (lefth > righth) {
				retorno.addAll(getLongestBranch(n.getIzq()));
			} else {
				retorno.addAll(getLongestBranch(n.getDer()));
			}
		}
		return retorno;
	}

	public List<Nodo> getFrontera() {
		return getFrontera(this.raiz);
	}

	private List<Nodo>getFrontera(Nodo n) {
		List<Nodo> retorno = new ArrayList<Nodo>();
		if (n != null) {
			if (n.getIzq() == null && n.getDer() == null) {
				retorno.add(n);
			}
			retorno.addAll(getFrontera(n.getIzq()));
			retorno.addAll(getFrontera(n.getDer()));
		}
		return retorno;
	}

	public List<Nodo> getElemAtLevel(int i) {
		return getElemAtLevel(this.raiz, i, 0);
	}

	private List<Nodo> getElemAtLevel(Nodo n, int i, int lvlActual) {
		List<Nodo> retorno = new ArrayList<Nodo>();	
		if (n != null) {
			if (i == lvlActual) {
				retorno.add(n);
			} else {
				retorno.addAll(getElemAtLevel(n.getIzq(), i, lvlActual+1));
				retorno.addAll(getElemAtLevel(n.getDer(), i, lvlActual+1));

			}
		}
		return retorno;
	}

	public Object getmaxElem() {
		return getMaxElem(this.raiz);
	}

	private Object getMaxElem(Nodo n) {
		Object retorno = n.getInfo();
		if (n.getDer() != null) {
			retorno = getMaxElem(n.getDer());
		}
		return retorno;
	}

	public Boolean delete(Comparable o) {
		return delete(this.raiz, o, null);
	}

	private Boolean delete(Nodo n, Comparable o, Nodo padre) {
		if(n != null) {
			if (n.getInfo().equals(o)) {
				if (esHoja(n)) {	//si es hoja se borra directamente
					if (n.getInfo().compareTo(padre.getInfo()) >= 0) {
						padre.setDer(null);
					}else {
						padre.setIzq(null);
					}
				}else if (n.getDer() != null && n.getIzq() != null) { //buscar el menor de los mayores
					Nodo nmi = getNmi(n.getDer());
					n.setInfo(nmi.getInfo());
					delete(n.getDer(), nmi.getInfo(), n);
				}else { //si tiene un hijo solo acomodamos el puntero para ignorar el nodo borrado
					if (n.getInfo().compareTo(padre.getInfo()) >= 0) {
						if (n.getIzq() != null) {
							padre.setDer(n.getIzq());
						}else {
							padre.setDer(n.getDer());
						}
					}else {
						if (n.getIzq() != null) {
							padre.setIzq(n.getIzq());
						}else {
							padre.setIzq(n.getDer());
						}
					}
				}
				return true;
			}else if (n.getInfo().compareTo(o) > 0) {
				return delete(n.getIzq(), o, n);
			}else {
				return delete(n.getDer(), o, n);
			}
		}
		return false;
	}
	private Nodo getNmi(Nodo n) {
		Nodo retorno = n;
		if (n.getIzq() != null) {
			retorno = getNmi(n.getIzq());
		}
		return retorno;
	}
	private String preOrder (Nodo nodoActual) {
		String retorno = "";
		if (nodoActual != null) {
			retorno += nodoActual.toString();
			retorno += preOrder(nodoActual.getIzq());		
			retorno += preOrder(nodoActual.getDer());
		}else {
			retorno += "_";
		}
		return retorno;
	}

	private String inOrder (Nodo nodoActual) {
		String retorno = "";
		if (nodoActual != null) {
			retorno += inOrder(nodoActual.getIzq());
			retorno += nodoActual.toString();
			retorno += inOrder(nodoActual.getDer());
		}else {
			retorno += "_";
		}
		return retorno;
	}

	private String postOrder (Nodo nodoActual) {
		String retorno = "";
		if (nodoActual != null) {
			retorno += postOrder(nodoActual.getIzq());
			retorno += postOrder(nodoActual.getDer());
			retorno += nodoActual.toString();
		}else {
			retorno += "_";
		}
		return retorno;
	}
	
	private boolean esHoja (Nodo n) {
		return (n.getIzq() == null && n.getDer() == null);
	}
	
	public String printPosOrder() {
		return postOrder(this.raiz);
	}

	public String printInOrder() {
		return inOrder(this.raiz);
	}

	public String printPreOrder() {
		return preOrder(this.raiz);
	}

}
