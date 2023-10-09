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
		NumericPriorityQueue stack= new NumericPriorityQueue();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		
		stack.enqueue("A",7);
		stack.enqueue("B",1);
		stack.enqueue("C",5);
		stack.enqueue("D",3);
		stack.enqueue("E",8);
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
