package estructura.arboles;

import estructura.nodo.NumericNodoArbol;

public class BiTree {
	
	private NumericNodoArbol r;
	
	public BiTree() {
		r=null;
		
	}
	
	public void add(int valor) {
		if (null==r) {
			r=new NumericNodoArbol();
			r.setDato(valor);
		}
		else {
			NumericNodoArbol nodo=new NumericNodoArbol();
			nodo.setDato(valor);
			add(nodo,r);
			
		}
	}
	
	private void add(NumericNodoArbol valor, NumericNodoArbol r) {
		if (valor.getDato( )> r.getDato()) {
			if(null==r.getDerecha()) {
				r.setDerecha(valor);
			}
			else {
				add(valor,r.getDerecha());
			}
		}else {
			if(null==r.getIzquierda()) {
				r.setIzquierda(valor);
			}
			else {
				add(valor,r.getIzquierda());
			}
			
		}
		
	}
	public void preorden() {
		preorden(r);
	}
	private void preorden (NumericNodoArbol nodo) {
		if(null==nodo) {
			return;
		}
		System.out.println(nodo.getDato());
		preorden(nodo.getIzquierda());
		preorden(nodo.getDerecha());

		
	}
	
	public void inorder() {
		inorder(r);
	}
	
	private void inorder(NumericNodoArbol r) {
		if(null!=r) {
			inorder(r.getIzquierda());
			System.out.println(r.getDato());
			inorder(r.getDerecha());
		}
		
	}
}
