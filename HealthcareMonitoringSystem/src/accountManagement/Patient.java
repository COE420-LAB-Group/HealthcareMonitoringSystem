package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.UserDatabaseCommunication;
import recordManagement.*;

public class Patient extends User {
	private ArrayList<Record> records;
	private String emergencyContact;
	private ArrayList<Caretaker> caretakers;
	private UserDatabaseCommunication db;
	private boolean CaretakerListChanged;

	public Patient(String name, String email, String password, String contact, String emergencyContact)
			throws SQLException {
		super(name, email, password, contact);
		this.emergencyContact = emergencyContact;
		records = new ArrayList<Record>();
		caretakers = new ArrayList<Caretaker>();
		db = new UserDatabaseCommunication("admin", "coe420project");
        CaretakerListChanged = true;
    }
    public void getLinkedPatientList() throws SQLException {
        ArrayList<String[]> CaretakerArray = db.getLinkedCaretakerList(this.email);
        Caretaker user = null;
        // if the user list has not been changed since the last time the function is called, return
        if (!CaretakerListChanged)
            return;
        for (int i = 0; i < CaretakerArray.size(); i++) {
            user = new Caretaker(CaretakerArray.get(i)[0], CaretakerArray.get(i)[1], CaretakerArray.get(i)[2], CaretakerArray.get(i)[3]);
            caretakers.add(user);

        }
            CaretakerListChanged = false;
        }
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
}