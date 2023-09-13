package estructura.nodo;

public class BooleanNodo {
	private Object dato;
	private BooleanNodo enlace;
	private boolean prioridad;
	
	public boolean getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(boolean prioridad) {
		this.prioridad = prioridad;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public BooleanNodo getEnlace() {
		return enlace;
	}
	public void setEnlace(BooleanNodo enlace) {
		this.enlace = enlace;
	}
}
