package estructura.tareas.hilo;

import estructura.cola.BooleanPriorityQueue;

public class Ingresar extends Thread {
	BooleanPriorityQueue cola= new BooleanPriorityQueue();
	public void run() {
		while(true) {
			try {
				cola.enqueue(new Persona(String.valueOf((Math.random()*1000000000000L)), (int)(Math.random()+.5),1+(int)(Math.random()*9000)), (int)(Math.random()+.5)==0);
				sleep((int)(1+Math.random()*10000));
			}catch(InterruptedException e) {}
		}
	}
}
