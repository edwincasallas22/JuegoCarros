package modelos;

public class Pista {

    private int limiteDistancia;
    private Via[] carriles;

    public Pista(int limiteDistancia, int carriles) {
        this.limiteDistancia = limiteDistancia * 1000;
        this.carriles = new Via[carriles];
    }

    public int getLimiteDistancia() {
        return limiteDistancia;
    }

    public void setLimiteDistancia(int limiteDistancia) {
        this.limiteDistancia = limiteDistancia;
    }

    public Via[] getVias() {
        return carriles;
    }

    public void setVia(Via[] carriles) {
        this.carriles = carriles;
    }

    public void agregarVia(Via carril, int numeroVia) {
        this.carriles[numeroVia] = carril;
    }

    public int avanzarVia(int numeroVia, int metros) {
        return this.carriles[numeroVia].avanzar(metros);
    }
}
