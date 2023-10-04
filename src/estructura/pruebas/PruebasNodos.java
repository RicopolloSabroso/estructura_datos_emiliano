package estructura.pruebas;
import estructura.cola.BooleanPriorityQueue;
import estructura.cola.CircularQueue;
import estructura.cola.LinkedQueue;
import estructura.cola.NumericPriorityQueue;
import estructura.nodo.*;
import estructura.pila.Pila;
public class PruebasNodos {
	public static void main(String[] args) {
		NumericPriorityQueue stack= new NumericPriorityQueue();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		
		stack.enqueue(4,3);

		stack.enqueue(5,7);
		stack.enqueue(10,1);
		stack.enqueue(59,5);
		System.out.println(stack);
//		System.out.println(stack.isEmpty());
//		System.out.println(stack.size());
//		System.out.println(stack.front());
//		System.out.println(stack.dequeue());
//		System.out.println(stack.front());
//		System.out.println(stack);
//		System.out.println(stack.dequeue());
//		System.out.println(stack.front());
//		System.out.println(stack);
//		System.out.println(stack.dequeue());
//		System.out.println(stack.front());
//		System.out.println(stack);
//		System.out.println(stack.dequeue());
//		System.out.println(stack.front());
//		System.out.println(stack);
//		
		
	}
}
