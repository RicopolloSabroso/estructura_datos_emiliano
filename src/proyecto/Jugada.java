package proyecto;

public class Jugada {
	public boolean esPosicionValida(String posicion) {
        if (posicion.length() < 2 || posicion.length() > 3) {
            return false;
        }

        char letra = posicion.charAt(0);
        int numero;

        try {
            numero = Integer.parseInt(posicion.substring(1));
        } catch (NumberFormatException e) {
            return false;
        }

        return letra >= 'A' && letra <= 'J' && numero >= 1 && numero <= 10;
    }
	public int filaIndex(String posicion) {
		String lugar=posicion.substring(1,posicion.length());
		int fila=0;
		if(validar(lugar)) {
			fila=Integer.parseInt(lugar);
		}
		return fila-1;
	}
	public int fila(int fila) {
		return fila+1;
	}
	public String columnaLetra(int columna ) {
		String colum="";
		switch(columna) {
			case 0:
				colum="A";
				break;
			case 1:
				colum="B";
				break;
			case 2:
				colum="C";
				break;
			case 3:
				colum="D";
				break;
			case 4:
				colum="E";
				break;
			case 5:
				colum="F";
				break;
			case 6:
				colum="G";
				break;
			case 7:
				colum="H";
				break;
			case 8:
				colum="I";
				break;
			case 9:
				colum="J";
				break;
		}
		return colum;
	}
	public int columnaEntera(String posicion ) {
		char lugar=posicion.charAt(0);
		int colum=0;
		switch(lugar) {
			case 'A':
				colum=0;
				break;
			case 'B':
				colum=1;
				break;
			case 'C':
				colum=2;
				break;
			case 'D':
				colum=3;
				break;
			case 'E':
				colum=4;
				break;
			case 'F':
				colum=5;
				break;
			case 'G':
				colum=6;
				break;
			case 'H':
				colum=7;
				break;
			case 'I':
				colum=8;
				break;
			case 'J':
				colum=9;
				break;
		}
		return colum;
	}
	public boolean validar(String x){
		boolean resultado=false;
		try {
			if(Integer.parseInt(x)>0&&Integer.parseInt(x)<11) {
				resultado=true;
			}
		}catch(Exception ex) {
		}
		return resultado;
	}
	
	
}
