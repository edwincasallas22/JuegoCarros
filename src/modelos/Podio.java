package modelos;

public class Podio {
    private String[] ganadores;

    public Podio() {
        this.ganadores = new String[3];
    }

    public String[] getGanadores() {
        return ganadores;
    }

    public void setGanadores(String[] ganadores) {
        this.ganadores = ganadores;
    }

    public void agregarGanador(int contador, String conductor) {
        this.ganadores[contador] = conductor;

    }
}
