package estructura.tareas.hilo;

import estructura.pila.Pila;

public class Billete {
	private Pila billete1000;
	private Pila billete500;
	private Pila billete200;
	private Pila billete100;
	private Pila billete50;
	private Pila billete20;
    private Pila moneda10;
    private Pila moneda5;
    private Pila moneda2;
    private Pila moneda1;

    public Billete() {
    	billete1000 = pilaDinero(100,1000);
    	billete500 = pilaDinero(100,500);
    	billete200 = pilaDinero(100,200);
    	billete100 = pilaDinero(100,100);
    	billete50 = pilaDinero(100,50);
    	billete20 = pilaDinero(100,20);
        moneda10 = pilaDinero(100,10);
        moneda5 = pilaDinero(100,5);
        moneda1 = pilaDinero(100,1);   
    }
    private Pila pilaDinero(int estadoInicial, double valor) {
        Pila stack = new Pila(200);
        for (int i = 0; i < estadoInicial; i++) {
            stack.push(valor);
        }
        return stack;
    }
    public Pila getBillete1000() {
		return billete1000;
	}
	public Pila getBillete500() {
		return billete500;
	}
	public Pila getBillete200() {
		return billete200;
	}
	public Pila getBillete100() {
		return billete100;
	}
	public Pila getBillete50() {
		return billete50;
	}
	public Pila getBillete20() {
		return billete20;
	}
	public Pila getMoneda10() {
		return moneda10;
	}
	public Pila getMoneda5() {
		return moneda5;
	}
	public Pila getMoneda2() {
		return moneda2;
	}
	public Pila getMoneda1() {
		return moneda1;
	}
	
}
