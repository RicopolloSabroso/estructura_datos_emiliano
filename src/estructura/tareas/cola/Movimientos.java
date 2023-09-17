package estructura.tareas.cola;

import estructura.cola.CircularQueue;
import estructura.pila.Pila;

public class Movimientos {
	CircularQueue colas[]= new CircularQueue[5];
	Pila stack[]= new Pila[6];
	public Movimientos() {
		for(int i=0; i<colas.length;i++) {
			colas[i]=new CircularQueue(10);
			while(colas[i].size()!=10) {
				colas[i].enqueue(1);
			}
			
		}
		for(int i=0; i<stack.length;i++) {
			stack[i]=new Pila(20);
			while(stack[i].size()!=15) {
				stack[i].push(1);
			}
			
		}
		
	}
	public boolean validarEntero(String valor) {
		boolean respuesta;
		try {
			Integer.parseInt(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}

	public boolean validarLlenoProducto(int opcion) {
		return colas[opcion-1].size()==10?true:false;
	}
	public boolean validarVacioProducto(int opcion) {
		return colas[opcion-1].size()==0?true:false;
	}
	public String llenarProducto(int opcion, int numero) {
		String respuesta="Se agregaron ";
		int j=0;
		for(int i=0; i<numero;i++) {
			if(colas[opcion-1].size()!=10) {
				colas[opcion-1].enqueue(1);
				j++;
			}else {
				break;
			}	
		}		
		respuesta+=j+" Producto/s";
		return respuesta;
	}
	public boolean validarLlenoMonedas(int opcion) {
		return stack[opcion-1].size()==20?true:false;
	}
	public boolean validarLlenoMonedasTodas() {
		return stack[0].size()==20 && stack[1].size()==20 && stack[2].size()==20 && stack[3].size()==20 && stack[4].size()==20 && stack[5].size()==20;
	}
	public boolean validarMayorADosMonedas() {
		boolean respuesta=false;
		if(stack[0].size()>=1 && stack[1].size()>=2 && stack[2].size()>=2 && stack[3].size()>=2 && stack[4].size()>=2 && stack[5].size()>=2){
			respuesta=true;
		}if(stack[0].size()>=2 && stack[1].size()>=1 && stack[2].size()>=2 && stack[3].size()>=2 && stack[4].size()>=2 && stack[5].size()>=2) {
			respuesta=true;
		}
		return respuesta;
	}
	public String llenarMonedas(int opcion, int numero) {
		String respuesta="Se agregaron ";
		int j=0;
		for(int i=0; i<numero;i++) {
			if(stack[opcion-1].size()!=20) {
				stack[opcion-1].push(1);
				j++;
			}else {
				break;
			}	
		}
		respuesta+=j+" Moneda/s";
		return respuesta;
	}
	public String informacionMaquina() {
		String respuesta= "Papas\t|Refrescos\t|Gomitas\t|Agua\t|Dulces\n";
		for(int i=0; i<colas.length;i++) {
			if(null!=colas[i]) {
				respuesta+=colas[i].size()+"\t";
			}else {
				respuesta+=0+"\t";
			}
		}
		respuesta+="\n$20.0\t|$10.0\t|$5.0\t|$2.0\t|$1.0\t|$0.50\n";
		for(int i=0; i<stack.length;i++) {
			if(null!=stack[i]) {
				respuesta+=stack[i].size()+"\t";
			}else {
				respuesta+=0+"\t";
			}
		}
		return respuesta+"\n";
	}
	 public double cambio(double dinero, int opcion) {
	    double cambio=0.0;    
		switch(opcion) {
			case 1:
				cambio=dinero-10;				
				break;
			case 2:
				cambio=dinero-15;
				break;
			case 3:
				cambio=dinero-9;
				break;
			case 4:
				cambio=dinero-5;
				break;
			case 5:
				cambio=dinero-12;
				break;
		}
		if(cambio>0) {
			colas[opcion-1].dequeue();
		}
		return cambio;
	 }
	 public boolean monedasCambio(double cambio) {
	    double[] arCambio = {20, 10, 5, 2, 1, 0.50};	        
	    for (int i = 0; i < arCambio.length; i++) {
	        if(stack[i].size()>0) {
	        	while (cambio >= arCambio[i]) {
	        		stack[i].pop();
		         	cambio -= arCambio[i];
		        }
	        }
	            
	    }    
	    return cambio==0;
	}
}

