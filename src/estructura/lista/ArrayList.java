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
	public void set(Integer index, Object value) {
		return null!=front?front.getDato():null;
	}
	public Object get(Integer index) {
		return null!=rear?rear.getDato():null;
	}
	public Object remove(Integer index) {
		return null!=front?front.getDato():null;
	}
	private void incrementaArray() {
		Object[] aux= new Object[list.length+increment];
		for(int i=0;i< list.length;i++) {
			aux[i]=list[i];
		}
		list=aux;
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
