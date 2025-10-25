package com.mycompany.grupo_3_pfa1;

/**
 *
 * @author Grupo 3
 */
public class Jugador {
    private String nombre;
    private int posicion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
    }

    public String getNombre() { return nombre; }
    public int getPosicion() { return posicion; }
    public void setPosicion(int posicion) { this.posicion = posicion; }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " | Posición actual: " + posicion;
    }
}