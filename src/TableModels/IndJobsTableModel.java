/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import data.DataManagerImpl;
import domain.Job;
import domain.JobLine;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class IndJobsTableModel extends AbstractTableModel {
    
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
    
    private List<Job> li;
    private String[] columnNames = {"Job Code", "Description", "Price"};

    public IndJobsTableModel(){
        li = new ArrayList<Job>();
    }
    
    public IndJobsTableModel(List<Job> li) {
        this.li = li;
    }
    
    public void update(List<Job> jobs){
        li = jobs;
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
        Job jl = li.get(rowIndex);
        switch(columnIndex){
            case 0:
                return jl.getCode();
            case 1:
                return jl.getJobDescription();
            case 2: 
                return jl.getPrice();
            
        }
        
       return null;
    }
    
}
