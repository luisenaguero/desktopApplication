/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import JPA.entities.Presupue;
import JPA.entities.Programa;
import JPA.entities.Sector;
import JPA.utilities.JPAManager;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Eddie Master
 */
public class TableController {

    //ENTIDAD SECTOR
    Sector sector = new Sector();
    Presupue presupue = new Presupue();

    //ENTIDAD XXX
    public DefaultTableModel Opciones(String op) {

        switch (op) {
            case "sector": {
                JPAManager jpam = new JPAManager(Sector.class);
                List<Sector> lista = jpam.objectListResultNQ(Sector.FIND_ALL, null);
                DefaultTableModel modelo = new DefaultTableModel();
                String[] col = {"id", "SECTOR", "DETSECTOR"};
                for (int i = 0; i < col.length; i++) {
                    modelo.addColumn(col[i]);
                }
                for (Sector sec : lista) {

                    String newCode = sec.getCodsector().toString();

                    if (sec.getCodsector() < 10) {
                        newCode = "0" + newCode;
                    }

                    modelo.addRow(new Object[]{sec.getId(), newCode, sec.getDetsector()});
                }

                return modelo;
            }
            case "presupuesto": {
                String[] col = {"id", "codpresup", "descripcion", "corrsoli", "corrpago", "emprcons"};
                DefaultTableModel modelo = new DefaultTableModel();
                JPAManager jpam = new JPAManager(Presupue.class);
                List<Presupue> lista = jpam.listResultNQ(Presupue.FIND_ALL, null);
                for (int i = 0; i < col.length; i++) {
                    modelo.addColumn(col[i]);
                }
                try {
                    for (Presupue pre : lista) {
                        String newCode = Integer.toString(pre.getCodpresup());
                        if (pre.getCodpresup() < 10) {
                            newCode = "0" + newCode;
                        }
                        modelo.addRow(new Object[]{pre.getId(), newCode, pre.getDescri(), pre.getCorrsoli(), pre.getCorrpago(), pre.getEmprcons()});
                    }

                } catch (Exception e) {
                }

                return modelo;
            }
            case "programa": {                
                String[] col = {"id", "SEC.", "PROG.", "NOMBRE"};
                DefaultTableModel modelo = new DefaultTableModel();
                JPAManager jpam = new JPAManager(Programa.class);
                List<Programa> lista = jpam.listResultNQ(Programa.FIND_ALL, null);
                for (int i = 0; i < col.length; i++) {
                    modelo.addColumn(col[i]);
                }
                for (Programa pro : lista) {     
                    String newCode = pro.getCodprogr().toString();
                    if (pro.getCodprogr() < 10) {
                        newCode = "0" + newCode;
                    }

                    String newSectorCode = pro.getCodsector().getCodsector().toString();
                    if (newSectorCode.length() < 2) {
                        newSectorCode = "0" + newSectorCode;
                    }

                    modelo.addRow(new Object[]{pro.getId(), newSectorCode, newCode, pro.getDetprogr()});
                }
                return modelo;
            }

        }
        return null;
    }

    public void updateTable(JTable t, String op) {
        DefaultTableModel modelo = (DefaultTableModel) t.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        TableColumnModel modCol = t.getColumnModel();
        while (modCol.getColumnCount() > 0) {
            modCol.removeColumn(modCol.getColumn(0));
        }
        t.setModel(Opciones(op));
        t.getColumnModel().getColumn(0).setMaxWidth(0);
        t.getColumnModel().getColumn(0).setMinWidth(0);
        t.getColumnModel().getColumn(0).setPreferredWidth(0);
        t.doLayout();

    }

}
