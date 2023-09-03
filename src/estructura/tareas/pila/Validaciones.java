package estructura.tareas.pila;

import estructura.pila.Pila;

public class Validaciones {
	public String sinEspacios(String valor) {
		valor=valor.replaceAll(" +", "");
		return valor;
	}
	public boolean verificarPalindroma(Pila stack, String valor) {
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
	public Pila postfija(String valor) {
		Pila postfija= new Pila(valor.length());
		Pila operadores= new Pila(valor.length());
		String numeroCompleto="";
		char numero;
		for (int i = 0; i < valor.length(); i++) {
			numero=valor.charAt(i);
			if (numero == '(') {
				operadores.push(numero);
				if (numeroCompleto!="") {
					postfija.push(numeroCompleto);
					numeroCompleto="";
				}
			} else if (numero == ')') {
				if (numeroCompleto!="") {
					postfija.push(numeroCompleto);
					numeroCompleto="";
				}
				while (!operadores.isEmpty() && (char)operadores.peak() != '(') {
					postfija.push(String.valueOf(operadores.pop()));
				}
				operadores.pop(); //duda, si hago una comparacion de un peak nulo con un parentesis truena el programa?
				
			}if (Character.isDigit(numero)) { 
				numeroCompleto+=numero;
			}else if (operadoresOrden(numero)==1||operadoresOrden(numero)==2){
				if (numeroCompleto!="") {
					postfija.push(numeroCompleto);
					numeroCompleto="";
				}
				while (!operadores.isEmpty() && operadoresOrden((char)operadores.peak()) >= operadoresOrden(numero)) {
					if((char)operadores.peak()!=(char)numero){
						postfija.push(String.valueOf(operadores.pop()));
					}else {
						break;
					}
				}
				operadores.push(numero);
			}
		}
		if (numeroCompleto!="") {
			postfija.push(numeroCompleto);
			numeroCompleto="";
		}
		while (!operadores.isEmpty()) {
            postfija.push(String.valueOf(operadores.pop()));
        }
		
		return postfija;
	}

	private int operadoresOrden(char valor) {
		int respuesta=0;
		if(valor=='+'||valor=='-') {
			respuesta=1;
		}else if(valor=='*'||valor=='/') {
			respuesta=2;
		}
		return respuesta;
	}
	public double postfijaResuelta(Pila postfija) {
		Pila respuesta= new Pila(postfija.size());
		Pila aux= new Pila(postfija.size());
		double resultado=0;
		Object aux2;
		int size=postfija.size();
		for(int i=0;i<size;i++) {
			if(!postfija.isEmpty()) {
				aux.push(postfija.pop());	
			}
		}
		while (!aux.isEmpty()) {
			aux2=aux.pop();
			if (numero(aux2)) {
                respuesta.push(Double.parseDouble(String.valueOf(aux2)));
            } else {
            	String cadena=aux2.toString();
            	if (operadoresOrden(cadena.charAt(0))==1||operadoresOrden(cadena.charAt(0))==2) {
                    resultado = operacion(Double.parseDouble(String.valueOf(respuesta.pop())),Double.parseDouble(String.valueOf(respuesta.pop())),cadena);
                    respuesta.push(resultado);
                }
            }
            	
		}
		
		return Double.parseDouble(String.valueOf(respuesta.pop()));
	}
	
	private boolean numero(Object valor) {
		boolean respuesta;
		try {
			Double.parseDouble(String.valueOf(valor));
			respuesta=true;
			
		}catch(Exception ex) {
			respuesta=false;
		}
		
		return respuesta;
	}
	private double operacion( double operando2, double operando, String operador) {
		 double respuesta=0;
			if (operador.equals("+")) {
				respuesta=operando+operando2;
		    } else if (operador.equals("-")) {
		    	respuesta=operando-operando2;
		    } else if (operador.equals("*")) {
		    	respuesta=operando*operando2;
		    } else if (operador.equals("/")) {
		        if (operando2 != 0) {
		        	respuesta=operando/operando2;
		        }
		    }
		return respuesta;
	}
}
