package estructura.tareas.hilo;

import estructura.cola.BooleanPriorityQueue;

public class Ingresar extends Thread {
	BooleanPriorityQueue cola= new BooleanPriorityQueue();
	public void run() {
		//while(true) {
			try {
				boolean prioridad= (int)(Math.random()+.5)==0?true:false;
				cola.enqueue(new Persona(String.valueOf((Math.random()*1000000000000L)), (int)(Math.random()+.5),prioridad), prioridad);
				sleep((int)(1+Math.random()*10000));
			}catch(InterruptedException e) {}
		//}
	}
}
