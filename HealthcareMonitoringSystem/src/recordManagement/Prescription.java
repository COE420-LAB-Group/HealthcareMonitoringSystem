package recordManagement;

public class Prescription extends Record {
    private double reading = -1;
    
    public Prescription(String name, String patientEmail) {
        super(name, patientEmail);
    }

    @Override
    protected int sendNotification() { 
        // implement notification sending for Prescription
        return 0;
    }
    
}