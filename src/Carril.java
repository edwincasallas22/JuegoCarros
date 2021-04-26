public class Carril {

    private Carro carro;

    public Carril(){};

    public Carril( Carro carro) {
        this.carro = carro;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
