package recordManagement;

public class Vital extends Record {
    public Vital(String name, String patientEmail) {
        super(name, patientEmail);
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Vital
        return 0;
    }
}