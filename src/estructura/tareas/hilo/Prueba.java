package estructura.tareas.hilo;

import java.util.Scanner;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresar ingreso=new Ingresar();
		ingreso.start();
		//System.out.print(ingreso.getCola());
//		IngresarCajas ingresoCaja=new IngresarCajas();
//		ingresoCaja.start();
		Caja1 caja1= new Caja1(ingreso.getCola());
		 
		caja1.start();

//		System.out.print(caja1.informacionCaja());
//		Caja1 caja2= new Caja1(ingreso.getCola());
//		if(!caja2.getEstado()) {
//			caja2.start();
//			caja2.getPersona().getCuenta();
//		}
//		caja1.getPersona().getCuenta();
//		Caja1 caja3= new Caja1(ingreso.getCola());
//		caja3.start();
//		caja1.getPersona().getCuenta();
//		Caja1 caja4= new Caja1(ingreso.getCola());
//		caja4.start();
//		caja1.getPersona().getCuenta();
		//while(true) {

		//}informacioBanco()
	}

}
