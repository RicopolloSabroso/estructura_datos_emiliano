package estructura.cola;

import estructura.nodo.Nodo;

public class LinkedQueue {
	private int size;
	private Nodo front;
	private Nodo rear;
	public LinkedQueue() {
		this.size=0;
		this.rear=null;
		this.front=null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void enqueue(Object value) {
		Nodo nodo=new Nodo();
		nodo.setDato(value);
		if(null!=rear) {
			rear.setEnlace(nodo);
		}else if(null==front) {
			this.front=nodo;
		}
		this.rear=nodo;
		this.size++;
	}
	public Object dequeue() {
		Object value=null;
		if(null!=front) {
			value= front.getDato();
			front=front.getEnlace();
			size--;
		}
		return value;
	}
	public Object front() {
		return null!=front?front.getDato():null;
	}
	public Object rear() {
		return null!=rear?rear.getDato():null;
	}
	public String toString() {
		Nodo temp=front;
		String s="";
		while(null!=temp) {
			s=temp.getDato()+"->"+s;
			temp=temp.getEnlace();
		}
		return s;
	}
}
