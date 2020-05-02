package healthcaregui;

import java.sql.SQLException;
import java.util.ArrayList;

import accountManagement.Admin;
import accountManagement.Doctor;
import accountManagement.Patient;
import accountManagement.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dubs2
 */
public class AddNewPatientRecords extends javax.swing.JFrame {

    private Doctor doctor;
    int patientindex;
    private ArrayList<Patient> patientList;

    /**
     * Creates new form AddNewVitals
     */
    public AddNewPatientRecords() {
        initComponents();
    }
    public AddNewPatientRecords(Doctor doctor) {
        this.doctor= doctor;
        try {
           patientList = doctor.getPatientList(); 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        patientindex = 0;
    
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtEmpno = new javax.swing.JTextField();
        txtEmpno1 = new javax.swing.JTextField();
        txtEmpno2 = new javax.swing.JTextField();
        txtEmpno3 = new javax.swing.JTextField();
        txtEmpno4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnAddNewEmp = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        String[] RecordTypes = { "Prescription", "Vital" };
        cmbMgr = new javax.swing.JComboBox<>(RecordTypes);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add New Patient Records");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient Email:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Record Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Times in a Day:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Intervals:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Repeat Every:");

        jRadioButton1.setText("Sunday");

        jRadioButton2.setText("Monday");

        jRadioButton3.setText("Tuesday");

        jRadioButton4.setText("Wednesday");

        jRadioButton5.setText("Thursday");

        jRadioButton6.setText("Friday");

        jRadioButton7.setText("Saturday");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Start Time:");

        txtEmpno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpnoActionPerformed(evt);
            }
        });

        txtEmpno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno1ActionPerformed(evt);
             txtEmpno1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
       }
        });

        txtEmpno2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno2ActionPerformed(evt);
            }
        });

        txtEmpno3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno3ActionPerformed(evt);
            }
        });

        txtEmpno4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno4ActionPerformed(evt);
            }
        });

        jButton3.setText(">>");

        jButton4.setText("<<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(patientindex != 0 )
                    patientindex--;
                else
                    patientindex = patientList.size()-1;
                 txtEmpno.setText(patientList.get(patientindex).getEmail());   
                

            
        }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(patientindex != (patientList.size()-1) )
                    patientindex++;
                else
                    patientindex = 0;
                 txtEmpno.setText(patientList.get(patientindex).getEmail());   
        }
        });
        btnAddNewEmp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewEmp.setText("Add");
        btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEmpActionPerformed(evt);
            }
        });

        cmbMgr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbMgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMgrActionPerformed(evt);

            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Record Type:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addGap(70, 70, 70)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3))
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton3)
                                .addComponent(jRadioButton4)
                                .addComponent(jRadioButton5)
                                .addComponent(jRadioButton6)
                                .addComponent(jRadioButton7))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmpno4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmpno3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmpno2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmpno1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbMgr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnAddNewEmp)))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEmpno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbMgr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmpno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmpno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmpno4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addGap(18, 18, 18)
                .addComponent(btnAddNewEmp)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpnoActionPerformed

    private void txtEmpno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno1ActionPerformed

    private void txtEmpno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno2ActionPerformed

    private void txtEmpno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno3ActionPerformed

    private void txtEmpno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno4ActionPerformed

    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewEmpActionPerformed
        // TODO add your handling code here:

//        try {
//            /*
//            * you need also to verify that the empno is unique and not duplicate
//            *
//            */
//            if (isValidData() && !isDuplicate(Integer.parseInt(txtEmpno.getText().trim()))) {
//                // if new employee details are valid, then add new employee to DB
//
//                String prepSQL = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES ("
//                + txtEmpno.getText().trim() + ", "
//                + "'" + txtEname.getText().toUpperCase() + "', "
//                + "'" + txtJob.getText().toUpperCase() + "', "
//                + cmbMgr.getSelectedItem().toString() + ", "
//                + "'" + ftxtHiredate.getText().trim() + "',"
//                + txtSalary.getText() + ","
//                + txtComm.getText() + ","
//                + cmbDeptno.getSelectedItem() + ")";
//
//                int result = dbCon.executePrepared(prepSQL);
//                if (result > 0) {
//
//                    javax.swing.JLabel label = new javax.swing.JLabel("New employee added successfully.");
//                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
//                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
//                    clearInputBoxes();
//                } else {
//
//                }
//
//                rs.close();
//            } else {
//                if (!isDuplicate(Integer.parseInt(txtEmpno.getText().trim()))) {
//                    javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
//                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
//                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
//                } else {
//                    javax.swing.JLabel label = new javax.swing.JLabel("Empno Already exists. Use a different employee number.");
//                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
//                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.INFORMATION_MESSAGE);
//                    // check validation errors
//                }
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error adding new employee.");
//        }
    }//GEN-LAST:event_btnAddNewEmpActionPerformed


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
            java.util.logging.Logger.getLogger(AddNewPatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewPatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewPatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewPatientRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewPatientRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JComboBox<String> cmbMgr;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JTextField txtEmpno;
    private javax.swing.JTextField txtEmpno1;
    private javax.swing.JTextField txtEmpno2;
    private javax.swing.JTextField txtEmpno3;
    private javax.swing.JTextField txtEmpno4;
    // End of variables declaration//GEN-END:variables
}
