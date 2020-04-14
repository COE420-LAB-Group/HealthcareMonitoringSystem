package recordManagement;

import java.util.ArrayList;
import java.util.Date;
import java.time.*;
public class Vital extends Record {
    double readings;
    public Vital(String name, Date datesToTake, String patientEmail, boolean createdByPatientObject, int frequency, int ID, double readings) {
        super(name, datesToTake, patientEmail, createdByPatientObject, frequency, ID);
        this.readings = readings;
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Vital
        return 0;
    }
}