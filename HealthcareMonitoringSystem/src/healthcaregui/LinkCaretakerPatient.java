package healthcaregui;

import accountManagement.*;

import java.sql.SQLException;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dubs2
 */
public class LinkCaretakerPatient extends javax.swing.JFrame {

    /**
     * Creates new form LinkCaretakerPatient
     */
    public LinkCaretakerPatient() {
        initComponents();
    }
    public LinkCaretakerPatient(Admin admin) {
        this.admin = admin;
        try {
           admin.getUserList();
           patientList = admin.getPatientList(); 
           caretakerList = admin.getCaretakerList();
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
        patientIndex = 0;
        caretakerIndex = 0;
        jLabel2 = new javax.swing.JLabel();
        nextPatientButton = new javax.swing.JButton();
        txtEmpno = new javax.swing.JTextField(patientList.get(0).getEmail());
        prevPatientButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        prevCaretakerButton = new javax.swing.JButton();
        txtEmpno1 = new javax.swing.JTextField(caretakerList.get(0).getEmail());
        nextCaretakerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAddNewEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient Email:");
        
        nextPatientButton.setText("<<");

        txtEmpno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpnoActionPerformed(evt);
            }
        });

        prevPatientButton.setText(">>");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Caretaker Email:");

        prevCaretakerButton.setText("<<");

        txtEmpno1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno1ActionPerformed(evt);
            }
        });

        nextCaretakerButton.setText(">>");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Link Caretaker-Patient");

        btnAddNewEmp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewEmp.setText("Link");
        btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEmpActionPerformed(evt);
            }
        });

        prevPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(patientIndex != 0 )
                    patientIndex--;
                else
                    patientIndex = patientList.size()-1;
                 txtEmpno.setText(patientList.get(patientIndex).getEmail());   
                

            
        }
        });
        nextPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(patientIndex != (patientList.size()-1) )
                    patientIndex++;
                else
                    patientIndex = 0;
                 txtEmpno.setText(patientList.get(patientIndex).getEmail());   
        }
        });
        prevCaretakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(caretakerIndex != 0 )
                    caretakerIndex--;
                else
                    caretakerIndex = caretakerList.size()-1;
                 txtEmpno1.setText(caretakerList.get(caretakerIndex).getEmail());   
                

            
        }
        });
        
       nextCaretakerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(caretakerIndex != (caretakerList.size()-1)  )
                    caretakerIndex++;
                else
                    caretakerIndex = 0;
                 txtEmpno1.setText(caretakerList.get(caretakerIndex).getEmail());   
                

            
        }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextPatientButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevPatientButton)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(116, 116, 116))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevCaretakerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpno1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextCaretakerButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnAddNewEmp)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prevPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtEmpno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextCaretakerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prevCaretakerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
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
            java.util.logging.Logger.getLogger(LinkCaretakerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LinkCaretakerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LinkCaretakerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LinkCaretakerPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LinkCaretakerPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JButton prevPatientButton;
    private javax.swing.JButton nextPatientButton;
    private javax.swing.JButton prevCaretakerButton;
    private javax.swing.JButton nextCaretakerButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtEmpno;
    private javax.swing.JTextField txtEmpno1;
    private Admin admin;
    private ArrayList<User> userList;
    private ArrayList<Patient> patientList;
    private ArrayList<Caretaker> caretakerList;
    private int index;
    private int patientIndex;
    private int caretakerIndex;
    // End of variables declaration//GEN-END:variables
}
