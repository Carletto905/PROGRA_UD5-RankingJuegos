package controlador;

import modelo.Videojuego;
import util.Utilidades;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankingManager {

    private static final ArrayList<Videojuego> lista = new ArrayList<>();

    public static void mostrarMenu() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                "1. Añadir\n2. Editar\n3. Mostrar\n4. Eliminar\nQ. Salir",
                "Menú Ranking", JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) continue;

            switch (opcion.toLowerCase()) {
                case "1": añadir(); break;
                case "2": editar(); break;
                case "3": mostrar(); break;
                case "4": eliminar(); break;
                case "q": break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (!"q".equalsIgnoreCase(opcion));
    }

    private static void añadir() {
        String nombre = Utilidades.solicitarTexto("Nombre del videojuego:");
        String genero = Utilidades.solicitarTexto("Género:");
        String plataforma = Utilidades.solicitarTexto("Plataforma:");
        int puntuacion = Utilidades.solicitarPuntuacion("Puntuación (1-5):");

        lista.add(new Videojuego(nombre, genero, plataforma, puntuacion));
    }

    private static void editar() {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay videojuegos para editar.");
            return;
        }

        mostrar();
        int index = Utilidades.solicitarIndice("Selecciona el índice del videojuego a editar:", lista.size());

        Videojuego vj = lista.get(index);
        vj.setNombre(Utilidades.solicitarTexto("Nuevo nombre:"));
        vj.setGenero(Utilidades.solicitarTexto("Nuevo género:"));
        vj.setPlataforma(Utilidades.solicitarTexto("Nueva plataforma:"));
        vj.setPuntuacion(Utilidades.solicitarPuntuacion("Nueva puntuación (1-5):"));
    }

    private static void mostrar() {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay videojuegos para mostrar.");
            return;
        }

        lista.sort(Comparator.comparingInt(Videojuego::getPuntuacion).reversed());

        StringBuilder sb = new StringBuilder("Ranking:\n");
        for (int i = 0; i < lista.size(); i++) {
            sb.append(i).append(". ").append(lista.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void eliminar() {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay videojuegos para eliminar.");
            return;
        }

        mostrar();
        int index = Utilidades.solicitarIndice("Selecciona el índice del videojuego a eliminar:", lista.size());
        lista.remove(index);
    }
}
