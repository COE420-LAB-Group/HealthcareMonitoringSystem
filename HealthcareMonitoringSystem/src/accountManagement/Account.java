package accountManagement;

import java.sql.SQLException;

import healthcareDatabase.DatabaseCommunication;

public class Account {
    private User user;
    private DatabaseCommunication comm;

    Account() throws SQLException {
        comm = new DatabaseCommunication("system", "coe420project");
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
    }
    
    public User validateUser(String email, String password) throws SQLException { // change return type to user
        // do validation of user, if validated create User
        // type of user created depends on type in database
        // after creating User with correct type, return it
        String[] userInfo = comm.validateUser(email, password);
        // index [0] = name, [1] = email, [2] = password, [3] = contact, [4] = userType
        // If userType is a patient, [5] is emergency contact
        String userType = userInfo[4];

        if (userType == "Admin") {
            user = new Admin(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        else if (userType == "Doctor") {
            user = new Doctor(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        else if (userType == "Patient") {
            user = new Patient(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[5]);
        }
        else if (userType == "Caretaker") {
            user = new Caretaker(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
        }
        return user;
        
    }
}