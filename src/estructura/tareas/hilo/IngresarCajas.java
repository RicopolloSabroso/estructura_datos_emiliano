package estructura.tareas.hilo;

public class IngresarCajas  extends Thread {
	Caja1 caja1= new Caja1();
	Caja2 caja2= new Caja2();
	Caja3 caja3= new Caja3();
	Caja4 caja4= new Caja4();
	public void run() {
		try {
			do {
				sleep((int)(1+Math.random()*1000));
				if(!caja1.getEstado()) {
					caja1.run();
				}else if(!caja2.getEstado()) {
					caja2.run();
				}else if(!caja3.getEstado()) {
					caja3.run();
				}else if(!caja4.getEstado()) {
					caja4.run();
				}
			}while(true);
		}catch(InterruptedException e) {}
	}
}
