package proyecto;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import estructura.lista.DoubleLinkedList;
import estructura.lista.LinkedList;

public class Tablero {
	Jugada jugada=new Jugada();
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
		int[][] tableroContrario= null;
		LinkedList barcos=null;
		Jugador resultado=null;
		if(jugador.getNombre().equals("jugador1")) {
			temp=disparos2;
			barcos=jugador2.getBarcos();
			resultado=jugador2;
			tableroContrario=resultado.getTablero();
		}else {
			temp=disparos1;
			barcos=jugador1.getBarcos();
			resultado=jugador1;
			tableroContrario=resultado.getTablero();
		}
		tableroContrario[jugada.filaIndex(posicion)][jugada.columnaEntera(posicion)]=1;
		temp[jugada.filaIndex(posicion)][jugada.columnaEntera(posicion)]=1;
		for(int i=0;i<barcos.size();i++) {
			Barco barco=(Barco)barcos.get(i);
			for(int j=0;j<barco.getPosiciones().length;j++) {
				int fila=jugada.filaIndex(barco.getPosiciones()[j]);
				int columna=jugada.columnaEntera(barco.getPosiciones()[j]);
				if(fila==jugada.filaIndex(posicion)&& columna==jugada.columnaEntera(posicion)) {
					temp[fila][columna]=2;
					tableroContrario[fila][columna]=2;
					resultado=jugador;
					barco.impacto(posicion);
					if (barco.estaHundido()) {
	                    barcoHundido(jugador, posicion);
	                }
				}
			}
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		return resultado;
	}
	public void barcoHundido(Jugador jugador, String posicion)throws Exception {
	    if(jugador == jugador1) {
	    	 LinkedList barcos = jugador2.getBarcos();
	 	    for(int i=0;i<barcos.size();i++) {
	 	    	Barco barco=(Barco)barcos.get(i);
	 	        if ( barco.estaHundido()) {
	 	            for (String posicionBarco : barco.getPosiciones()) {
	 	               disparos2[jugada.filaIndex(posicionBarco)][jugada.columnaEntera(posicionBarco)]= 3; 
	 	            }
	 	        }
	 	    }
	    }else {
	    	LinkedList barcos =jugador1.getBarcos();
	 	    for(int i=0;i<barcos.size();i++) {
	 	    	Barco barco=(Barco)barcos.get(i);
	 	        if ( barco.estaHundido()) {
	 	            for (String posicionBarco : barco.getPosiciones()) {
	 	               disparos1[jugada.filaIndex(posicionBarco)][jugada.columnaEntera(posicionBarco)] = 3; 
	 	            }
	 	        }
	 	    }
	    }
	    
	   
	}
	public void mostrarTableroDisparosYBarcos(Jugador jugador) throws Exception{
		int[][] disparos = (jugador.getNombre().equals("jugador1")) ? disparos2 : disparos1;
	    System.out.println("Disparos del " + jugador.getNombre() + " a " + ((jugador == jugador1) ? "Jugador2" : "Jugador1"));
	    System.out.print("  ");
	    for (int i = 0; i < disparos.length; i++) {
	        System.out.print(jugada.columnaLetra(i) + " ");
	    }
	    System.out.println();
	    for (int i = 0; i < disparos.length; i++) {
	        System.out.print(jugada.fila(i) + " ");
	        for (int j = 0; j < disparos[i].length; j++) {
	        	char marca = (disparos[i][j] == 0) ? '0' : (disparos[i][j] == 1) ? 'X' : (disparos[i][j] == 2) ? 'I' : (disparos[i][j] == 3) ? 'H' : 'B';
		        System.out.print(marca + " ");
	        }
	        System.out.println();
	    }
	    mostrarTableroBarcos(jugador);
	}

	public void mostrarTableroBarcos(Jugador jugador) throws Exception {
	    System.out.println("Tablero del " + ((jugador == jugador1) ? "Jugador1" : "Jugador2"));
	    int[][] barcosJugador = (jugador == jugador1) ? jugador1.getTablero() : jugador2.getTablero();
	    System.out.print("  ");
	    for (int i = 0; i < barcosJugador.length; i++) {
	        System.out.print(jugada.columnaLetra(i) + " ");
	    }
	    System.out.println();
	    for (int i = 0; i < barcosJugador.length; i++) {
	        System.out.print(jugada.fila(i) + " ");
	        for (int j = 0; j < barcosJugador[i].length; j++) {
	            char marca = (barcosJugador[i][j] == 0) ? '0' : (barcosJugador[i][j] == 1) ? 'X' : (barcosJugador[i][j] == 2) ? 'I' :  (barcosJugador[i][j] == 3) ? 'H' : 'B';
	            System.out.print(marca + " ");
	        }
	        System.out.println();
	    }
	}
	public boolean juegoTerminao(Jugador jugador)throws Exception {
		LinkedList barcos =(jugador == jugador1) ?jugador2.getBarcos() : jugador1.getBarcos();
 	    for(int i=0;i<barcos.size();i++) {
 	    	Barco barco=(Barco)barcos.get(i);
 	    	 if (!barco.estaHundido()) {
                 return false;
             }
 	    }
        return true;
    }
	public boolean disparoValido(Jugador jugador, String posicion) {
	    int[][] disparos = (jugador.getNombre().equals("jugador1")) ? disparos2 : disparos1;
	    int fila = jugada.filaIndex(posicion);
	    int columna = jugada.columnaEntera(posicion);
	    if (disparos[fila][columna] != 0) {
	        System.out.println("Posición inválida. Ya has disparado en esa ubicación.");
	        return false;
	    }
	    return true;
	}
}
	
