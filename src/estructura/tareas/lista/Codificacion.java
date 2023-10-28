package estructura.tareas.lista;
import java.util.Scanner;


import estructura.lista.LinkedList;
public class Codificacion {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		LinkedList lista= new LinkedList();
		String palabra=leer.nextLine();
        //System.out.println(xor(lista, palabra));
		LinkedList separacion= pasarALista(palabra);
		System.out.println(separacion);
		System.out.println(polibio(lista,palabra));
	}
	public static void convertirBinario(LinkedList arreglo,String palabra) {
		for (int i = 0; i < palabra.length(); i++) {
			 int letra = (int) palabra.charAt(i);
			arreglo.add(String.format("%8s", Integer.toBinaryString(letra)).replace(' ', '0'));
		}    
    }
	public static LinkedList pasarALista(String palabra) {
		LinkedList lista= new LinkedList();
		for (int i = 0; i < palabra.length(); i++) {
			lista.add(palabra.charAt(i));
		}   
		return lista;
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
	public static LinkedList polibio(LinkedList arreglo,String palabra) throws Exception{
		 String matrizPolibio [][] = {
				{"A", "B", "C", "D", "E"},
			    {"F", "G", "H", "I,J", "K"},
			    {"L", "M", "N", "O", "P"},
			    {"Q", "R", "S", "T", "U"},
			    {"V", "W", "X", "Y", "Z"}};
		for (int k = 0; k < palabra.length(); k++) {
			for (int i = 0; i < matrizPolibio.length; i++) {
				 for (int j = 0; j < matrizPolibio[0].length; j++) {
					 if((String.valueOf(palabra.charAt(k))).equalsIgnoreCase("I")||(String.valueOf(palabra.charAt(k))).equalsIgnoreCase("J")) {
						 arreglo.add(24);
						 i=6;
						 break;
					 }else if(matrizPolibio [i][j].equalsIgnoreCase(String.valueOf(palabra.charAt(k)))){
						 arreglo.add(String.valueOf(i+1)+String.valueOf(j+1));
						 i=6;
						 break;
					 }
			      }
		      }
		}
        return arreglo;
    }

}
