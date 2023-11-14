package proyecto;

import proyecto.Barco.Ubicacion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jugador jugador1=new Jugador("ricoy");
		Jugador jugador2=new Jugador("richi");
		Jugador resultado=null;
		
		Tablero tablero=new Tablero(jugador1,jugador2);
		//Jugador 1
		PortaAvion portaAvion1=new PortaAvion("D5",Ubicacion.horizontal);
		portaAvion1.setPosiciones(new String[] {"D5","E5","F5","G5"});
		PortaAvion portaAvion2=new PortaAvion("D5",Ubicacion.vertical);
		portaAvion1.setPosiciones(new String[] {"A6","A7","A8","95"});
		tablero.meterBarco(jugador1, portaAvion1);
		tablero.meterBarco(jugador1, portaAvion2);
	}

}
