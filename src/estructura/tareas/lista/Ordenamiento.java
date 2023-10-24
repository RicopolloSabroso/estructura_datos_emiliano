package estructura.tareas.lista;

import java.util.Scanner;

import estructura.lista.ArrayList;

public class Ordenamiento {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String cantidad;
        int cantidadNumero,num;
        
        System.out.print("cantidad de numeros aleatorios: ");
        cantidad = leer.nextLine();

        if (Integer.parseInt(cantidad) > 1 && Integer.parseInt(cantidad) <= 100) {
            ArrayList arregloEnteros = new ArrayList();
        

            System.out.print("Los números aleatorios son: ");
            for (int i = 0; i < Integer.parseInt(cantidad); i++) {
                num= 1+(int)(Math.random()*100);
                arregloEnteros.add(1+(int)(Math.random()*100));
                System.out.println(num);
            }
        }
        
    }

    public static void quicksort(ArrayList lista, int izquierda, int derecha) throws Exception{
        if (izquierda >= derecha) {
            return;
        }
        int pivote =(int) lista.get(izquierda);  //Iniciar con el primer elemento de la lista como pivote
        int i = izquierda;
        int j = derecha;
        while (i < j) {
            while ((int)lista.get(i) <= pivote && i < j) {
                i++;
            }
            while ((int)lista.get(j) > pivote) {
                j--;
            }
            if (i < j) {
                int aux =(int) lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, aux);
            }
        }
        lista.set(izquierda, lista.get(j));
        lista.set(j, pivote);
        quicksort(lista, izquierda, j - 1);
        quicksort(lista, j + 1, derecha);
    }
   
