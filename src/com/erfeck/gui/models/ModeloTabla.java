package com.erfeck.gui.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModeloTabla {

    private Connection connection;

    public ModeloTabla(Connection connection) {
        this.connection = connection;
    }

    public ResultSet listarFaltas(int idUsuario) {
        String sql = "SELECT c.nombre_curso,a.nombre_asignatura,f.horas_faltadas,f.motivo,f.fecha_falta,f.cuenta_como_falta\n"
                + "FROM falta f\n"
                + "JOIN asignatura a ON a.id = f.id_asignatura\n"
                + "JOIN curso c ON c.id = a.id_curso\n"
                + "JOIN usuario u ON u.id = c.id_usuario\n"
                + "WHERE u.id = ?";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println("ERROR al recuperar faltas: " + e);
            JOptionPane.showMessageDialog(null, "Error al recuperar faltas");
        }
        return null;
    }
}
