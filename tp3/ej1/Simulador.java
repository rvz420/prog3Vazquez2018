package ej1;

public class Simulador {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();

		for (int i = 0; i < 50; i++) {
			grafo.addVertice(i);
			grafo.addVertice(i+1);
			grafo.insertarArista(i, i+1);
		}

	}

}
