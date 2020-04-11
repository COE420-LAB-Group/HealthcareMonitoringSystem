package accountManagement;
import java.util.ArrayList;
import recordManagement.*;  

public class Patient extends User {
    private ArrayList<Record> records;
	private String emergencyContact;
	private Caretaker caretakers[];

    public Patient(String name, String email, String password, String contact, String emergencyContact) {
		super(name, email, password, contact);
		this.emergencyContact = emergencyContact;
        records = new ArrayList<Record>();
    }

	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
}