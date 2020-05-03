package recordManagement;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Calendar;
import java.text.*;
public abstract class Record implements Runnable {
    protected String name;
    protected Calendar calendar = Calendar.getInstance();
    protected Date startDateTime;
    protected String patientEmail;
    protected String daysRepeating;
    protected boolean createdByPatientObject;
    protected int TID, intervals;
    protected int ID;

    public void run() {
        while(true) {
            boolean checkIfDatePassed = checkDate();
            if (checkIfDatePassed) {
                // notify user
                JPanel panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "take medication");
                // Date newDateTime = getNextDate();
               // startDateTime = newDateTime;
            }
        }

    }

    // public Date getNextDate() {
    //     for (int i = 0; i < daysRepeating.length(); i++) {
    //     }
    // }

    public Date getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getDaysRepeating() {
        return this.daysRepeating;
    }

    public void setDaysRepeating(String daysRepeating) {
        this.daysRepeating = daysRepeating;
    }

    public boolean getCreatedByPatientObject() {
        return this.createdByPatientObject;
    }


    public int getTID() {
        return this.TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getIntervals() {
        return this.intervals;
    }

    public void setIntervals(int intervals) {
        this.intervals = intervals;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public boolean checkDate() {
        Date currentDateTime = calendar.getTime();
        if (currentDateTime.before(startDateTime))
            return true;
        return false;
    }
    // public Date getDateToTake() {
    //     return this.dateToTake;
    // }

    // public void setDateToTake(Date dateToTake) {
    //     this.dateToTake = dateToTake;
    // }

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

    public Record(String name, Date startDateTime, String patientEmail, String daysRepeating, boolean createdByPatientObject, int TID, int intervals, int ID) {
        System.out.println(ID);
        this.name = name;
        this.startDateTime = startDateTime;
        this.patientEmail = patientEmail;
        this.daysRepeating = daysRepeating;
        this.createdByPatientObject = createdByPatientObject;
        this.TID = TID;
        this.intervals = intervals;
        this.ID = ID;
    }

    // public Record(String name, Date dateToTake, String patientEmail, int frequency) {
    //     this.name = name;
    //     this.patientEmail = patientEmail;
    //     this.createdByPatientObject = true;
    //     this.frequency = frequency;
    //     this.ID = -1;
    //     this.dateToTake = dateToTake;
    // }

    //returns 1 if notifcation succesfully sent, -1 if failed
    protected abstract int sendNotification(); 
    //sets the name of the Record
    void setName() {
        
    }
}