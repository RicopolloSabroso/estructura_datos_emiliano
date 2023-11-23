package proyecto;


import java.util.Scanner;

import estructura.lista.DoubleLinkedList;
import estructura.lista.LinkedList;
import proyecto.Barco.Ubicacion;

public class Jugador {
	Jugada jugada=new Jugada();
	private String nombre;
	private LinkedList barcos=new LinkedList();
	private int[][] tablero= new int[10][10];
	public Jugador(String nombre)  throws Exception{
		this.nombre=nombre;
		inicializarBarcos();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LinkedList getBarcos() {
		return barcos;
	}
	 private void inicializarBarcos() throws Exception{
		 int[] tam = {4, 3, 3, 3, 2, 2, 2, 1, 1};
	        Scanner leer = new Scanner(System.in);
	        for (int i = 0; i < tam.length; i++) {
	        	mostrarTableroBarcos(); 
	            System.out.println("Posiciona el barco " + (i + 1) + " (ejemplo: A1, B2): ");
	            String posicion = leer.nextLine().toUpperCase();
	            while (!jugada.esPosicionValida(posicion) || posicionOcupada(posicion)) {
	                System.out.println("Posición inválida o ocupada. Porfavor vuelve a intentarlo ");
	                posicion = leer.nextLine().toUpperCase();
	            }
	            System.out.println("Elige la orientación del barco (Horizontal o Vertical): ");
	            String orientacion = leer.nextLine().toLowerCase();
	            while (!orientacionValida(orientacion)) {
	                System.out.println("orientacion inválida . Porfavor vuelve a intentarlo ");
	                orientacion = leer.nextLine().toLowerCase();
	            }
	            	Barco barco = new Barco(posicion, Barco.Ubicacion.valueOf(orientacion),tam[i]);
	 	            this.barcos.add(barco);  
	        }
	    }
	    private boolean posicionOcupada(String posicion) throws Exception{
	        for (int i = 0; i < barcos.size(); i++) {
	            Barco barco = (Barco)barcos.get(i);
	            if (barco != null) {
	                String[] posiciones = barco.getPosiciones();
	                for (int j = 0; j < posiciones.length; j++) {
	                    if (posiciones[j].equals(posicion)) {
	                        return true;
	                    }
	                }
	            }
	        }
	        return false;
	    }
	    private void mostrarTableroBarcos() throws Exception{
	    	 for(int k=0;k<this.barcos.size();k++) {
	    		 Barco barco=(Barco)this.barcos.get(k);
					for (String posicion : barco.getPosiciones()) {
		                tablero[jugada.filaIndex(posicion)][jugada.columnaEntera(posicion)] = 1;
					}
	    	 }
	    	 
			System.out.println("Tablero y Barcos") ;
			System.out.print("  ");
			for (int i = 0; i < tablero.length; i++) {
				System.out.print(jugada.columnaLetra(i) + " ");
			}
			System.out.println();
				 for (int i = 0; i < tablero.length; i++) {
						System.out.print(jugada.fila(i) + " ");
						for (int j = 0; j < tablero[i].length; j++) {
							System.out.print(tablero[i][j]+" ");
						}
						System.out.println();
					} 
			 }
			
	    public boolean orientacionValida(String orientacion) {
	        return orientacion.equalsIgnoreCase("vertical") || orientacion.equalsIgnoreCase("horizontal");
	    }

}
