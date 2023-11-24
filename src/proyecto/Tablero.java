package proyecto;

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
		mostrarTableroDisparosYBarcos(jugador);
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
		temp[jugada.filaIndex(posicion)][jugada.columnaEntera(posicion)]=1;
		for(int i=0;i<barcos.size()-1;i++) {
			Barco barco=(Barco)barcos.get(i);
			for(int j=0;j<barco.getPosiciones().length;j++) {
				int fila=jugada.filaIndex(barco.getPosiciones()[j]);
				int columna=jugada.columnaEntera(barco.getPosiciones()[j]);
				if(fila==jugada.filaIndex(posicion)&& columna==jugada.columnaEntera(posicion)) {
					temp[fila][columna]=2;
					resultado=jugador;
					barco.impacto(posicion);
					if (barco.estaHundido()) {
	                    barcoHundido(jugador, posicion);
	                }
				}
			}
		}
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
        int[][] disparos = (jugador.getNombre().equals("jugador1")) ? disparos1 : disparos2;
        System.out.println("Disparos del " + jugador.getNombre() + " a " + ((jugador == jugador1) ? "Jugador2" : "Jugador1"));
        System.out.print("  ");
        for (int i = 0; i < disparos.length; i++) {
            System.out.print(jugada.columnaLetra(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < disparos.length; i++) {
        	 System.out.print(jugada.fila(i) + " ");
            for (int j = 0; j < disparos[i].length; j++) {
                System.out.print(disparos[i][j] + " ");
            }
            System.out.println();
        }
        mostrarTableroBarcos(jugador);
	}
	public void mostrarTableroBarcos(Jugador jugador) throws Exception{
		int[][] disparos = (jugador.getNombre().equals("jugador1")) ? disparos1 : disparos2;
        LinkedList barcos = jugador.getBarcos();
        int[][] barcosJ1 =jugador.getTablero();
        System.out.println("Tablero del " + jugador.getNombre());
        System.out.print("  ");
        for (int i = 0; i < barcosJ1.length; i++) {
            System.out.print(jugada.columnaLetra(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < barcosJ1.length; i++) {
            System.out.print(jugada.fila(i) + " ");
            for (int j = 0; j < barcosJ1[i].length; j++) {
                char marca = (barcosJ1[i][j] == 0) ? '0' : (barcosJ1[i][j] == 1) ? 'X' : (barcosJ1[i][j] == 2) ? 'I' : 'B';
                System.out.print(marca + " ");
            }
            System.out.println();
        }	
	}
}
	
