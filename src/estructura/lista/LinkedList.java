package estructura.lista;

import estructura.nodo.Nodo;
public class LinkedList {
	private Integer size;
	private Nodo apuntador;
	
	public LinkedList() {
		this.size=0;
		apuntador=null;
	}

	public Integer size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void add(Object value) {
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
	private void addFirst(Nodo value) {
		Nodo actual=apuntador;
		while(null!= actual.getEnlace()) {
			actual=actual.getEnlace();
		}
		actual.setEnlace(value);
		size++;
	}
	private void addMiddle(int index, Nodo value) {
		int tempSize=size-1;
		Nodo actual=apuntador;
		while(tempSize>index) {
			actual=actual.getEnlace();
			tempSize--;
		}
		Nodo siguiente=actual.getEnlace();
		actual.setEnlace(value);
		value.setEnlace(siguiente);
		size++;
	}
	public void add(Integer index, Object value) throws Exception{
		if(index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}//Stack.trace
		Nodo nodo=new Nodo();
		nodo.setDato(value);
		if(index==0) {
			addFirst(nodo);
		}else if(index==size-1) {
			add(value);
		}else {
			addMiddle(index, nodo);
		}
	}
	public void set(Integer index, Object value) throws Exception{
		int tempSize=size-1;
		Nodo actual=apuntador;
		if(index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}
		while(tempSize>index) {
			actual=actual.getEnlace();
			tempSize--;
		}
		actual.setDato(value);
	}
	public Object get(Integer index)throws Exception {
		int tempSize=size-1;
		Nodo actual=apuntador;
		if(index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}
		while(tempSize>index) {
			actual=actual.getEnlace();
			tempSize--;
		}
		return actual.getDato();
	} 

	private Object removeFirst() {
		Nodo temp=apuntador;
		Object value;
		int tempSize=size-1;
		while(null!=temp.getEnlace() && tempSize>1) {
			temp=temp.getEnlace();
			tempSize--;
		}
		value=temp.getEnlace().getDato();
		temp.setEnlace(null);
		size--;
		return value;
	}
	
	private Object removeLast() {
		Object value=null;
		if(null!=apuntador) {
			value=apuntador.getDato();
			this.apuntador=apuntador.getEnlace();
			size--;
		}
		return value;
	}
	private Object removeMiddle(int index) {
		Object value=null;
		int tempSize=size-2;
		Nodo actual=apuntador;
		while(tempSize>index) {
			actual=actual.getEnlace();
			tempSize--;
		}
		Nodo siguiente=actual.getEnlace();
		value=siguiente.getDato();
		actual.setEnlace(siguiente.getEnlace());
		size--;
		return value;
	}
	public Object remove(Integer index) throws Exception{
		Object value;
		if(index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}//Stack.trace
		if(index==0) {
			value=removeFirst();
		}else if(index==size-1) {
			value=removeLast();
		}else {
			value=removeMiddle(index);
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
