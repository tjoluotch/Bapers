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
 * @author DanTe
 */
public class CustomersTableModel extends AbstractTableModel {

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
             case 4:
               return String.class;
             }
             return null;
         //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Customer> li;
    private String[] columnNames = {"Account Holder", "Forename", "Surname", "Account Number", "Valued"};

    public CustomersTableModel(List<Customer> li) {
        this.li = li;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
       return li.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer cl = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return cl.getAccountHolderName();
            case 1:
                return cl.getForename();
            case 2: 
                return cl.getSurname();
            case 3:
               return cl.getAccountNo();
            case 4:
                if(cl.getValuedCustomer() == true){
                return cl.getDiscountType();
                } else {
                    return "No";
                }
        }
        
       return null;
    }
    
    
}
