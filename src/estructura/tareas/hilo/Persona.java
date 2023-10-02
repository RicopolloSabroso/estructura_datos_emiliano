package estructura.tareas.hilo;

public class Persona {
	private long cuenta;
	private int tarea;
	private int monto;
	public Persona(long cuenta, int tarea, int monto) {
		this.cuenta=cuenta;
		this.monto=monto;
		this.tarea=tarea;
	}
	public long getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	public int getTarea() {
		return tarea;
	}
	public void setTarea(int tarea) {
		this.tarea = tarea;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
}
