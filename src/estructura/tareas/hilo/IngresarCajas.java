package estructura.tareas.hilo;

public class IngresarCajas  extends Thread {
	Ingresar ingreso=new Ingresar();
	private Caja1 caja1;
	private Caja1 caja2;
	private Caja1 caja3;
	private Caja1 caja4;
	public IngresarCajas(){
		this.caja1= new Caja1(ingreso.getCola());
		this.caja2= new Caja1(ingreso.getCola());
		this.caja3= new Caja1(ingreso.getCola());
		this.caja4= new Caja1(ingreso.getCola());
	}
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
	public Caja1 getCaja1() {
		return caja1;
	}
	public Caja1 getCaja2() {
		return caja2;
	}
	public Caja1 getCaja3() {
		return caja3;
	}
	public Caja1 getCaja4() {
		return caja4;
	}
}
