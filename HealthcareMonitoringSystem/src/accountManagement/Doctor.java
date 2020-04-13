package accountManagement;

import recordManagement.*;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.InputErrorException;
import healthcareDatabase.RecordsDatabaseCommunication;
import healthcareDatabase.UserNotFoundException;

public class Doctor extends User {
    private ArrayList<Record> records;
    private RecordsDatabaseCommunication db;
    private boolean RecordListChanged = false;

    public Doctor(String name, String email, String password, String contact) {
        super(name, email, password, contact);
        records = new ArrayList<Record>();
    }

    public int addRecord(Record record) throws SQLException {
        String RecordType = record.getClass().getSimpleName();

        // if Record is a patient, add an emergency contact as well
        try {
            db.addRecord(record.getPatientEmail(), record.getName(), record.getFrequency(), RecordType);
            RecordListChanged = true;
        } catch (InputErrorException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public int modifyRecord(Record currentRecord, Record newRecord) throws SQLException {
        String newRecordType = newRecord.getClass().getSimpleName();
        // if Record is a patient, modify emergency contact as well
        try {

            db.modifyRecord(currentRecord.getPatientEmail(), currentRecord.getName(), newRecord.getPatientEmail(), newRecord.getName(), newRecord.getFrequency(), newRecordType);
            RecordListChanged = true;
        } catch (InputErrorException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public int deleteRecord(Record record) throws SQLException, UserNotFoundException {
        db.deleteRecord(record.getID());
        RecordListChanged = true;
        return 1;

    }

    
}