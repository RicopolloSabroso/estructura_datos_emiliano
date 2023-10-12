package estructura.tareas.hilo;

import java.util.Scanner;

import estructura.cola.BooleanPriorityQueue;

public class BancoBanorte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresar ingreso=new Ingresar();
		ingreso.start();
		Scanner leer=new Scanner(System.in);
		String opcion;
		Caja1 caja1= new Caja1(ingreso.getCola());
		caja1.start();
		Caja1 caja2= new Caja1(ingreso.getCola());	 
		caja2.start();
		Caja1 caja3= new Caja1(ingreso.getCola());	 
		caja3.start();
		Caja1 caja4= new Caja1(ingreso.getCola());	 
		caja4.start();
		;
		boolean ciclo=false;
		do {			
			System.out.println("\tBanorte "+"\n"+"Escoge una opcion:"+"\n"+"1)Estatus del Banco"+"\n"+"2)Salir");
			opcion=leer.nextLine();
			if(validarEntero(opcion)) {
				if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=2) {
					switch(Integer.parseInt(opcion))
					{
						case 1:
							System.out.println("\tFila de Banco:\n");
							System.out.println(ingreso.getCola().toString());
							System.out.println(caja1.informacionCaja());
							System.out.println(caja2.informacionCaja());
							System.out.println(caja3.informacionCaja());
							System.out.println(caja4.informacionCaja());
							ciclo=true;
							break;
						case 2:
							do {
								System.out.println("Adios");
								ciclo= false;
							}while(ciclo);
							break;
					}
				}else {
					System.out.println("Opcion invalida");
					ciclo=true;
				}
			}else {
				System.out.println("Solo numeros");
				ciclo=true;
			}
		}while(ciclo);
	}
	public static boolean validarEntero(String valor) {
		boolean respuesta;
		try {
			Integer.parseInt(valor);
			respuesta = true;
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}
	
}
