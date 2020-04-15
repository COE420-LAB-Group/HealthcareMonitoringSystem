package recordManagement;

import java.util.Date;

public class Prescription extends Record {
    public Prescription(String name, Date dateToTake, String patientEmail, boolean createdByPatientObject, int frequency, int ID) {
        super(name, dateToTake, patientEmail, createdByPatientObject, frequency, ID);
    }
    
    public Prescription(String name, Date dateToTake, String patientEmail, int frequency) {
        super(name, dateToTake, patientEmail, frequency);
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Prescription
        return 0;
    }
}