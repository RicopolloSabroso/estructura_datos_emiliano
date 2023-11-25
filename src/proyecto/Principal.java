package proyecto;

import java.util.Scanner;

import proyecto.Barco.Ubicacion;

public class Principal {

	public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);

        Jugador jugador1 = new Jugador("jugador1");
        Jugador jugador2 = new Jugador("jugador2");
        Jugador resultado = null;

        Tablero tablero = new Tablero(jugador1, jugador2);
      	resultado = jugador1;
        while (true) {
            System.out.println("Turno: " + resultado.getNombre());
            tablero.mostrarTableroDisparosYBarcos(resultado);
            String disparo = resultado.coordenadaValida();
            while (!tablero.disparoValido(resultado, disparo)) {
                disparo = resultado.coordenadaValida();
            }
            resultado = tablero.disparar(resultado, disparo);
            if (tablero.juegoTerminao(resultado)) {
                System.out.println("¡Fin del juego! El jugador " + resultado.getNombre() + " ha ganado.");
                break;
            }

        }
    }
}
