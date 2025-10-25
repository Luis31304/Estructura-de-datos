package com.mycompany.grupo_3_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;

    public void encolar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Object desencolar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return null;
        }
        Object dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void listar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "Cola vacía.");
            return;
        }
        String lista = "";
        Nodo aux = frente;
        while (aux != null) {
            lista += aux.dato.toString() + "\n";
            aux = aux.siguiente;
        }
        JOptionPane.showMessageDialog(null, lista, "Lista de jugadores", JOptionPane.INFORMATION_MESSAGE);
    }
}
