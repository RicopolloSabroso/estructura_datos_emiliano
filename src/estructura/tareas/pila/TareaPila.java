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
		System.out.println("Escriba la palabra o numero");
		valor=leer.nextLine();
		valor=validar.sinEspacios(valor);
		Pila stack=new Pila(valor.length());
		for(int i=0;i<valor.length();i++) {
			stack.push(valor.charAt(i));
		}
		System.out.println(validar.verificar(stack, valor));
	}
	

}
