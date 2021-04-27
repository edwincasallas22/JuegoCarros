import modelos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        ArrayList<Podio> historialPodios = new ArrayList<>();

        while (!salir){
            opcion = bienvenida(scanner);
            switch (opcion){
                case 1:  {
                    historialPodios.add(iniciarJuego(scanner));
                    break;
                }
                case 2:  {
                    imprimirHistorial(historialPodios);
                    break;
                }
                case 3:{
                    salir = true;
                    break;
                }
                default:
                    System.out.println("Error, escoja una opcion que este dentro del rango");
            }
        }

    }

    private static int bienvenida(Scanner scanner) {
        System.out.println("/////////////////////////////////////////");
        System.out.println("/////Bienvenido al juego de carreras/////");
        System.out.println("/////////////////////////////////////////");
        System.out.println("Presiona 1 para jugar");
        System.out.println("Presiona 2 para ver el historial de ganadores ");
        System.out.println("Presiona 3 para salir");
        return scanner.nextInt();
    }

    private static Podio iniciarJuego(Scanner scanner) {
        int limitePista = definirDistancia(scanner);
        int numeroJugadores = definirNumeroJugadores(scanner);
        Pista pista = new Pista(limitePista, numeroJugadores);
        asignarJugadores(scanner, numeroJugadores, pista);

        int turno = 0;
        int ronda = 0;
        int contador = 0;
        String ganadorActual;
        Podio podio = new Podio(numeroJugadores);
        do {
            if (!pista.getVias()[turno].isFinalizo()) {
                System.out.println("Turno del jugador " + (turno + 1));
                System.out.print("Escriba cualquier letra y presione enter para lanzar dado: ");
                scanner.next();
                int resultado = obtenerResultadoDado();
                System.out.println("Resultado al tirar el dado = " + resultado);
                int metros = resultado * 100;
                int posicionActual = pista.getVias()[turno].getPosicion();
                metros = Math.min(metros, pista.getLimiteDistancia() - posicionActual);
                pista.avanzarVia(turno, metros);
                posicionActual = pista.getVias()[turno].getPosicion();
                System.out.println("El jugador " + (turno + 1) + " avanzo: " + metros + " metros");
                if (posicionActual >= pista.getLimiteDistancia()) {
                    ganadorActual = pista.getVias()[turno].getCarro().getConductor().getNombre();
                    podio.agregarGanador(contador, ganadorActual);
                    pista.getVias()[turno].setFinalizo(true);
                    contador++;
                }
                for (int i = 0; i < pista.getVias().length; i++) {
                    System.out.println("Carro " + (i + 1) + ": " + pista.getVias()[i].getPosicion());
                }
            }
            ronda++;
            turno = ronda % numeroJugadores;
        } while (contador < numeroJugadores);
        System.out.println("El Juego Termino \n");
        imprimirPodio(podio);
        return podio;
    }

    private static int definirDistancia(Scanner scanner) {
        int distanciaPista = 0;
        do {
            System.out.println("Escriba la ditancia de la pista");
            try {
                distanciaPista = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("La distancia de la pista escrita no es valida");
            }
        } while (distanciaPista == 0);

        return distanciaPista;
    }

    private static int definirNumeroJugadores(Scanner scanner) {
        int cantidadJugadores = 0;
        do {
            System.out.println("Seleccione la cantidad de Jugadores");
            try {
                cantidadJugadores = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("El numero de jugadores no es valido");
            }
        } while (cantidadJugadores == 0);

        return cantidadJugadores;
    }

    private static void asignarJugadores(Scanner scanner, int numeroJugadores, Pista pista) {
        for (int i = 0; i < numeroJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombreConductor = scanner.next();
            Jugador conductor = new Jugador(nombreConductor);
            Carro carro = new Carro(conductor);
            Via carril = new Via(carro);
            pista.agregarVia(carril, i);
        }
    }

    private static void imprimirPodio(Podio podio) {
        System.out.println("Los ganadores son: \n");

        for (int i = 0; i < podio.getGanadores().length; i++) {
            System.out.println("Puesto número " + (i+1) + ": " + podio.getGanadores()[i]);
            if (i == 2) {
                break;
            }
        }
    }

    private static void imprimirHistorial(ArrayList<Podio> historialPodios) {
        if(historialPodios.isEmpty()){
            System.out.println("Aun no hay registro de juegos");
        } else {
            System.out.println("El historial es el siguiente: ");
            for (int i = 0; i < historialPodios.size(); i++) {
                System.out.println("------Ronda " + (i+1) + ": -------");
                imprimirPodio(historialPodios.get(i));
                System.out.println("-------------------------------");
            }
        }
    }

    private static int obtenerResultadoDado() {
        return (int) (Math.random() * 6) + 1;
    }

}