package estructura.lista;

import estructura.nodo.NumericNodo;

public class ArrayList {
	private Integer size;
	private int increment;
	private Object[] list;
	public ArrayList() {
		this.size=0;
		this.rear=null;
	}
	public Integer size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void add(Object value, Integer priority) {
		
	}
	public Object add() {
		
	}
	public Object set() {
		return null!=front?front.getDato():null;
	}
	public Object get() {
		return null!=rear?rear.getDato():null;
	}
	public Object remove() {
		return null!=front?front.getDato():null;
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
