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
	            while (!jugada.esPosicionValida(posicion)||(!jugada.entraEnRango(posicion, tam[i],Barco.Ubicacion.horizontal)&& !jugada.entraEnRango(posicion, tam[i],Barco.Ubicacion.vertical)) ||(barcoOcupado(posicion,tam[i],Barco.Ubicacion.horizontal)&&barcoOcupado(posicion,tam[i],Barco.Ubicacion.vertical))) {
	                System.out.println("Posición inválida u ocupada. Porfavor vuelve a intentarlo ");
	                posicion = leer.nextLine().toUpperCase();
	            }
	        	if(i==7||i==8) {
	        		Barco barco = new Barco(posicion, Barco.Ubicacion.valueOf("vertical"),tam[i]);
	 	            this.barcos.add(barco);
	        	}else {
	        		System.out.println("Elige la orientación del barco (Horizontal o Vertical): ");
		            String orientacion = leer.nextLine().toLowerCase();
		            while (!orientacionValida(orientacion)|| !jugada.entraEnRango(posicion, tam[i], Barco.Ubicacion.valueOf(orientacion))||barcoOcupado(posicion,tam[i],Barco.Ubicacion.valueOf(orientacion))) {
		                System.out.println("orientacion inválida o el barco se pasa de rango . Porfavor vuelve a intentarlo ");
		                orientacion = leer.nextLine().toLowerCase();
		            }
		            Barco barco = new Barco(posicion, Barco.Ubicacion.valueOf(orientacion),tam[i]);
	 	            this.barcos.add(barco);  
	        	}
	            
	        }
	        mostrarTableroBarcos(); 
	        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	    }

	    private boolean barcoOcupado(String posicion, int tam, Ubicacion ubicacion) throws Exception{
	    	String[] lugar=jugada.posicionarBarcoPrueba(posicion,ubicacion, tam);
	    	for (int i = 0; i < this.barcos.size(); i++) {
	            Barco barco = (Barco)this.barcos.get(i);
	            if (barco != null) {
	            	for (String pos : barco.getPosiciones()) {
		                for (String nuevaPos : lugar) {
		                    if (pos.equalsIgnoreCase(nuevaPos)) {
		                        return true; 
		                    }
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
		                tablero[jugada.filaIndex(posicion)][jugada.columnaEntera(posicion)] = 4;
					}
	    	 }
	    	 
			System.out.println("Tablero y Barcos del: "+ this.nombre) ;
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
			
	    public int[][] getTablero() {
			return tablero;
		}
		public boolean orientacionValida(String orientacion) {
	        return orientacion.equalsIgnoreCase("vertical") || orientacion.equalsIgnoreCase("horizontal");
	    }
		public String coordenadaValida() {
	        Scanner leer = new Scanner(System.in);
			System.out.println("Escriba la coordenada que desee disparar ");
            String coordenada = leer.nextLine().toUpperCase();
            while (!jugada.esPosicionValida(coordenada)) {
                System.out.println("Posición inválida. Porfavor vuelve a intentarlo ");
                coordenada = leer.nextLine().toUpperCase();
            }
            return coordenada;
		}

}
