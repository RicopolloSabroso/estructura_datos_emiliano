package estructura.nodo;

public class NumericNodoArbol {
	private Integer value;
	private NumericNodoArbol derecha;
	private NumericNodoArbol izquierda;
	public Integer getDato() {
		return value;
	}
	public void setDato(int dato) {
		this.value = value;
	}
	public NumericNodoArbol getDerecha() {
		return derecha;
	}
	public void setDerecha(NumericNodoArbol derecha) {
		this.derecha = derecha;
	}
	public NumericNodoArbol getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(NumericNodoArbol izquierda) {
		this.izquierda = izquierda;
	}
}
