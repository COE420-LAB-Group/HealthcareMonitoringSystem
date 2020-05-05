package healthcaregui;

import java.sql.SQLException;
import java.util.ArrayList;
import accountManagement.Admin;
import accountManagement.Caretaker;
import accountManagement.Doctor;
import accountManagement.Patient;
import accountManagement.User;
import healthcareDatabase.InputErrorException;


public class UpdateDeleteUser extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDeleteUser
     */
    public UpdateDeleteUser() {
        initComponents();
    }

    public UpdateDeleteUser(Admin admin) {
        this.admin = admin;
        try {
            userList = admin.getUserList();
        } catch (SQLException e) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmpno = new javax.swing.JTextField(userList.get(index).getName());
        lblEmpnoError = new javax.swing.JLabel();
        txtEmpno2 = new javax.swing.JTextField(userList.get(index).getEmail());
        jLabel4 = new javax.swing.JLabel();
        lblEmpnoError2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmpno3 = new javax.swing.JTextField(userList.get(index).getContact());
        lblEmpnoError3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        String userType = userList.get(index).getClass().getSimpleName(); // gets the type of user
        String emergencyContact = "";
        if (userType.equals("Patient"))
            emergencyContact = ((Patient) userList.get(index)).getEmergencyContact(); // Gets the patient's emergency contact
        txtEmpno4 = new javax.swing.JTextField(emergencyContact);
        lblEmpnoError4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmpno5 = new javax.swing.JPasswordField(userList.get(index).getPassword());
        lblEmpnoError5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmpno6 = new javax.swing.JPasswordField();
        lblEmpnoError6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmpno7 = new javax.swing.JPasswordField();
        lblEmpnoError7 = new javax.swing.JLabel();
        userAddingErrorLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        String[] userTypes = { "Admin", "Caretaker", "Patient", "Doctor" };
        userTypeSelect = new javax.swing.JComboBox<>(userTypes);
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        
        index = 0;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Update/Delete User");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient Name:");

        txtEmpno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblEmpnoError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError.setText("");

        txtEmpno2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Email:");

        lblEmpnoError2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError2.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError2.setText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Contact:");

        txtEmpno3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Emergency Contact:");

        txtEmpno4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Old Password:");

        txtEmpno5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno5ActionPerformed(evt);
            }
        });

        lblEmpnoError5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmpnoError5.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError5.setText("");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("New Password:");

        txtEmpno6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno6ActionPerformed(evt);
            }
        });

        lblEmpnoError6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError6.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError6.setText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Confirm Password:");

        txtEmpno7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno7ActionPerformed(evt);
            }
        });

        lblEmpnoError7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError7.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError7.setText("");

        userAddingErrorLabel.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        userAddingErrorLabel.setText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("User Type:");

        userTypeSelect.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userTypeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeSelectActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    updateButtonActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    deleteButtonActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nextButton.setText(">>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        prevButton.setText("<<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmpno2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmpnoError3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(lblEmpnoError4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmpnoError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmpnoError2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userTypeSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(jLabel7))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                                        .addGap(2, 2, 2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userAddingErrorLabel)
                                    .addComponent(txtEmpno4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpno6, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpno7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpno5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmpno3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpnoError5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmpnoError7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmpnoError6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(prevButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton)))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmpno4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmpno5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmpno6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmpno7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(userTypeSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userAddingErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(nextButton)
                    .addComponent(prevButton))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno4ActionPerformed
    }//GEN-LAST:event_txtEmpno4ActionPerformed
    private void txtEmpno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno5ActionPerformed
    }//GEN-LAST:event_txtEmpno5ActionPerformed
    private void txtEmpno6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno6ActionPerformed
    }//GEN-LAST:event_txtEmpno6ActionPerformed
    private void txtEmpno7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpno7ActionPerformed
    }//GEN-LAST:event_txtEmpno7ActionPerformed
    private void userTypeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeSelectActionPerformed
    }//GEN-LAST:event_userTypeSelectActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        String name = txtEmpno.getText();
        String email = txtEmpno2.getText();
        String contact = txtEmpno3.getText();
        String emergencyContact = txtEmpno4.getText();
        String newPassword = new String(txtEmpno6.getPassword());
        String confirmPassword = new String(txtEmpno7.getPassword());
        String userType = (String) userTypeSelect.getSelectedItem();

        // display error label that passwords do not match, and exit the event function
        if (!newPassword.equals(confirmPassword)) {
            userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
            userAddingErrorLabel.setText("The new passwords do not match!");
            return;
        }  

        System.out.println(newPassword);
        if (newPassword.equals("")){
            newPassword = userList.get(index).getPassword();
            System.out.println(newPassword);
        }

        User user = null;
        if (userType.equals("Admin")) {
            user = new Admin(name, email, newPassword, contact);
        }
        else if (userType.equals("Doctor")) {
            user = new Doctor(name, email, newPassword, contact);
        }
        else if (userType.equals("Patient")) {
            user = new Patient(name, email, newPassword, contact, emergencyContact);
        }
        else if (userType.equals("Caretaker")) {
            user = new Caretaker(name, email, newPassword, contact);
        }
        else {
            System.out.println("Not a valid user type!");
        }

        try {
            int success = admin.modifyUser(userList.get(index), user);
            if (success == 1){
                userAddingErrorLabel.setForeground(new java.awt.Color(0, 0, 255));
                userAddingErrorLabel.setText("Account modified successfully!");
            }
            else {
                userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
                userAddingErrorLabel.setText("This user was not found!");
            }
        }
        catch (InputErrorException ex) {
            userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
            userAddingErrorLabel.setText(ex.getMessage());
        }
    }                                            

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        int success = admin.deleteUser(txtEmpno2.getText());
        if (success == 1) {
            userAddingErrorLabel.setForeground(new java.awt.Color(0, 0, 255));
            userAddingErrorLabel.setText("Account deleted successfully!");
        }
        else {
            userAddingErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
            userAddingErrorLabel.setText("This user was not found!");
        }
    }                                            

    private void changeUserInformationInTextField() {
        txtEmpno.setText(userList.get(index).getName());
        txtEmpno2.setText(userList.get(index).getEmail());
        txtEmpno3.setText(userList.get(index).getContact());

        String emergencyContact = "";
        String userType = userList.get(index).getClass().getSimpleName(); // gets the type of user
        if (userType.equals("Patient"))
            emergencyContact = ((Patient) userList.get(index)).getEmergencyContact(); // Gets the patient's emergency contact
        txtEmpno4.setText(emergencyContact);
        txtEmpno5.setText(userList.get(index).getPassword());
        userTypeSelect.setSelectedItem(userList.get(index).getClass().getSimpleName());
    }
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if (index >= userList.size() - 1)
            index = 0; // Go back to the first user if the last user is reached
        else
            index++;

        changeUserInformationInTextField();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        if (index <= 0)
            index = userList.size() - 1; // Go back to the last user if the first user is reached
        else
            index--;

        changeUserInformationInTextField();
    }//GEN-LAST:event_prevButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton updateButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JComboBox<String> userTypeSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel lblEmpnoError7;
    private javax.swing.JLabel userAddingErrorLabel;
    private javax.swing.JTextField txtEmpno;
    private javax.swing.JTextField txtEmpno2;
    private javax.swing.JTextField txtEmpno3;
    private javax.swing.JTextField txtEmpno4;
    private javax.swing.JPasswordField txtEmpno5;
    private javax.swing.JPasswordField txtEmpno6;
    private javax.swing.JPasswordField txtEmpno7;
    private Admin admin;
    private ArrayList<User> userList;
    private int index;
    // End of variables declaration//GEN-END:variables
}
