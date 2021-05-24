/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.ui.instructor;

import com.unindra.smartbrain.database.EntityManager;
import com.unindra.smartbrain.model.Instructor;
import com.unindra.smartbrain.repository.InstructorRepository;
import com.unindra.smartbrain.repository.IfaceInstructorRepository;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 *
 * @author harunnurrasyid
 */
public class DashboardUI extends JFrame {

    private DefaultTableModel tableModel;

    /**
     * Creates new form ParticipantUI
     */
    public DashboardUI() {
        initComponents();
        initTableInstructor();
        
        // Center form
        this.setLocationRelativeTo(null);
    }
    
    public void initTableInstructor() {
        instructorPageButton.setEnabled(false);
                
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");        
        tableModel.addColumn("Name");        
        tableModel.addColumn("Age");
        
        EntityManager entityManager = new EntityManager();
        IfaceInstructorRepository repo = new InstructorRepository(entityManager);
        List<Instructor> instructors = repo.getInstructors();
        
        for (Instructor instructor : instructors) {
            tableModel.addRow(new Object[]{instructor.getId(), instructor.getName(), instructor.getAge()});
        }
        
        tableInstructor.setModel(tableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        itemCreate = new javax.swing.JMenuItem();
        itemUpdate = new javax.swing.JMenuItem();
        itemDetail = new javax.swing.JMenuItem();
        itemDelete = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInstructor = new javax.swing.JTable();
        createButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        sideBarPanel = new javax.swing.JPanel();
        participantPageButton = new javax.swing.JButton();
        instructorPageButton = new javax.swing.JButton();
        ReportCardPageButton = new javax.swing.JButton();
        coursePageButton = new javax.swing.JButton();

        itemCreate.setText("Add");
        itemCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateActionPerformed(evt);
            }
        });
        popupMenu.add(itemCreate);

        itemUpdate.setText("Edit");
        itemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUpdateActionPerformed(evt);
            }
        });
        popupMenu.add(itemUpdate);

        itemDetail.setText("Detail");
        popupMenu.add(itemDetail);

        itemDelete.setText("Delete");
        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeleteActionPerformed(evt);
            }
        });
        popupMenu.add(itemDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableInstructor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableInstructorMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableInstructor);

        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add.png"))); // NOI18N
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createButtonMousePressed(evt);
            }
        });

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-reset.png"))); // NOI18N
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshButtonMousePressed(evt);
            }
        });

        participantPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-male_user.png"))); // NOI18N
        participantPageButton.setText("Peserta");
        participantPageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                participantPageButtonMousePressed(evt);
            }
        });

        instructorPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-administrator_male.png"))); // NOI18N
        instructorPageButton.setText("Pengajar");
        instructorPageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                instructorPageButtonMousePressed(evt);
            }
        });

        ReportCardPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-conference.png"))); // NOI18N
        ReportCardPageButton.setText("Raport");
        ReportCardPageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReportCardPageButtonMousePressed(evt);
            }
        });

        coursePageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-literature.png"))); // NOI18N
        coursePageButton.setText("Kursus");
        coursePageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                coursePageButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(instructorPageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(participantPageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coursePageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportCardPageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(instructorPageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(participantPageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coursePageButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReportCardPageButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableInstructorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInstructorMouseReleased
        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (SwingUtilities.isRightMouseButton(evt) && tableInstructor.getSelectedRowCount() != 0) {
                popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tableInstructorMouseReleased

    private void itemCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreateActionPerformed
        JFrame frame = new FormCreateUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(mainPanel); // or whatever...
        frame.pack();
        frame.setLocationRelativeTo(null);  // *** this will center your app ***
        frame.setVisible(true);
    }//GEN-LAST:event_itemCreateActionPerformed

    private void itemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteActionPerformed
        int selectedRow = tableInstructor.getSelectedRow();
        
        if (selectedRow >= 0) {
            int id = (int) tableInstructor.getValueAt(selectedRow, 0);
            EntityManager entityManager = new EntityManager();
            IfaceInstructorRepository repo = new InstructorRepository(entityManager);
            repo.deleteInstructorById(id);
            
            initTableInstructor();
        }
    }//GEN-LAST:event_itemDeleteActionPerformed

    private void refreshButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMousePressed
        initTableInstructor();
    }//GEN-LAST:event_refreshButtonMousePressed

    private void itemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUpdateActionPerformed
        int currentRow = tableInstructor.getSelectedRow();
        JFrame frame = new FormUpdateUI(tableInstructor.getValueAt(currentRow, 0).toString(), tableInstructor.getValueAt(currentRow, 1).toString(), tableInstructor.getValueAt(currentRow, 2).toString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(mainPanel); // or whatever...
        frame.pack();
        frame.setLocationRelativeTo(null);  // *** this will center your app ***
        frame.setVisible(true);
    }//GEN-LAST:event_itemUpdateActionPerformed

    private void instructorPageButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructorPageButtonMousePressed
        initTableInstructor();
    }//GEN-LAST:event_instructorPageButtonMousePressed

    private void participantPageButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantPageButtonMousePressed
        JFrame frame = new com.unindra.smartbrain.ui.participant.DashboardUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(mainPanel); // or whatever...
        frame.pack();
        frame.setLocationRelativeTo(null);  // *** this will center your app ***
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_participantPageButtonMousePressed

    private void coursePageButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursePageButtonMousePressed
        JFrame frame = new com.unindra.smartbrain.ui.course.DashboardUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(mainPanel); // or whatever...
        frame.pack();
        frame.setLocationRelativeTo(null);  // *** this will center your app ***
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_coursePageButtonMousePressed

    private void ReportCardPageButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportCardPageButtonMousePressed
        JFrame frame = new com.unindra.smartbrain.ui.reportCard.DashboardUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(mainPanel); // or whatever...
        frame.pack();
        frame.setLocationRelativeTo(null);  // *** this will center your app ***
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReportCardPageButtonMousePressed

    private void createButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createButtonMousePressed
        JFrame frame = new FormCreateUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().add(mainPanel); // or whatever...
        frame.pack();
        frame.setLocationRelativeTo(null);  // *** this will center your app ***
        frame.setVisible(true);
    }//GEN-LAST:event_createButtonMousePressed
  
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
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReportCardPageButton;
    private javax.swing.JButton coursePageButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton instructorPageButton;
    protected javax.swing.JMenuItem itemCreate;
    protected javax.swing.JMenuItem itemDelete;
    protected javax.swing.JMenuItem itemDetail;
    protected javax.swing.JMenuItem itemUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton participantPageButton;
    public javax.swing.JPopupMenu popupMenu;
    private javax.swing.JButton refreshButton;
    private javax.swing.JPanel sideBarPanel;
    public javax.swing.JTable tableInstructor;
    // End of variables declaration//GEN-END:variables
}