/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import java.util.List;
import domain.JobLine;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tjay
 */
public class AllJobLineTableModel extends AbstractTableModel {
    
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
             }
             return null;
         //To change body of generated methods, choose Tools | Templates.
    }
    
    private List<JobLine> job;
    private String[] columnNames = {"Job Line ID", "Job Code", "Job Deadline", "Special Instructions", "reminder status", "Order Id"};

    public AllJobLineTableModel(List<JobLine> job) {
        this.job = job;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
       return job.size();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 6; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JobLine jl = job.get(rowIndex);
        switch(columnIndex){
            case 0:
                return jl.getJoblineID();
            case 1:
                return jl.getJobCode();
            case 2: 
                return jl.getJobDeadline();
            case 3:
                return jl.getSpecialInstructions();
            case 4:
                return jl.getReminderStatus();
            case 5:
                return jl.getOrderID();
        }
        
       return null;
    }
}
