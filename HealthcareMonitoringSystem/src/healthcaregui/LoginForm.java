package healthcaregui;

import java.sql.SQLException;

import accountManagement.Account;
import accountManagement.User;
import healthcareDatabase.UserNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dubs2
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        try {
            initComponents();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {
        account = new Account();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        btnLogin2 = new javax.swing.JButton();
        btnLogin3 = new javax.swing.JButton();
        passwordMessage = new javax.swing.JLabel("");
        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Healthcare Monitoring Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Email:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }   
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsername1ActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnLoginActionPerformed(evt);
                } catch (SQLException | UserNotFoundException e) {
                    System.out.println("User not found!");
                    passwordMessage.setText("Incorrect Email/password combination");
                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                }
            }
        });

        btnLogin1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin1.setText("MenuP");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });

        btnLogin2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin2.setText("MenuD");
        btnLogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin2ActionPerformed(evt);
            }
        });

        btnLogin3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin3.setText("MenuC");
        btnLogin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1).addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPassword).addComponent(txtUsername))
                                .addGap(57, 57, 57))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE).addComponent(btnLogin)
                        // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnLogin1)
                        // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnLogin2)
                        // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnLogin3)
                        .addGap(78, 78, 78))
                .addGroup(layout.createSequentialGroup().addGap(140, 140, 140).addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(33, 33, 33).addComponent(jLabel3).addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                // .addComponent(btnLogin3).addComponent(btnLogin1).addComponent(btnLogin2)
                                .addComponent(btnLogin))
                        .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsername1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUsername1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtUsername1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, UserNotFoundException {// GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        /*Scanner in = new Scanner(System.in);
        String usertype = in.next();
        if (usertype.equals("A"))*/
        /*else if (usertype.equals("P"))
        new MenuP().setVisible(true);
        else if (usertype.equals("D"))
        new MenuD().setVisible(true);
        else if (usertype.equals("C"))
        new MenuC().setVisible(true);*/
        String email = txtUsername.getText();
        System.out.println(email);
        String password = txtPassword.getText();
        System.out.println(password);

        User user = account.validateUser(email, password);
        String userType = user.getClass().getSimpleName();

        if (userType.equals("Admin")) {
            new MenuA().setVisible(true);
        }
        else if (userType.equals("Doctor")) {
            new MenuD().setVisible(true);
        }
        else if (userType.equals("Patient")) {
            new MenuP().setVisible(true);
        }
        else if (userType.equals("Caretaker")) {
            new MenuC().setVisible(true);
        }
        else {
            System.out.println("Not a valid user type!");
        }
        this.dispose(); // remove this login from from memory
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin3ActionPerformed
        new MenuC().setVisible(true);
        this.dispose(); // remove this login from from memory
    }//GEN-LAST:event_btnLogin3ActionPerformed

    private void btnLogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin2ActionPerformed
        new MenuD().setVisible(true);
        this.dispose(); // remove this login from from memory
    }//GEN-LAST:event_btnLogin2ActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        // TODO add your handling code here:
        new MenuP().setVisible(true);
        this.dispose(); // remove this login from from memory
    }//GEN-LAST:event_btnLogin1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btnLogin2;
    private javax.swing.JButton btnLogin3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtPassword;
    private Account account;
    private javax.swing.JLabel passwordMessage;
    // End of variables declaration//GEN-END:variables
}
