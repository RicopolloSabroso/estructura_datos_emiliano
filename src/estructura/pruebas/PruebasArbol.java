package estructura.pruebas;

import estructura.arboles.BiTree;

public class PruebasArbol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiTree arbol=new BiTree();
		arbol.add(67);
		arbol.add(43);
		arbol.add(11);
		arbol.add(55);
		arbol.add(5);
		arbol.add(13);
		arbol.add(50);
		arbol.add(56);
		arbol.add(80);
		arbol.add(70);
		arbol.add(68);
		arbol.add(74);
		arbol.add(92);
		arbol.add(90);
		arbol.add(95);
		arbol.postorden();
	}

}
