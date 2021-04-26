import modelos.*;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        int menu = 0;
        Scanner scanner = new Scanner(System.in);
        menu = bienvenida(scanner);
        if (menu == 1) {
            int limitePista = definirDistancia(scanner);
            int numeroJugadores = definirNumeroJugadores(scanner);
            Pista pista = new Pista(limitePista, numeroJugadores);
            asignarJugadores(scanner, numeroJugadores, pista);

            int turno = 0;
            int ronda = 0;
            int contador = 0;
            String ganadorActual;
            Podio podio = new Podio();
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
            } while (contador < 3);
            imprimirPodio(podio);
        } else if (menu == 2) {

        }


    }


    private static int bienvenida(Scanner scanner) {
        System.out.println("/////////////////////////////////////////");
        System.out.println("/////Bienvenido al juego de carreras/////");
        System.out.println("/////////////////////////////////////////");
        System.out.println("Presiona 1 para jugar o presiona 2 para ver el historial de ganadores : ");
        return scanner.nextInt();
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
        System.out.println("                 El Juego Termino \n");
        System.out.println("Los ganadores son: \n");

        for (int i = 0; i < podio.getGanadores().length; i++) {
            System.out.println("Puesto número " +  i + ": " + podio.getGanadores()[i]);
        }
    }

    private static int obtenerResultadoDado() {
        return (int) (Math.random() * 6) + 1;
    }

}