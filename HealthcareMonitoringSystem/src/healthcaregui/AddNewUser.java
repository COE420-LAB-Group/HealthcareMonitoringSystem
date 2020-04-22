package healthcaregui;

import java.sql.SQLException;

import accountManagement.*;
import healthcareDatabase.InputErrorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dubs2
 */
public class AddNewUser extends javax.swing.JFrame {

    /**
     * Creates new form AddNewPatient
     */
    public AddNewUser(Admin admin) {
        this.admin = admin;
        initComponents();
    }
    public AddNewUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAddNewEmp = new javax.swing.JButton();
        txtEmpno = new javax.swing.JTextField();
        txtEmpno2 = new javax.swing.JTextField();
        txtEmpno3 = new javax.swing.JTextField();
        txtEmpno4 = new javax.swing.JTextField();
        txtEmpno5 = new javax.swing.JPasswordField();
        txtEmpno6 = new javax.swing.JPasswordField();
        lblEmpnoError = new javax.swing.JLabel();
        lblEmpnoError2 = new javax.swing.JLabel();
        lblEmpnoError3 = new javax.swing.JLabel();
        lblEmpnoError4 = new javax.swing.JLabel();
        lblEmpnoError5 = new javax.swing.JLabel();
        lblEmpnoError6 = new javax.swing.JLabel();
        userAddingErrorLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        String[] userTypes = { "Admin", "Caretaker", "Patient", "Doctor" };
        userTypeSelect = new javax.swing.JComboBox<>(userTypes);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add New User");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Contact:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Emergency Contact:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Password:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Confirm Password:");

        btnAddNewEmp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewEmp.setText("Add");
        btnAddNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnAddNewEmpActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        txtEmpno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmpno2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmpno3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmpno4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno4ActionPerformed(evt);
            }
        });

        txtEmpno5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno5ActionPerformed(evt);
            }
        });

        txtEmpno6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno6ActionPerformed(evt);
            }
        });

        lblEmpnoError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError.setText("");

        lblEmpnoError2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError2.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError2.setText("");

        lblEmpnoError3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError3.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError3.setText("");

        lblEmpnoError4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError4.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError4.setText("");

        lblEmpnoError5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError5.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError5.setText("");

        lblEmpnoError6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError6.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError6.setText("");

        userAddingErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        userAddingErrorLabel.setText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("User Type:");

        userTypeSelect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userTypeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel9)
                        .addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel2)
                        .addComponent(jLabel7).addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userAddingErrorLabel)
                                        .addComponent(txtEmpno, javax.swing.GroupLayout.DEFAULT_SIZE, 381,
                                                Short.MAX_VALUE)
                                        .addComponent(txtEmpno2).addComponent(txtEmpno3).addComponent(txtEmpno4)
                                        .addComponent(txtEmpno5).addComponent(txtEmpno6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEmpnoError6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmpnoError2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmpnoError, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmpnoError3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmpnoError4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEmpnoError5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(userTypeSelect, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(479, 479, 479))))
                        .addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addComponent(jLabel1).addGap(0, 0,
                                0))))
                .addGroup(layout.createSequentialGroup().addGap(360, 360, 360).addComponent(btnAddNewEmp)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(30, 30, 30).addComponent(jLabel1).addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
                        .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmpnoError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
                        .addComponent(txtEmpno2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmpnoError2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEmpnoError3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5).addComponent(txtEmpno3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6)
                        .addComponent(txtEmpno4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmpnoError4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEmpnoError5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7).addComponent(txtEmpno5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblEmpnoError6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8).addComponent(txtEmpno6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
                        .addComponent(userTypeSelect, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userAddingErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18).addComponent(btnAddNewEmp).addGap(30, 30, 30)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewEmpActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {// GEN-FIRST:event_btnAddNewEmpActionPerformed
        // TODO add your handling code here:

        String name = txtEmpno.getText();
        String email = txtEmpno2.getText();
        String contact = txtEmpno3.getText();
        String emergencyContact = txtEmpno4.getText();
        String password = new String(txtEmpno5.getPassword());
        String confirmPassword = new String(txtEmpno6.getPassword());
        String userType = (String) userTypeSelect.getSelectedItem();

        // display error label that passwords do not match, and exit the event function
        if (!password.equals(confirmPassword)) {
            userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
            userAddingErrorLabel.setText("Passwords do not match!");
            return;
        }

        User user = null;
        if (userType.equals("Admin")) {
            user = new Admin(name, email, password, contact);
        }
        else if (userType.equals("Doctor")) {
            user = new Doctor(name, email, password, contact);
        }
        else if (userType.equals("Patient")) {
            user = new Patient(name, email, password, contact, emergencyContact);
        }
        else if (userType.equals("Caretaker")) {
            user = new Caretaker(name, email, password, contact);
        }
        else {
            System.out.println("Not a valid user type!");
        }
        try {
            int success = admin.addUser(user);
            if (success == 1){
                userAddingErrorLabel.setForeground(new java.awt.Color(0, 0, 255));
                userAddingErrorLabel.setText("Account created successfully!");
            }
            else {
                userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
                userAddingErrorLabel.setText("This email is already being used for another account.");
            }
        }
        catch (InputErrorException ex) {
            userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
            userAddingErrorLabel.setText(ex.getMessage());
        }
    }//GEN-LAST:event_btnAddNewEmpActionPerformed

    private void txtEmpno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno4ActionPerformed

    private void txtEmpno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno5ActionPerformed

    private void txtEmpno6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpno6ActionPerformed

    private void userTypeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeSelectActionPerformed
        // TODO add your handling code here:
        // String items[] = {"Patient", "Doctor", "Caretaker"};
        // for(int i = 0; i < items.length; ++i)
        //     userTypeSelect.addItem(items[i]);
    }//GEN-LAST:event_userTypeSelectActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewEmp;
    private javax.swing.JComboBox<String> userTypeSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblEmpnoError;
    private javax.swing.JLabel lblEmpnoError2;
    private javax.swing.JLabel lblEmpnoError3;
    private javax.swing.JLabel lblEmpnoError4;
    private javax.swing.JLabel lblEmpnoError5;
    private javax.swing.JLabel lblEmpnoError6;
    private javax.swing.JLabel userAddingErrorLabel;
    private javax.swing.JTextField txtEmpno;
    private javax.swing.JTextField txtEmpno2;
    private javax.swing.JTextField txtEmpno3;
    private javax.swing.JTextField txtEmpno4;
    private javax.swing.JPasswordField txtEmpno5;
    private javax.swing.JPasswordField txtEmpno6;
    private Admin admin;
    // End of variables declaration//GEN-END:variables
}