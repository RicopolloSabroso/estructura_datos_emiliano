package estructura.pruebas;
import estructura.cola.BooleanPriorityQueue;
import estructura.cola.CircularQueue;
import estructura.cola.LinkedQueue;
import estructura.cola.NumericPriorityQueue;
import estructura.nodo.*;
import estructura.pila.LinkedStack;
import estructura.pila.Pila;
public class PruebasNodos {
	public static void main(String[] args) {
		BooleanPriorityQueue stack= new BooleanPriorityQueue();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		
		stack.enqueue("A",true);
		stack.enqueue("B",false);
		stack.enqueue("C",false);
		stack.enqueue("D",true);
		stack.enqueue("E",true);
		System.out.println(stack.isEmpty());
		stack.dequeue();
		stack.dequeue();
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
