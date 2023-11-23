package proyecto;

import proyecto.Barco.Ubicacion;

public class Barco {
	Jugada jugada=new Jugada();
	public enum Ubicacion{horizontal,vertical}
	private String posicionInicial;
	private Ubicacion ubicacion;
	protected String[] posiciones;
	protected boolean[] bajas;
	public Barco(String posicionInicial, Ubicacion ubicacion, int tam) {
		this.posicionInicial=posicionInicial;
		this.ubicacion=ubicacion;
		posiciones=new String [tam];
		bajas=new boolean[tam];
		posicionarBarco(posicionInicial, ubicacion);
	}
	
	public String[] getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(String[] posiciones) {
		this.posiciones = posiciones;
	}
	public void posicionarBarco(String posicionInicial, Ubicacion ubicacion) {
        int fila = jugada.filaIndex(posicionInicial);
        int columna = jugada.columnaEntera(posicionInicial);
        for (int i = 0; i < posiciones.length; i++) {
            if (ubicacion == Ubicacion.horizontal) {
                posiciones[i] = jugada.columnaLetra(columna + i) + jugada.fila(fila);
            } else {
                posiciones[i] = jugada.columnaLetra(columna) + jugada.fila(fila + i);
            }
        }
    }
	 public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public String getPosicionInicial() {
		return posicionInicial;
	}

	public void impacto(String posicion) {
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
