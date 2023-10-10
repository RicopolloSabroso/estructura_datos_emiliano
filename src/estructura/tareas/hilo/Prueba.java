package estructura.tareas.hilo;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresar ingreso=new Ingresar();
		ingreso.start();
		
		IngresarCajas ingresoCaja=new IngresarCajas();
		ingresoCaja.start();
		
		//while(true) {
			System.out.println(ingreso.cola.size());
		//}informacioBanco()
	}

}
