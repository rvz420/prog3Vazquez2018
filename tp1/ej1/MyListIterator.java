package ej1;

import java.util.Iterator;

public class MyListIterator implements Iterator<Object>{
	
	private Node n; 
	
	public MyListIterator(Node n) {
		this.n = n;
	}
	
	@Override
	public boolean hasNext() {
		return n != null;
	}

	@Override
	public Object next() {
		Node tmp;
		tmp = n;
		n = n.getNext();
		return tmp.getdata();
	}

}
