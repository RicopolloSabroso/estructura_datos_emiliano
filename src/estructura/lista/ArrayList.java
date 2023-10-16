package estructura.lista;

import estructura.nodo.NumericNodo;

public class ArrayList {
	private Integer size;
	private int increment;
	private Object[] list;
	public ArrayList() {
		this.size=0;
		this.increment=10;
		list=new Object[20];
	}
	public ArrayList(int size, int increment) {
		this.size=0;
		this.increment=increment;
		list=new Object[size];
	}
	public Integer size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void add(Object value) {
		add(size,value);
	}
	public void add(Integer index, Object value) {
		int nIndex=index>size?size:index;
		if(size>=list.length){
			incrementaArray();
		}
		if(nIndex<size){
			for(int i=size-1;i> nIndex;i--) {
				list[i+1]=list[i];
			}
		}
		list[nIndex]=value;
		size++;
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
