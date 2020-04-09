package recordManagement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.time.*;

public abstract class Record {
    protected String name;
    protected Calendar calendar = Calendar.getInstance();
    protected ArrayList<Date> datesToTake;
    protected String patientEmail;

    public Record(String name, String patientEmail) {
        this.name = name;
        this.patientEmail = patientEmail;
        datesToTake = new ArrayList<Date>();
    }
    //returns 1 if notifcation succesfully sent, -1 if failed
    protected abstract int sendNotification(); 
    //sets the name of the Record
    void setName() {
        
    }
}