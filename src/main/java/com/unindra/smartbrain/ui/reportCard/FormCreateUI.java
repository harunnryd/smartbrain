/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unindra.smartbrain.ui.reportCard;

import com.unindra.smartbrain.database.EntityManager;
import com.unindra.smartbrain.model.Participant;
import com.unindra.smartbrain.model.Instructor;
import com.unindra.smartbrain.model.Course;
import com.unindra.smartbrain.model.ReportCard;

import com.unindra.smartbrain.repository.IfaceParticipantRepository;
import com.unindra.smartbrain.repository.IfaceInstructorRepository;
import com.unindra.smartbrain.repository.IfaceCourseRepository;
import com.unindra.smartbrain.repository.IfaceReportCardRepository;

import com.unindra.smartbrain.repository.ParticipantRepository;
import com.unindra.smartbrain.repository.InstructorRepository;
import com.unindra.smartbrain.repository.CourseRepository;
import com.unindra.smartbrain.repository.ReportCardRepository;

import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author harunnurrasyid
 */
public class FormCreateUI extends JFrame {
    
    protected Integer reportCardId;

    /**
     * Creates new form FormUI
     */
    public FormCreateUI() {
        initComponents();
        initComboBox();
    }
    
    public void initComboBox() {
        EntityManager entityManager = new EntityManager();
        IfaceParticipantRepository participantRepo = new ParticipantRepository(entityManager);
        IfaceInstructorRepository instructorRepo = new InstructorRepository(entityManager);
        IfaceCourseRepository courseRepo = new CourseRepository(entityManager);

        List<Participant> participants = participantRepo.getParticipants();
        
        for (Participant participant : participants) {
            participantComboBox.addItem(participant.getName());
        }
        
        List<Instructor> instructors = instructorRepo.getInstructors();
        
        for (Instructor instructor : instructors) {
            instructorComboBox.addItem(instructor.getName());
        }
        
        List<Course> courses = courseRepo.getCourses();
        
        for (Course course : courses) {
            courseComboBox.addItem(course.getName());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        scoreField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        schoolYearField = new javax.swing.JTextField();
        storeButton = new javax.swing.JButton();
        instructorComboBox = new javax.swing.JComboBox<>();
        participantComboBox = new javax.swing.JComboBox<>();
        courseComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Pengajar");

        jLabel2.setText("Nama Peserta");

        jLabel3.setText("Nama Kursus");

        cancelButton.setText("Batal");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelButtonMousePressed(evt);
            }
        });

        jLabel4.setText("Nilai");

        jLabel5.setText("Tahun Ajaran");

        storeButton.setText("Simpan");
        storeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                storeButtonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(storeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(schoolYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scoreField)
                                .addComponent(instructorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(participantComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(courseComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(instructorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(participantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(courseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(schoolYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storeButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMousePressed
        this.dispose();
    }//GEN-LAST:event_cancelButtonMousePressed

    private void storeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeButtonMousePressed
        EntityManager entityManager = new EntityManager();
        IfaceParticipantRepository participantRepo = new ParticipantRepository(entityManager);
        IfaceInstructorRepository instructorRepo = new InstructorRepository(entityManager);
        IfaceCourseRepository courseRepo = new CourseRepository(entityManager);
        IfaceReportCardRepository reportCardRepo = new ReportCardRepository(entityManager);
        
        Participant currentParticipant = participantRepo.getParticipantByName(participantComboBox.getSelectedItem().toString());
        Instructor currentInstructor = instructorRepo.getInstructorByName(instructorComboBox.getSelectedItem().toString());
        Course currentCourse = courseRepo.getCourseByName(courseComboBox.getSelectedItem().toString());
        
        reportCardRepo.createReportCard(new ReportCard(
                currentInstructor.getId(),
                currentParticipant.getId(),
                currentCourse.getId(),
                Integer.parseInt(scoreField.getText()),
                schoolYearField.getText()
        ));
        
        this.dispose();
    }//GEN-LAST:event_storeButtonMousePressed

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
            java.util.logging.Logger.getLogger(FormCreateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCreateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCreateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCreateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCreateUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JComboBox<String> courseComboBox;
    protected javax.swing.JComboBox<String> instructorComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    protected javax.swing.JComboBox<String> participantComboBox;
    private javax.swing.JTextField schoolYearField;
    private javax.swing.JTextField scoreField;
    protected javax.swing.JButton storeButton;
    // End of variables declaration//GEN-END:variables
}
