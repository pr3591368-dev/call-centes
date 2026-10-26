package call_center;

import java.util.LinkedList;

public class CallCenter {

    private final Cola<Llamada> colaLlamadas;
    private double tiempoTotal;
    private final LinkedList<Integer> puntuaciones;

    public CallCenter() {
        this.colaLlamadas = new Cola<>();
        this.tiempoTotal = 0.0;
        this.puntuaciones = new LinkedList<>();
    }

    public void recibirLlamada(Llamada llamada) {
        if (llamada.getTipo() == Llamada.Tipo.PRIORITARIA) {
            colaLlamadas.enqueuePrioritario(llamada);
        } else {
            colaLlamadas.enqueue(llamada);
        }
    }

    public Llamada atenderLlamada() {
        if (colaLlamadas.empty()) {
            System.out.println("No hay llamadas para atender.");
            return null;
        }
        Llamada llamada = colaLlamadas.dequeue();
        this.tiempoTotal += llamada.getDuracion();
        int puntuacion = llamada.obtenerPuntuacion();
        this.puntuaciones.add(puntuacion);
        
        System.out.println("Atendida -> Cliente: " + llamada.getCliente() +
                " | Duracion: " + llamada.getDuracion() + " min | Puntuacion: " + puntuacion);
        return llamada;
    }

    public void cancelarLlamada() {
        if (colaLlamadas.empty()) {
            System.out.println("No hay llamadas para cancelar.");
            return;
        }
        Llamada cancelada = colaLlamadas.dequeue();
        System.out.println("Llamada cancelada de: " + cancelada.getCliente());
    }

    public void mostrarCola() {
        if (colaLlamadas.empty()) {
            System.out.println("La cola de llamadas esta vacia.");
            return;
        }

        System.out.println("--- Llamadas Pendientes ---");
        Cola<Llamada> aux = new Cola<>();
        while (!colaLlamadas.empty()) {
            Llamada l = colaLlamadas.dequeue();
            System.out.println("- Cliente: " + l.getCliente() + " | Duracion: " + l.getDuracion() + " min | Tipo: " + l.getTipo());
            aux.enqueue(l);
        }
        while (!aux.empty()) {
            colaLlamadas.enqueue(aux.dequeue());
        }
    }

    public double tiempoTotalPendiente() {
        double suma = 0.0;
        Cola<Llamada> aux = new Cola<>();
        while (!colaLlamadas.empty()) {
            Llamada l = colaLlamadas.dequeue();
            suma += l.getDuracion();
            aux.enqueue(l);
        }
        while (!aux.empty()) {
            colaLlamadas.enqueue(aux.dequeue());
        }
        return suma;
    }

    public int llamadasPendientes() {
        return colaLlamadas.size();
    }

    public void atenderTodas() {
        if (colaLlamadas.empty()) {
            System.out.println("No hay llamadas pendientes para atender.");
            return;
        }
        System.out.println("--- Atendiendo todas las llamadas ---");
        while (!colaLlamadas.empty()) {
            atenderLlamada();
        }
    }

    public int obtenerPromedio() {
        if (puntuaciones.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (int p : puntuaciones) {
            suma += p;
        }
        return suma / puntuaciones.size();
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public LinkedList<Integer> getPuntuaciones() {
        return puntuaciones;
    }
}