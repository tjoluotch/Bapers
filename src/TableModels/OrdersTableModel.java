/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.List;
import domain.OrderTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DanTe
 */
public class OrdersTableModel extends AbstractTableModel{
    
 @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
             case 0:
               return String.class;
             case 1:
               return String.class;
             case 2:
               return String.class;
             }
             return null;
         //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<OrderTable> li;
    private String[] columnNames = {"Order ID", "Total Price", "Payment Status"};

    public OrdersTableModel(List<OrderTable> li) {
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
        return 3; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderTable o = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return o.getOrderID();
            case 1:
                return o.getTotalPrice();
            case 2:
                return o.getPaymentStatus();
        }
        
       return null;
    }
    
    
}
