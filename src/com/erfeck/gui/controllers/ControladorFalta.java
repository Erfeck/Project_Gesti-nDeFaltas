package com.erfeck.gui.controllers;

import com.erfeck.base.Asignatura;
import com.erfeck.base.Curso;
import com.erfeck.gui.models.ModeloFalta;
import com.erfeck.gui.views.VistaFalta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.List;
import com.erfeck.util.Util;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorFalta {
    
    ModeloFalta modeloFalta;
    VistaFalta vistaFalta;
    
    boolean seEstaCreandoCurso;
    boolean seEstaBorrandoCurso;

    public ControladorFalta(ModeloFalta modeloFalta, VistaFalta vistaFalta) {
        this.modeloFalta = modeloFalta;
        this.vistaFalta = vistaFalta;
        this.seEstaCreandoCurso = false;
        this.seEstaBorrandoCurso = false;
        
        addWindowClosingListener();
        //Método para agregar ItemStateChanged de cbFaltaCursos
        addItemStateChanged();
        
        listarCursos();
    }
    
    private void addWindowClosingListener() {
        vistaFalta.addWindowListener(new WindowAdapter() {
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
    
    private void addItemStateChanged() {
        vistaFalta.cbFaltaCurso.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!seEstaCreandoCurso && !seEstaBorrandoCurso) {
                    listarAsignaturas();
                    System.out.println("Desde el itemstateChanged");
                }
            }
        });
    }
    
    public void listarCursos() {
        vistaFalta.cbFaltaCurso.removeAllItems();
        List<Curso> listaCursos = modeloFalta.getCursos(ControladorPrincipal.ID_USUARIO);
        for (Curso unCurso: listaCursos) {
            vistaFalta.cbFaltaCurso.addItem(unCurso);
        }
    }
    
    public void listarAsignaturas() {
        vistaFalta.cbFaltaAsignatura.removeAllItems();
        if (vistaFalta.cbFaltaCurso.getItemCount() == 0) {
            return;
        }
        Curso cursoSeleccionado = (Curso) vistaFalta.cbFaltaCurso.getSelectedItem();
        List<Asignatura> listaAsignaturas = modeloFalta.getAsignaturas(cursoSeleccionado.getIdCurso());
        for (Asignatura unaAsignatura: listaAsignaturas) {
            vistaFalta.cbFaltaAsignatura.addItem(unaAsignatura);
        }
    }
    
    public void agregarCurso() {
        String nuevoNombreCurso = JOptionPane.showInputDialog("Indica el nombre del Curso:");

        if (nuevoNombreCurso == null) {
            JOptionPane.showMessageDialog(null, "Crear Curso cancelado");
            return;
        } 
        if (nuevoNombreCurso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacío");
            return;
        }
        if (modeloFalta.existeCurso(ControladorPrincipal.ID_USUARIO, nuevoNombreCurso)) {
            JOptionPane.showMessageDialog(null, "Ese nombre ya existe. Indica otro");
            return;
        }

        this.seEstaCreandoCurso = true;
        modeloFalta.crearCurso(nuevoNombreCurso, ControladorPrincipal.ID_USUARIO);
        listarCursos();
        vistaFalta.cbFaltaCurso.setSelectedIndex(vistaFalta.cbFaltaCurso.getItemCount() - 1);
        vistaFalta.cbFaltaAsignatura.removeAllItems();
        this.seEstaCreandoCurso = false;
    }
    
    public void agregarAsignatura() {
        String nuevoNombreAsignatura = JOptionPane.showInputDialog("Indica el nombre de la Asignatura:");

        if (nuevoNombreAsignatura == null) {
            JOptionPane.showMessageDialog(null, "Crear Asignatura cancelado");
            return;
        }
        if (nuevoNombreAsignatura.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacío");
            return;
        }
        int idCursoSeleccionado = ((Curso) vistaFalta.cbFaltaCurso.getSelectedItem()).getIdCurso();
        if (modeloFalta.existeAsignatura(idCursoSeleccionado, nuevoNombreAsignatura)) {
            JOptionPane.showMessageDialog(null, "Ese nombre ya existe. Indica otro");
            return;
        }

        //FALTAS TOTALES: DE MOMENTO NO ESTÁ DISPONIBLE, PERO DEBE SER OPCIONAL
        //DEBE APARECER UN PANEL PREGUNTADO LAS FALTAS
        //COMO MÉTODO IDEAL DEBERÍA AYUDAR AL USUARIO A CALCULAR SUS FALTAS SI NO LAS SABE
        modeloFalta.crearAsignatura(idCursoSeleccionado, nuevoNombreAsignatura, -1);
        listarAsignaturas();
        vistaFalta.cbFaltaAsignatura.setSelectedIndex(vistaFalta.cbFaltaAsignatura.getItemCount() - 1);
    }
    
    public void borrarCurso() {
        Curso cursoSeleccionado = (Curso) vistaFalta.cbFaltaCurso.getSelectedItem();
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Seguro que quieres eliminar el curso " + cursoSeleccionado.getNombreCurso() + "?",
                "Eliminar Curso",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            this.seEstaBorrandoCurso = true;
            modeloFalta.eliminarCurso(cursoSeleccionado.getIdCurso());
            listarCursos();
            this.seEstaBorrandoCurso = false;
            listarAsignaturas();
        }
    }
    
    public void borrarAsignatura() {
        Asignatura asignaturaSeleccionada = (Asignatura) vistaFalta.cbFaltaAsignatura.getSelectedItem();
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Seguro que quieres eliminar la asignatura " + asignaturaSeleccionada.getNombreAsignatura() + "?",
                "Eliminar Asignatura",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            modeloFalta.eliminarUnaAsignatura(asignaturaSeleccionada.getIdAsignatura());
            listarAsignaturas();
        }
    }
    
    public void crearFalta() {
        if (vistaFalta.cbFaltaCurso.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear la falta porque no tienes cursos");
            return;
        }
        if (vistaFalta.cbFaltaAsignatura.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "No se ha podido crear la falta porque no tienes asignaturas");
            return;
        }
        
        String textoHorasFaltadas = String.valueOf(vistaFalta.cbFaltaListaHoras.getSelectedItem());
        int horasFaltadas = Integer.parseInt(textoHorasFaltadas);

        String motivo = vistaFalta.tfFaltaMotivo.getText();
        if (motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduce un motivo antes");
            return;
        }

        String cuentaComoFalta = "si";
        if (vistaFalta.rbFaltaNoEsFalta.isSelected()) {
            cuentaComoFalta = "no";
        }

        if (vistaFalta.dpFaltaFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Introduce una fecha en el calendario");
            return;
        }
        LocalDate fechaFalta = vistaFalta.dpFaltaFecha.getDate();
        String fechaFormateada = Util.formatearFecha(fechaFalta);
        
        int idAsignatura = ((Asignatura) vistaFalta.cbFaltaAsignatura.getSelectedItem()).getIdAsignatura();
        modeloFalta.crearFalta(horasFaltadas, motivo, cuentaComoFalta, fechaFormateada, idAsignatura);
        
        
        vistaFalta.cbFaltaListaHoras.setSelectedIndex(0);
        vistaFalta.tfFaltaMotivo.setText(null);
        vistaFalta.rbFaltaSiEsFalta.setSelected(true);
        vistaFalta.dpFaltaFecha.setDate(null);
    }
    
    private boolean validarNumero(String numeroAValidar) {
        int posibleNumero;

        try {
            posibleNumero = Integer.parseInt(numeroAValidar);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error al validar string a número: " + e);
        }
        return false;
    }
}