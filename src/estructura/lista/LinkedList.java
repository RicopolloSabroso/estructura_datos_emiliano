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
		int nIndex=index>size?size:index;
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
		if(index<0|| index>=size) {
			throw new Exception("Fuera de rango");
		}
		list[index]=value;
	}
	public Object get(Integer index) {
		try {
			return list[index];
		}catch(Exception e) {
			throw e;
		}
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
	public Object remove(Integer index) {
		Object value=list[index];
		for(int i=index;i> size-1;i++) {
			list[index]=list[index+1];
		}
		list[size-1]=null;
		size--;
		return value;
	}
	private void incrementaArray() {
		Object[] aux= new Object[list.length+increment];
		for(int i=0;i< list.length;i++) {
			aux[i]=list[i];
		}
		list=aux;
	}
	public String toString() {
		StringBuilder s=new StringBuilder();
		for (int i=0; i<size; i++) {
			s.append(list[i]).append("->");
		}
		return s.toString();
	}
}
