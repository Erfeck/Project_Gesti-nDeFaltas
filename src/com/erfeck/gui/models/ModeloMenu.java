package com.erfeck.gui.models;

import com.erfeck.base.Usuario;
import com.erfeck.util.Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModeloMenu {

    private Connection connection;

    public ModeloMenu(Connection connection) {
        this.connection = connection;
    }

    public List<Usuario> getUsers() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT id, nombre_usuario FROM usuario ORDER BY id";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id");
                String nombreUsuario = Util.capitalizarCadaPalabra(rs.getString("nombre_usuario"));
                Usuario usuario = new Usuario(idUsuario, nombreUsuario);
                listaUsuarios.add(usuario);
            }
            System.out.println("Lista Desplegable de Usuarios Cargada con exito");
        } catch (SQLException e) {
            System.out.println("ERROR al cargar Usuarios: " + e);
        }
        return listaUsuarios;
    }

    public void agregarUsuario(String nombreUsuario) {
        nombreUsuario = nombreUsuario.toLowerCase();
        String sql = "INSERT INTO usuario (nombre_usuario) values (?)";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nombreUsuario);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario " + nombreUsuario + " se creo correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear el usuario" + e);
            System.out.println("ERROR al crear el usuario: " + e);
        }
    }

    public void cambiarNombreUsuario(int idUsuario, String nuevoNombreUsuario) {
        nuevoNombreUsuario = nuevoNombreUsuario.toLowerCase();
        String sql = "UPDATE usuario "
                + "SET nombre_usuario = ? "
                + "WHERE id = ?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, nuevoNombreUsuario);
            pst.setInt(2, idUsuario);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Nombre de usuario actualizado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al cambiar nombre de usuario: " + e);
        }
    }

    public void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario se borró correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR al borrar usuario: " + e);
        }
    }

    public boolean existeNombre(String nuevoNombreUsuario) {
        nuevoNombreUsuario = nuevoNombreUsuario.toLowerCase();
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ?";
        try {
            PreparedStatement pst = this.connection.prepareStatement(sql);
            pst.setString(1, nuevoNombreUsuario);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar si existe usuario: " + e);
        }
        return false;
    }

    private String leerDatosPrueba() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("datos_prueba.sql"));

        String linea;
        StringBuilder stb = new StringBuilder();

        while ((linea = reader.readLine()) != null) {
            stb.append(linea).append(" ");
        }

        return stb.toString();
    }

    public void cargarDatosPrueba() {
        try {
            String sql = leerDatosPrueba();
            String[] allQuerys = sql.split("--");
            for (String query : allQuerys) {
                PreparedStatement pst = connection.prepareStatement(query);
                pst.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "SE CARGARON TODOS LOS DATOS");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido cargar todos los datos" + e);
            System.out.println("ERROR al cargar todos los datos: " + e);
        } catch (IOException e) {
            System.out.println("Error cargar doble doble: " + e);
        }
    }

    public void borrarTodosLosDatos() {
        String sql = "DELETE FROM usuario";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "SE BORRARON TODOS LOS DATOS");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido borrar todos los datos" + e);
            System.out.println("ERROR al borrar todos los datos: " + e);
        }
    }
}
