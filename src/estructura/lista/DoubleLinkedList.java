package estructura.lista;

import estructura.nodo.BiNodo;
import estructura.nodo.Nodo;

public class DoubleLinkedList {

    private int size;
    private BiNodo f;
    private BiNodo r;

    public DoubleLinkedList() {
        size = 0;
        f = null;
        r = null;
    }

    public void addFirst(Object value) {
        BiNodo nodo = new BiNodo();
        nodo.setDato(value);
        if (f != null) {
            nodo.setDerecha(f);
            f.setIzquierda(nodo);
        } else if (r == null) {
            r = nodo;
        }
        f = nodo;
        size++;
    }

    public void addLast(Object value) {
        BiNodo nodo = new BiNodo();
        nodo.setDato(value);
        if (r != null) {
            nodo.setIzquierda(r);
            r.setDerecha(nodo);
        } else if (f == null) {
            f = nodo;
        }
        r = nodo;
        size++;
    }

    public void addMiddle(int index, Object value) {
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            BiNodo temp = search(index);
            if (temp != null) {
                BiNodo nodo = new BiNodo();
                nodo.setDato(value);
                BiNodo izquierda = temp.getIzquierda();
                nodo.setDerecha(temp);
                nodo.setIzquierda(izquierda);
                izquierda.setDerecha(nodo);
                temp.setIzquierda(nodo);
                size++;
            }
        }
    }

    public Object removeFirst() {
        if (isEmpty()) {
            return null;
        }
        BiNodo temp = f;
        Object value = temp.getDato();
        f = temp.getDerecha();
        if (f != null) {
            f.setIzquierda(null);
        } else {
            r = null; // La lista queda vacía
        }
        size--;
        return value;
    }

    public Object removeLast() {
        if (isEmpty()) {
            return null;
        }
        BiNodo temp = r;
        Object value = temp.getDato();
        r = temp.getIzquierda();
        if (r != null) {
            r.setDerecha(null);
        } else {
            f = null; // La lista queda vacía
        }
        size--;
        return value;
    }

    public void add(int index, Object value) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Fuera de rango.");
        }
        BiNodo nodo = new BiNodo();
        nodo.setDato(value);
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            addMiddle(index, value);
        }
    }

    public void add(Object value) {
        BiNodo nodo = new BiNodo();
        nodo.setDato(value);
        if (r != null) {
            nodo.setIzquierda(r);
            r.setDerecha(nodo);
        }
        r = nodo;
        size++;
    }

    public Object removeMiddle(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            return null;
        }
        BiNodo temp = search(index);
        BiNodo derecha = temp.getDerecha();
        BiNodo izquierda = temp.getIzquierda();
        if (derecha != null) {
            derecha.setIzquierda(izquierda);
        }
        if (izquierda != null) {
            izquierda.setDerecha(derecha);
        }
        temp.setIzquierda(null);
        temp.setDerecha(null);
        size--;
        return temp.getDato();
    }

    public Object remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            return removeMiddle(index);
        }
    }

    private BiNodo search(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            return null;
        }
        int middle = size / 2;
        BiNodo temp;
        int tempIndex;
        if (index < middle) {
            temp = f;
            tempIndex = 0;
            while (tempIndex < index) {
                tempIndex++;
                temp = temp.getDerecha();
            }
        } else {
            temp = r;
            tempIndex = size - 1;
            while (tempIndex > index) {
                tempIndex--;
                temp = temp.getIzquierda();
            }
        }
        return temp;
    }

    public Object get(int index) {
        BiNodo temp = search(index);
        return (temp != null) ? temp.getDato() : null;
    }

    public void set(int index, Object value) {
        BiNodo temp = search(index);
        if (temp != null) {
            temp.setDato(value);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        BiNodo current = f; 

        while (current != null)
        {
            s.append(current.getDato()).append(" -> ");
            current = current.getDerecha(); 
        }

        return s.toString();
    }
}
