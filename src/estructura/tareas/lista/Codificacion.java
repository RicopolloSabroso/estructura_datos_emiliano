package estructura.tareas.lista;
import java.util.Scanner;


import estructura.lista.LinkedList;
public class Codificacion {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		LinkedList lista= new LinkedList();
		String palabra=leer.nextLine();
        System.out.println(xor(lista, palabra));
	}
	public static void convertirBinario(LinkedList arreglo,String palabra) {
		for (int i = 0; i < palabra.length(); i++) {
			 int letra = (int) palabra.charAt(i);
			arreglo.add(String.format("%8s", Integer.toBinaryString(letra)).replace(' ', '0'));
		}    
    }
	public static LinkedList xor(LinkedList arreglo,String palabra) throws Exception{
		convertirBinario(arreglo,palabra);
		 System.out.println(arreglo);
		String code="11110011";	
		LinkedList resultado= new LinkedList();
		 for (int i = 0; i < arreglo.size(); i++) {
			 String codif="";
			 for (int j = 0; j < code.length(); j++) {
				 if(String.valueOf(arreglo.get(i)).charAt(j)==code.charAt(j)) {
					 codif+="0";
				 }else {
					 codif+="1";
				 }
		      }
			 resultado.add(codif);
	      }
        return resultado;
    }

}
