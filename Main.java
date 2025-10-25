package com.mycompany.grupo_3_pfa1;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 3
 */
public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        int opcion = 0;

        do {
            String menu = """
                    ============================
                     JUEGO DE CARRERAS (Grupo 3)
                    ============================
                    1. Registrar jugadores
                    2. Agregar premio
                    3. Agregar castigo
                    4. Listar jugadores
                    5. Listar pilas
                    6. Jugar turno
                    7. Ayuda
                    8. Salir del programa
                    ============================
                    """;

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcion) {
                    case 1 -> {
                        int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores? (máx. 4)"));
                        for (int i = 0; i < n; i++) {
                            String nombre = JOptionPane.showInputDialog("Nombre del jugador " + (i + 1) + ":");
                            juego.registrarJugador(nombre);
                        }
                    }

                    case 2 -> {
                        String[] opcionesPremio = {
                                "+1 - Avanza 1 posición",
                                "+2 - Avanza 2 posiciones",
                                "+5 - Avanza 5 posiciones",
                                "+0 - Se queda en la misma posición"
                        };
                        String seleccionPremio = (String) JOptionPane.showInputDialog(
                                null, "Seleccione un premio:", "PILA DE PREMIOS",
                                JOptionPane.QUESTION_MESSAGE, null, opcionesPremio, opcionesPremio[0]);

                        if (seleccionPremio != null) {
                            String[] partes = seleccionPremio.split(" ");
                            String op = partes[0].substring(0, 1);
                            int num = Integer.parseInt(partes[0].substring(1));
                            String desc = seleccionPremio.substring(3);
                            juego.agregarPremio(new Premio(op, num, desc));
                            JOptionPane.showMessageDialog(null, "Premio agregado correctamente.");
                        }
                    }

                    case 3 -> {
                        String[] opcionesCastigo = {
                                "-1 - Retrocede 1 posición",
                                "-3 - Retrocede 3 posiciones",
                                "-5 - Retrocede 5 posiciones",
                                "=1 - Vuelve a la posición 1"
                        };
                        String seleccionCastigo = (String) JOptionPane.showInputDialog(
                                null, "Seleccione un castigo:", "PILA DE CASTIGOS",
                                JOptionPane.QUESTION_MESSAGE, null, opcionesCastigo, opcionesCastigo[0]);

                        if (seleccionCastigo != null) {
                            String[] partes = seleccionCastigo.split(" ");
                            String op = partes[0].substring(0, 1);
                            int num = Integer.parseInt(partes[0].substring(1));
                            String desc = seleccionCastigo.substring(3);
                            juego.agregarCastigo(new Castigo(op, num, desc));
                            JOptionPane.showMessageDialog(null, "Castigo agregado correctamente.");
                        }
                    }

                    case 4 -> juego.listarJugadores();
                    case 5 -> { juego.listarPremios(); juego.listarCastigos(); }
                    case 6 -> juego.jugarTurno();

                    case 7 -> JOptionPane.showMessageDialog(null, """
                            Versión: V 1.0.3
                            Desarrollado por: Grupo 3
                            Curso: SC-304 Estructuras de Datos
                            Profesor: José Alfredo Chaves Barboza
                            Universidad Fidélitas
                            """);

                    case 8 -> JOptionPane.showMessageDialog(null, "Gracias por jugar. ¡Hasta la próxima!");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }

        } while (opcion != 8);
    }
}