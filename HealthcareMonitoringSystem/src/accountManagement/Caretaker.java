package accountManagement;
import java.util.ArrayList;

public class Caretaker extends User {
    private ArrayList<Patient> patients;
    private boolean hasPermission;
    
    public Caretaker(String name, String email, String password, String contact) {
        super(name, email, password, contact);
        patients = new ArrayList<Patient>();
        hasPermission = false;
    }

	public boolean doesHavePermission() {
		return hasPermission;
	}
	public void setHasPermission(boolean hasPermission) {
		this.hasPermission = hasPermission;
	}
}