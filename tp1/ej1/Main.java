package ej1;

public class Main {

	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		
		System.out.println("Lista vacia?: "+list.isEmpty());
		System.out.println("Cargando nodos 0, 1, 2");
		
		list.insertFirst(2);
		list.insertFirst(1);
		list.insertFirst(0);
		
		System.out.println("Lista vacia?: "+list.isEmpty());
		System.out.println("Primer elemento: "+list.getNode(0));
		System.out.println("Extract: " + list.extractFirst().toString());
		System.out.println("Nuevo primer elemento: "+list.getNode(0));
		
		MyListIterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}
}
