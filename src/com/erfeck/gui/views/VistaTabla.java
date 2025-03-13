package com.erfeck.gui.views;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;

public class VistaTabla extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        tablaScrollPane = new javax.swing.JScrollPane();
        tablaFaltas = new javax.swing.JTable();
        labelCurso = new javax.swing.JLabel();
        labelAsignatura = new javax.swing.JLabel();
        labelHoras = new javax.swing.JLabel();
        labelMotivo = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelCuenta = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        bTablaEditar = new javax.swing.JButton();
        bTablaEliminar = new javax.swing.JButton();
        bTablaVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gestión de Faltas");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/com/erfeck/img/Estudiante 200px.png")).getImage());
        setResizable(false);
        setSize(new java.awt.Dimension(930, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaFaltas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Asignatura", "Horas", "Motivo", "Fecha", "¿Cuenta?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFaltas.setColumnSelectionAllowed(true);
        tablaScrollPane.setViewportView(tablaFaltas);
        tablaFaltas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tablaFaltas.getColumnModel().getColumnCount() > 0) {
            tablaFaltas.getColumnModel().getColumn(0).setResizable(false);
            tablaFaltas.getColumnModel().getColumn(1).setResizable(false);
            tablaFaltas.getColumnModel().getColumn(2).setResizable(false);
            tablaFaltas.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaFaltas.getColumnModel().getColumn(3).setResizable(false);
            tablaFaltas.getColumnModel().getColumn(4).setResizable(false);
            tablaFaltas.getColumnModel().getColumn(4).setPreferredWidth(90);
            tablaFaltas.getColumnModel().getColumn(5).setResizable(false);
            tablaFaltas.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        background.add(tablaScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 900, 420));

        labelCurso.setForeground(new java.awt.Color(0, 0, 0));
        labelCurso.setText("jLabel1");
        background.add(labelCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        labelAsignatura.setForeground(new java.awt.Color(0, 0, 0));
        labelAsignatura.setText("jLabel1");
        background.add(labelAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, -1));

        labelHoras.setForeground(new java.awt.Color(0, 0, 0));
        labelHoras.setText("jLabel1");
        background.add(labelHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        labelMotivo.setForeground(new java.awt.Color(0, 0, 0));
        labelMotivo.setText("jLabel1");
        background.add(labelMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        labelFecha.setForeground(new java.awt.Color(0, 0, 0));
        labelFecha.setText("jLabel1");
        background.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        labelCuenta.setForeground(new java.awt.Color(0, 0, 0));
        labelCuenta.setText("jLabel1");
        background.add(labelCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, -1, -1));

        labelTotal.setForeground(new java.awt.Color(0, 0, 0));
        labelTotal.setText("jLabel1");
        background.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        bTablaEditar.setText("Editar");
        background.add(bTablaEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 120, 40));

        bTablaEliminar.setText("Eliminar");
        background.add(bTablaEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 120, 40));

        bTablaVolver.setText("Volver");
        background.add(bTablaVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 120, 40));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bTablaEditar;
    public javax.swing.JButton bTablaEliminar;
    public javax.swing.JButton bTablaVolver;
    private javax.swing.JPanel background;
    private javax.swing.JLabel labelAsignatura;
    private javax.swing.JLabel labelCuenta;
    private javax.swing.JLabel labelCurso;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHoras;
    private javax.swing.JLabel labelMotivo;
    private javax.swing.JLabel labelTotal;
    public javax.swing.JTable tablaFaltas;
    private javax.swing.JScrollPane tablaScrollPane;
    // End of variables declaration//GEN-END:variables

    //Modelo asignado a JComboBox listaCursos y listaAsignaturas
    public DefaultTableModel dtmFaltas;

    //Atributo para guardar si el usuario desea utilizar el modo oscuro.
    private boolean estaActivadoModoOscuro;

    //Constructor
    public VistaTabla() {
        initComponents();

        this.dtmFaltas = new DefaultTableModel();
        //tablaFaltas.setModel(dtmFaltas);
        this.tablaFaltas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
    
    // Icono del JFrame:
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/IconoGF 200px.png"));
        return retValue;
    }

    // Método para ajustar el ancho de las columnas
    public void ajustarAnchoColumnas() {
        for (int columna = 0; columna < this.tablaFaltas.getColumnCount(); columna++) {
            int maxWidth = 0;

            if (columna == 2 || columna == 4 || columna == 5) {
                continue;
            }

            TableColumn tableColumn = this.tablaFaltas.getColumnModel().getColumn(columna);
            TableCellRenderer headerRenderer = this.tablaFaltas.getTableHeader().getDefaultRenderer();
            Component headerComp = headerRenderer.getTableCellRendererComponent(this.tablaFaltas, tableColumn.getHeaderValue(), false, false, -1, columna);
            maxWidth = headerComp.getPreferredSize().width;

            for (int fila = 0; fila < this.tablaFaltas.getRowCount(); fila++) {
                TableCellRenderer cellRenderer = this.tablaFaltas.getCellRenderer(fila, columna);
                Component cellComp = this.tablaFaltas.prepareRenderer(cellRenderer, fila, columna);
                maxWidth = Math.max(cellComp.getPreferredSize().width, maxWidth);
            }

            tableColumn.setPreferredWidth(maxWidth);
            tableColumn.setWidth(maxWidth);
        }
    }

    public void ajustarAnchoColumnaExtra() {
        int totalColumnWidth = 0;
        int tablaWidth = this.tablaFaltas.getWidth();

        for (int columna = 0; columna < this.tablaFaltas.getColumnCount(); columna++) {
            totalColumnWidth += this.tablaFaltas.getColumnModel().getColumn(columna).getPreferredWidth();
        }

        int extraWidth = tablaWidth - totalColumnWidth;

        TableColumn columnaExtra = this.tablaFaltas.getColumnModel().getColumn(3);
        if (extraWidth > 0) {
            columnaExtra.setPreferredWidth(columnaExtra.getWidth() + extraWidth);
            columnaExtra.setWidth(columnaExtra.getWidth() + extraWidth);
        } else if (extraWidth < 0) {
            columnaExtra.setPreferredWidth(columnaExtra.getWidth() + extraWidth);
            columnaExtra.setWidth(columnaExtra.getWidth() + extraWidth);
        }
    }
    
    public void actualizarModoOscuro(boolean estaActivadoModoOscuro) {
        if (estaActivadoModoOscuro) {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                SwingUtilities.updateComponentTreeUI(this);
                
                this.background.setBackground(new Color(102, 102, 102));
                
                colorSecretLabelSizeTable(new Color(102, 102, 102));
                
                this.tablaFaltas.setForeground(Color.white);
                this.tablaFaltas.getTableHeader().setForeground(Color.white);
                
                this.estaActivadoModoOscuro = true;
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Error aplicando el tema" + e);
            }
        } else {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                SwingUtilities.updateComponentTreeUI(this);
                
                this.background.setBackground(Color.white);
                
                colorSecretLabelSizeTable(Color.white);
                
                this.tablaFaltas.setForeground(Color.black);
                this.tablaFaltas.getTableHeader().setForeground(Color.black);
                
                this.estaActivadoModoOscuro = false;
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Error aplicando el tema" + e);
            }
        }
    }
    public void colorSecretLabelSizeTable(Color unColor) {
        this.labelCurso.setForeground(unColor);
        this.labelAsignatura.setForeground(unColor);
        this.labelHoras.setForeground(unColor);
        this.labelMotivo.setForeground(unColor);
        this.labelFecha.setForeground(unColor);
        this.labelCuenta.setForeground(unColor);
        this.labelTotal.setForeground(unColor);
    }
    public void setTextSizeLabels() {
        this.labelCurso.setText(String.valueOf(tablaFaltas.getColumnModel().getColumn(0).getWidth()));
        this.labelAsignatura.setText(String.valueOf(tablaFaltas.getColumnModel().getColumn(1).getWidth()));
        this.labelHoras.setText(String.valueOf(tablaFaltas.getColumnModel().getColumn(2).getWidth()));
        this.labelMotivo.setText(String.valueOf(tablaFaltas.getColumnModel().getColumn(3).getWidth()));
        this.labelFecha.setText(String.valueOf(tablaFaltas.getColumnModel().getColumn(4).getWidth()));
        this.labelCuenta.setText(String.valueOf(tablaFaltas.getColumnModel().getColumn(5).getWidth()));

        int total = 0;
        for (int i = 0; i < tablaFaltas.getColumnCount(); i++) {
            total += tablaFaltas.getColumnModel().getColumn(i).getWidth();
        }
        this.labelTotal.setText(String.valueOf(total));
    }
}