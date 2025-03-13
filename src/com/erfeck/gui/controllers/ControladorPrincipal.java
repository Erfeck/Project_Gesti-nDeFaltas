package com.erfeck.gui.controllers;

import com.erfeck.base.Usuario;
import com.erfeck.gui.models.ModeloMenu;
import com.erfeck.gui.views.VistaMenu;
import com.erfeck.gui.models.ModeloFalta;
import com.erfeck.gui.models.ModeloPrincipal;
import com.erfeck.gui.models.ModeloTabla;
import com.erfeck.gui.views.VistaFalta;
import com.erfeck.gui.views.VistaTabla;
import com.erfeck.util.Util;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControladorPrincipal implements ActionListener {

    public static int ID_USUARIO;

    ControladorMenu controladorMenu;
    ControladorFalta controladorFalta;
    ControladorTabla controladorTabla;

    ModeloPrincipal modeloPrincipal;
    ModeloMenu modeloMenu;
    ModeloFalta modeloFalta;
    ModeloTabla modeloTabla;

    VistaMenu vistaMenu;
    VistaFalta vistaFalta;
    VistaTabla vistaTabla;

    boolean seCargoPrimeroFaltas;
    boolean seCargoPrimeroTabla;

    public ControladorPrincipal(ModeloPrincipal modeloPrincipal) {
        this.modeloPrincipal = modeloPrincipal;

        seCargoPrimeroFaltas = false;
        seCargoPrimeroTabla = false;

        modeloPrincipal.conectar();
        modeloPrincipal.createTablesIfNoExists();
        
        modeloMenu = new ModeloMenu(modeloPrincipal.getConnection());
        vistaMenu = new VistaMenu();
        controladorMenu = new ControladorMenu(modeloMenu, vistaMenu);

        addMenuMouseListeners();
        controladorMenu.addKeyListener();
    }

    private void addMenuMouseListeners() {
        vistaMenu.labellniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vistaMenu.cbInicioUsuarios.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "No tienes usuarios");
                    return;
                }
                
                ID_USUARIO = ((Usuario) vistaMenu.cbInicioUsuarios.getSelectedItem()).getId();

                if (!seCargoPrimeroFaltas) {
                    modeloFalta = new ModeloFalta(modeloPrincipal.getConnection());
                    vistaFalta = new VistaFalta();
                    controladorFalta = new ControladorFalta(modeloFalta, vistaFalta);
                    seCargoPrimeroFaltas = true;
                }

                addFaltaActionListeners();

                controladorFalta.listarCursos();

                JOptionPane.showMessageDialog(null, "ID Usuario: " + ID_USUARIO);
                int xLocation = vistaMenu.getLocation().x;
                int yLocation = vistaMenu.getLocation().y;
                vistaFalta.setLocation(xLocation, yLocation);
                vistaFalta.setVisible(true);
                vistaMenu.dispose();
            }
        });
    }

    private void addFaltaActionListeners() {
        vistaFalta.bFaltaCrearFalta.addActionListener(e -> controladorFalta.crearFalta());
        vistaFalta.bFaltaVerFaltas.addActionListener(e -> irATabla());
        vistaFalta.bFaltaCerrarSesion.addActionListener(e -> volverAMenu());

        vistaFalta.bFaltaAgregarCurso.addActionListener(e -> controladorFalta.agregarCurso());
        vistaFalta.bFaLtaAgregarAsignatura.addActionListener(e -> controladorFalta.agregarAsignatura());

        vistaFalta.bFaltaBorrarCurso.addActionListener(e -> controladorFalta.borrarCurso());
        vistaFalta.bFaltaBorrarAsignatura.addActionListener(e -> controladorFalta.borrarAsignatura());
    }

    private void addTablaActionListeners() {
        vistaTabla.bTablaEditar.addActionListener(e -> Util.noHaceNada());
        vistaTabla.bTablaEliminar.addActionListener(e -> Util.noHaceNada());
        vistaTabla.bTablaVolver.addActionListener(e -> volverACrearFaltas());
    }

    private void volverAMenu() {
        vistaMenu.setVisible(true);
        vistaFalta.dispose();
    }

    private void volverACrearFaltas() {
        vistaFalta.setVisible(true);
        vistaTabla.dispose();
    }

    private void irATabla() {
        if (!seCargoPrimeroTabla) {
            modeloTabla = new ModeloTabla(modeloPrincipal.getConnection());
            vistaTabla = new VistaTabla();
            controladorTabla = new ControladorTabla(modeloTabla, vistaTabla);
            seCargoPrimeroTabla = true;
        }

        addTablaActionListeners();
        controladorTabla.addKeyListener(); //TEMPORAL

        controladorFalta.listarCursos();
        controladorTabla.listarFaltas();
        vistaTabla.ajustarAnchoColumnas();
        vistaTabla.ajustarAnchoColumnaExtra();
        vistaTabla.colorSecretLabelSizeTable(Color.white); //TEMPORAL

        JOptionPane.showMessageDialog(null, "ID Usuario: " + ID_USUARIO);
        int xLocation = vistaFalta.getLocation().x;
        int yLocation = vistaFalta.getLocation().y;
        vistaTabla.setLocation(xLocation - 50, yLocation + 30);
        vistaTabla.setVisible(true);
        vistaFalta.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
