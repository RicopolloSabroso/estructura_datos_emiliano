package estructura.tareas.lista;

import java.util.Scanner;

import estructura.lista.ArrayList;

public class Ordenamiento {
	public static void main(String[] args) throws Exception{
		Scanner leer = new Scanner(System.in);
		String cantidad;

		System.out.print("cantidad de numeros aleatorios: ");
		cantidad = leer.nextLine();
		ArrayList arregloEnteros = new ArrayList();
		for (int i = 0; i < Integer.parseInt(cantidad); i++) {
			arregloEnteros.add(1+(int)(Math.random()*100));
		}
		System.out.println("Los números aleatorios son: \n"+arregloEnteros);
		quickSort(arregloEnteros,0,arregloEnteros.size()-1);
		//shellSort(arregloEnteros);
		//seleccion(arregloEnteros);
		System.out.println(arregloEnteros);
	}
        
        

    public static void quickSort(ArrayList lista, int menor, int mayor)throws Exception {       
        int i = menor;
        int j = mayor;
        int pivote = ((int)lista.get(i) + (int)lista.get(j)) / 2;
        while (i < j) {
            while ((int)lista.get(i) < pivote) {
                i++;
            }
            while ((int)lista.get(j) > pivote) {
                j--;
            }
            if (i <= j) {
                int x = (int)lista.get(j);
                lista.set(j, lista.get(i));
                lista.set(i, x);
                i++;
                j--;
            }
        }
        if (menor < j) {
            quickSort(lista, menor, j);
        }
        if (mayor > i) {
            quickSort(lista, i, mayor);
        }
    }
    public static void shellSort(ArrayList lista) throws Exception {
        int incremento = lista.size() / 2;
        while (incremento > 0) {
            for (int i = incremento; i < lista.size(); i++) {
                int j = i;
                int temporal = (int)lista.get(i);
                while (j >= incremento && (int)lista.get(j - incremento) > temporal) {
                    lista.set(j, lista.get(j - incremento));
                    j = j - incremento;
                }
                lista.set(j, temporal);
            }
            if (incremento == 2) {
                incremento = 1;
            } else {
                incremento = (int) (incremento / 2.2);
            }
        }
    }
    public static void seleccion(ArrayList lista) throws Exception{
    	 for (int llenarRanura = lista.size() - 1; llenarRanura > 0; llenarRanura--) {
             int posicionDelMayor = 0;
             for (int ubicacion = 1; ubicacion <= llenarRanura; ubicacion++) {
                 if ((int)lista.get(ubicacion) > (int)lista.get(posicionDelMayor)) {
                     posicionDelMayor = ubicacion;
                 }
             }

             int temp = (int)lista.get(llenarRanura);
             lista.set(llenarRanura, lista.get(posicionDelMayor));
             lista.set(posicionDelMayor, temp);
         }
    }
}
