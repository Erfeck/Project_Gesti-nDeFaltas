package com.erfeck.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Util {
    
    public static void noHaceNada() {
        JOptionPane.showMessageDialog(null, "No hace nada. Se agregará funcionalidad más adelante");
    }
    
    public static String capitalizarCadaPalabra(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return cadena;
        }
        String[] cadenaCompleta = cadena.split(" ");
        StringBuilder cadenaActualizada = new StringBuilder();

        for (String unaPalabra : cadenaCompleta) {
            if (!unaPalabra.isEmpty()) {
                cadenaActualizada.append(unaPalabra.substring(0, 1).toUpperCase())
                        .append(unaPalabra.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return cadenaActualizada.toString().trim();
    }
    
    public static void showErrorAlert(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarningAlert(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Aviso", JOptionPane.WARNING_MESSAGE);
    }

    public static void showInfoAlert(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static String formatearFecha(LocalDate fecha) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formateador.format(fecha);
    }

    public static LocalDate parsearFecha(String fecha){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(fecha, formateador);
    }
}
