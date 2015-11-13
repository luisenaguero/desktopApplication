/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Controllers.TableController;
import JPA.entities.Sector;
import JPA.utilities.JPAManager;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import views.Actualizar.ActualizarSector;
import views.Registros.RegistroSector;

/**
 *
 * @author Eddie Master
 */
public class General extends javax.swing.JPanel {

    /**
     * Creates new form General
     */
    TableController tc = new TableController();
    JPAManager jpam;
    long id;
    int row ;
    String opcion = "";
    Sector sector = new Sector();

    public General(String op) {
        initComponents();
        opcion = op;
        DefaultTableModel modelo = tc.Opciones(op);
        GeneralTable.setModel(modelo);
        GeneralTable.getColumnModel().getColumn(0).setMaxWidth(0);
        GeneralTable.getColumnModel().getColumn(0).setMinWidth(0);
        GeneralTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        GeneralTable.doLayout();
        PanelRegistro.setLayout(new BorderLayout());
        switch(op){
            case "sector":{
                RegistroSector rs = new RegistroSector();
                PanelRegistro.add(rs);
                PanelRegistro.updateUI();
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Popup = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        PanelEntidad = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GeneralTable = new javax.swing.JTable();
        PanelRegistro = new javax.swing.JPanel();

        jMenuItem2.setText("Actualizar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Popup.add(jMenuItem2);

        jMenuItem1.setText("Eliminar Seleccion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Popup.add(jMenuItem1);

        PanelEntidad.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entidad", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        GeneralTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        GeneralTable.setComponentPopupMenu(Popup);
        GeneralTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GeneralTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeneralTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(GeneralTable);

        javax.swing.GroupLayout PanelEntidadLayout = new javax.swing.GroupLayout(PanelEntidad);
        PanelEntidad.setLayout(PanelEntidadLayout);
        PanelEntidadLayout.setHorizontalGroup(
            PanelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );
        PanelEntidadLayout.setVerticalGroup(
            PanelEntidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        PanelRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Registro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(PanelEntidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GeneralTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeneralTableMouseClicked
        row = GeneralTable.rowAtPoint(evt.getPoint());
        id = (long) GeneralTable.getValueAt(row, 0);
        System.out.println("ID: " + id);
    }//GEN-LAST:event_GeneralTableMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.out.println("poup");
        System.out.println(opcion);
        System.out.println(id);
        switch (opcion) {
            case "sector": {
                if (id > 0) {
                    jpam = new JPAManager(Sector.class);
                    sector.setId(id);
                    System.out.println(jpam.deleteEntity(sector));
                    tc.updateTable(GeneralTable, opcion);
                } else {
                    System.out.println("Seleccione una fila");
                }

            }
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        PanelRegistro.setBorder(BorderFactory.createTitledBorder("Actualizar"));
        PanelRegistro.removeAll();
        ActualizarSector as = new ActualizarSector(row);
        PanelRegistro.add(as);
        PanelRegistro.updateUI();
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable GeneralTable;
    public static javax.swing.JPanel PanelEntidad;
    public static javax.swing.JPanel PanelRegistro;
    private javax.swing.JPopupMenu Popup;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
