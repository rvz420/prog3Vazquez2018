package ej6;

public class Main {

	public static void main(String[] args) {
		Arbol a = new Arbol(new Nodo("h"));
		a.insert("c");
		a.insert("a");
		a.insert("b");
		a.insert("z");
		a.insert("w");
		a.insert("d");
		a.insert("s");
		a.insert("x");
		a.insert("y");
		
		
		System.out.println(a.hasElem("x"));
		System.out.println("altura: "+a.getHeight());
		System.out.println(a.printInOrder());
		System.out.println("Rama mas larga: "+a.getLongestBranch().toString());
		System.out.println("Frontera: "+a.getFrontera().toString());
		System.out.println("Max Elem: "+a.getmaxElem().toString());
		System.out.println("imprimir un nivel: "+a.getElemAtLevel(5).toString());
		System.out.println(a.delete("c"));
		System.out.println(a.printInOrder());
		
	}

}
