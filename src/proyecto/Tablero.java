package proyecto;

import estructura.lista.DoubleLinkedList;
import estructura.lista.LinkedList;

public class Tablero {
	private Jugador jugador1;
	private Jugador jugador2;
	private int[][] disparos1= new int[10][10];
	private int[][] disparos2= new int[10][10];
	public Tablero(Jugador jugador1, Jugador jugador2){
		this.jugador1=jugador1;	
		this.jugador2  =jugador2;
	}
	public void meterBarco(Jugador jugador, Barco barco) {
		jugador.getBarcos().add(barco);
	}
	public Jugador disparar(Jugador jugador, String posicion)throws Exception {
		int[][] temp= null;
		LinkedList barcos=null;
		Jugador resultado=null;
		if(jugador.getNombre().equals("jugador1")) {
			temp=disparos2;
			barcos=jugador2.getBarcos();
			resultado=jugador2;
		}else {
			temp=disparos1;
			barcos=jugador1.getBarcos();
			resultado=jugador1;
		}
		temp[Jugada.filaIndex(posicion)][Jugada.columnaEntera(posicion)]=1;
		for(int i=0;i<barcos.size()-1;i++) {
			Barco barco=(Barco)barcos.get(i);
			for(int j=0;j<barco.getPosiciones().length;j++) {
				int fila=Jugada.filaIndex(barco.getPosiciones()[j]);
				int columna=Jugada.columnaEntera(barco.getPosiciones()[j]);
				if(fila==Jugada.filaIndex(posicion)&& columna==Jugada.columnaEntera(posicion)) {
					temp[fila][columna]=2;
					resultado=jugador;
					barco.recibirImpacto(posicion);
					if (barco.estaHundido()) {
	                    marcarBarcoHundido(jugador, posicion);
	                }
				}
			}
		}
		return resultado;
	}
	public void marcarBarcoHundido(Jugador jugador, String posicion)throws Exception {
	    if(jugador == jugador1) {
	    	 LinkedList barcos = jugador2.getBarcos();
	 	    for(int i=0;i<barcos.size()-1;i++) {
	 	    	Barco barco=(Barco)barcos.get(i);
	 	        if ( barco.estaHundido()) {
	 	            for (String posicionBarco : barco.getPosiciones()) {
	 	                int fila = Jugada.filaIndex(posicionBarco);
	 	                int columna = Jugada.columnaEntera(posicionBarco);
	 	               disparos2[fila][columna] = 3; 
	 	            }
	 	        }
	 	    }
	    }else {
	    	LinkedList barcos =jugador1.getBarcos();
	 	    for(int i=0;i<barcos.size()-1;i++) {
	 	    	Barco barco=(Barco)barcos.get(i);
	 	        if ( barco.estaHundido()) {
	 	            for (String posicionBarco : barco.getPosiciones()) {
	 	                int fila = Jugada.filaIndex(posicionBarco);
	 	                int columna = Jugada.columnaEntera(posicionBarco);
	 	               disparos1[fila][columna] = 3; 
	 	            }
	 	        }
	 	    }
	    }
	    
	   
	}
	public void mostrarTableroDisparosJ1() {
		System.out.println("Disparos de Jugador1 a Jugador2");
		for(int i=0;i<disparos2.length;i++) {
			for(int j=0;j<disparos2[i].length;j++) {
				System.out.print(disparos2[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void mostrarTableroDisparosJ2() {
		System.out.println("Disparos de Jugador2 a Jugador1");
		for(int i=0;i<disparos1.length;i++) {
			for(int j=0;j<disparos1[i].length;j++) {
				System.out.print(disparos1[i][j]+" ");
			}
			System.out.println();
		}
	}
}
