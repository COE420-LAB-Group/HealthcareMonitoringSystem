package healthcaregui;

import accountManagement.Doctor;
import healthcareDatabase.UserNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import recordManagement.Prescription;
import recordManagement.Record;
import recordManagement.Vital;

public class UpdateDeletePatientRecords extends javax.swing.JFrame {

    private Doctor doctor;
    int recordIndex;
    private ArrayList<Record> recordList;
    private Record newrecord;

    /**
     * Creates new form UpdateDeletePatientRecords
     */
    public UpdateDeletePatientRecords() {
        initComponents();
    }

    public UpdateDeletePatientRecords(Doctor doctor) {
        this.doctor = doctor;
        try {
            doctor.initializeDatabaseConnection();
            recordList = doctor.getRecords();
            recordIndex = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initComponents();
        String items[] = { "Vital", "Prescription" };
        for (int i = 0; i < items.length; ++i)
            cmbMgr.addItem(items[i]);
        String times[] = { "1 hour", "2 hours", "3 hours", "4 hours", "5 hours", "6 hours" };
        for (int i = 0; i < times.length; ++i)
            cmbMgr1.addItem(times[i]);

        changeValuesInGUI(0);
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
        txtEmpno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmpno1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbMgr = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEmpno2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmpno3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        prevButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        cmbMgr1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Update/Delete Patient Records");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Patient Email:");

        txtEmpno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Record Name:");

        txtEmpno1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Record Type:");

        cmbMgr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbMgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMgrActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Times in a Day:");

        txtEmpno2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Start Time:");

        txtEmpno3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpno3ActionPerformed(evt);
            }
        });

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

        prevButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        prevButton.setText("<<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nextButton.setText(">>");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        cmbMgr1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbMgr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMgr1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(140, 140, 140)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4).addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEmpno2, javax.swing.GroupLayout.PREFERRED_SIZE, 317,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEmpno3, javax.swing.GroupLayout.PREFERRED_SIZE, 317,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup().addGap(150, 150, 150)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3).addComponent(jLabel2).addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, 316,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEmpno1, javax.swing.GroupLayout.PREFERRED_SIZE, 316,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cmbMgr, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup().addGap(152, 152, 152)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel5).addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbMgr1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jRadioButton2).addComponent(jRadioButton1)
                                                .addComponent(jRadioButton3).addComponent(jRadioButton4)
                                                .addComponent(jRadioButton5).addComponent(jRadioButton6)
                                                .addComponent(jRadioButton7)))
                                .addGroup(layout.createSequentialGroup().addGap(163, 163, 163).addComponent(prevButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nextButton))
                                .addGroup(layout.createSequentialGroup().addGap(79, 79, 79).addComponent(jLabel1)))
                        .addContainerGap(88, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(32, 32, 32).addComponent(jLabel1).addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2)
                        .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
                        .addComponent(txtEmpno1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9)
                        .addComponent(cmbMgr, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4)
                        .addComponent(txtEmpno2, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7)
                        .addComponent(txtEmpno3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5)
                        .addComponent(cmbMgr1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6)
                        .addGroup(layout.createSequentialGroup().addComponent(jRadioButton1)
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
                                .addComponent(jRadioButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateButton).addComponent(deleteButton).addComponent(nextButton)
                        .addComponent(prevButton))
                .addGap(55, 55, 55)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpnoActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void txtEmpno1ActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void cmbMgrActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void txtEmpno2ActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void txtEmpno3ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (recordIndex != 0)
            recordIndex--;
        else
            recordIndex = recordList.size() - 1;
        changeValuesInGUI(recordIndex);
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String daysrepeat = "";
        String recordType = (String) cmbMgr.getSelectedItem();
        if (jRadioButton1.isSelected())
            daysrepeat += 'U';
        if (jRadioButton2.isSelected())
            daysrepeat += 'M';
        if (jRadioButton3.isSelected())
            daysrepeat += 'T';
        if (jRadioButton4.isSelected())
            daysrepeat += 'W';
        if (jRadioButton5.isSelected())
            daysrepeat += 'R';
        if (jRadioButton6.isSelected())
            daysrepeat += 'F';
        if (jRadioButton7.isSelected())
            daysrepeat += 'S';
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(txtEmpno3.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AddNewPatientRecords.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (recordType.equals("Vital"))
            newrecord = new Vital(txtEmpno1.getText(), date, txtEmpno.getText(), daysrepeat, false,
                    Integer.parseInt(txtEmpno2.getText()),
                    Character.getNumericValue(((String) cmbMgr1.getSelectedItem()).charAt(0)), recordList.get(recordIndex).getID(), ((Vital) recordList.get(recordIndex)).getReading());
        else
            newrecord = new Prescription(txtEmpno1.getText(), date, txtEmpno.getText(), daysrepeat, false,
                    Integer.parseInt(txtEmpno2.getText()),
                    Character.getNumericValue(((String) cmbMgr1.getSelectedItem()).charAt(0)), recordList.get(recordIndex).getID());

        try {
            doctor.modifyRecord(newrecord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
        try {
            doctor.deleteRecord(recordList.get(recordIndex));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }                                            

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(recordIndex != (recordList.size()-1))
            recordIndex++;
        else
            recordIndex = 0;
        changeValuesInGUI(recordIndex);
    }//GEN-LAST:event_nextButtonActionPerformed
    
    private void changeValuesInGUI(int index)
    {
        txtEmpno.setText(recordList.get(index).getPatientEmail());
        txtEmpno1.setText(recordList.get(index).getName());
        txtEmpno2.setText(Integer.toString(recordList.get(index).getTID()));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        txtEmpno3.setText(dateFormat.format(recordList.get(index).getStartDateTime()));
        cmbMgr.setSelectedItem(recordList.get(index).getClass().getSimpleName());
        int intervals = recordList.get(index).getIntervals();
        if (intervals == 1)
            cmbMgr1.setSelectedItem(Integer.toString(intervals) + " hour");
        else
            cmbMgr1.setSelectedItem(Integer.toString(intervals) + " hours");
        String days = recordList.get(index).getDaysRepeating();
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        jRadioButton5.setSelected(false);
        jRadioButton6.setSelected(false);
        jRadioButton7.setSelected(false);
        for(int i = 0; i < days.length(); ++i)
        {
            if(days.charAt(i) == 'U')
                jRadioButton1.setSelected(true); 
            if(days.charAt(i) == 'M')
                jRadioButton2.setSelected(true);
            if(days.charAt(i) == 'T')
                jRadioButton3.setSelected(true);
            if(days.charAt(i) == 'W')
                jRadioButton4.setSelected(true);
            if(days.charAt(i) == 'R')
                jRadioButton5.setSelected(true);
            if(days.charAt(i) == 'F')
                jRadioButton6.setSelected(true);
            if(days.charAt(i) == 'S')
                jRadioButton7.setSelected(true);
        }
    }
  
    private void cmbMgr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMgr1ActionPerformed
    }//GEN-LAST:event_cmbMgr1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbMgr;
    private javax.swing.JComboBox<String> cmbMgr1;
    private javax.swing.JButton deleteButton;
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
    private javax.swing.JButton nextButton;
    private javax.swing.JButton prevButton;
    private javax.swing.JTextField txtEmpno;
    private javax.swing.JTextField txtEmpno1;
    private javax.swing.JTextField txtEmpno2;
    private javax.swing.JTextField txtEmpno3;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
