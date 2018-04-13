package ej5;

import ej1.MyListIterator;
import ej1.Node;
import ej1.SimpleLinkedList;

public class Test5 {
	final static int TESTS = 5;
	public static void instertarOrdenado(SimpleLinkedList l, int n ) {
		MyListIterator it = l.iterator();
		Node aInsertar = new Node(n, null);
		boolean inserto = false;
		if (l.isEmpty()) {	//si la lista esta vacia se insterta como primer elemento
			l.insertFirst(n);
		}else if((int)l.getFirst().getdata() > n){ //si es menor que el primero se inserta al principio
			l.insertFirst(n);
		}else {
			while (it.hasNext() && !inserto) { 
				Node nodoActual = it.next();
				if (nodoActual.getNext() != null) {	//se inserta en el lugar que debe ir manteniendo el nodo anterior
					if((int) nodoActual.getNext().getdata() > n) {
						inserto = true;
						aInsertar.setNext(nodoActual.getNext());
						nodoActual.setNext(aInsertar);
					}
				}else { //sino se inserta al final
					l.getNode(l.size()-1).setNext(aInsertar);
				}
				
			}
			l.setSize(l.size()+1);
		}
	}
	
	public static SimpleLinkedList elementosComunes(SimpleLinkedList l1, SimpleLinkedList l2) {
		SimpleLinkedList retorno = new SimpleLinkedList();
		MyListIterator it1 = l1.iterator();
				
		while (it1.hasNext()) {
			boolean comun = false;
			int elem1 = (int) it1.next().getdata();
			MyListIterator it2 = l2.iterator();
			
			while (it2.hasNext() && !comun) {			
				int elem2 = (int) it2.next().getdata();
				
				if (elem1 == elem2) {
					comun = true;
					instertarOrdenado(retorno, elem1);
				}
			}
		}
		
		return retorno;
	}
	
	public static void main(String[] args) {
		
		long startTime;
		long totalTime;
		
		SimpleLinkedList listd1 = new SimpleLinkedList();
		SimpleLinkedList listd2 = new SimpleLinkedList();
		SimpleLinkedList dcomunes = new SimpleLinkedList();
		
		SimpleLinkedList listo1 = new SimpleLinkedList();
		SimpleLinkedList listo2 = new SimpleLinkedList();
		SimpleLinkedList ocomunes = new SimpleLinkedList();
		
		System.out.println("Listas desordenadas:");

		listd1.insertFirst(1);
		listd1.insertFirst(30);
		listd1.insertFirst(10);
		listd1.insertFirst(20);
		listd1.insertFirst(4);

		listd2.insertFirst(10);
		listd2.insertFirst(3);
		listd2.insertFirst(30);
		listd2.insertFirst(2);
		listd2.insertFirst(20);
		
		startTime = System.nanoTime();
		dcomunes = elementosComunes(listd1, listd2);
		totalTime = System.nanoTime() - startTime;
		
		System.out.println("Tardo "+totalTime+ " nanosegundos en encontrar e insertar ordenados los siguientes elementos comunes:");
		
		MyListIterator it = dcomunes.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getdata());
		}
		
		System.out.println("Listas ordenadas:");

		listo1.insertFirst(1);
		listo1.insertFirst(2);
		listo1.insertFirst(3);
		listo1.insertFirst(4);
		listo1.insertFirst(5);

		listo2.insertFirst(3);
		listo2.insertFirst(4);
		listo2.insertFirst(5);
		listo2.insertFirst(6);
		listo2.insertFirst(7);
		
		startTime = System.nanoTime();
		ocomunes = elementosComunes(listo1, listo2);
		totalTime = System.nanoTime() - startTime;
		
		System.out.println("Tardo "+totalTime+ " nanosegundos en encontrar e insertar ordenados los siguientes elementos comunes:");
		
		it = ocomunes.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getdata());
		}
		
	}

}
