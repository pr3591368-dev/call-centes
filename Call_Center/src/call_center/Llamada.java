package call_center;

import java.util.Random;

public class Llamada {

    public enum Tipo {
        NORMAL, PRIORITARIA
    }

    private final int id;
    private final String cliente;
    private final Tipo tipo;
    private final double duracion;
    private static final Random random = new Random();

    public Llamada(int id, String cliente, Tipo tipo, double duracion) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getDuracion() {
        return duracion;
    }

    public int obtenerPuntuacion() {
        return random.nextInt(10) + 1;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Cliente: " + cliente + " | Tipo: " + tipo + " | Duracion: " + duracion + " min";
    }
}