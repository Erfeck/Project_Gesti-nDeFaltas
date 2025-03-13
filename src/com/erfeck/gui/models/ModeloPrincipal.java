package com.erfeck.gui.models;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ModeloPrincipal {
    
    private static final String NOMBRE_BASE_DATOS = "gestionFaltas.db";
    private Connection connection;
    
    public void conectar() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + NOMBRE_BASE_DATOS);
            connection.createStatement().execute("PRAGMA foreign_keys = ON;");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
        
    }
    
    private String leerTablas() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("tablas.sql"));

        String linea;
        StringBuilder stb = new StringBuilder();

        while ((linea = reader.readLine()) != null) {
            stb.append(linea).append(" ");
        }

        return stb.toString();
    }

    public void createTablesIfNoExists() {
        try {
            String sql = leerTablas();
            String[] allQuerys = sql.split("--");
            for (String query : allQuerys) {
                PreparedStatement pst = connection.prepareStatement(query);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear la base de datos" + e);
            System.out.println("ERROR al crear base de datos: " + e);
        } catch (IOException e) {
            System.out.println("Error crear BD doble doble: " + e);
        }
    }
    
    public void desconectar() {
        try {
            connection.close();
            System.out.println("Sesion Cerrada");
        } catch (SQLException e) {
            System.out.println("ERROR al cerrar conexion: " + e);
        }
    }
    
    public static boolean isModoOscuro() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
            return Boolean.parseBoolean(properties.getProperty("modoOscuro", "false"));
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de error
            return false; // Retorna false en caso de error
        }
    }

    public Connection getConnection() {
        return connection;
    }
}