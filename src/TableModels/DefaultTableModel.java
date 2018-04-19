/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import domain.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tjay
 */
public class DefaultTableModel extends AbstractTableModel {
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
    
    private List<Customer> cust;
    private String[] columnNames = {"First Name", "Last Name", "Account Number", "Status"};

    public DefaultTableModel(List<Customer> cust) {
        this.cust = cust;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
       return cust.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = cust.get(rowIndex);
        switch(columnIndex){
            case 0:
                return c.getForename();
            case 1:
                return c.getSurname();
            case 2: 
                return c.getAccountNo();
            case 3:
                return c.getStatus();
        }
        
       return null;
    }
}
