package accountManagement;

import recordManagement.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import healthcareDatabase.InputErrorException;
import healthcareDatabase.RecordsDatabaseCommunication;
import healthcareDatabase.UserNotFoundException;
import recordManagement.*;
public class Doctor extends User {
    private ArrayList<Record> records;
    private RecordsDatabaseCommunication db;
    private boolean recordListChanged = true;
    
    public Doctor(String name, String email, String password, String contact) {
        super(name, email, password, contact);
        records = new ArrayList<Record>();
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


    public void getRecordsList() throws SQLException {
        if (recordListChanged)
            records = db.getRecordList();
        // if the record list has not been changed since the last time the function is called, do not read again
        recordListChanged = false;
    }

    
    public int addRecord(Record record) throws SQLException {
        String RecordType = record.getClass().getSimpleName();

        // if Record is a patient, add an emergency contact as well
        try {
            db.addRecord(record.getPatientEmail(), record.getName(), record.getFrequency(), RecordType, record.getDateToTake());
            recordListChanged = true;
        } catch (InputErrorException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public int modifyRecord(Record currentRecord, Record newRecord) throws SQLException {
        String newRecordType = newRecord.getClass().getSimpleName();
        // if Record is a patient, modify emergency contact as well
        try {

            db.modifyRecord(currentRecord.getID(), currentRecord.getPatientEmail(), newRecord.getName(), newRecord.getFrequency(), newRecordType, newRecord.getDateToTake());
            recordListChanged = true;
        } catch (InputErrorException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public int deleteRecord(Record record) throws SQLException, UserNotFoundException {
        db.deleteRecord(record.getID());
        recordListChanged = true;
        return 1;

    }

    
}