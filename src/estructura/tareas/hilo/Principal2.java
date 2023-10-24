package estructura.tareas.hilo;
import estructura.pila.LinkedStack;

public class Principal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cambio = {1,5,10,20,50,100,200,500,1000};
		int dinero=0;
		 LinkedStack cartera=new LinkedStack();
		int total=(int)(Math.random()*9000);
		do {
			int aleatorio=cambio[(int)(Math.random()*8)];
			if(dinero+aleatorio<=total) {
				cartera.push(aleatorio);
	            dinero=dinero+aleatorio;
			}
        }while(dinero<total);
	}

}
