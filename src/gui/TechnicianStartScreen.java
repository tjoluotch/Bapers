/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import TableModels.TasksTableModel;
import data.DataManagerImpl;
import domain.Staff;
import domain.TaskLine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Tweetie Pie
 */
public class TechnicianStartScreen extends javax.swing.JFrame {
Staff staff;
DataManagerImpl dm = new DataManagerImpl();
List<TaskLine> tl = dm.searchbyStartTime();
TaskLine selectedTask;
    /**
     * Creates new form TechnicianSHomeScreen
     */
    public TechnicianStartScreen() {
        initComponents();
    }
    public TechnicianStartScreen(Staff staff) {
        this.staff = staff;
        
        Timer timer = new Timer(60000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
                tl = dm.searchbyStartTime();
                JobTable.setModel(new TasksTableModel(tl));
               
               
           }
       });
        
        timer.start(); 
        
        
        initComponents();
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        sp = new javax.swing.JPanel();
        SelectTaskButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TaskHistoryButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JobTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        sp.setBackground(new java.awt.Color(250, 174, 62));

        SelectTaskButton.setBackground(new java.awt.Color(250, 190, 100));
        SelectTaskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectTaskButtonMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/taskicon.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Task");

        javax.swing.GroupLayout SelectTaskButtonLayout = new javax.swing.GroupLayout(SelectTaskButton);
        SelectTaskButton.setLayout(SelectTaskButtonLayout);
        SelectTaskButtonLayout.setHorizontalGroup(
            SelectTaskButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectTaskButtonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SelectTaskButtonLayout.setVerticalGroup(
            SelectTaskButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SelectTaskButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(SelectTaskButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TaskHistoryButton.setBackground(new java.awt.Color(250, 190, 100));
        TaskHistoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaskHistoryButtonMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/taskhistoryicon.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Task History");

        javax.swing.GroupLayout TaskHistoryButtonLayout = new javax.swing.GroupLayout(TaskHistoryButton);
        TaskHistoryButton.setLayout(TaskHistoryButtonLayout);
        TaskHistoryButtonLayout.setHorizontalGroup(
            TaskHistoryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaskHistoryButtonLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TaskHistoryButtonLayout.setVerticalGroup(
            TaskHistoryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaskHistoryButtonLayout.createSequentialGroup()
                .addGroup(TaskHistoryButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TaskHistoryButtonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addGroup(TaskHistoryButtonLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        LogoutButton.setBackground(new java.awt.Color(250, 190, 100));
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Logout");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/logoutIcon.png"))); // NOI18N

        javax.swing.GroupLayout LogoutButtonLayout = new javax.swing.GroupLayout(LogoutButton);
        LogoutButton.setLayout(LogoutButtonLayout);
        LogoutButtonLayout.setHorizontalGroup(
            LogoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutButtonLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogoutButtonLayout.setVerticalGroup(
            LogoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(LogoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/SolSoft.png"))); // NOI18N

        javax.swing.GroupLayout spLayout = new javax.swing.GroupLayout(sp);
        sp.setLayout(spLayout);
        spLayout.setHorizontalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SelectTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TaskHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(spLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        spLayout.setVerticalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(19, 19, 19)
                .addComponent(SelectTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaskHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JobTable.setModel(new TasksTableModel(tl));
        JobTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JobTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JobTable);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Homepage");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel8)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void TaskHistoryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaskHistoryButtonMouseClicked
        // TODO add your handling code here:
        TaskHistoryScreen th = new TaskHistoryScreen();
        th.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_TaskHistoryButtonMouseClicked

    private void SelectTaskButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectTaskButtonMouseClicked
        // TODO add your handling code here:
        
        
        
        SelectTaskScreen st = new SelectTaskScreen();
        st.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_SelectTaskButtonMouseClicked

    private void JobTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JobTableMouseClicked
        // TODO add your handling code here:
        int row = JobTable.getSelectedRow();
        String tID = JobTable.getValueAt(row, 0).toString();
        int tlID = Integer.parseInt(tID);
        DataManagerImpl dm = new DataManagerImpl();
        TaskLine selecetedTask = dm.findTaskLineByCode(tlID);
        
        
    }//GEN-LAST:event_JobTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TechnicianStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TechnicianStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TechnicianStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TechnicianStartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TechnicianStartScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JobTable;
    private javax.swing.JPanel LogoutButton;
    private javax.swing.JPanel SelectTaskButton;
    private javax.swing.JPanel TaskHistoryButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel sp;
    // End of variables declaration//GEN-END:variables
}
