package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.*;

public class Admin extends User {
    UserDatabaseCommunication db;
    ArrayList<User> userList;
    ArrayList<Patient> patientList;
    ArrayList<Caretaker> caretakerList;
    ArrayList<String[]> linkedUsersEmailList; // index 0 is patient email, index 1 is caretaker email
    boolean userListChanged, linkedUsersListChanged;

    public Admin(String name, String email, String password, String contact) throws SQLException {
        super(name, email, password, contact);
        db = new UserDatabaseCommunication("admin", "coe420project");
        userListChanged = true;
        linkedUsersListChanged = true;
        userList = new ArrayList<User>();
        patientList = new ArrayList<Patient>();
        caretakerList = new ArrayList<Caretaker>();
    }
    
    // YOU MUST CALL GETUSERLIST FIRST TO BE ABLE TO GET THE PATIENT LIST
    public ArrayList<Patient> getPatientList() {
        return this.patientList;
    }

    // YOU MUST CALL GETPATIENTLIST FIRST TO BE ABLE TO GET THE PATIENT LIST
    public ArrayList<Caretaker> getCaretakerList() {
        return this.caretakerList;
    }

    // loads list of all users from database
    public ArrayList<User> getUserList() throws SQLException {
        ArrayList<String[]> userArray = db.getUserList();
        User user = null;

        // if the user list has not been changed since the last time the function is called, return
        if (!userListChanged)
            return this.userList;

        userList = new ArrayList<User>();
        patientList = new ArrayList<Patient>();
        caretakerList = new ArrayList<Caretaker>();
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
                patientList.add((Patient) user);
            }
            else if (userType.equals("Caretaker")) {
                user = new Caretaker(userArray.get(i)[0], userArray.get(i)[1], userArray.get(i)[2], userArray.get(i)[3]);
                caretakerList.add((Caretaker) user);
            }
            else {
                System.out.println("Not a valid user type!");
            }

            userList.add(user);
        }
        userListChanged = false;
        return this.userList;
    }


    public int addUser(User user) throws SQLException, InputErrorException {
        String userType = user.getClass().getSimpleName();

        // if user is a patient, add an emergency contact as well
        int checkIfInDatabase;
        if (userType.equals("Patient")) {
            String emergencyContact = ((Patient) user).getEmergencyContact();
            checkIfInDatabase = db.addUser(user.getName(), user.getEmail(), user.getPassword(), user.getContact(), userType, emergencyContact);
        }
        else {
            checkIfInDatabase = db.addUser(user.getName(), user.getEmail(), user.getPassword(), user.getContact(), userType, "");
        }

        userListChanged = true;
        return checkIfInDatabase;
    }

    
    public int modifyUser(User currentUser, User newUser) throws SQLException, InputErrorException {
        String newUserType = newUser.getClass().getSimpleName();
        // if user is a patient, modify emergency contact as well
        int checkIfInDatabase;
        if (newUserType.equals("Patient")) {
            String emergencyContact = ((Patient) newUser).getEmergencyContact();
            checkIfInDatabase = db.modifyUser(currentUser.getEmail(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getContact(), newUserType, emergencyContact);
        }
        else {
            checkIfInDatabase = db.modifyUser(currentUser.getEmail(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getContact(), newUserType, "");
        }
        userListChanged = true;
        return checkIfInDatabase;
    }

    public int deleteUser(String email) throws SQLException {
        int checkIfInDatabase =  db.deleteUser(email);
        if (checkIfInDatabase == 1)
            userListChanged = true;
        return checkIfInDatabase;
    }

    public int linkUsers(String patientEmail, String caretakerEmail) throws SQLException {
        int checkIfInDatabase = db.linkPatientAndCaretaker(patientEmail, caretakerEmail); 
        if (checkIfInDatabase == 1)
            linkedUsersListChanged = true;
        return checkIfInDatabase;
    }

    public ArrayList<String[]> getAllLinkedUsersEmail() throws SQLException {
        if (linkedUsersListChanged)
            this.linkedUsersEmailList = db.getAllLinkedUsersEmail();
        return this.linkedUsersEmailList;
    }
}