package estructura.pruebas;
import estructura.nodo.*;
import estructura.pila.Pila;
public class PruebasNodos {
	public static void main(String[] args) {
		LinkedStack stack= new LinkedStack();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack);
		stack.push(10);
		stack.push(4);
		stack.push(5);
		stack.push(59);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.peak());
		Object value=stack.pop();
		System.out.println(stack);	
	}
}
