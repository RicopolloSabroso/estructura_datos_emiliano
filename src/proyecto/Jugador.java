package proyecto;

import estructura.lista.DoubleLinkedList;

public class Jugador {
	private String nombre;
	private DoubleLinkedList barcos=new DoubleLinkedList();
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DoubleLinkedList getBarcos() {
		return barcos;
	}
}
