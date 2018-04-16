/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;


import domain.TaskLine;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tweetie Pie
 */
public class TasksTableModel extends AbstractTableModel {

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
    
    private List<TaskLine> li;
    private String[] columnNames = {"Task ID", "Description", "Department", "Expected Duration", "Job Deadline" , "Special Instructions"};

    public TasksTableModel(List<TaskLine> li) {
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
        return 6; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TaskLine tl = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return tl.getTaskID().getTaskID().toString();
            case 1:
                return tl.getTaskID().getDescription();
            case 2: 
                return tl.getTaskID().getDepartment();
            case 3:
                return tl.getTaskID().getExpectedDuration();
            case 4:
                return tl.getJoblineID().getJobDeadline();
            case 5:
                return tl.getJoblineID().getSpecialInstructions();
        }
        
       return null;
    }
    
}
