package estructura.cola;
import estructura.nodo.NumericNodo;

public class NumericPriorityQueue {
	private int size;
	private NumericNodo front;
	private NumericNodo rear;
	public NumericPriorityQueue() {
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
	public void enqueue(Object value, Integer priority) {
		NumericNodo nodo=new NumericNodo();
		nodo.setDato(value);
		nodo.setPrioridad(priority);
		if(null==rear) {
			rear=nodo;
			front=rear;
		}else{
			NumericNodo temp=front;
			while(null!=temp.getEnlace()&&priority>temp.getEnlace().getPrioridad()){
				temp=temp.getEnlace();
			}
			if(null== temp.getEnlace()) {
				rear.setEnlace(nodo);
				rear=nodo;
			}else {
				NumericNodo siguiente=temp.getEnlace();
				temp.setEnlace(nodo);
				nodo.setEnlace(siguiente);
			}
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
		NumericNodo temp=front;
		String s="";
		while(null!=temp) {
			s=temp.getDato()+"->"+s;
			temp=temp.getEnlace();
		}
		return s;
	}
}
