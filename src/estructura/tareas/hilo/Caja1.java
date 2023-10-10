package estructura.tareas.hilo;
import estructura.pila.LinkedStack;
import estructura.tareas.hilo.*;
public class Caja1 extends Thread{
	Billete cajaExpendedora= new Billete();
	public Persona persona;
	private boolean estado=false;
	
	Ingresar ingreso=new Ingresar();	
	public void run() {
			try {
				if(!ingreso.cola.isEmpty()) {
					this.estado=true;	
					this.persona=(Persona)ingreso.cola.dequeue();
					sleep((int)(1+Math.random()*100000));
					if(persona.getTarea()==0) {
						deposito(persona.getCartera());
					}else {
						cajaVacia();
						persona.setCartera(retiro(persona.getMonto()));
					}
				}
			}catch(InterruptedException e) {}
			estado=false;
		}
	public Billete getCajaExpendedora() {
		return cajaExpendedora;
	}
	public Persona getPersona() {
		return persona;
	}
	public boolean getEstado() {
		return estado;
	}
	public void deposito(LinkedStack cartera) {
		int aux;
		double moneda;
		do {
			moneda=Double.parseDouble(String.valueOf(cartera.pop()));
			aux=(int)moneda;
			switch (aux) {
			case 1:
				if (!(cajaExpendedora.getMoneda1().size()==200)) {
					cajaExpendedora.getMoneda1().push(moneda);
				}
				break;
			case 5:
				if (!(cajaExpendedora.getMoneda5().size()==200)) {
					cajaExpendedora.getMoneda5().push(moneda);
				}
				break;
			case 10:
				if (!(cajaExpendedora.getMoneda10().size()==200)) {
					cajaExpendedora.getMoneda10().push(moneda);
				}
				break;
			case 20:
				if (!(cajaExpendedora.getBillete20().size()==200)) {
					cajaExpendedora.getBillete20().push(moneda);
				}
				break;
			case 50:
				if (!(cajaExpendedora.getBillete50().size()==200)) {
					cajaExpendedora.getBillete50().push(moneda);
				}
				break;
			case 100:
				if (!(cajaExpendedora.getBillete100().size()==200)) {
					cajaExpendedora.getBillete100().push(moneda);
				}
				break;
			case 200:
				if (!(cajaExpendedora.getBillete200().size()==200)) {
					cajaExpendedora.getBillete200().push(moneda);
				}
				break;
			case 500:
				if (!(cajaExpendedora.getBillete500().size()==200)) {
					cajaExpendedora.getBillete500().push(moneda);
				}
				break;
			case 1000:
				if (!(cajaExpendedora.getBillete1000().size()==200)) {
					cajaExpendedora.getBillete1000().push(moneda);
				}
				break;
			}
		}while (cartera.size()>0);	
	}
	public LinkedStack retiro(int monto) {
		LinkedStack cartera=new LinkedStack();
		int dinero=0;
		int[] cambio = {1,5,10,20,50,100,200,500};
		do {
			int aleatorio=cambio[(int)(Math.random()*7)];
			if(dinero+aleatorio<=monto) {
				switch (aleatorio) {
				case 1:
					cartera.push(cajaExpendedora.getMoneda1().pop());
					break;
				case 5:
					cartera.push(cajaExpendedora.getMoneda5().pop());
					break;
				case 10:
					cartera.push(cajaExpendedora.getMoneda10().pop());
					break;
				case 20:
					cartera.push(cajaExpendedora.getBillete20().pop());
					break;
				case 50:
					cartera.push(cajaExpendedora.getBillete50().pop());
					break;
				case 100:
					cartera.push(cajaExpendedora.getBillete100().pop());
					break;
				case 200:
					cartera.push(cajaExpendedora.getBillete200().pop());
					break;
				case 500:
					cartera.push(cajaExpendedora.getBillete500().pop());
					break;
				case 1000:
					cartera.push(cajaExpendedora.getBillete1000().pop());
					break;
				}
				dinero=dinero+aleatorio;
			}
        }while(dinero<monto);
		return cartera;		
	}
	public void cajaVacia() {
		if(cajaExpendedora.getMoneda1().size()<=20) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getMoneda1().push(1);
			}	
		}else if(cajaExpendedora.getMoneda5().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getMoneda5().push(5);
			}
		}else if(cajaExpendedora.getMoneda10().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getMoneda10().push(10);
			}
		}else if(cajaExpendedora.getBillete20().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getBillete20().push(20);
			}
		}else if(cajaExpendedora.getBillete50().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getBillete50().push(50);
			}
		}else if(cajaExpendedora.getBillete100().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getBillete100().push(100);
			}
		}else if(cajaExpendedora.getBillete200().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getBillete200().push(200);
			}
		}else if(cajaExpendedora.getBillete500().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getBillete500().push(500);
			}
		}else if(cajaExpendedora.getBillete1000().size()<=10) {
			for(int i = 0; i < 50; i++) {
				cajaExpendedora.getBillete1000().push(1000);
			}
		}
	}
}


