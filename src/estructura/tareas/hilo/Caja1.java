package estructura.tareas.hilo;
import estructura.cola.BooleanPriorityQueue;
import estructura.pila.LinkedStack;
import estructura.tareas.hilo.*;
public class Caja1 extends Thread{
	private Persona persona;
	private boolean estado=false;
	private BooleanPriorityQueue ingresos;
	Billete cajaExpendedora= new Billete();
	public Caja1(BooleanPriorityQueue cola) {
		this.ingresos=cola;
	}
	public void run() {
		while(true) {
			try {
				//System.out.println("hola");
				if(!ingresos.isEmpty()) {
					this.estado=true;	
					this.persona=(Persona)ingresos.dequeue();
				//	System.out.println(persona.getCuenta());
					if(persona.getTarea()==0) {
						deposito(persona.getCartera());
						System.out.println("ho");
					}else {
						cajaVacia();
						System.out.println("o");
						persona.setCartera(retiro(persona.getMonto()));						
					}
				}
				sleep((int)(1+Math.random()*10000));
				System.out.print(informacionCaja());
			}catch(InterruptedException e) {}
			estado=false;
		}
			
		}
	public Billete getCajaExpendedora() {
		return this.cajaExpendedora;
	}
	public Persona getPersona() {
		return this.persona;
	}
	public boolean getEstado() {
		return this.estado;
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
	public String informacionCaja() {
		String s="\tCaja "+"\n"+"Cuenta\t|Accion\t|Monto\n";
		if(this.estado) {
			s+=persona.getCuenta()+"\t|"+ String.valueOf(persona.getTarea()==0?"deposito":"retiro")+"\t|"+"$"+persona.getMonto()+"\n";
		}else {
			s+= "Caja Vacia\n";
		}
		s+="Dinero caja: \n"+"$1:"+cajaExpendedora.getMoneda1().size()+"\t"+"$5:"+cajaExpendedora.getMoneda5().size()+"\t"+"$10:"+cajaExpendedora.getMoneda10().size()
				+"\t"+"$10:"+cajaExpendedora.getMoneda10().size()+"\t"+"$20:"+cajaExpendedora.getBillete20().size()+"\t"+"$50:"+cajaExpendedora.getBillete50().size()
				+"\t"+"$100:"+cajaExpendedora.getBillete100().size()+"\t"+"$200:"+cajaExpendedora.getBillete200().size()+"\t"+"$500:"+cajaExpendedora.getBillete500().size()
				+"\t"+"$1000:"+cajaExpendedora.getBillete1000().size()+"\n";
		return s;
	}
}


