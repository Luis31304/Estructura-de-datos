package com.mycompany.grupo_3_pfa1;

import javax.swing.JOptionPane;
/**
 *
 * @author Grupo3
 */
public class Pila {
    private Nodo cima;

    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public Object desapilar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
            return null;
        }
        Object dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void listar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay elementos en esta pila.");
            return;
        }
        String lista = "";
        Nodo aux = cima;
        while (aux != null) {
            lista += aux.dato.toString() + "\n";
            aux = aux.siguiente;
        }
        JOptionPane.showMessageDialog(null, lista, "Elementos en la pila", JOptionPane.INFORMATION_MESSAGE);
    }
}