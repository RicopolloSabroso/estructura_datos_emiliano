package estructura.nodo;

public class NumericNodo {
	private Object dato;
	private NumericNodo enlace;
	private Integer prioridad;
	
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public NumericNodo getEnlace() {
		return enlace;
	}
	public void setEnlace(NumericNodo enlace) {
		this.enlace = enlace;
	}
}