package com.mycompany.grupo_3_pfa1;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class Juego {
    private Cola colaJugadores = new Cola();
    private Pila pilaPremios = new Pila();
    private Pila pilaCastigos = new Pila();
    private Random random = new Random();

    public void registrarJugador(String nombre) {
        colaJugadores.encolar(new Jugador(nombre));
    }

    public void agregarPremio(Premio p) { pilaPremios.apilar(p); }
    public void agregarCastigo(Castigo c) { pilaCastigos.apilar(c); }

    public void listarJugadores() {
        if (colaJugadores.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
        } else {
            JOptionPane.showMessageDialog(null, "Jugadores listos para jugar:");
            colaJugadores.listar();
        }
    }

    public void listarPremios() {
        JOptionPane.showMessageDialog(null, "Premios disponibles:");
        pilaPremios.listar();
    }

    public void listarCastigos() {
        JOptionPane.showMessageDialog(null, "Castigos disponibles:");
        pilaCastigos.listar();
    }

    public void jugarTurno() {
        if (colaJugadores.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay jugadores en la cola.");
            return;
        }

        Jugador jugador = (Jugador) colaJugadores.desencolar();
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int total = dado1 + dado2;

        String mensaje = "Jugador: " + jugador.getNombre() + "\n"
                + "Dado 1: " + dado1 + "\n"
                + "Dado 2: " + dado2 + "\n"
                + "Total: " + total + "\n";

        if (total % 2 == 0) { // número par → premio
            Premio p = (Premio) pilaPremios.desapilar();
            if (p != null) {
                jugador.setPosicion(jugador.getPosicion() + p.getNumero());
                mensaje += "\n🎉 Premio obtenido: " + p + "\nNueva posición: " + jugador.getPosicion();
            } else {
                mensaje += "\nNo hay más premios disponibles.";
            }
        } else { // número impar → castigo
            Castigo c = (Castigo) pilaCastigos.desapilar();
            if (c != null) {
                jugador.setPosicion(jugador.getPosicion() - c.getNumero());
                if (jugador.getPosicion() < 0) jugador.setPosicion(0);
                mensaje += "\n😬 Castigo recibido: " + c + "\nNueva posición: " + jugador.getPosicion();
            } else {
                mensaje += "\nNo hay más castigos disponibles.";
            }
        }

        JOptionPane.showMessageDialog(null, mensaje);
        colaJugadores.encolar(jugador);
    }
}