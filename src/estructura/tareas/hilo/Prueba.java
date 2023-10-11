package estructura.tareas.hilo;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresar ingreso=new Ingresar();
		ingreso.start();
		
//		IngresarCajas ingresoCaja=new IngresarCajas();
//		ingresoCaja.start();
		Caja1 caja1= new Caja1(ingreso.getCola());
		caja1.start();
		//while(true) {

		//}informacioBanco()
	}

}
