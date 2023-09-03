package estructura.tareas.pila;
import java.util.Scanner;
public class TareaPila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer=new Scanner(System.in);
		Validaciones validar=new Validaciones();
		String valor;
		System.out.println("Escriba la ecuacion");
		valor=leer.nextLine();
		valor=validar.sinEspacios(valor);                  
		if(validar.parentesis(valor)) {
			System.out.println(validar.postfija(valor));
			System.out.println(validar.postfijaResuelta(validar.postfija(valor)));
		}else {
		System.out.println("No tiene bien los parentesis");
	
		}
		
		
		leer.close();
	}
	

}

