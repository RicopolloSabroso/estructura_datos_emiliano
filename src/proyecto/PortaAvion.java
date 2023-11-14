package proyecto;

public class PortaAvion extends Barco {
	private String[] posiciones;
	public PortaAvion(String posicionInicial, Ubicacion ubicacion) {
		super(posicionInicial, ubicacion);
		posiciones=new String [4];
		bajas=new boolean[4];
	}
}
