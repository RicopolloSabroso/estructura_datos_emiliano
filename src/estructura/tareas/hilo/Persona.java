package estructura.tareas.hilo;

public class Persona {
	private String cuenta;
	private int tarea;
	private int monto;
	private LinkedStack cartera;
	public Persona(String cuenta, int tarea, int monto) {
		this.cuenta=cuenta;
		this.monto=monto;
		this.tarea=tarea;
		
	}
	public String getCuenta() {
		return cuenta;
	}
	public int getTarea() {
		return tarea;
	}
	public int getMonto() {
		return monto;
	}
	
}
