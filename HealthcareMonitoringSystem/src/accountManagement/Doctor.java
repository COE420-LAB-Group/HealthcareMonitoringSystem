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
    private boolean recordListChanged = false;

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
        ArrayList<String[]> recordArray = db.getRecordList();
        Record record = null;
        ArrayList<Date> datesarray;
        // if the user list has not been changed since the last time the function is called, return
        if (!recordListChanged)
            return;
        for (int i = 0; i < recordArray.size(); i++) {
            String recordType = recordArray.get(i)[6]; // double-check this

            if (recordType.equals("Prescription")) {
                datesarray.add(StringToDate( recordArray.get(i)[1]));
                record = new Prescription(recordArray.get(i)[0], datesarray, recordArray.get(i)[2],Boolean.parseBoolean( recordArray.get(i)[3]), Integer.parseInt(recordArray.get(i)[4]),  Integer.parseInt(recordArray.get(i)[5]));
            }
            else if (recordType.equals("Vital")) {
                datesarray.add(StringToDate( recordArray.get(i)[1]));
                record = new Vital(recordArray.get(i)[0], datesarray, recordArray.get(i)[2],Boolean.parseBoolean( recordArray.get(i)[3]), Integer.parseInt(recordArray.get(i)[4]),  Integer.parseInt(recordArray.get(i)[5]));
            else {
                System.out.println("Not a valid user type!");
            }
            records.add(record);
        }
        recordListChanged = false;
    }
    public int addRecord(Record record) throws SQLException {
        String RecordType = record.getClass().getSimpleName();

        // if Record is a patient, add an emergency contact as well
        try {
            db.addRecord(record.getPatientEmail(), record.getName(), record.getFrequency(), RecordType);
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

            db.modifyRecord(currentRecord.getID(), currentRecord.getName(), newRecord.getPatientEmail(), newRecord.getName(), newRecord.getFrequency(), newRecordType);
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