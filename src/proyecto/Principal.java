package proyecto;

import proyecto.Barco.Ubicacion;

public class Principal {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Jugador jugador1=new Jugador("jugador1");

		Jugador jugador2=new Jugador("jugador2");
		Jugador resultado=null;
		
		Tablero tablero=new Tablero(jugador1,jugador2);
		//Jugador 1
		//Barco portaAvion1=new Barco("D5",Ubicacion.horizontal);
		//portaAvion1.setPosiciones(new String[] {"D5","E5","F5","G5"});
		//Barco portaAvion2=new Barco("D5",Ubicacion.vertical);
		//portaAvion2.setPosiciones(new String[] {"A6","A7","A8","95"});
//		tablero.meterBarco(jugador1, portaAvion1);
//		tablero.meterBarco(jugador1, portaAvion2);
		//jugador 2
		//portaAvion1=new Barco("A1",Ubicacion.horizontal);
		//portaAvion1.setPosiciones(new String[] {"A1","B1","C1","D1"});
		//portaAvion2=new Barco("C4",Ubicacion.vertical);
		//portaAvion2.setPosiciones(new String[] {"C4","C5","C6","C7"});
		//tablero.meterBarco(jugador2, portaAvion1);
		//tablero.meterBarco(jugador2, portaAvion2);
		//turnos jugador inicial
		resultado=jugador1;
		System.out.println("turno: "+resultado.getNombre());
		resultado=tablero.disparar(resultado,"A1");
		tablero.mostrarTableroDisparosYBarcos(resultado);
		System.out.println("turno: "+resultado.getNombre());
		resultado=tablero.disparar(resultado,"B1");
		System.out.println("turno: "+resultado.getNombre());
		resultado=tablero.disparar(resultado,"C1");
		System.out.println("turno: "+resultado.getNombre());
		resultado=tablero.disparar(resultado,"D1");
		System.out.println("turno: "+resultado.getNombre());
		resultado=tablero.disparar(resultado,"C4");
		System.out.println("turno: "+resultado.getNombre());
		//tablero.mostrarTableroJ2();
		resultado=tablero.disparar(resultado,"J3");
		System.out.println("turno: "+resultado.getNombre());
		tablero.mostrarTableroDisparosYBarcos(resultado);
		
	}

}
