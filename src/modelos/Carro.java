package modelos;

public class Carro {
    Jugador conductor;

    public Jugador getConductor() {
        return conductor;
    }

    public void setConductor(Jugador conductor) {
        this.conductor = conductor;
    }

    public Carro(Jugador conductor) {
        this.conductor = conductor;
    }

}
