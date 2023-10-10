package estructura.tareas.hilo;

public class IngresarCajas  extends Thread {
	Caja1 caja1= new Caja1();
	Caja2 caja2= new Caja2();
	Caja3 caja3= new Caja3();
	Caja4 caja4= new Caja4();
	Ingresar ingreso=new Ingresar();
	public void run() {
		try {
			do {
				sleep((int)(1+Math.random()*10000));
				if(!caja1.getEstado() ) {
					System.out.println("hola");
					caja1.start();
				}else if(!caja2.getEstado() ) {
					System.out.println("ho");
					caja2.start();
				}else if(!caja3.getEstado()) {
					caja3.start();
				}else if(!caja4.getEstado()) {
					caja4.start();
				}
			}while(true);
		}catch(InterruptedException e) {}
	}
}
