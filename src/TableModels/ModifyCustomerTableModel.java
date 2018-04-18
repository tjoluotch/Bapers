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
 * @author redwan
 */
public class ModifyCustomerTableModel extends AbstractTableModel {
  
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
             case 5:
               return String.class;
             case 6:
               return String.class;
             case 7:
               return String.class;
             case 8:
               return String.class;
             case 9:
               return String.class;
             case 10:
               return String.class;
             case 11:
               return String.class;
             }
             return null;
         //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<Customer> li;
    private String[] columnNames = {"Acc. No", "Forename", "Surname", "Acc. Holder Name", "Address 1", "Address 2", "City", "Postcode", "Phone", "Email","Valued Customer","Discount Type"};

    public ModifyCustomerTableModel(List<Customer> li) {
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
        return 12; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer cl = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return cl.getAccountNo();
            case 1:
                return cl.getForename();
            case 2: 
                return cl.getSurname();
            case 3:
               return cl.getAccountHolderName();
            case 4:
                return cl.getAddress1();
            case 5:
                return cl.getAddress2();
            case 6:
                return cl.getCity();
            case 7:
                return cl.getPostcode();
            case 8:
                return cl.getPhone();
            case 9:
                return cl.getEmail();
            case 10:
               return cl.getValuedCustomer();
            case 11:
               return cl.getDiscountType();    
        }
        
       return null;
    }  
}
