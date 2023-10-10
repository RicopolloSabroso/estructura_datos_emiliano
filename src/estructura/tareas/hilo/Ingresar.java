package estructura.tareas.hilo;

import java.util.Random;

import estructura.cola.BooleanPriorityQueue;

public class Ingresar extends Thread {
	Random random = new Random();
	BooleanPriorityQueue cola= new BooleanPriorityQueue();
	public void run() {
		while(true) {
			try {
				boolean prioridad= (int)(Math.random()+.5)==0?true:false;
				cola.enqueue(new Persona(String.valueOf((long) (random.nextDouble() * 900000000000L) + 100000000000L), (int)(Math.random()+.5),prioridad), prioridad);
				System.out.println(((Persona)cola.dequeue()).getCuenta());
				sleep((int)(1+Math.random()*10000));

			}catch(InterruptedException e) {}
		}
	}
}
