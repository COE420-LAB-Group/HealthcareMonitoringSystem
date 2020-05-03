package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.RecordsDatabaseCommunication;
import healthcareDatabase.UserDatabaseCommunication;
import recordManagement.*;

public class Patient extends User {
	private ArrayList<Record> records;
	private String emergencyContact;
	private ArrayList<Caretaker> caretakers;
	private RecordsDatabaseCommunication dbRecords;
	private UserDatabaseCommunication dbUsers;
	private boolean CaretakerListChanged, recordsListRead;

	public Patient(String name, String email, String password, String contact, String emergencyContact)
			throws SQLException {
		super(name, email, password, contact);
		this.emergencyContact = emergencyContact;
		CaretakerListChanged = true;
		recordsListRead = true;
		caretakers = new ArrayList<Caretaker>();
	}
	
	// this function must be called to connect user to database and to read records list and caretakers list
	public void initializeDatabaseConnection() throws SQLException {
		this.dbRecords = new RecordsDatabaseCommunication("admin", "coe420project");
		this.dbUsers = new UserDatabaseCommunication("admin", "coe420project");
		getLinkedCaretakerList(); // puts caretakers from database into the caretakers ArrayList
		this.records = dbRecords.getPatientRecordList(this.email);
	}

	public void closeDatabaseConnection() throws SQLException {
		dbRecords.closeDatabaseConnection();
		dbUsers.closeDatabaseConnection();
	}

    public ArrayList<Caretaker> getLinkedCaretakerList() throws SQLException {
        ArrayList<String[]> CaretakerArray = dbUsers.getLinkedCaretakerList(this.email);
        Caretaker user = null;
        // if the user list has not been changed since the last time the function is called, return
        if (!CaretakerListChanged)
			return this.caretakers;
		caretakers = new ArrayList<Caretaker>();
        for (int i = 0; i < CaretakerArray.size(); i++) {
            user = new Caretaker(CaretakerArray.get(i)[0], CaretakerArray.get(i)[1], CaretakerArray.get(i)[2], CaretakerArray.get(i)[3]);
            caretakers.add(user);
        }
			CaretakerListChanged = false;
			return this.caretakers;
		}

	public ArrayList<Record> getRecords() throws SQLException {
		if (recordsListRead) {
			this.records = dbRecords.getPatientRecordList(this.email);
			recordsListRead = false;
		}
		return this.records;
	}
	
	public int insertReading(Record r, double reading) throws SQLException {
		((Vital) r).setReading(reading);
		return dbRecords.insertReading(r.getID(), r.getPatientEmail(), reading);
	}

	public int insertReading(int id, String patientEmail, double reading) throws SQLException {
		return dbRecords.insertReading(id, patientEmail, reading);
	}

	public ArrayList<Caretaker> getCaretakers() {
		return this.caretakers;
	}

	public String getEmergencyContact() {
		return this.emergencyContact;
	}
}