package call_center;

public class Main {
    public static void main(String[] args) {
        CallCenter centro = new CallCenter();

        System.out.println("1-recepcionllamada");
        centro.recibirLlamada(new Llamada(1, "Carlos Perez", Llamada.Tipo.NORMAL, 5.5));
        centro.recibirLlamada(new Llamada(2, "Ana Gomez", Llamada.Tipo.NORMAL, 3.0));
        centro.recibirLlamada(new Llamada(3, "VIP - Maria Lopez", Llamada.Tipo.PRIORITARIA, 8.0));
        centro.recibirLlamada(new Llamada(4, "Juan Torres", Llamada.Tipo.NORMAL, 4.2));

        System.out.println("2-estado inicial cola");
        centro.mostrarCola();
        System.out.println("Llamadas pendientes: " + centro.llamadasPendientes());
        System.out.println("Tiempo pendiente total: " + centro.tiempoTotalPendiente() + " min");

        System.out.println("3-atender una llamada");
        centro.atenderLlamada();

        System.out.println("4-cancelar llamada");
        centro.cancelarLlamada();

        System.out.println("5-estado actualizada");
        centro.mostrarCola();

        System.out.println("6-atender restantes");
        centro.atenderTodas();

        System.out.println("7-resumen final");
        System.out.println("Tiempo acumulado total atendido: " + centro.getTiempoTotal() + " min");
        System.out.println("Puntuaciones registradas: " + centro.getPuntuaciones());
        System.out.println("Promedio de puntuacion: " + centro.obtenerPromedio());
    }
}