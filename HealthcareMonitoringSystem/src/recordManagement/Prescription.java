package recordManagement;

import java.util.ArrayList;
import java.util.Date;

public class Prescription extends Record {
    private double reading = -1;

    public Prescription(String name, Date dateToTake, String patientEmail, boolean createdByPatientObject, int frequency, int ID) {
        super(name, dateToTake, patientEmail, createdByPatientObject, frequency, ID);
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Prescription
        return 0;
    }
    
}