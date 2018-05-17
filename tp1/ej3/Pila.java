package ej3;

import ej1.SimpleLinkedList;

public class Pila {
	SimpleLinkedList elements;
	
	public Pila (){
		elements = new SimpleLinkedList();
	}
	
	public void apilar(Object elem){
		elements.insertFirst(elem);
	}
	
	public Object desapilar(){
		return elements.extractFirst();
	}
	
	public boolean esVacia(){
		return elements.isEmpty();
	}
	
	public Object verTope(){
		if(!elements.isEmpty()){
			return elements.getNode(0).getdata();
		}else{
			return null;
		}
	}
	
}
