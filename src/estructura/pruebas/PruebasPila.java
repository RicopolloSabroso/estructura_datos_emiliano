package estructura.pruebas;

import estructura.pila.Pila;

public class PruebasPila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pila stack= new Pila(10);
		System.out.println(stack.peak());
		System.out.println(stack.size());
//		System.out.println(stack);
		stack.push(10);
		stack.push(4);
		stack.push(5);
		stack.push(59);
//		System.out.println(stack.isEmpty());
//		System.out.println(stack.size());
//		System.out.println(stack.peak());
//		Object value=stack.pop();
		System.out.println(stack);
	}

}
