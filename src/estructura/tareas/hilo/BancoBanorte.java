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
		BooleanPriorityQueue aux=ingreso.getCola();
		IngresarCajas cajas=new IngresarCajas();
		String respuesta= "Cola de Espera\n";
		int tam=aux.size();
		for(int i=0; i<tam;i++) {
			Persona persona=(Persona)aux.dequeue();
			respuesta+=persona.getCuenta()+"\n";
		}
		for(int i=1; i<=4;i++) {
			respuesta+="\tCaja "+ i+"\n"+"Cuenta\t|Accion\t|Monto\n";
			switch (i) {
			case 1:
				if(cajas.getCaja1().getEstado()) {
					respuesta+=cajas.getCaja1().getPersona().getCuenta()+"\t|"+ cajas.getCaja1().getPersona().getTarea()=="0"?"deposito":"retiro"+"\t|"+"$"+cajas.getCaja1().getPersona().getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+cajas.getCaja1().getCajaExpendedora().getMoneda1().size()+"\t"+"$5:"+cajas.getCaja1().getCajaExpendedora().getMoneda5().size()+"\t"+"$10:"+cajas.getCaja1().getCajaExpendedora().getMoneda10().size()
							+"\t"+"$10:"+cajas.getCaja1().getCajaExpendedora().getMoneda10().size()+"\t"+"$20:"+cajas.getCaja1().getCajaExpendedora().getBillete20().size()+"\t"+"$50:"+cajas.getCaja1().getCajaExpendedora().getBillete50().size()
							+"\t"+"$100:"+cajas.getCaja1().getCajaExpendedora().getBillete100().size()+"\t"+"$200:"+cajas.getCaja1().getCajaExpendedora().getBillete200().size()+"\t"+"$500:"+cajas.getCaja1().getCajaExpendedora().getBillete500().size()
							+"\t"+"$1000:"+cajas.getCaja1().getCajaExpendedora().getBillete1000().size();
				}			
				break;
			case 2:
				if(cajas.getCaja2().getEstado()) {
					respuesta+=cajas.getCaja2().getPersona().getCuenta()+"\t|"+ cajas.getCaja2().getPersona().getTarea()=="0"?"deposito":"retiro"+"\t|"+cajas.getCaja2().getPersona().getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+cajas.getCaja2().getCajaExpendedora().getMoneda1().size()+"\t"+"$5:"+cajas.getCaja2().getCajaExpendedora().getMoneda5().size()+"\t"+"$10:"+cajas.getCaja2().getCajaExpendedora().getMoneda10().size()
							+"\t"+"$10:"+cajas.getCaja2().getCajaExpendedora().getMoneda10().size()+"\t"+"$20:"+cajas.getCaja2().getCajaExpendedora().getBillete20().size()+"\t"+"$50:"+cajas.getCaja2().getCajaExpendedora().getBillete50().size()
							+"\t"+"$100:"+cajas.getCaja2().getCajaExpendedora().getBillete100().size()+"\t"+"$200:"+cajas.getCaja2().getCajaExpendedora().getBillete200().size()+"\t"+"$500:"+cajas.getCaja2().getCajaExpendedora().getBillete500().size()
							+"\t"+"$1000:"+cajas.getCaja2().getCajaExpendedora().getBillete1000().size();
				}	
				break;
			case 3:
				if(cajas.getCaja3().getEstado()) {
					respuesta+=cajas.getCaja3().getPersona().getCuenta()+"\t|"+ cajas.getCaja3().getPersona().getTarea()=="0"?"deposito":"retiro"+"\t|"+cajas.getCaja3().getPersona().getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+cajas.getCaja3().getCajaExpendedora().getMoneda1().size()+"\t"+"$5:"+cajas.getCaja3().getCajaExpendedora().getMoneda5().size()+"\t"+"$10:"+cajas.getCaja3().getCajaExpendedora().getMoneda10().size()
							+"\t"+"$10:"+cajas.getCaja3().getCajaExpendedora().getMoneda10().size()+"\t"+"$20:"+cajas.getCaja3().getCajaExpendedora().getBillete20().size()+"\t"+"$50:"+cajas.getCaja3().getCajaExpendedora().getBillete50().size()
							+"\t"+"$100:"+cajas.getCaja3().getCajaExpendedora().getBillete100().size()+"\t"+"$200:"+cajas.getCaja3().getCajaExpendedora().getBillete200().size()+"\t"+"$500:"+cajas.getCaja3().getCajaExpendedora().getBillete500().size()
							+"\t"+"$1000:"+cajas.getCaja3().getCajaExpendedora().getBillete1000().size();
				}	
				break;
			case 4:
				if(cajas.getCaja2().getEstado()) {
					respuesta+=cajas.getCaja4().getPersona().getCuenta()+"\t|"+ cajas.getCaja4().getPersona().getTarea()=="0"?"deposito":"retiro"+"\t|"+cajas.getCaja4().getPersona().getMonto()+"\n";
					respuesta+="Dinero caja: \n"+"$1:"+cajas.getCaja2().getCajaExpendedora().getMoneda1().size()+"\t"+"$5:"+cajas.getCaja4().getCajaExpendedora().getMoneda5().size()+"\t"+"$10:"+cajas.getCaja4().getCajaExpendedora().getMoneda10().size()
							+"\t"+"$10:"+cajas.getCaja4().getCajaExpendedora().getMoneda10().size()+"\t"+"$20:"+cajas.getCaja4().getCajaExpendedora().getBillete20().size()+"\t"+"$50:"+cajas.getCaja4().getCajaExpendedora().getBillete50().size()
							+"\t"+"$100:"+cajas.getCaja4().getCajaExpendedora().getBillete100().size()+"\t"+"$200:"+cajas.getCaja4().getCajaExpendedora().getBillete200().size()+"\t"+"$500:"+cajas.getCaja4().getCajaExpendedora().getBillete500().size()
							+"\t"+"$1000:"+cajas.getCaja4().getCajaExpendedora().getBillete1000().size();
				}	
				break;
			}
		}
		return respuesta+"\n";
	}
}
