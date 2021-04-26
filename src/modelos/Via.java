package modelos;


public class Via {

    private int posicion;
    private boolean finalizo;
    private Carro carro;

    public Via (Carro carro){
        this.carro = carro;
        this.posicion = 0;
        this.finalizo = false;
    }

    public boolean isFinalizo() {
        return finalizo;
    }

    public void setFinalizo(boolean finalizo) {
        this.finalizo = finalizo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int avanzar ( int metros){
        this.posicion += metros;
        return this.posicion;
    }

}
