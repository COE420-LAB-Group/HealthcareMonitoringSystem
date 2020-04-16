package accountManagement;

import java.sql.SQLException;
import healthcareDatabase.UserDatabaseCommunication;
import healthcareDatabase.UserNotFoundException;


public class Account {
    private User user;
    private UserDatabaseCommunication db;

    public Account() throws SQLException {
        db = new UserDatabaseCommunication("admin", "coe420project");
    }

    public Account(User user) throws SQLException {
        this.user = user;
        db = new UserDatabaseCommunication("admin", "coe420project");
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
    }

    public User validateUser(String email, String password) throws SQLException, UserNotFoundException { // change return type to user
        // do validation of user, if validated create User
        // type of user created depends on type in database
        // after creating User with correct type, return it
        String[] userInfo = db.validateUser(email, password);
        // index [0] = name, [1] = email, [2] = password, [3] = contact, [4] = userType
        // If userType is a patient, [5] is emergency contact
        if (userInfo.length == 0) {
            System.out.println("User not found!");
        }
        String userType = userInfo[4];
        if (userType.equals("Admin")) {
            user = new Admin(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        else if (userType.equals("Doctor")) {
            user = new Doctor(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        else if (userType.equals("Patient")) {
            user = new Patient(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[5]);
        }
        else if (userType.equals("Caretaker")) {
            user = new Caretaker(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        else {
            System.out.println("Not a valid user type!");
        }
        return user;
        
    }
}