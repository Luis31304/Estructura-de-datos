package com.mycompany.grupo_3_pfa1;

/**
 *
 * @author Grupo 3
 */
public class Castigo {
    private String operacion;
    private int numero;
    private String descripcion;

    public Castigo(String operacion, int numero, String descripcion) {
        this.operacion = operacion;
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public String getOperacion() { return operacion; }
    public int getNumero() { return numero; }

    @Override
    public String toString() {
        return operacion + numero + " → " + descripcion;
    }
}