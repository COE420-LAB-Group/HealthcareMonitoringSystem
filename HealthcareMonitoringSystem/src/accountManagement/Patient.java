package accountManagement;
import java.util.ArrayList;
import recordManagement.*;  

public class Patient extends User {
    private ArrayList<Record> records;
    
    public Patient(String name, String email, String password, String contact) {
        super(name, email, password, contact);
        records = new ArrayList<Record>();
    }

	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	private Caretaker caretakers[];
    private String emergencyContact;
}