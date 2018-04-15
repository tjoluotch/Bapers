/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import domain.Staff;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tweetie Pie
 */
public class StaffTableModel extends AbstractTableModel{

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
    
    private List<Staff> li;
    private String[] columnNames = {"Username", "First Name", "Surname", "Role"};

    public StaffTableModel(List<Staff> li) {
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
        Staff staff = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return staff.getUsername();
            case 1:
                return staff.getForename();
            case 2: 
                return staff.getSurname();
            case 3:
                return staff.getRole();
        }
        
       return null;
    }
    
}
