package com.erfeck.gui.controllers;

import com.erfeck.gui.models.ModeloTabla;
import com.erfeck.gui.views.VistaTabla;
import com.erfeck.util.Util;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorTabla {

    ModeloTabla modeloTabla;
    VistaTabla vistaTabla;

    public ControladorTabla(ModeloTabla modeloTabla, VistaTabla vistaTabla) {
        this.modeloTabla = modeloTabla;
        this.vistaTabla = vistaTabla;
        
        addWindowClosingListener();
    }
    
    private void addWindowClosingListener() {
        vistaTabla.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcionParaSalir = JOptionPane.showConfirmDialog(
                        null,
                        "¿Seguro que quieres salir?",
                        "Salir App",
                        JOptionPane.YES_NO_OPTION);

                if (opcionParaSalir == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    
    public void addKeyListener() {
        vistaTabla.setFocusable(true);
        vistaTabla.requestFocusInWindow();
        
        vistaTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    vistaTabla.setTextSizeLabels();
                    vistaTabla.colorSecretLabelSizeTable(Color.BLACK);
                }
            }
        });
    }

    public void listarFaltas() {
        try {
            ResultSet rs = modeloTabla.listarFaltas(ControladorPrincipal.ID_USUARIO);
            Object[] falta = new Object[6];
            vistaTabla.dtmFaltas = (DefaultTableModel) vistaTabla.tablaFaltas.getModel();
            vistaTabla.dtmFaltas.setRowCount(0);
            while (rs.next()) {
                falta[0] = Util.capitalizarCadaPalabra(rs.getString("nombre_curso"));
                falta[1] = Util.capitalizarCadaPalabra(rs.getString("nombre_asignatura"));
                falta[2] = rs.getInt("horas_faltadas");
                falta[3] = rs.getString("motivo");
                falta[4] = rs.getString("fecha_falta");
                falta[5] = rs.getString("cuenta_como_falta");
                vistaTabla.dtmFaltas.addRow(falta);
            }
        } catch (SQLException e) {
            System.out.println("ERROR al listar faltas: " + e);
            JOptionPane.showMessageDialog(null, "Error al listar faltas");
        }
    }
}