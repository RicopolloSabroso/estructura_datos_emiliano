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
	public void enqueue(Object value, boolean prioridad) 
	{
		BooleanNodo nodo = new BooleanNodo();
	    nodo.setDato(value);
	    nodo.setPrioridad(prioridad);

	    if (null == front) 
	    {
	    	front = nodo;
	        rear = nodo;
	    }
	    else if (prioridad) 
	    {
	     
	        BooleanNodo temp = front;
	        BooleanNodo prev = null;

	        while (temp != null && temp.getPrioridad()) 
	        {
	            prev = temp;
	            temp = temp.getEnlace();
	        }

	        if (prev != null) 
	        {
	            prev.setEnlace(nodo);
	            nodo.setEnlace(temp);
	        }
	        else 
	        {
	        	nodo.setEnlace(front);
	        	front = nodo;
	        }
	    } 
	    else 
	    {
	        rear.setEnlace(nodo);
	        rear= nodo;
	    }

	    size++;
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
