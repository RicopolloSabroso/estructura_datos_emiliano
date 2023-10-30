package estructura.pruebas;

import java.util.Random;

import estructura.lista.LinkedList;

public class PruebasLista {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LinkedList lista= new LinkedList();
		Random random = new Random();
		System.out.println(lista.isEmpty()+"\n"+lista.size());
		lista.add(1);
		System.out.println(lista.isEmpty());
		lista.add(2);
		System.out.println(lista.size());
		lista.add(3);
		lista.add(4);
		System.out.println(lista);
		lista.add(5);
		lista.add(6);
		System.out.println(lista);
		System.out.println(lista.remove(0));
		System.out.println(lista);
		System.out.println(lista.remove(lista.size()-1));
		System.out.println(lista);
		System.out.println(lista.remove(2));
		System.out.println(lista);
	}

}
