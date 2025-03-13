package com.erfeck.gui.views;

import com.erfeck.base.Usuario;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class VistaMenu extends javax.swing.JFrame {
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        bInicioModoOscuro = new javax.swing.JButton();
        inicioSesion = new javax.swing.JLabel();
        seleccionUsuario = new javax.swing.JLabel();
        cbInicioUsuarios = new javax.swing.JComboBox<>();
        prIniciarSesion = new com.erfeck.modelpanel.PanelRound();
        labellniciarSesion = new javax.swing.JLabel();
        prEliminarUsuario = new com.erfeck.modelpanel.PanelRound();
        labelEliminarUsuario = new javax.swing.JLabel();
        prCambiarNombre = new com.erfeck.modelpanel.PanelRound();
        labelCambiarNombre = new javax.swing.JLabel();
        IntroduceNombre = new javax.swing.JLabel();
        tfCrearUsuario = new javax.swing.JTextField();
        prCrearUsuario = new com.erfeck.modelpanel.PanelRound();
        labelCrearUsuario = new javax.swing.JLabel();
        logoEstudiante = new javax.swing.JLabel();
        labelGestionFaltas = new javax.swing.JLabel();
        labelCreadoPor = new javax.swing.JLabel();
        labelVersion = new javax.swing.JLabel();
        backgroundSide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Faltas");
        setIconImage(new ImageIcon(getClass().getResource("/com/erfeck/img/Estudiante 200px.png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(900, 645));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bInicioModoOscuro.setBackground(new java.awt.Color(102, 153, 255));
        bInicioModoOscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/luna.png"))); // NOI18N
        background.add(bInicioModoOscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        inicioSesion.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        inicioSesion.setForeground(new java.awt.Color(0, 0, 0));
        inicioSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/LogoGF 80px.png"))); // NOI18N
        inicioSesion.setText("INICIO DE SESIÓN");
        background.add(inicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 410, -1));

        seleccionUsuario.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        seleccionUsuario.setForeground(new java.awt.Color(0, 0, 0));
        seleccionUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seleccionUsuario.setText("SELECCIONE UN USUARIO:");
        background.add(seleccionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 230, -1));
        background.add(cbInicioUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 300, 40));

        prIniciarSesion.setBackground(new java.awt.Color(102, 153, 255));
        prIniciarSesion.setRoundBottomLeft(10);
        prIniciarSesion.setRoundBottomRight(10);
        prIniciarSesion.setRoundTopLeft(10);
        prIniciarSesion.setRoundTopRight(10);

        labellniciarSesion.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        labellniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        labellniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labellniciarSesion.setText("Iniciar Sesión");
        labellniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labellniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labellniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labellniciarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout prIniciarSesionLayout = new javax.swing.GroupLayout(prIniciarSesion);
        prIniciarSesion.setLayout(prIniciarSesionLayout);
        prIniciarSesionLayout.setHorizontalGroup(
            prIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labellniciarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        prIniciarSesionLayout.setVerticalGroup(
            prIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labellniciarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(prIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 120, 40));

        prEliminarUsuario.setBackground(new java.awt.Color(102, 153, 255));
        prEliminarUsuario.setRoundBottomLeft(10);
        prEliminarUsuario.setRoundBottomRight(10);
        prEliminarUsuario.setRoundTopLeft(10);
        prEliminarUsuario.setRoundTopRight(10);

        labelEliminarUsuario.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        labelEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelEliminarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEliminarUsuario.setText("Eliminar Usuario");
        labelEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelEliminarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelEliminarUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout prEliminarUsuarioLayout = new javax.swing.GroupLayout(prEliminarUsuario);
        prEliminarUsuario.setLayout(prEliminarUsuarioLayout);
        prEliminarUsuarioLayout.setHorizontalGroup(
            prEliminarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        prEliminarUsuarioLayout.setVerticalGroup(
            prEliminarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(prEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 120, 40));

        prCambiarNombre.setBackground(new java.awt.Color(102, 153, 255));
        prCambiarNombre.setRoundBottomLeft(10);
        prCambiarNombre.setRoundBottomRight(10);
        prCambiarNombre.setRoundTopLeft(10);
        prCambiarNombre.setRoundTopRight(10);

        labelCambiarNombre.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        labelCambiarNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelCambiarNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCambiarNombre.setText("Cambiar Nombre");
        labelCambiarNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelCambiarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCambiarNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCambiarNombreMouseExited(evt);
            }
        });

        javax.swing.GroupLayout prCambiarNombreLayout = new javax.swing.GroupLayout(prCambiarNombre);
        prCambiarNombre.setLayout(prCambiarNombreLayout);
        prCambiarNombreLayout.setHorizontalGroup(
            prCambiarNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCambiarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        prCambiarNombreLayout.setVerticalGroup(
            prCambiarNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCambiarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        background.add(prCambiarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 120, 40));

        IntroduceNombre.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        IntroduceNombre.setForeground(new java.awt.Color(0, 0, 0));
        IntroduceNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntroduceNombre.setText("INTRODUCE TU NOMBRE:");
        background.add(IntroduceNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 220, -1));
        background.add(tfCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 300, 40));

        prCrearUsuario.setBackground(new java.awt.Color(102, 153, 255));
        prCrearUsuario.setRoundBottomLeft(10);
        prCrearUsuario.setRoundBottomRight(10);
        prCrearUsuario.setRoundTopLeft(10);
        prCrearUsuario.setRoundTopRight(10);

        labelCrearUsuario.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        labelCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelCrearUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrearUsuario.setText("Crear Usuario");
        labelCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelCrearUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelCrearUsuarioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout prCrearUsuarioLayout = new javax.swing.GroupLayout(prCrearUsuario);
        prCrearUsuario.setLayout(prCrearUsuarioLayout);
        prCrearUsuarioLayout.setHorizontalGroup(
            prCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prCrearUsuarioLayout.createSequentialGroup()
                .addComponent(labelCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        prCrearUsuarioLayout.setVerticalGroup(
            prCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prCrearUsuarioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        background.add(prCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 120, 40));

        logoEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/Estudiante 200px.png"))); // NOI18N
        background.add(logoEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 380, -1));

        labelGestionFaltas.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        labelGestionFaltas.setForeground(new java.awt.Color(255, 255, 255));
        labelGestionFaltas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGestionFaltas.setText("Gestión de Faltas");
        background.add(labelGestionFaltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 380, 40));

        labelCreadoPor.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        labelCreadoPor.setForeground(new java.awt.Color(255, 255, 255));
        labelCreadoPor.setText("Created by ErFeck");
        background.add(labelCreadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 590, 170, 30));

        labelVersion.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        labelVersion.setForeground(new java.awt.Color(255, 255, 255));
        labelVersion.setText("Versión: Beta 1.0");
        background.add(labelVersion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 590, 130, 30));

        backgroundSide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/BackgroundSide.jpg"))); // NOI18N
        backgroundSide.setText("jLabel1");
        background.add(backgroundSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 380, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelEliminarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEliminarUsuarioMouseEntered
        this.prEliminarUsuario.setBackground(new Color(40, 112, 255));
    }//GEN-LAST:event_labelEliminarUsuarioMouseEntered

    private void labelEliminarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEliminarUsuarioMouseExited
        this.prEliminarUsuario.setBackground(new Color(102, 153, 255));
    }//GEN-LAST:event_labelEliminarUsuarioMouseExited

    private void labelCambiarNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCambiarNombreMouseEntered
        this.prCambiarNombre.setBackground(new Color(40, 112, 255));
    }//GEN-LAST:event_labelCambiarNombreMouseEntered

    private void labelCambiarNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCambiarNombreMouseExited
        this.prCambiarNombre.setBackground(new Color(102, 153, 255));
    }//GEN-LAST:event_labelCambiarNombreMouseExited

    private void labellniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellniciarSesionMouseEntered
        this.prIniciarSesion.setBackground(new Color(40, 112, 255));
    }//GEN-LAST:event_labellniciarSesionMouseEntered

    private void labellniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labellniciarSesionMouseExited
        this.prIniciarSesion.setBackground(new Color(102, 153, 255));
    }//GEN-LAST:event_labellniciarSesionMouseExited

    private void labelCrearUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearUsuarioMouseEntered
        this.prCrearUsuario.setBackground(new Color(40, 112, 255));
    }//GEN-LAST:event_labelCrearUsuarioMouseEntered

    private void labelCrearUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearUsuarioMouseExited
        this.prCrearUsuario.setBackground(new Color(102, 153, 255));
    }//GEN-LAST:event_labelCrearUsuarioMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IntroduceNombre;
    public javax.swing.JButton bInicioModoOscuro;
    private javax.swing.JPanel background;
    private javax.swing.JLabel backgroundSide;
    public javax.swing.JComboBox<Usuario> cbInicioUsuarios;
    private javax.swing.JLabel inicioSesion;
    public javax.swing.JLabel labelCambiarNombre;
    private javax.swing.JLabel labelCreadoPor;
    public javax.swing.JLabel labelCrearUsuario;
    public javax.swing.JLabel labelEliminarUsuario;
    private javax.swing.JLabel labelGestionFaltas;
    private javax.swing.JLabel labelVersion;
    public javax.swing.JLabel labellniciarSesion;
    private javax.swing.JLabel logoEstudiante;
    private com.erfeck.modelpanel.PanelRound prCambiarNombre;
    private com.erfeck.modelpanel.PanelRound prCrearUsuario;
    private com.erfeck.modelpanel.PanelRound prEliminarUsuario;
    private com.erfeck.modelpanel.PanelRound prIniciarSesion;
    private javax.swing.JLabel seleccionUsuario;
    public javax.swing.JTextField tfCrearUsuario;
    // End of variables declaration//GEN-END:variables

    //Constructor
    public VistaMenu() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    // Icono del JFrame:
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("/com/erfeck/img/Estudiante 30px.png"));
        return retValue;
    }
    
    public void activarModoOscuro(boolean activar) {
        if (activar) {
            this.cbInicioUsuarios.setForeground(Color.white);

            this.background.setBackground(new Color(102, 102, 102));
            this.inicioSesion.setForeground(new Color(221,221,221));
            this.seleccionUsuario.setForeground(new Color(221,221,221));
            this.IntroduceNombre.setForeground(new Color(221,221,221));

            this.tfCrearUsuario.setForeground(Color.white);
            this.labelGestionFaltas.setForeground(Color.black);
            this.labelCreadoPor.setForeground(Color.black);
            this.labelVersion.setForeground(Color.black);

            bInicioModoOscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/icons8-sol-30.png")));
            FlatDarkLaf.setup();
            SwingUtilities.updateComponentTreeUI(this);
        } else {
            this.cbInicioUsuarios.setForeground(Color.black);

            this.background.setBackground(new Color(255,255,255));
            this.inicioSesion.setForeground(Color.black);
            this.seleccionUsuario.setForeground(Color.black);
            this.IntroduceNombre.setForeground(Color.black);

            this.tfCrearUsuario.setForeground(Color.black);
            this.labelGestionFaltas.setForeground(Color.white);
            this.labelCreadoPor.setForeground(Color.white);
            this.labelVersion.setForeground(Color.white);
            
            bInicioModoOscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/erfeck/img/icons8-satélite-luna-30.png")));
            FlatLightLaf.setup();
            SwingUtilities.updateComponentTreeUI(this);
        }
    }
}