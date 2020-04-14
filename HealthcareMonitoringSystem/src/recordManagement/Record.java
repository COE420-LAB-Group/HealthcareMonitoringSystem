package recordManagement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.time.*;
import java.text.*;
public abstract class Record {
    protected String name;
    protected Calendar calendar = Calendar.getInstance();
    protected Date dateToTake;
    protected String patientEmail;
    protected boolean createdByPatientObject;
    protected int frequency;
    protected int ID;

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    

    Date current = new Date();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Date getDateToTake() {
        return this.dateToTake;
    }

    public void setDateToTake(Date dateToTake) {
        this.dateToTake = dateToTake;
    }

    public String getPatientEmail() {
        return this.patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public boolean isCreatedByPatientObject() {
        return this.createdByPatientObject;
    }

    public void setCreatedByPatientObject(boolean createdByPatientObject) {
        this.createdByPatientObject = createdByPatientObject;
    }


    public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }
    
        catch(ParseException e){
            e.printStackTrace();
    
        }
        return result;
    }

    public Record(String name, Date dateToTake, String patientEmail, boolean createdByPatientObject, int frequency, int ID) {
        this.name = name;
        this.patientEmail = patientEmail;
        this.createdByPatientObject = true;
        this.frequency = frequency;
        this.ID = ID;
        this.dateToTake = dateToTake;
    }

    public boolean compareDate(Date d){
        System.out.println(current.toLocaleString());
        if (current.compareTo(d) == 0)
            return true;
        return false;
    }
    
    //returns 1 if notifcation succesfully sent, -1 if failed
    protected abstract int sendNotification(); 
    //sets the name of the Record
    void setName() {
        
    }
    // public static void main(String [] args){
    //    Prescription x = new Prescription ("n ", "n@n.n");
    //    while(true){
    //    Date d = x.StringToDate("2020-04-11 21:09:00");
    //           if(x.compareDate(d))
    //           System.out.println("Please take the medicine now");
        
    //    }
       
    }
