/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Laptop
 */
public class ViewSistema extends javax.swing.JFrame {

    /**
     * Creates new form ViewSistema
     */
    public ViewSistema() {
        initComponents();
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

    public void setjDesktopPane1(JDesktopPane jDesktopPane1) {
        this.jDesktopPane1 = jDesktopPane1;
    }

    public JMenuItem getjMenuItemAdministrador() {
        return jMenuItemAdministrador;
    }

    public void setjMenuItemAdministrador(JMenuItem jMenuItemAdministrador) {
        this.jMenuItemAdministrador = jMenuItemAdministrador;
    }

    public JMenuItem getjMenuItemAsistente() {
        return jMenuItemAsistente;
    }

    public void setjMenuItemAsistente(JMenuItem jMenuItemAsistente) {
        this.jMenuItemAsistente = jMenuItemAsistente;
    }

    public JMenuItem getjMenuItemJefeOperaciones() {
        return jMenuItemJefeOperaciones;
    }

    public void setjMenuItemJefeOperaciones(JMenuItem jMenuItemJefeOperaciones) {
        this.jMenuItemJefeOperaciones = jMenuItemJefeOperaciones;
    }

    public JMenu getjMenuReportes() {
        return jMenuReportes;
    }

    public void setjMenuReportes(JMenu jMenuReportes) {
        this.jMenuReportes = jMenuReportes;
    }

    public JMenu getjMenuUsuarios() {
        return jMenuUsuarios;
    }

    public void setjMenuUsuarios(JMenu jMenuUsuarios) {
        this.jMenuUsuarios = jMenuUsuarios;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemAdministrador = new javax.swing.JMenuItem();
        jMenuItemJefeOperaciones = new javax.swing.JMenuItem();
        jMenuItemAsistente = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jMenuUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users.png"))); // NOI18N
        jMenuUsuarios.setText("USUARIOS");

        jMenuItemAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empresario.png"))); // NOI18N
        jMenuItemAdministrador.setText("Administrador");
        jMenuUsuarios.add(jMenuItemAdministrador);

        jMenuItemJefeOperaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empresario.png"))); // NOI18N
        jMenuItemJefeOperaciones.setText("Jefe Operacional");
        jMenuUsuarios.add(jMenuItemJefeOperaciones);

        jMenuItemAsistente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/assistant.png"))); // NOI18N
        jMenuItemAsistente.setText("Asistente");
        jMenuUsuarios.add(jMenuItemAsistente);

        jMenuBar1.add(jMenuUsuarios);

        jMenuReportes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuReportes.setText("REPORTES");
        jMenuBar1.add(jMenuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAdministrador;
    private javax.swing.JMenuItem jMenuItemAsistente;
    private javax.swing.JMenuItem jMenuItemJefeOperaciones;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenu jMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
