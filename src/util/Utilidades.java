package util;

import javax.swing.*;

public class Utilidades {

    public static String solicitarTexto(String mensaje) {
        String entrada;
        do {
            entrada = JOptionPane.showInputDialog(null, mensaje);
        } while (entrada == null || entrada.trim().isEmpty());
        return entrada.trim();
    }

    public static int solicitarPuntuacion(String mensaje) {
        int puntuacion;
        while (true) {
            try {
                puntuacion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                if (puntuacion >= 1 && puntuacion <= 5) return puntuacion;
            } catch (Exception ignored) {}
            JOptionPane.showMessageDialog(null, "Introduce un número válido entre 1 y 5.");
        }
    }

    public static int solicitarIndice(String mensaje, int max) {
        int indice;
        while (true) {
            try {
                indice = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                if (indice >= 0 && indice < max) return indice;
            } catch (Exception ignored) {}
            JOptionPane.showMessageDialog(null, "Introduce un índice válido entre 0 y " + (max - 1));
        }
    }
}
