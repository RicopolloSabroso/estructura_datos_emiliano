package estructura.pila;

import estructura.nodo.Nodo;

public class LinkedStack {
	private Nodo apuntador;
	private int size;
	public LinkedStack() {
		this.size=0;
		this.apuntador=null;
	}
	public void push(Object value) {
		Nodo nodo=new Nodo();
		nodo.setDato(value);
		if(null==apuntador) {
			this.apuntador=nodo;
			this.size++;
		}else {
			nodo.setEnlace(apuntador);
			this.apuntador=nodo;
			this.size++;
		}
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return null==apuntador;
	}
	public Object peak() {
		return null!=apuntador?apuntador.getDato():null;
	}

	public Object pop() {
		Object value=null;
		if(null!=apuntador) {
			value=apuntador.getDato();
			this.apuntador=apuntador.getEnlace();
			size--;
		}
	
		return value;
	}
	public String toString() {
		Nodo temp=apuntador;
		String s="";
		while(null!=temp) {
			s=temp.getDato()+"<-"+s;
			temp=temp.getEnlace();
		}
		return s;
	}
	
	
}
