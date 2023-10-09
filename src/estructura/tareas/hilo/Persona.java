package estructura.tareas.hilo;

import estructura.pila.LinkedStack;

public class Persona {
	private String cuenta;
	private int tarea;
	private int monto;
	private LinkedStack cartera=new LinkedStack();
	public boolean prioridad;
	public Persona(String cuenta, int tarea, boolean prioridad) {
		this.cuenta=cuenta;
		this.tarea=tarea;
		this.prioridad=prioridad;
		int total=(int)(Math.random()*9000);
		if(tarea==0){
			int[] cambio = {1,5,10,20,50,100,200,500};
			int dinero=0;
			do {
				int aleatorio=cambio[(int)(Math.random()*7)];
				if(dinero+aleatorio<=total) {
					cartera.push(aleatorio);
		            dinero=dinero+aleatorio;
				}
	        }while(dinero<total);
			this.monto=dinero;
		}
		this.monto=total;
	}
	public void setCartera(LinkedStack cartera) {
		this.cartera = cartera;
	}
	public LinkedStack getCartera() {
		return cartera;
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
