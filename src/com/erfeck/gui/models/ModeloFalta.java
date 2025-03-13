package com.erfeck.gui.models;

import com.erfeck.base.Asignatura;
import com.erfeck.base.Curso;
import com.erfeck.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ModeloFalta {
    
    private Connection connection;
    
    public ModeloFalta(Connection connection) {
        this.connection = connection;
    }
    
    public List<Curso> getCursos(int idUsuario) {
        List<Curso> listaCursos = new ArrayList<>();
        String sql = "SELECT id, nombre_curso FROM curso "
                + "WHERE id_usuario = ?";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int idCurso = rs.getInt("id");
                String nombreCurso = Util.capitalizarCadaPalabra(rs.getString("nombre_curso"));
                Curso curso = new Curso(idCurso, nombreCurso);
                listaCursos.add(curso);
            }
            System.out.println("Lista de Cursos Cargada con exito");
        } catch (SQLException e) {
            System.out.println("ERROR al cargar Cursos: " + e);
        }
        return listaCursos;
    }
    
    public List<Asignatura> getAsignaturas(int idCurso) {
        List<Asignatura> listaAsignaturas = new ArrayList<>();
        String sql = "SELECT id, nombre_asignatura, faltas_totales FROM asignatura "
                + "WHERE id_curso = ?";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idCurso);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int idAsignatura = rs.getInt("id");
                String nombreAsignatura = Util.capitalizarCadaPalabra(rs.getString("nombre_asignatura"));
                int faltasTotales = rs.getInt("faltas_totales");
                Asignatura asignatura = new Asignatura(idAsignatura, nombreAsignatura, faltasTotales);
                listaAsignaturas.add(asignatura);
            }
            System.out.println("(getAsignaturas) Lista de Asignaturas Cargada con exito");
        } catch (SQLException e) {
            System.out.println("ERROR al cargar asignaturas: " + e);
        }
        return listaAsignaturas;
    }
    
    public void crearCurso(String nuevoNombreCurso, int idUsuario) {
        nuevoNombreCurso = nuevoNombreCurso.toLowerCase();
        String sql = "INSERT INTO curso (nombre_curso, id_usuario) VALUES (?, ?)";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, nuevoNombreCurso);
            pst.setInt(2, idUsuario);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "El curso " + nuevoNombreCurso + " se creo correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR al crear nuevo curso: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR al crear curso");
        }
    }
    
    public void crearAsignatura(int idCurso, String nuevoNombreAsignatura, int faltasAsignaturas) {
        nuevoNombreAsignatura = nuevoNombreAsignatura.toLowerCase();
        String sql = "INSERT INTO asignatura (nombre_asignatura, faltas_totales, id_curso) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, nuevoNombreAsignatura);
            pst.setInt(2, faltasAsignaturas);
            pst.setInt(3, idCurso);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "La asignatura " + nuevoNombreAsignatura + " se creo correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR al crear nueva asignatura: " + e);
            JOptionPane.showMessageDialog(null, "ERROR al crear asignatura");
        }
    }
    
    public void crearFalta(int horasFaltadas, String motivo, String cuentaComoFalta, String fechaFalta, int idAsignatura) {
        String sql = "INSERT INTO falta (horas_faltadas, motivo, cuenta_como_falta, fecha_falta, id_asignatura) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, horasFaltadas);
            pst.setString(2, motivo);
            pst.setString(3, cuentaComoFalta);
            pst.setString(4, fechaFalta);
            pst.setInt(5, idAsignatura);
            pst.executeUpdate();

            System.out.println("La falta fue introducido con exito");
            JOptionPane.showMessageDialog(null, "La falta fue introducido con exito");
        } catch (SQLException e) {
            System.out.println("ERROR al crear falta: " + e);
        }
    }
    
    public void eliminarCurso(int idCurso) {
        String sql = "DELETE FROM curso WHERE id = ?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idCurso);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Curso eliminado");
        } catch (SQLException e) {
            System.out.println("ERROR al eliminar un curso de un usuario: " + e);
        }
    }
    
    public void eliminarUnaAsignatura(int idAsignatura) {
        String sql = "DELETE FROM asignatura WHERE id = ?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idAsignatura);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Asignatura eliminada");
        } catch (SQLException e) {
            System.out.println("ERROR al eliminar una asignatura de un usuario: " + e);
        }
    }
    
    public boolean existeCurso(int idUsuario, String nombreARevisar) {
        nombreARevisar = nombreARevisar.toLowerCase();

        String sql = "SELECT * FROM curso WHERE id_usuario = ? AND nombre_curso = ?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.setString(2, nombreARevisar);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al revisar si existe curso: " + e);
        }
        return false;
    }

    public boolean existeAsignatura(int idCurso, String nuevoNombreAsignatura) {
        nuevoNombreAsignatura = nuevoNombreAsignatura.toLowerCase();
        String sql = "SELECT * FROM asignatura WHERE id_curso = ? AND nombre_asignatura = ?";

        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setInt(1, idCurso);
            pst.setString(2, nuevoNombreAsignatura);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al revisar si existe asignatura: " + e);
        }
        return false;
    }
}
