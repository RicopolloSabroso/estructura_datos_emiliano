package estructura.tareas.pila;
import java.util.Scanner;
import estructura.pila.Pila;
import estructura.tareas.pila.Validaciones;

public class TareaPila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer=new Scanner(System.in);
		Validaciones validar=new Validaciones();
		String valor;
		System.out.println("Escriba la ecuacion");
		valor=leer.nextLine();
		valor=validar.sinEspacios(valor);                  
		System.out.println(validar.parentesis(valor));
		System.out.println(validar.postfija(valor));
		
		
	}
	

}
