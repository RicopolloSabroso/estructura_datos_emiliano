package proyecto;

import estructura.lista.DoubleLinkedList;

public class Tablero {
	private Jugador jugador1;
	private Jugador jugador2;
	private DoubleLinkedList[] disparos1= new DoubleLinkedList[10];
	private DoubleLinkedList[] disparos2= new DoubleLinkedList[10];
	public Tablero(Jugador jugador1, Jugador jugador2){
		this.jugador1=jugador1;	
		this.jugador2  =jugador2;	
	}
	public void meterBarco(Jugador jugador, Barco barco) {
		jugador.getBarcos().add(barco);
	}
}
