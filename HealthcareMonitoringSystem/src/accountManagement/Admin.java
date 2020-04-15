package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.*;

public class Admin extends User {
    UserDatabaseCommunication db;
    ArrayList<User> userList;
    boolean userListChanged;

    public Admin(String name, String email, String password, String contact) throws SQLException {
        super(name, email, password, contact);
        db = new UserDatabaseCommunication("admin", "coe420project");
        userListChanged = true;
    }
    
    // loads list of all users from database
    public ArrayList<User> getUserList() throws SQLException {
        ArrayList<String[]> userArray = db.getUserList();
        User user = null;
        userList = new ArrayList<User>();

        // if the user list has not been changed since the last time the function is called, return
        if (!userListChanged)
            return this.userList;
        for (int i = 0; i < userArray.size(); i++) {
            String userType = userArray.get(i)[4];

            if (userType.equals("Admin")) {
                user = new Admin(userArray.get(i)[0], userArray.get(i)[1], userArray.get(i)[2], userArray.get(i)[3]);
            }
            else if (userType.equals("Doctor")) {
                user = new Doctor(userArray.get(i)[0], userArray.get(i)[1], userArray.get(i)[2], userArray.get(i)[3]);
            }
            else if (userType.equals("Patient")) {
                user = new Patient(userArray.get(i)[0], userArray.get(i)[1], userArray.get(i)[2], userArray.get(i)[3], userArray.get(i)[5]);
            }
            else if (userType.equals("Caretaker")) {
                user = new Caretaker(userArray.get(i)[0], userArray.get(i)[1], userArray.get(i)[2], userArray.get(i)[3]);
            }
            else {
                System.out.println("Not a valid user type!");
            }

            userList.add(user);
        }
        userListChanged = false;
        return this.userList;
    }


    public int addUser(User user) throws SQLException {
        String userType = user.getClass().getSimpleName();

        // if user is a patient, add an emergency contact as well
        try {
            if (userType.equals("Patient")) {
                String emergencyContact = ((Patient) user).getEmergencyContact();
                db.addUser(user.getName(), user.getEmail(), user.getPassword(), user.getContact(), userType, emergencyContact);
            }
            else {
                db.addUser(user.getName(), user.getEmail(), user.getPassword(), user.getContact(), userType, "");
            }

            userListChanged = true;
        }
        catch (InputErrorException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    
    public int modifyUser(User currentUser, User newUser) throws SQLException {
        String newUserType = newUser.getClass().getSimpleName();
        // if user is a patient, modify emergency contact as well
        try {
            if (newUserType.equals("Patient")) {
                String emergencyContact = ((Patient) newUser).getEmergencyContact();
                db.modifyUser(currentUser.getEmail(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getContact(), newUserType, emergencyContact);
            }
            else {
                db.modifyUser(currentUser.getEmail(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getContact(), newUserType, "");
            }
            userListChanged = true;
        }
        catch (InputErrorException | UserNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
            return 0;
    }

    public int deleteUser(User user) throws SQLException {
        try {
            db.deleteUser(user.getEmail());
            userListChanged = true;
            return 1;
        }
        catch (UserNotFoundException exception) {
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    public void linkUsers(User patient, User caretaker) throws SQLException {
        db.linkPatientAndCaretaker(patient.getEmail(), caretaker.getEmail()); 
    }

}