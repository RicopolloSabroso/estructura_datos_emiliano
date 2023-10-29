package estructura.tareas.lista;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//import estructura.lista.ArrayList;
import estructura.lista.LinkedList;
import estructura.pila.LinkedStack;
import estructura.pila.Pila;
public class Codificacion {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		LinkedList lista= new LinkedList();
		String palabra=leer.nextLine();
//		XOR
        //System.out.println(xor(lista, palabra));
		
//		ESte es del polibio
		//LinkedList separacion= pasarALista(palabra);
		//System.out.println(separacion);
		//System.out.println(polibio(lista,palabra));
		
//		ESte es del ADFGVX
		//System.out.println(ADFGVX( lista, palabra));

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
	public static LinkedList ADFGVX(LinkedList arreglo,String palabra) throws Exception{
		 String matriz [][] = {
					{"-","A", "D", "F", "G", "V", "X"},
					{"A", "", "", "", "", "", ""},
				    {"D", "", "", "", "", "", ""},
				    {"F", "", "", "", "", "", ""},
				    {"G", "", "", "", "", "", ""},
				    {"V", "", "", "", "", "", ""},
				    {"X", "", "", "", "", "", ""}};
		char[] letrasAl = letrasAleatorias("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray());
		int k=0;
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz[0].length; j++) {
				matriz[i][j]=String.valueOf(letrasAl[k]);
				k++;
			}
		} 
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		} 
		palabra=palabra.replaceAll(" ", "");
		System.out.println(palabra);
		for (int x = 0; x < palabra.length(); x++) {
			for (int i = 1; i < matriz.length; i++) {
				 for (int j = 1; j < matriz[0].length; j++) {
					 if(matriz [i][j].equalsIgnoreCase(String.valueOf(palabra.charAt(x)))){
						 arreglo.add(String.valueOf(matriz [i][0])+String.valueOf(matriz [0][j]));
						 i=7;
						 break;
					 }
			      }
		      }
		}
		
       return arreglo;
   }
	public static char[] letrasAleatorias(char[] abecedario) throws Exception{
		Random random = new Random();
	    for (int i = abecedario.length - 1; i > 0; i--) {
	        int index = random.nextInt(i + 1);
	        if (index != 36) {
	            char letra = abecedario[index];
	            abecedario[index] = abecedario[i];
	            abecedario[i] = letra;
	        }else {
	        	i++;
	        }
	    }
	    return abecedario;
      
  }

}
