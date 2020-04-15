package recordManagement;

import java.util.Date;
public class Vital extends Record {
    double reading;
    
    public Vital(String name, Date datesToTake, String patientEmail, boolean createdByPatientObject, int frequency, int ID, double reading) {
        super(name, datesToTake, patientEmail, createdByPatientObject, frequency, ID);
        this.reading = reading;
    }

    public Vital(String name, Date dateToTake, String patientEmail, int frequency) {
        super(name, dateToTake, patientEmail, frequency);
        this.reading = -1;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Vital
        return 0;
    }
}