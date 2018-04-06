package ej1;

public class SimpleLinkedList implements Iterable<Object>{
	protected Node first;
	protected int size = 0;
	
	public SimpleLinkedList() {
		first = null;
	}
	
	public void insertFirst(Object o) {
		Node tmp = new Node(o, null);
		tmp.setNext(first);
		this.first = tmp;
		this.size++;
	}
	
	//public Object extract() {	}
	
	public void print(int n) {
		
	}
	
	public boolean isEmpty(){
		return this.first == null;
	}
	
	public int size(){
		return this.size;
	}
	
	public Node getNode(int n) {
		Node tmp = null;
		if((n>=0)&&(n<this.size())) {
			tmp = first;
			for (int i = 0; i < n; i++) {
				tmp = tmp.getNext();
			}
		}	
		return tmp;
	}
	
	public Node extractFirst(){
		Node ret = first;
		this.first = this.first.getNext();
		return ret;
	}

	@Override
	public String toString() {
		return "SimpleLinkedList [first=" + first + ", size=" + size + "]";
	}
	
	@Override
	public MyListIterator iterator() {
		MyListIterator it = new MyListIterator(first);
		return it;
	}
	
	
}