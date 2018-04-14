/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import domain.Alert;
import domain.Staff;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tweetie Pie
 */
public class AlertTableModel extends AbstractTableModel {
      @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
             case 0:
               return String.class;
             case 1:
               return String.class;
             case 2:
               return String.class;
             case 3:
               return String.class;
             
             }
             return null;
         //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Alert> al;
    private String[] columnNames = {"Order ID", "Description", "Account Number", "Job Code"};

    public AlertTableModel(List<Alert> al) {
        this.al = al;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
       return al.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alert alert = al.get(rowIndex);
        switch(columnIndex){
            case 0:
                return alert.getOrderID().getOrderID();
            case 1:
                return alert.getDescription();
            case 2: 
                return alert.getAccountNo();
            case 3:
                return alert.getJoblineID().getJobCode();
        }
        
       return null;
    }
    
}
