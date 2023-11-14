package proyecto;

public abstract class Barco {
	public enum Ubicacion{horizontal,vertical}
	private String posicionInicial;
	private Ubicacion ubicacion;
	protected String[] posiciones;
	protected boolean[] bajas;
	public Barco(String posicionInicial, Ubicacion ubicacion) {
		this.posicionInicial=posicionInicial;
		this.ubicacion=ubicacion;
	}
	public String[] getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(String[] posiciones) {
		this.posiciones = posiciones;
	}
}
