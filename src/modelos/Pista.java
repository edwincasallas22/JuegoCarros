package modelos;

public class Pista {

    private final int limiteDistancia;
    private final Via[] carriles;

    public Pista(int limiteDistancia, int carriles) {
        this.limiteDistancia = limiteDistancia * 1000;
        this.carriles = new Via[carriles];
    }

    public int getLimiteDistancia() {
        return limiteDistancia;
    }

    public Via[] getVias() {
        return carriles;
    }

    public void agregarVia(Via carril, int numeroVia) {
        this.carriles[numeroVia] = carril;
    }

    public void avanzarVia(int numeroVia, int metros) {
        this.carriles[numeroVia].avanzar(metros);
    }
}
