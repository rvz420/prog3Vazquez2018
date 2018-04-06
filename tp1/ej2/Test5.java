package ej2;
import ej1.Node;
import ej1.SimpleLinkedList;

public class Test5 {
	
	public static void insertFirst(int value, int[] array) {
		for (int i = array.length-1; i > 0 ; i--) {
			array[i] = array[i-1];
		}
		array[0] = value;
	}
	
	public static void main(String[] args) {
		long startTime;
		long totalTime;
		int testElem;
		Node testNode = new Node(7, null);
		
		SimpleLinkedList list5 = new SimpleLinkedList();
		
		int[] array5 = new int[5];
		
		
		//cargar array[5]:
		for (int i = 0; i < array5.length; i++) {
			array5[i] = i;
		}
		
		//cargar lista5
		for (int i = 0; i < 5; i++) {
			list5.insertFirst(i);
		}
		
		//Tests:
		
		System.out.println("1.- Insertar al principio.");
		
		startTime = System.nanoTime();
		insertFirst(7, array5);
		totalTime = System.nanoTime() - startTime;
		System.out.println("Tiempo arreglo[5]: "+totalTime);
		
		startTime = System.nanoTime();
		list5.insertFirst(testNode);
		totalTime = System.nanoTime() - startTime;
		System.out.println("Tiempo nodo[5]: "+totalTime);
		
		//
		
		System.out.println("2.- Buscar un elemento en una posicion.");
		
		startTime = System.nanoTime();
		testElem = array5[array5.length-1];
		totalTime = System.nanoTime() - startTime;
		System.out.println("Tiempo arreglo[5]: "+totalTime);
		
		startTime = System.nanoTime();
		testElem = (int) (list5.getNode(list5.size()-1).getdata());
		totalTime = System.nanoTime() - startTime;
		System.out.println("Tiempo nodo[5]: "+totalTime);
		
		//
		
		System.out.println("3.- Determinar la cantidad de elementos.");
		startTime = System.nanoTime();
		System.out.println("Elementos arreglo[5]: "+array5.length);
		totalTime = System.nanoTime() - startTime;
		System.out.println("Tiempo arreglo[5]: "+totalTime);
		
		startTime = System.nanoTime();
		System.out.println("Elementos nodo[5]: "+list5.size());
		totalTime = System.nanoTime() - startTime;
		System.out.println("Tiempo nodo[5]: "+totalTime);
	}
}
