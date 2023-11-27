package proyecto;

import java.util.Scanner;

import proyecto.Barco.Ubicacion;

public class Principal {

	public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        System.out.println("BATTLESHIP");
        System.out.println("\tReglas\n-Una vez posicionas tus barcos y comienzas la partida, no podrás volver a cambiarlos de posición.\n-Podrás disparar en cualquier casilla del tablero, salvo en las que ya has disparado.\n-No puedes deshacer disparos ni propios ni de tus oponentes.\n-Es un juego por turnos: haces tu disparo, si es \"agua\" el turno pasa a tu oponente; si \"tocas\" y/o hundes un barco enemigo, vuelves a disparar.\n-La partida acaba cuando un jugador ha hundido la flota completa del enemigo. \n");
        System.out.println("-Cada jugador tiene una flota de 9 barcos de diferente tamaño, por lo que cada uno ocupará un número determinado de casillas en el tablero.\n"
        		+ "\t-EL barco 1 ocupa 4 casillas.\n"
        		+ "\t-EL barco 2, 3 y 4 ocupan 3 casillas.\n"
        		+ "\t-EL barco 5, 6 y 7 ocupan 2 casillas.\n"
        		+ "\t-EL barco8 y 9 ocupan 1 casilla.\n");
        System.out.println("-Agua(0): cuando disparas sobre una casilla donde no está colocado ningún barco enemigo, disparas al agua. En tu tablero principal aparecerá una X. Pasa el turno a tu oponente.\n"
        		+ "-Impactado(I): cuando disparas en una casilla en la que está ubicado un barco enemigo que ocupa 2 o más casillas y destruyes sólo una parte del barco, lo has tocado. Vuelves a disparar.\n"
        		+ "-Hundido(H): si disparas en una casilla en la que está ubicado un fragata (1 casilla) u otro barco con el resto de casillas tocadas, le has hundido, es decir, has eliminado ese barco del juego. Aparecerá en tu tablero principal el barco completo echando humo. Vuelves a disparar, siempre y cuando no hayas hundido toda la flota de tu enemigo, en cuyo caso habrás ganado.\n"
        		+ "-Barco(4 o B): es la simbologia en la que va estar psicionado tu barco en tu tablero.\\n-Agua(0): cuando disparas sobre una casilla donde no está colocado ningún barco enemigo, disparas al agua. En tu tablero principal aparecerá una X. Pasa el turno a tu oponente.\n"
        		+ "-Impactado(I): cuando disparas en una casilla en la que está ubicado un barco enemigo que ocupa 2 o más casillas y destruyes sólo una parte del barco, lo has tocado. Vuelves a disparar.\n"
        		+ "-Hundido(H): si disparas en una casilla en la que está ubicado un fragata (1 casilla) u otro barco con el resto de casillas tocadas, le has hundido, es decir, has eliminado ese barco del juego. Aparecerá en tu tablero principal el barco completo echando humo. Vuelves a disparar, siempre y cuando no hayas hundido toda la flota de tu enemigo, en cuyo caso habrás ganado.\n"
        		+ "-Barco(4 o B): es la simbologia en la que va estar psicionado tu barco en tu tablero.\n");
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
             System.out.println("¡Fin del juego! El " + resultado.getNombre() + " ha ganado.");
             break;
         }
        }
    }
}
