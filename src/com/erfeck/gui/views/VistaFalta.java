package com.erfeck.gui.views;

import com.erfeck.base.Asignatura;
import com.erfeck.base.Curso;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;

public class VistaFalta extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        labelTextoCrearFalta = new javax.swing.JLabel();
        labelCurso = new javax.swing.JLabel();
        cbFaltaCurso = new javax.swing.JComboBox<>();
        bFaltaAgregarCurso = new javax.swing.JButton();
        bFaltaBorrarCurso = new javax.swing.JButton();
        labelAsignatura = new javax.swing.JLabel();
        cbFaltaAsignatura = new javax.swing.JComboBox<>();
        bFaLtaAgregarAsignatura = new javax.swing.JButton();
        bFaltaBorrarAsignatura = new javax.swing.JButton();
        labelHorasFaltadas = new javax.swing.JLabel();
        cbFaltaListaHoras = new javax.swing.JComboBox<>();
        labelMotivoDeLaFalta = new javax.swing.JLabel();
        tfFaltaMotivo = new javax.swing.JTextField();
        labelCuentaComoFalta = new javax.swing.JLabel();
        rbFaltaSiEsFalta = new javax.swing.JRadioButton();
        rbFaltaNoEsFalta = new javax.swing.JRadioButton();
        labelSeleccioneLaFecha = new javax.swing.JLabel();
        bFaltaCrearFalta = new javax.swing.JButton();
        bFaltaVerFaltas = new javax.swing.JButton();
        bFaltaCerrarSesion = new javax.swing.JButton();
        dpFaltaFecha = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de Faltas");
        setIconImage(new ImageIcon(getClass().getResource("/com/erfeck/img/Estudiante 200px.png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(900, 645));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        background.setPreferredSize(new java.awt.Dimension(900, 645));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LeftPanel.setBackground(new java.awt.Color(102, 153, 255));
        LeftPanel.setLayout(null);
        background.add(LeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 630));

        labelTextoCrearFalta.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        labelTextoCrearFalta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/TextoCrearFalta.png"))); // NOI18N
        background.add(labelTextoCrearFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 270, 58));

        labelCurso.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        labelCurso.setForeground(new java.awt.Color(0, 0, 0));
        labelCurso.setText("Curso:");
        background.add(labelCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, 20));

        cbFaltaCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        background.add(cbFaltaCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 180, 40));

        bFaltaAgregarCurso.setText("+");
        background.add(bFaltaAgregarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 40, 40));

        bFaltaBorrarCurso.setText("-");
        background.add(bFaltaBorrarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 40, 40));

        labelAsignatura.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        labelAsignatura.setForeground(new java.awt.Color(0, 0, 0));
        labelAsignatura.setText("Asignatura:");
        background.add(labelAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 90, 20));
        background.add(cbFaltaAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 180, 40));

        bFaLtaAgregarAsignatura.setText("+");
        background.add(bFaLtaAgregarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 40, 40));

        bFaltaBorrarAsignatura.setText("-");
        background.add(bFaltaBorrarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 40, 40));

        labelHorasFaltadas.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        labelHorasFaltadas.setForeground(new java.awt.Color(0, 0, 0));
        labelHorasFaltadas.setText("Horas faltadas:");
        background.add(labelHorasFaltadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        cbFaltaListaHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        background.add(cbFaltaListaHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 280, 40));

        labelMotivoDeLaFalta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        labelMotivoDeLaFalta.setForeground(new java.awt.Color(0, 0, 0));
        labelMotivoDeLaFalta.setText("Motivo de la falta:");
        background.add(labelMotivoDeLaFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));
        background.add(tfFaltaMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 280, 40));

        labelCuentaComoFalta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        labelCuentaComoFalta.setForeground(new java.awt.Color(0, 0, 0));
        labelCuentaComoFalta.setText("Cuenta como falta:");
        background.add(labelCuentaComoFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, 20));

        rbFaltaSiEsFalta.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup.add(rbFaltaSiEsFalta);
        rbFaltaSiEsFalta.setText("Si");
        background.add(rbFaltaSiEsFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        rbFaltaNoEsFalta.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup.add(rbFaltaNoEsFalta);
        rbFaltaNoEsFalta.setText("No");
        background.add(rbFaltaNoEsFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, -1, -1));

        labelSeleccioneLaFecha.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        labelSeleccioneLaFecha.setForeground(new java.awt.Color(0, 0, 0));
        labelSeleccioneLaFecha.setText("Seleccione la fecha:");
        background.add(labelSeleccioneLaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 150, 30));

        bFaltaCrearFalta.setText("Crear falta");
        background.add(bFaltaCrearFalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 120, 40));

        bFaltaVerFaltas.setText("Ver faltas");
        background.add(bFaltaVerFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 120, 40));

        bFaltaCerrarSesion.setText("Cerrar Sesión");
        background.add(bFaltaCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 120, 40));
        background.add(dpFaltaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 465, 280, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    public javax.swing.JButton bFaLtaAgregarAsignatura;
    public javax.swing.JButton bFaltaAgregarCurso;
    public javax.swing.JButton bFaltaBorrarAsignatura;
    public javax.swing.JButton bFaltaBorrarCurso;
    public javax.swing.JButton bFaltaCerrarSesion;
    public javax.swing.JButton bFaltaCrearFalta;
    public javax.swing.JButton bFaltaVerFaltas;
    private javax.swing.JPanel background;
    private javax.swing.ButtonGroup buttonGroup;
    public javax.swing.JComboBox<Asignatura> cbFaltaAsignatura;
    public javax.swing.JComboBox<Curso> cbFaltaCurso;
    public javax.swing.JComboBox<String> cbFaltaListaHoras;
    public com.github.lgooddatepicker.components.DatePicker dpFaltaFecha;
    private javax.swing.JLabel labelAsignatura;
    private javax.swing.JLabel labelCuentaComoFalta;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelHorasFaltadas;
    private javax.swing.JLabel labelMotivoDeLaFalta;
    private javax.swing.JLabel labelSeleccioneLaFecha;
    private javax.swing.JLabel labelTextoCrearFalta;
    public javax.swing.JRadioButton rbFaltaNoEsFalta;
    public javax.swing.JRadioButton rbFaltaSiEsFalta;
    public javax.swing.JTextField tfFaltaMotivo;
    // End of variables declaration//GEN-END:variables

    //Atributo para guardar si el usuario desea utilizar el modo oscuro.
    private boolean estaActivadoModoOscuro;

    //Constructor
    public VistaFalta() {
        initComponents();
        this.rbFaltaSiEsFalta.setSelected(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    // Icono del JFrame:
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/IconoGF 200px.png"));
        return retValue;
    }

    void actualizarModoOscuro(boolean estaActivadoModoOscuro) {
        if (estaActivadoModoOscuro) {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                this.cbFaltaCurso.setForeground(Color.white);
                this.cbFaltaAsignatura.setForeground(Color.white);
                this.cbFaltaListaHoras.setForeground(Color.white);
                SwingUtilities.updateComponentTreeUI(this);
                
                this.background.setBackground(new Color(102, 102, 102));
                this.rbFaltaSiEsFalta.setBackground(new Color(102, 102, 102));
                this.rbFaltaNoEsFalta.setBackground(new Color(102, 102, 102));

                this.labelCurso.setForeground(new Color(204, 204, 204));
                this.labelAsignatura.setForeground(new Color(204, 204, 204));
                this.labelHorasFaltadas.setForeground(new Color(204, 204, 204));
                this.labelMotivoDeLaFalta.setForeground(new Color(204, 204, 204));
                this.labelCuentaComoFalta.setForeground(new Color(204, 204, 204));
                this.labelSeleccioneLaFecha.setForeground(new Color(204, 204, 204));

                cambiarColorLetras(Color.white);
                this.estaActivadoModoOscuro = true;
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Error aplicando el tema dark faltas" + e);
            }
        } else {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                this.cbFaltaCurso.setForeground(Color.black);
                this.cbFaltaAsignatura.setForeground(Color.black);
                this.cbFaltaListaHoras.setForeground(Color.black);
                SwingUtilities.updateComponentTreeUI(this);
                
                this.background.setBackground(Color.white);
                this.rbFaltaSiEsFalta.setBackground(Color.white);
                this.rbFaltaNoEsFalta.setBackground(Color.white);

                this.labelCurso.setForeground(Color.black);
                this.labelAsignatura.setForeground(Color.black);
                this.labelHorasFaltadas.setForeground(Color.black);
                this.labelMotivoDeLaFalta.setForeground(Color.black);
                this.labelCuentaComoFalta.setForeground(Color.black);
                this.labelSeleccioneLaFecha.setForeground(Color.black);

                cambiarColorLetras(Color.black);
                this.estaActivadoModoOscuro = false;
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Error aplicando el tema light faltas" + e);
            }
        }
    }
    
    private void cambiarColorLetras(Color unColor) {
        //this.listaCursos.setForeground(unColor);
        this.bFaltaAgregarCurso.setForeground(unColor);
        this.bFaltaBorrarCurso.setForeground(unColor);
        //this.listaAsignatura.setForeground(unColor);
        this.bFaLtaAgregarAsignatura.setForeground(unColor);
        this.bFaltaBorrarAsignatura.setForeground(unColor);
        //this.listaHoras.setForeground(unColor);
        this.tfFaltaMotivo.setForeground(unColor);
        this.rbFaltaSiEsFalta.setForeground(unColor);
        this.rbFaltaNoEsFalta.setForeground(unColor);
        // //this.logoConsultas.setForeground(unColor);
        // //this.logoFaltas.setForeground(unColor);
    }
}