package estructura.tareas.pila;

import estructura.pila.Pila;

public class Validaciones {
	public String sinEspacios(String valor) {
		valor=valor.replaceAll(" +", "");
		return valor;
	}
	public boolean verificar(Pila stack, String valor) {
		int j=0, tamaño=stack.size();
		for(int i=0;i<tamaño;i++) {
			if(String.valueOf(valor.charAt(i)).equalsIgnoreCase(stack.pop().toString())) {
				j++;
			}
		}
		return j==valor.length() ;
	}
	
}
