package call_center;

public class Cola<T> {

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public void enqueue(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (empty()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        tamano++;
    }

    public void enqueuePrioritario(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (empty()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            nuevoNodo.siguiente = frente;
            frente = nuevoNodo;
        }
        tamano++;
    }

    public T dequeue() {
        if (empty()) {
            throw new RuntimeException("La cola esta vacia.");
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        tamano--;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("La cola esta vacia.");
        }
        return frente.dato;
    }

    public boolean empty() {
        return frente == null;
    }

    public int size() {
        return tamano;
    }
}