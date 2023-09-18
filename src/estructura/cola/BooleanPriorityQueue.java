package estructura.cola;

import estructura.nodo.BooleanNodo;

public class BooleanPriorityQueue {
	private int size;
	private BooleanNodo front;
	private BooleanNodo rear;
	public BooleanPriorityQueue() {
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
	public void enqueue(Object value, boolean priority) {
		BooleanNodo nodo=new BooleanNodo();
		nodo.setDato(value);
		nodo.setPrioridad(priority);
		if(null==rear) {
			rear=nodo;
			front=rear;
		}else if(priority){
			BooleanNodo temp=front;
			while(null!=temp.getEnlace()&&temp.getEnlace().getPrioridad()){
				temp=temp.getEnlace();
			}
			if(null== temp.getEnlace()) {
				rear.setEnlace(nodo);
				rear=nodo;
			}else {
				BooleanNodo siguiente=temp.getEnlace();
				temp.setEnlace(nodo);
				nodo.setEnlace(siguiente);
			}
		}else {
			rear.setEnlace(nodo);
			rear=nodo;
		}
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
		BooleanNodo temp=front;
		String s="";
		while(null!=temp) {
			s=temp.getDato()+"->"+s;
			temp=temp.getEnlace();
		}
		return s;
	}
}
