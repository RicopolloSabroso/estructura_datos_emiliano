package estructura.pruebas;
import estructura.cola.LinkedQueue;
import estructura.nodo.*;
import estructura.pila.Pila;
public class PruebasNodos {
	public static void main(String[] args) {
		LinkedQueue stack= new LinkedQueue();
		System.out.println(stack.isEmpty());
		stack.enqueue(10);
		System.out.println(stack);
		stack.enqueue(4);
		System.out.println(stack);
		stack.enqueue(5);
		System.out.println(stack);
		stack.enqueue(59);
		System.out.println(stack);
//		System.out.println(stack.isEmpty());
//		System.out.println(stack.size());
//		System.out.println(stack.front());
		System.out.println(stack.dequeue());
		System.out.println(stack.front());
		System.out.println(stack);
		System.out.println(stack.dequeue());
		System.out.println(stack.front());
		System.out.println(stack);
		System.out.println(stack.dequeue());
		System.out.println(stack.front());
		System.out.println(stack);
		System.out.println(stack.dequeue());
		System.out.println(stack.front());
		System.out.println(stack);
		
		
	}
}
