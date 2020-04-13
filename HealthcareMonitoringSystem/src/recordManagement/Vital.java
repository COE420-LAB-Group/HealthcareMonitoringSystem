package recordManagement;

import java.util.ArrayList;
import java.util.Date;
import java.time.*;
public class Vital extends Record {
    public Vital(String name, ArrayList<Date> datesToTake, String patientEmail, boolean createdByPatientObject, int frequency, int ID) {
        super(name, datesToTake, patientEmail, createdByPatientObject, frequency, ID);
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Vital
        return 0;
    }
}