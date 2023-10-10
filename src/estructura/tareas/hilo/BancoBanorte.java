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
		boolean ciclo=false;
		IngresarCajas ingresoCaja=new IngresarCajas();
		ingresoCaja.start();
		do {			
			System.out.println("\tBanorte "+"\n"+"Escoge una opcion:"+"\n"+"1)Estatus del Banco"+"\n"+"2)Salir");
			opcion=leer.nextLine();
			if(validarEntero(opcion)) {
				if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=2) {
					switch(Integer.parseInt(opcion))
					{
						case 1:
							System.out.println(informacioBanco());
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
	public static String informacioBanco() {
		Ingresar ingreso=new Ingresar();
		Caja1 caja1= new Caja1();
		Caja2 caja2= new Caja2();
		Caja3 caja3= new Caja3();
		Caja4 caja4= new Caja4();
		String respuesta= "Cola de Espera\n";
		int tam=ingreso.cola.size();
		for(int i=0; i<tam;i++) {
			Persona persona=(Persona)ingreso.cola.dequeue();
			respuesta+=persona.getCuenta()+"\n";
			ingreso.cola.enqueue(persona, persona.prioridad);
		}
		for(int i=1; i<=4;i++) {
			respuesta+="\tCaja "+ i+"\n"+"Cuenta\t|Accion\t|Monto\n";
			switch (i) {
			case 1:
				if(caja1.getEstado()) {
					respuesta+=caja1.persona.getCuenta()+"\t|"+ caja1.persona.getTarea()=="0"?"deposito":"retiro"+"\t|"+caja1.persona.getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+caja1.cajaExpendedora.getMoneda1().size()+"\t"+"$5:"+caja1.cajaExpendedora.getMoneda5().size()+"\t"+"$10:"+caja1.cajaExpendedora.getMoneda10().size()
							+"\t"+"$10:"+caja1.cajaExpendedora.getMoneda10().size()+"\t"+"$20:"+caja1.cajaExpendedora.getBillete20().size()+"\t"+"$50:"+caja1.cajaExpendedora.getBillete50().size()
							+"\t"+"$100:"+caja1.cajaExpendedora.getBillete100().size()+"\t"+"$200:"+caja1.cajaExpendedora.getBillete200().size()+"\t"+"$500:"+caja1.cajaExpendedora.getBillete500().size()
							+"\t"+"$1000:"+caja1.cajaExpendedora.getBillete1000().size();
				}			
				break;
			case 2:
				if(caja2.getEstado()) {
					respuesta+=caja2.persona.getCuenta()+"\t|"+ caja2.persona.getTarea()=="0"?"deposito":"retiro"+"\t|"+caja2.persona.getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+caja2.cajaExpendedora.getMoneda1().size()+"\t"+"$5:"+caja2.cajaExpendedora.getMoneda5().size()+"\t"+"$10:"+caja2.cajaExpendedora.getMoneda10().size()
							+"\t"+"$10:"+caja2.cajaExpendedora.getMoneda10().size()+"\t"+"$20:"+caja2.cajaExpendedora.getBillete20().size()+"\t"+"$50:"+caja2.cajaExpendedora.getBillete50().size()
							+"\t"+"$100:"+caja2.cajaExpendedora.getBillete100().size()+"\t"+"$200:"+caja2.cajaExpendedora.getBillete200().size()+"\t"+"$500:"+caja2.cajaExpendedora.getBillete500().size()
							+"\t"+"$1000:"+caja2.cajaExpendedora.getBillete1000().size();
				}	
				break;
			case 3:
				if(caja3.getEstado()) {
					respuesta+=caja3.persona.getCuenta()+"\t|"+ caja3.persona.getTarea()=="0"?"deposito":"retiro"+"\t|"+caja3.persona.getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+caja3.cajaExpendedora.getMoneda1().size()+"\t"+"$5:"+caja3.cajaExpendedora.getMoneda5().size()+"\t"+"$10:"+caja3.cajaExpendedora.getMoneda10().size()
							+"\t"+"$10:"+caja3.cajaExpendedora.getMoneda10().size()+"\t"+"$20:"+caja3.cajaExpendedora.getBillete20().size()+"\t"+"$50:"+caja3.cajaExpendedora.getBillete50().size()
							+"\t"+"$100:"+caja3.cajaExpendedora.getBillete100().size()+"\t"+"$200:"+caja3.cajaExpendedora.getBillete200().size()+"\t"+"$500:"+caja3.cajaExpendedora.getBillete500().size()
							+"\t"+"$1000:"+caja3.cajaExpendedora.getBillete1000().size();
				}	
				break;
			case 4:
				if(caja4.getEstado()) {
					respuesta+=caja4.persona.getCuenta()+"\t|"+ caja4.persona.getTarea()=="0"?"deposito":"retiro"+"\t|"+caja4.persona.getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+caja4.cajaExpendedora.getMoneda1().size()+"\t"+"$5:"+caja4.cajaExpendedora.getMoneda5().size()+"\t"+"$10:"+caja4.cajaExpendedora.getMoneda10().size()
							+"\t"+"$10:"+caja4.cajaExpendedora.getMoneda10().size()+"\t"+"$20:"+caja4.cajaExpendedora.getBillete20().size()+"\t"+"$50:"+caja4.cajaExpendedora.getBillete50().size()
							+"\t"+"$100:"+caja4.cajaExpendedora.getBillete100().size()+"\t"+"$200:"+caja4.cajaExpendedora.getBillete200().size()+"\t"+"$500:"+caja4.cajaExpendedora.getBillete500().size()
							+"\t"+"$1000:"+caja4.cajaExpendedora.getBillete1000().size();
				}	
				break;
			}
		}
		return respuesta+"\n";
	}
}
