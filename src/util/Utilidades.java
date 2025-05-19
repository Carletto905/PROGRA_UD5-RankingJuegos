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
                else throw new Exception("Rango inválido");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entre 1 y 5.");
            }
        }
    }

    public static int solicitarIndice(String mensaje, int max) {
        int indice = -1;
        while (true) {
            try {
                indice = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
                if (indice >= 0 && indice < max) return indice;
                else throw new Exception("Índice fuera de rango");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Introduce un número válido entre 0 y " + (max - 1));
            }
        }
    }
}
