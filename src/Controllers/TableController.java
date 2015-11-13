/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
    JPAManager jpamSector = new JPAManager(Sector.class);
    Sector sector = new Sector();

    //ENTIDAD XXX
    public DefaultTableModel Opciones(String op) {
        List<Sector> listaS = jpamSector.objectListResultNQ(Sector.FIND_ALL, null);
        DefaultTableModel modelo = new DefaultTableModel();
        switch (op) {
            case "sector": {
                String[] col = {"id", "SECTOR", "DETSECTOR"};
                for (int i = 0; i < col.length; i++) {
                    modelo.addColumn(col[i]);
                }
                for (Sector sec : listaS) {

                    String newCode = sec.getCodsector().toString();

                    if (sec.getCodsector() < 10) {
                        newCode = "0" + newCode;
                    }

                    modelo.addRow(new Object[]{sec.getId(), newCode, sec.getDetsector()});
                }

                return modelo;
            }
            case "actividad": {
                String[] col = {"id",};

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
