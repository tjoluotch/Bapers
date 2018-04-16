/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import data.DataManagerImpl;
import domain.JobLine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class JobsTableModel extends AbstractTableModel {
    
    DataManagerImpl dm = new DataManagerImpl();
    
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
    
    private List<JobLine> li;
    private String[] columnNames = {"Job ID", "Price", "Description"};

    public JobsTableModel(){
        li = new ArrayList<JobLine>();
    }
    
    public JobsTableModel(List<JobLine> li) {
        this.li = li;
    }
    
//    public void update(Collection<JobLine> jobs){
//        li = new ArrayList(jobs);
//    }

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
        JobLine jl = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return jl.getJoblineID();
            case 1:
                return jl.getJobCode().getPrice();
            case 2: 
                return jl.getJobCode().getJobDescription();
            
        }
        
       return null;
    }
    
}
