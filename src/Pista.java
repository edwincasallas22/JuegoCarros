import java.util.ArrayList;

public class Pista {

    private double distancia;
    private ArrayList<Carril> carriles;

    public Pista(){};

    public Pista(ArrayList<Carril> carriles, double distancia) {
        this.carriles = carriles;
        this.distancia = distancia;
    }

    public ArrayList<Carril> getCarriles() {
        return carriles;
    }

    public void setCarriles(ArrayList<Carril> carriles) {
        this.carriles = carriles;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}
