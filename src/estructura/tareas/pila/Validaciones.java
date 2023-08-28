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
	public boolean parentesis(String valor) {
		Pila stack= new Pila(valor.length());
		for(int i=0;i<valor.length();i++) {
			if(valor.charAt(i)=='(') {
				stack.push(valor.charAt(i));
			}else if(valor.charAt(i)==')'){
				 if(stack.isEmpty()||'('!=(char)stack.pop()) {
					 return false;
				 }
			}
		}
		return stack.isEmpty();
	}
	
}
