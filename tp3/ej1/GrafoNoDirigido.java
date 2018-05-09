package ej1;

public class GrafoNoDirigido extends Grafo{
	public int cantAristas(){
		return super.cantAristas()/2;
	}

	public void insertarArista(int i, int j){
		super.insertarArista(i, j);
		super.insertarArista(j, i);
	}

	public void insertarArista(int i, int j, double peso){
		super.insertarArista(i, j, peso);
		super.insertarArista(j, i, peso);
	}
}
