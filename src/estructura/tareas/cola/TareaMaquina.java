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
		String opcion, numero;
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
								if(movimiento.validarLleno(Integer.parseInt(opcion))) {
									System.out.println("Cuantos quiere agregar?");
									numero=leer.nextLine();
									if() {
										
									}
								}else {
									
								}
							}while(ciclo);
						case 2:
							do {
								
							}while(ciclo);
						case 3:
							do {
								
							}while(ciclo);
						case 4:
							do {
								System.out.println(movimiento.informacionMaquina());
							}while(ciclo);
						System.out.println("Quiere volver al menu?\n1)Si\n presione cualquier tecla si no");
						opcion = leer.nextLine();			
						if (validar.validarEntero(opcion) == true && Integer.parseInt(opcion)== 1) 
						{
							ciclo = true;
						}else{
							System.out.println("adios");
							ciclo = false;
						}	
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