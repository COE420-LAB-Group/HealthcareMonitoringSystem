package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.UserDatabaseCommunication;

public class Caretaker extends User {
    private ArrayList<Patient> patients;
    private boolean hasPermission;
    private UserDatabaseCommunication db;
    private boolean patientListChanged;

    public Caretaker(String name, String email, String password, String contact) throws SQLException {
        super(name, email, password, contact);
        patients = new ArrayList<Patient>();
        hasPermission = false;
        patientListChanged = true;
    }

    public boolean getHasPermission() {
        return this.hasPermission;
    }

    public void getHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }


    public void initializeDatabaseConnection() throws SQLException {
		db = new UserDatabaseCommunication("admin", "coe420project");
	}

    public ArrayList<Patient> getLinkedPatientList() throws SQLException {
        ArrayList<String[]> patientArray = db.getLinkedPatientList(this.email);
        Patient user = null;
        // if the user list has not been changed since the last time the function is called, return
        if (!patientListChanged)
            return this.patients;
        for (int i = 0; i < patientArray.size(); i++) {
            user = new Patient(patientArray.get(i)[0], patientArray.get(i)[1], patientArray.get(i)[2], patientArray.get(i)[3], patientArray.get(i)[5]);
            patients.add(user);

        }
            patientListChanged = false;
        return this.patients;
        }
    
	public boolean doesHavePermission() {
		return hasPermission;
	}
	public void setHasPermission(boolean hasPermission) {
		this.hasPermission = hasPermission;
	}
}