package recordManagement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.time.*;
import java.text.*;
public abstract class Record {
    protected String name;
    protected Calendar calendar = Calendar.getInstance();
    protected ArrayList<Date> datesToTake;
    protected String patientEmail;
    protected boolean createdByPatientObject;
    Date current = new Date();

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


    public Record(String name, String patientEmail) {
        this.name = name;
        this.patientEmail = patientEmail;
        datesToTake = new ArrayList<Date>();
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
    public static void main(String [] args){
       Prescription x = new Prescription ("n ", "n@n.n");
       while(true){
       Date d = x.StringToDate("2020-04-11 21:09:00");
              if(x.compareDate(d))
              System.out.println("Please take the medicine now");
        
       }
       
    }
}
