public class Carro {

    private Jugador conductor;
    private long cantidadRecorrida;

    public Carro(){};

    public Carro(Jugador conductor) {

        this.conductor = conductor;
    }

    public Jugador getConductor() {
        return conductor;
    }

    public void setConductor(Jugador conductor) {
        this.conductor = conductor;
    }

    public long getCantidadRecorrida() {
        return cantidadRecorrida;
    }

    public void setCantidadRecorrida(long cantidadRecorrida) {
        this.cantidadRecorrida = cantidadRecorrida;
    }

    public void sumarCantidadRecorrida(long cantidadRecorrida) {
        this.cantidadRecorrida += cantidadRecorrida;
    }
}
