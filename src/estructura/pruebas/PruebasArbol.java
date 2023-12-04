package estructura.pruebas;

import estructura.arboles.BiTree;

public class PruebasArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiTree arbol=new BiTree();
		arbol.add(8);
		arbol.add(1);
		arbol.add(1);
		arbol.add(0);
		arbol.add(4);
		arbol.add(5);
		arbol.add(2);
		arbol.add(10);
		arbol.add(9);
		arbol.add(15);
		arbol.preorden();
	}

}
