package estructura.tareas.cola;
import java.util.Scanner;

import estructura.tareas.cola.Movimientos;
public class TareaMaquina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer=new Scanner(System.in);
		Movimientos movimiento=new Movimientos(); 
		String opcion,numero, monto;
		boolean ciclo=false;
		double cambio=0.0;
		do {
			
			//LA MAQUINA EXPENDEDORA SOLO PUEDE VENDER CUANDO HAY 2 O MAS MONEDAS EN EL CAMBIO EN TODAS LAS DENOMINACIONES MENOS EN LA DE 20 PESOS O DE 10 PESOS
			
			System.out.println("\tMi maquina expendedora "+"\n"+"Escoge una opcion:"+"\n"+"1)Agregar Productos"+"\n"+"2)Comprar"+"\n"+"3)Agregar Monedas"+"\n"+"4)Estado Maquina"+"\n"+"5)Salir");
			opcion=leer.nextLine();
			if(movimiento.validarEntero(opcion)) {
				if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=4) {
					switch(Integer.parseInt(opcion))
					{
						case 1:
							do {
								System.out.println("Escoge una opcion:"+"\n"+"1)Papas"+"\n"+"2)Refrescos"+"\n"+"3)Gomitas"+"\n"+"4)Agua"+"\n"+"5)Dulces");
								opcion=leer.nextLine();
								if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=5) {
									if(!movimiento.validarLlenoProducto(Integer.parseInt(opcion))) {
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
								if(movimiento.validarMayorADosMonedas()&& !movimiento.validarLlenoMonedasTodas()) {
									do {
										System.out.println("Ingrese el monto del producto a comprar(el monto minimo es de $5 y Maximo de 50)"+"\n"+"Papas $10\t (1 1) "+"\n"+"Refrescos $15\t(2 1)"+"\n"+"Gomitas $9\t (3 1)"+"\n"+"Agua $5\t (4 1)"+"\n"+"Dulces $12\t (5 1)\n"+ "");
										monto=leer.nextLine();
										if(Double.parseDouble(monto)>=5 && Double.parseDouble(monto)<=50) {
											do {
												System.out.println("Escribe el codigo (solo el numero) del producto\n|1|6|\n|2|7|\n|3|8|\n|4|9|\n|5|0|\n");
												opcion=leer.nextLine();
												if(Integer.parseInt(opcion)==11 || Integer.parseInt(opcion)==21 || Integer.parseInt(opcion)==31 || Integer.parseInt(opcion)==41 || Integer.parseInt(opcion)==51  ) {
													if(!movimiento.validarVacioProducto(opcion.charAt(0)-'0')) {
														cambio=movimiento.cambio(Double.parseDouble(monto), opcion.charAt(0)-'0');
														if(cambio>=0) {
															if(movimiento.monedasCambio(cambio)) {
																System.out.println("Producto comprado\n"+ "cambio: $"+ cambio+"\n");
																ciclo = false;
															}else {
																System.out.println("no acompleto");
																ciclo = false;
															}
														}else {
															System.out.println("No se pudo comprar porque no le alcanza\n"+ " $"+ monto+" devueltos\n");
															ciclo = false;
														}
													}else {
														System.out.println("No se puede comprar porque esta vacio el producto\n"+ " $"+ monto+" devueltos\n");
														ciclo = false;
													}
												}else {
													System.out.println("Codigo invalido, no hay producto con ese codigo\n");
													ciclo = true;
												}
											}while(ciclo);
											
										}else {
											System.out.println("no es el monto minimo indicado\n");
											ciclo = true;
										}
									}while(ciclo);
									
								}else {
									System.out.println("No hay cambio suficiente o esta lleno el cambio\n");
									ciclo = false;
								}
								
							}while(ciclo);
							break;
						case 3:
							do {
								System.out.println("Escoge una opcion:"+"\n"+"1)$20.0"+"\n"+"2)$10.0"+"\n"+"3)$5.0"+"\n"+"4)$2.0"+"\n"+"5)$1.0"+"\n"+"6)$0.5\n");
								opcion=leer.nextLine();
								if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=6) {
									if(!movimiento.validarLlenoMonedas(Integer.parseInt(opcion))) {
										System.out.println("Cuantas Monedas quiere agregar?");
										numero=leer.nextLine();
										System.out.println(movimiento.llenarMonedas(Integer.parseInt(opcion),  Integer.parseInt(numero)));
										ciclo = false;
									}else {
										System.out.println("No se pueden agregar Monedas porque esta lleno ");
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
					if (movimiento.validarEntero(opcion) == true && Integer.parseInt(opcion)== 1) 
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