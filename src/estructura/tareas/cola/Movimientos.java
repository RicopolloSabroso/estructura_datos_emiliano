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
			while(stack[i].size()!=20) {
				stack[i].push(1);
			}
			
		}
		
	}
	public boolean validarLleno(int opcion) {
		boolean respuesta=false;
		switch(opcion){
			case 1:
				if(colas[0].size()==10) {
					respuesta=true;
				}
				break;
			case 2:
				if(colas[1].size()==10) {
					respuesta=true;
				}
				break;
			case 3:
				if(colas[2].size()==10) {
					respuesta=true;
				}
				break;
			case 4:
				if(colas[3].size()==10) {
					respuesta=true;
				}
				break;
			case 5:
				if(colas[4].size()==10) {
					respuesta=true;
				}
				break;
		}
		return respuesta;
	}
	public String llenarProducto(int opcion, int numero) {
		String respuesta="Se agregaron ";
		int j=0;
		switch(opcion){
			case 1:
				for(int i=0; i<numero;i++) {
					if(colas[0].size()!=10) {
						colas[0].enqueue(1);
						j++;
					}else {
						break;
					}	
				}
				break;
			case 2:
				for(int i=0; i<numero;i++) {
					if(colas[1].size()!=10) {
						colas[1].enqueue(1);
						j++;
					}else {
						break;
					}	
				}
				break;
			case 3:
				for(int i=0; i<numero;i++) {
					if(colas[2].size()!=10) {
						colas[2].enqueue(1);
						j++;
					}else {
						break;
					}	
				}
				break;
			case 4:
				for(int i=0; i<numero;i++) {
					if(colas[3].size()!=10) {
						colas[3].enqueue(1);
						j++;
					}else {
						break;
					}	
				}
				break;
			case 5:
				for(int i=0; i<numero;i++) {
					if(colas[4].size()!=10) {
						colas[4].enqueue(1);
						j++;
					}else {
						break;
					}	
				}
				break;
		}
		respuesta+=j+"Producto/s";
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
		respuesta+="\n$0.50\t|$1.0\t|$2.0\t|$5.0\t|$10\t|$20\n";
		for(int i=0; i<stack.length;i++) {
			if(null!=stack[i]) {
				respuesta+=stack[i].size()+"\t";
			}else {
				respuesta+=0+"\t";
			}
		}
		return respuesta+"\n";
	}
	
}

