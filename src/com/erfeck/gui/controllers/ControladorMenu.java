package com.erfeck.gui.controllers;

import com.erfeck.base.Usuario;
import com.erfeck.gui.models.ModeloMenu;
import com.erfeck.gui.views.VistaMenu;
import com.erfeck.util.Util;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorMenu {

    ModeloMenu modeloMenu;
    VistaMenu vistaMenu;

    //Atributo para guardar si el usuario desea utilizar el modo oscuro.
    private boolean estaActivadoModoOscuro;

    //TEMPORAL, SOLO PARA QUE SE CAMBIE EL ICONO DE MODO OSCURO (ESTÉTICA
    private boolean estaIconoModoOscuro;

    public ControladorMenu(ModeloMenu modeloMenu, VistaMenu vistaMenu) {
        this.modeloMenu = modeloMenu;
        this.vistaMenu = vistaMenu;

        estaIconoModoOscuro = false;

        addMenuActionListeners();
        addMenuMouseListeners();
        addWindowClosingListener();

        listarUsuarios();
        //revisarPrimerUsuario();

        //estaActivadoModoOscuro = modelo.isModoOscuro();
        //vistaInicio.activarModoOscuro(estaActivadoModoOscuro);
    }

    public void addKeyListener() {
        vistaMenu.setFocusable(true);
        vistaMenu.requestFocusInWindow();

        vistaMenu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1) {
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "¿Deseas Cargar datos de prueba?",
                            "Datos de prueba",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        modeloMenu.cargarDatosPrueba();
                        listarUsuarios();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_F2) {
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "¿Deseas todos los datos?",
                            "BORRAR DATOS",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        modeloMenu.borrarTodosLosDatos();
                        listarUsuarios();
                    }
                }
            }
        });
    }

    private void addMenuActionListeners() {
        vistaMenu.bInicioModoOscuro.addActionListener(e -> activarModoOscuro());
    }

    private void addMenuMouseListeners() {
        vistaMenu.labelEliminarUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eliminarUsuario();
            }
        });
        vistaMenu.labelCambiarNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cambiarNombre();
            }
        });
        vistaMenu.labelCrearUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crearUsuario();
            }
        });
    }

    private void addWindowClosingListener() {
        vistaMenu.addWindowListener(new WindowAdapter() {
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

    public void activarModoOscuro() {
        Util.noHaceNada();
        //estaActivadoModoOscuro = !estaActivadoModoOscuro;
        //vistaInicio.activarModoOscuro(estaActivadoModoOscuro);

        //TEMPORAL, POR ESTÉTICA
        if (!estaIconoModoOscuro) {
            vistaMenu.bInicioModoOscuro.setIcon(new ImageIcon(getClass().getResource("/com/erfeck/img/luna.png")));
            estaIconoModoOscuro = true;
        } else {
            vistaMenu.bInicioModoOscuro.setIcon(new ImageIcon(getClass().getResource("/com/erfeck/img/sol.png")));
            estaIconoModoOscuro = false;
        }

    }

    public void listarUsuarios() {
        vistaMenu.cbInicioUsuarios.removeAllItems();
        List<Usuario> listaUsuarios = modeloMenu.getUsers();
        for (Usuario unUsuario : listaUsuarios) {
            vistaMenu.cbInicioUsuarios.addItem(unUsuario);
        }
    }

    public void revisarPrimerUsuario() {
        if (vistaMenu.cbInicioUsuarios.getItemCount() > 0) {
            return;
        }
        String nombreUsuario = JOptionPane.showInputDialog("¡Indica el nombre de tu PRIMER USUARIO!");
        while (nombreUsuario == null || nombreUsuario.isEmpty()) {
            nombreUsuario = JOptionPane.showInputDialog("Debes tener mínimo un Usuario");
        }
        modeloMenu.agregarUsuario(nombreUsuario);
    }

    public void eliminarUsuario() {
        //HACER COUNTDOWN PARA ASEGURAR QUE QUIERE BORRAR EL USUARIO.
        Usuario usuarioSeleccionado = (Usuario) vistaMenu.cbInicioUsuarios.getSelectedItem();
        
        if (usuarioSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No tienes usuarios");
            return;
        }
        
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Seguro que desea eliminar el usuario " + usuarioSeleccionado.getNombreUsuario() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            modeloMenu.eliminarUsuario(usuarioSeleccionado.getId());
            listarUsuarios();
            revisarPrimerUsuario();
        }
    }

    public void cambiarNombre() {
        if (vistaMenu.cbInicioUsuarios.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "No tienes usuarios");
            return;
        }
        
        String nuevoNombreUsuario = JOptionPane.showInputDialog("Indica el nuevo nombre del usuario");

        if (nuevoNombreUsuario == null || nuevoNombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cambiar nombre Cancelado");
            return;
        }

        if (modeloMenu.existeNombre(nuevoNombreUsuario)) {
            JOptionPane.showMessageDialog(null, "Ese nombre ya existe. Escribe otro");
            return;
        }

        int indice = vistaMenu.cbInicioUsuarios.getSelectedIndex();
        int idUsuario = ((Usuario) vistaMenu.cbInicioUsuarios.getSelectedItem()).getId();
        modeloMenu.cambiarNombreUsuario(idUsuario, nuevoNombreUsuario);
        listarUsuarios();
        vistaMenu.cbInicioUsuarios.setSelectedIndex(indice);
    }

    public void crearUsuario() {
        String nombreUsuario = vistaMenu.tfCrearUsuario.getText();

        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacío");
            return;
        }

        if (modeloMenu.existeNombre(nombreUsuario)) {
            JOptionPane.showMessageDialog(null, "Ese nombre ya existe. Indica otro");
            return;
        }

        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Seguro que desea crear el usuario " + nombreUsuario + "?",
                "Confirmar creación usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            modeloMenu.agregarUsuario(nombreUsuario);
            listarUsuarios();
            vistaMenu.cbInicioUsuarios.setSelectedIndex(vistaMenu.cbInicioUsuarios.getItemCount() - 1);
            vistaMenu.tfCrearUsuario.setText(null);
        }
    }
}
