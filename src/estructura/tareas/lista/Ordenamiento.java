package estructura.tareas.lista;

import java.util.Scanner;

import estructura.lista.ArrayList;

public class Ordenamiento {
    public static void main(String[] args) throws Exception{
        Scanner leer = new Scanner(System.in);
        String cantidad;
        int cantidadNumero,num;
        
        System.out.print("cantidad de numeros aleatorios: ");
        cantidad = leer.nextLine();

        if (Integer.parseInt(cantidad) > 1 && Integer.parseInt(cantidad) <= 100) {
            ArrayList arregloEnteros = new ArrayList();
            for (int i = 0; i < Integer.parseInt(cantidad); i++) {
                num= 1+(int)(Math.random()*100);
                arregloEnteros.add(1+(int)(Math.random()*100));
            }
            System.out.println("Los números aleatorios son: \n"+arregloEnteros);
            quickSort(arregloEnteros,0,arregloEnteros.size()-1);
            System.out.println(arregloEnteros);
        }
        
        
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
    public static void shellsort(ArrayList lista) throws Exception {
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
}
