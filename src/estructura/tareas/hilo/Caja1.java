package estructura.tareas.hilo;

public class Caja1 extends Thread{
	public void run() {
		while(true) {
			try {
				sleep((int)(1+Math.random()*100000));
			}catch(InterruptedException e) {}
		}
	}
}