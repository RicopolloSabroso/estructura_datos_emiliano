package proyecto;

import proyecto.Barco.Ubicacion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jugador jugador1=new Jugador("jugador1");
		Jugador jugador2=new Jugador("jugador2");
		Jugador resultado=null;
		
		Tablero tablero=new Tablero(jugador1,jugador2);
		//Jugador 1
		PortaAvion portaAvion1=new PortaAvion("D5",Ubicacion.horizontal);
		portaAvion1.setPosiciones(new String[] {"D5","E5","F5","G5"});
		PortaAvion portaAvion2=new PortaAvion("D5",Ubicacion.vertical);
		portaAvion1.setPosiciones(new String[] {"A6","A7","A8","95"});
		tablero.meterBarco(jugador1, portaAvion1);
		tablero.meterBarco(jugador1, portaAvion2);
		//jugador 2
		portaAvion1=new PortaAvion("A1",Ubicacion.horizontal);
		portaAvion1.setPosiciones(new String[] {"A1","B1","C1","D1"});
		portaAvion2=new PortaAvion("C4",Ubicacion.vertical);
		portaAvion1.setPosiciones(new String[] {"C4","C5","C6","C7"});
		tablero.meterBarco(jugador2, portaAvion1);
		tablero.meterBarco(jugador2, portaAvion2);
		//turnos jugador inicial
		resultado=jugador1;
		resultado=tablero.disparar(resultado,"C4");
	}

}
