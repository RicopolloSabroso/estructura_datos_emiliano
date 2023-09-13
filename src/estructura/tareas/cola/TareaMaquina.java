package estructura.tareas.cola;
import java.util.Scanner;

import estructura.tareas.cola.Movimientos;
import estructura.tareas.cola.Validaciones;
public class TareaMaquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer=new Scanner(System.in);
		Movimientos movimiento=new Movimientos();
		Validaciones validar=new Validaciones();
		String opcion,numero;
		boolean ciclo=false;
		do {
			System.out.println("\tMi maquina expendedora "+"\n"+"Escoge una opcion:"+"\n"+"1)Agregar Productos"+"\n"+"2)Comprar"+"\n"+"3)Agregar Monedas"+"\n"+"4)Estado Maquina"+"\n"+"5)Salir");
			opcion=leer.nextLine();
			if(validar.validarEntero(opcion)) {
				if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=4) {
					switch(Integer.parseInt(opcion))
					{
						case 1:
							do {
								System.out.println("Escoge una opcion:"+"\n"+"1)Papas"+"\n"+"2)Refrescos"+"\n"+"3)Gomitas"+"\n"+"4)Agua"+"\n"+"5)Dulces");
								opcion=leer.nextLine();
								if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=5) {
									if(!movimiento.validarLlenoVacioProducto(Integer.parseInt(opcion))) {
										System.out.println("Cuantos quiere agregar?");
										numero=leer.nextLine();
										System.out.println(movimiento.llenarProducto(Integer.parseInt(opcion),  Integer.parseInt(numero)));
										ciclo = false;
									}else {
										System.out.println("No se pueden agregar Productos porque esta lleno o vacia");
										ciclo = false;
									}
								}
							}while(ciclo);
							break;
						case 2:
							do {
								System.out.println("Escoge la opcion a comprar:"+"\n"+"1)Papas"+"\n"+"2)Refrescos"+"\n"+"3)Gomitas"+"\n"+"4)Agua"+"\n"+"5)Dulces");
								opcion=leer.nextLine();
								if(!movimiento.validarLlenoVacioProducto(Integer.parseInt(opcion))) {
									
								}else {
									System.out.println("No se pueden agregar Monedas porque esta lleno o vacia");
									ciclo = false;
								}
							}while(ciclo);
							break;
						case 3:
							do {
								System.out.println("Escoge una opcion:"+"\n"+"1)$0.50"+"\n"+"2)$1.0"+"\n"+"3)$2.0"+"\n"+"4)$5.0"+"\n"+"5)$10.0"+"\n"+"6)$20.0\n");
								opcion=leer.nextLine();
								if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=6) {
									if(!movimiento.validarLlenoVacioMonedas(Integer.parseInt(opcion))) {
										System.out.println("Cuantas Monedas quiere agregar?");
										numero=leer.nextLine();
										System.out.println(movimiento.llenarMonedas(Integer.parseInt(opcion),  Integer.parseInt(numero)));
										ciclo = false;
									}else {
										System.out.println("No se pueden agregar Monedas porque esta lleno o vacia");
										ciclo = false;
									}
								}
								
							}while(ciclo);
							break;
							
						case 4:
							do {
								System.out.println(movimiento.informacionMaquina());
								ciclo = false;
							}while(ciclo);
						
						break;
					}
					System.out.println("Quiere volver al menu?\n1)Si\n presione cualquier tecla si no");
					opcion =leer.nextLine();			
					if (validar.validarEntero(opcion) == true && Integer.parseInt(opcion)== 1) 
					{
						ciclo = true;
					}else{
						System.out.println("adios");
						ciclo = false;
					}	
				}else {
					if(Integer.parseInt(opcion)==5) {
						System.out.println("adios");
						ciclo=false;
					}else {
						System.out.println("Opcion invalida");
						ciclo=true;
					}
				}
			}else {
				System.out.println("Solo numeros");
				ciclo=true;
			}
		}while(ciclo);
	}

}