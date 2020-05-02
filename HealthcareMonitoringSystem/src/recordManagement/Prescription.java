package recordManagement;

import java.util.Date;

public class Prescription extends Record {
    public Prescription(String name, Date startDateTime, String patientEmail, String daysRepeating, boolean createdByPatientObject, int TID, int intervals, int ID) {
        super(name, startDateTime, patientEmail, daysRepeating, createdByPatientObject, TID, intervals, ID);
    }
    
    // public Prescription(String name, Date dateToTake, String patientEmail, int frequency) {
    //     super(name, dateToTake, patientEmail, frequency);
    // }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Prescription
        return 0;
    }
}