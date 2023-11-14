package proyecto;

import estructura.lista.DoubleLinkedList;

public class Tablero {
	private Jugador jugador1;
	private Jugador jugador2;
	private DoubleLinkedList[] disparos1= new DoubleLinkedList[10];
	private DoubleLinkedList[] disparos2= new DoubleLinkedList[10];
	public Tablero(Jugador jugador1, Jugador jugador2){
		this.jugador1=jugador1;	
		for(int i=0; i<10;i++) {
			for(int j=0; j<10;j++) {
				disparos1[i].add(0);
			}
		}
		this.jugador2  =jugador2;
		for(int i=0; i<10;i++) {
			for(int j=0; j<10;j++) {
				disparos2[i].add(0);
			}
		}
	}
	public void meterBarco(Jugador jugador, Barco barco) {
		jugador.getBarcos().add(barco);
	}
	public Jugador disparar(Jugador jugador, String posicion) {
		DoubleLinkedList[] temp= null;
		DoubleLinkedList barcos=null;
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
		int fila=
	}
}
