package proyecto;

public class Barco {
	public enum Ubicacion{horizontal,vertical}
	private String posicionInicial;
	private Ubicacion ubicacion;
	protected String[] posiciones;
	protected boolean[] bajas;
	public Barco(String posicionInicial, Ubicacion ubicacion) {
		this.posicionInicial=posicionInicial;
		this.ubicacion=ubicacion;
		posiciones=new String [4];
		bajas=new boolean[4];
	}
	public String[] getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(String[] posiciones) {
		this.posiciones = posiciones;
	}
	 public void recibirImpacto(String posicion) {
	        for (int i = 0; i < posiciones.length; i++) {
	            if (posiciones[i].equals(posicion)) {
	                bajas[i] = true;
	                break;
	            }
	        }
	    }

	   public boolean estaHundido() {
	       for (boolean baja : bajas) {
	           if (!baja) {
	               return false;
            }
	      }
	       return true;
	   }
}
