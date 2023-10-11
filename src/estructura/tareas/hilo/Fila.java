package estructura.tareas.hilo;

import java.util.Random;

import estructura.cola.BooleanPriorityQueue;

public class Fila {
	Random random = new Random();
	BooleanPriorityQueue cola =new BooleanPriorityQueue();
	public Fila(){
		
	}
	public void llenarCola() {
		boolean prioridad= (int)(Math.random()+.5)==0?true:false;
		cola.enqueue(new Persona(String.valueOf((long) (random.nextDouble() * 900000000000L) + 100000000000L), (int)(Math.random()+.5),prioridad), prioridad);
	}
	public boolean vacio(){
		return cola.size()==0;
	}
	public Persona sacarPersona() {
		return (Persona)cola.dequeue();
	}
	
}
