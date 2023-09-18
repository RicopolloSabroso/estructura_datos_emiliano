package estructura.pruebas;
import estructura.cola.BooleanPriorityQueue;
import estructura.cola.CircularQueue;
import estructura.cola.LinkedQueue;
import estructura.nodo.*;
import estructura.pila.Pila;
public class PruebasNodos {
	public static void main(String[] args) {
		BooleanPriorityQueue stack= new BooleanPriorityQueue();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		stack.enqueue(10,true);
		
		stack.enqueue(4,true);

		stack.enqueue(5,true);

		stack.enqueue(59,true);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.front());
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
