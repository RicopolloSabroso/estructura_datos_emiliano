package estructura.lista;

import estructura.nodo.BiNodo;

public class DoubleLinkedList {
	private int size;
	private BiNodo f;
	private BiNodo r;

	DoubleLinkedList(){
		size=0;
		f=null;
		r=null;
	}

	public  int size() {
		return size;
	}
	public  boolean isEmpty() {
		return size==0;             //Devuelve un boleano 
	}
	public void addLast(Object value) {
	    BiNodo nodo = new BiNodo(); 
	    nodo.setDato(value); 
	    
	    if (f == null) {
	        
	        f = r = nodo;
	    } else {
	        
	        nodo.setIzquierda(r); 
	        r.setDerecha(nodo);
	        r = nodo; 
	    }
	    
	    size++; 
	}

	public BiNodo search(int index) {
		int mitad=size/2;     //Big decimal
		BiNodo temp=index<mitad?f:r;  //Ternario
		int tempIndex=0;
		if(tempIndex<mitad) {
			tempIndex=0;
			temp=f;
			while(tempIndex<index) {
				tempIndex++;
				temp=temp.getDerecha();
			}
		}
		else {
			tempIndex=size-1;
			temp=r;
			while(tempIndex>index) {
				tempIndex--;
				temp=temp.getIzquierda();
			}
		}
		return temp;
	}
	private void addMiddle(int index,Object value) {
		BiNodo temp=search(index);
		BiNodo nodo=new BiNodo();
		nodo.setDato(value);
		BiNodo derecha=temp.getDerecha();
		nodo.setDerecha(temp);
		nodo.setIzquierda(derecha);
		derecha.setDerecha(nodo);
		temp.setIzquierda(nodo);
		size++;
	}
	private Object removeFirst() {
		BiNodo temp=r;
		Object value;
		int tempSize=size-1;
		while(null!=temp.getIzquierda() && tempSize>1) {
			temp=temp.getIzquierda();
			tempSize--;
		}
		value=temp.getIzquierda().getDato();
		temp.setIzquierda(null);
		size--;
		return value;
	}
	private Object removeLast() {
		Object value=null;
		if(null!=r) {
			value=r.getDato();
			this.r=r.getDerecha();
			size--;
		}
		return value;
	}
	private Object removeMiddle(int index) {
		BiNodo temp=search(index);
		BiNodo derecha=temp.getDerecha();
		BiNodo izquierda=temp.getIzquierda();
		derecha.setIzquierda(izquierda);
		izquierda.setDerecha(derecha);
		temp.setIzquierda(null);
		temp.setDerecha(null);
		size--;
		return temp.getDato();
	}

}
