package estructura.examenes;

import java.util.Random;
import java.util.Scanner;
import estructura.lista.DoubleLinkedList;
import estructura.lista.LinkedList;
import estructura.cola.CircularQueue;
import estructura.cola.LinkedQueue;
public class SegundoP {

	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		Scanner leer = new Scanner(System.in);
		LinkedList lista= new LinkedList();
		LinkedQueue colaConsonantes=new LinkedQueue();
		LinkedQueue colaVocales=new LinkedQueue();
		vocalOConsonante(colaVocales,colaConsonantes);
		System.out.println(colaVocales);
		System.out.println(colaConsonantes);
		System.out.println("vocales");
		contar(colaVocales);
		System.out.println("consonantes ");
		contar( colaConsonantes);
//		Ejercicio 2
//		System.out.print(noRepetidos());
//			Ejercicio 3
//		lista=generarListaNumeros();
//	    System.out.println("Media: " + media(lista));
//	    System.out.println("Moda: " + moda(lista));
//	    System.out.println("Mediana: " + mediana(lista);
//		ejercicio 4
//		cuartaPregunta();
	}
	public static void vocalOConsonante( LinkedQueue colaVocales, LinkedQueue colaConsonantes) {
		Scanner leer = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese una palabra: ");
            String palabra = leer.nextLine();
            for (char letra : palabra.toCharArray()) {
                if (esVocal(letra)) {
                    colaVocales.enqueue(letra);
                } else {
                    colaConsonantes.enqueue(letra);
                }
            }
        }
    }

	public static void contar(LinkedQueue cola) {
        int[] frecuencia = new int[256];
        // esto es para ver las veces que se repiten
        while (!cola.isEmpty()) {
            char letra = (char) cola.dequeue(); 
            frecuencia[letra]++;
        }
        for (int i = 0; i < frecuencia.length; i++) {
            if (frecuencia[i] > 0) {
                System.out.println((char) i + ": " + frecuencia[i] + " veces");
            }
        }
    }
	private static boolean esVocal(char letraP) {
	    char letra = Character.toLowerCase(letraP);
	    return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
	}
	public static LinkedList noRepetidos() throws Exception {
        
		LinkedQueue numeros = new LinkedQueue();
        Random random = new Random();
		for (int i = 0; i <50; i++) {
            numeros.enqueue(random.nextInt(50) + 1);
		}
		System.out.println(numeros ); 
		LinkedList listaNumeros = new LinkedList();
        LinkedList repetidos = new LinkedList();

        while (!numeros.isEmpty()) {
            int numero = (int) numeros.dequeue();

            if (!contieneNum(listaNumeros, numero) && !contieneNum(repetidos, numero)) {
                listaNumeros.add(numero);
            } else {
                repetidos.add(numero);
            }
        }
    	System.out.println(listaNumeros.size() ); 
        return listaNumeros;
    }

    private static boolean contieneNum(LinkedList lista, int numero) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            if ((int)lista.get(i) == numero) {
                return true;
            }
        }
        return false;
    }
	public static LinkedList generarListaNumeros() {
		LinkedList listaNumeros = new LinkedList();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            listaNumeros.add(random.nextInt(100) + 1);
        }

        return listaNumeros;
    }
	public static double media(LinkedList numeros)throws Exception  {
		int suma = 0;
	    int cantidad = numeros.size()-1;

	    for (int i = 0; i < cantidad; i++) {
	        suma += (Integer)numeros.get(i);
	    }

	    return (double) suma / cantidad;
    }
	public static void shellSort(LinkedList lista) throws Exception {
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
	public static double mediana(LinkedList numeros)throws Exception  {
        shellSort(numeros);

        int n = numeros.size();
        if (n % 2 == 0) {
            int mediana1 =(int) numeros.get(n / 2 - 1);
            int mediana2 = (int)numeros.get(n / 2);
            return (double) (mediana1 + mediana2) / 2;
        } else {
            return (double) numeros.get(n / 2);
        }
    }
	 private static LinkedList moda(LinkedList numeros)throws Exception  {
		 shellSort(numeros);
		 LinkedList moda = new LinkedList();
		 int maxFrecuencia = 0;
		 int frecuenciaActual = 1;
		 int numeroActual = (int)numeros.get(0);
		 for (int i = 1; i < numeros.size(); i++) {
			 if ((int)numeros.get(i) == numeroActual) {
				 frecuenciaActual++;
			 }else {
				 frecuenciaActual = 1;
				 numeroActual = (int)numeros.get(i);
			 }
			 if (frecuenciaActual > maxFrecuencia) {
				 moda = new LinkedList();  
				 moda.add(numeroActual);
				 maxFrecuencia = frecuenciaActual;
			 }else if (frecuenciaActual == maxFrecuencia) {
				 moda.add(numeroActual);
			 }
		 }

		 return moda;
	 }
	 public static void cuartaPregunta() { 
			CircularQueue colas= new CircularQueue(50);
			int numero,contador=0;
			while(colas.size()<50) {
				numero=(1+(int)(Math.random()*50));
				if(numero!=25) {
					colas.enqueue(numero);
				}else {
					contador++;
					for(int i=0;i<3;i++) {
						if(!colas.isEmpty()) {
							System.out.println(colas.dequeue());
						}
					}
				}
				
			}
			System.out.println("contador de 25: "+ contador);
			System.out.println(colas);
		}

}

