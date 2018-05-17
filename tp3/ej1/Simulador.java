package ej1;

public class Simulador {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();

//		for (int i = 0; i < 5; i++) {
//			grafo.addVertice(i);
//			grafo.addVertice(i+1);
//			grafo.insertarArista(i, i+1);
//		}
//		
		
		grafo.addVertice(0);
		grafo.addVertice(1);
		grafo.addVertice(2);
		grafo.addVertice(3);

		grafo.insertarArista(0, 1);
		grafo.insertarArista(0, 2);
		grafo.insertarArista(1, 2);
		grafo.insertarArista(2, 0);
		grafo.insertarArista(2, 3);
		
		System.out.println(grafo.bfs(grafo.buscarVertice(0)));
		
		System.out.println("Iterable hay ciclo?:"+grafo.esCiclicoRecursivo());		

	}

}
