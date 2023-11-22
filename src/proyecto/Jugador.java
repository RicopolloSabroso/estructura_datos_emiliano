package proyecto;


import estructura.lista.DoubleLinkedList;
import estructura.lista.LinkedList;

public class Jugador {
	private String nombre;
	private LinkedList barcos=new LinkedList();
	public Jugador(String nombre) {
		this.nombre=nombre;
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
}
