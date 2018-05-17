package ej1;

public class Node {
	private Object data;
	private Node next;
	
	public Node() {
		data = null;
		next = null;
	}
	
	public Node(Object i, Node n) {
		setdata(i);
		setNext(n);
	}
	
	public Object getdata() {
		return this.data;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setdata(Object i) {
		this.data = i;
	}
	
	public void setNext(Node n) {
		this.next = n;
	}

	@Override
	public String toString() {
		return "Node [" + data + "]";
	}	
}
