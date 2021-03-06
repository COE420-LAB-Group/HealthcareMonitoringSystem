package accountManagement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import recordManagement.*;
import healthcareDatabase.InputErrorException;
import healthcareDatabase.RecordsDatabaseCommunication;
import healthcareDatabase.UserDatabaseCommunication;
import healthcareDatabase.UserNotFoundException;
public class Doctor extends User {
    private ArrayList<Record> records;
    private RecordsDatabaseCommunication db;
    private UserDatabaseCommunication userDb;
    private boolean recordListChanged = true;
    private boolean patientListChanged = true;
    private ArrayList<Patient> patientList;

    public Doctor(String name, String email, String password, String contact) {
        super(name, email, password, contact);
        records = new ArrayList<Record>();
        patientList = new ArrayList<Patient>();
    }
    public Date StringToDate(String s){
        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }
    
        catch(ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void initializeDatabaseConnection() throws SQLException {
        this.db = new RecordsDatabaseCommunication("admin", "coe420project");
        this.userDb = new UserDatabaseCommunication("admin", "coe420project");
    }

    public ArrayList<Record> getRecords() throws SQLException {
        if (recordListChanged)
            records = db.getRecordList();
            // if the record list has not been changed since the last time the function is called, do not read again
        recordListChanged = false;
        return this.records;
    }
    
    public int addRecord(Record record) throws SQLException {
        String recordType = record.getClass().getSimpleName();
        System.out.println(recordType);
        // if Record is a patient, add an emergency contact as well
        try {
            db.addRecord(record.getPatientEmail(), record.getName(), record.getTID(), recordType, record.getIntervals(), record.getStartDateTime(), record.getDaysRepeating());
            record.setID(db.getRecordID(record.getPatientEmail(), record.getName()));
            recordListChanged = true;
        } catch (InputErrorException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public int modifyRecord(Record newRecord) throws SQLException {
        String newRecordType = newRecord.getClass().getSimpleName();
        // if Record is a patient, modify emergency contact as well
        try {
            // new record's id is passed because the ID of a modified record does not change
            System.out.println(newRecord.getID());
            db.modifyRecord(newRecord.getID(), newRecord.getPatientEmail(), newRecord.getName(), newRecord.getTID(), newRecordType, newRecord.getIntervals(), newRecord.getStartDateTime(), newRecord.getDaysRepeating());
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

    public ArrayList<Patient> getPatientList() throws SQLException {
        ArrayList<String[]> patientArray = userDb.getPatientList();
        Patient patient = null;

        // if the user list has not been changed since the last time the function is called, return
        if (!patientListChanged)
            return this.patientList;

        patientList = new ArrayList<Patient>();
        for (int i = 0; i < patientArray.size(); i++) {
            patient = new Patient(patientArray.get(i)[0], patientArray.get(i)[1], patientArray.get(i)[2], patientArray.get(i)[3], patientArray.get(i)[5]);
            patientList.add(patient);
        }

        patientListChanged = false;
        return this.patientList;
    }
    
}