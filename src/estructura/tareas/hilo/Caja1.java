package estructura.tareas.hilo;
import estructura.tareas.hilo.*;
public class Caja1 extends Thread{
	Billete cajaExpendedora= new Billete();
	private String cuenta;
	private int tarea;
	private int monto;
	private boolean estado=false;
	
	Ingresar ingreso=new Ingresar();	
	public void run() {
			try {
				if(!ingreso.cola.isEmpty()) {
					estado=true;	
					Persona persona=(Persona)ingreso.cola.dequeue();
					tarea= persona.getTarea();
					monto=persona.getMonto();
					cuenta=persona.getCuenta();	
					sleep((int)(1+Math.random()*10000));
					
				}
			}catch(InterruptedException e) {}
			estado=false;
		}
	public void meterMonedas(LinkedStack monedas, Cambios cambios) {
		int aux;
		double moneda;
		do {
			moneda=Double.parseDouble(String.valueOf(monedas.pop()));
			aux=((moneda==.5)?-1:(int)moneda);
			switch (aux) {
			case -1:
				if (!(cambios.getCentavo50().size()==100)) {
					cambios.getCentavo50().push(moneda);
				}
				break;
			case 1:
				if (!(cambios.getMoneda1().size()==100)) {
					cambios.getMoneda1().push(moneda);
				}
				break;
			case 2:
				if (!(cambios.getMoneda2().size()==100)) {
					cambios.getMoneda2().push(moneda);
				}
				break;
			case 5:
				if (!(cambios.getMoneda5().size()==100)) {
					cambios.getMoneda5().push(moneda);
				}
				break;
			case 10:
				if (!(cambios.getMoneda10().size()==100)) {
					cambios.getMoneda10().push(moneda);
				}
				break;
			case 20:
				if (!(cambios.getMoneda20().size()==100)) {
					cambios.getMoneda20().push(moneda);
				}
				break;
			}
		}while (monedas.size()>0);
	}
	public Billete getCajaExpendedora() {
		return cajaExpendedora;
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
	public boolean getEstado() {
		return estado;
	}
}


