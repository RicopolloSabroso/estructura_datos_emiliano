package estructura.examenes;

import estructura.cola.CircularQueue;
import estructura.pila.Pila;

public class PrimerP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(primeraPregunta());
		//System.out.println(segundaPregunta());
		terceraPregunta();
		//cuartaPregunta();
	}
	public static int primeraPregunta() { 
	Pila stack= new Pila(101);
		int numero,suma=0;
		while(true) {
			numero=(1+(int)(Math.random()*100));
			System.out.println(numero);
			if(numero!=50) {
				stack.push(numero);
			}else {
				break;
			}
		}
		while(!stack.isEmpty()) {
			suma+=(int)stack.pop();
		}
		return suma;
	}
	public static int segundaPregunta() { 
		Pila stack= new Pila(10);
		Pila pilaSuma= new Pila(10);
		int suma=0;
		while(stack.size()<10) {
			stack.push((1+(int)(Math.random()*100)));
		}
		while(!stack.isEmpty()) {//suma
			suma=(int)stack.pop()+(int)stack.pop();
			System.out.println("suma "+suma);
			pilaSuma.push(suma);;
		}
		suma=0;
		suma=(int)pilaSuma.pop()-(int)pilaSuma.pop();
		System.out.println("resta "+suma);
		suma*=(int)pilaSuma.pop();
		System.out.println("multiplicacion "+suma);
		suma+=(int)pilaSuma.pop();
		System.out.println("suma "+suma);
		suma=suma-(int)pilaSuma.pop();
		return suma;
	}
	public static void terceraPregunta() { 
		CircularQueue colas= new CircularQueue(50);
		int ar[]=new int[50];
		int rep[]=new int[50];
		int numero;
		while(colas.size()<50) {
			numero=(1+(int)(Math.random()*50));
			colas.enqueue(numero);
		}
		 while (!colas.isEmpty()) {
	            numero = (int)colas.dequeue();
	            rep[numero-1]=rep[numero-1]+1;
	        }
		for(int i=0;i<rep.length;i++) {
			if (rep[i] == 1) {
                ar[i]=i;
                System.out.println(i+1);
            }
					
		}
		
	}
	public static void cuartaPregunta() { 
		CircularQueue colas= new CircularQueue(50);
		int numero,contador=0;
		while(colas.size()<50) {
			numero=(1+(int)(Math.random()*50));
			if(numero!=25) {
				colas.enqueue(numero);
			}else {
				contador++;
				for(int i=0;i<3;i++) {
					if(!colas.isEmpty()) {
						System.out.println(colas.dequeue());
					}
				}
			}
			
		}
		System.out.println("contador de 25: "+ contador);
	}
}
