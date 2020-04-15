package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.UserNotFoundException;
import recordManagement.*;
public class Driver {
    public static void main(String[] args) throws SQLException, UserNotFoundException {
        Account acc = new Account();
        User patient = acc.validateUser("test8@gmail.com", "12345_");
        User caretaker = acc.validateUser("test5@gmail.com", "1234");
        User doctor = acc.validateUser("test@gmail.com", "1234");
        User admin = acc.validateUser("test3@gmail.com", "1234");

        ((Patient) patient).initializeDatabaseConnection();
        ((Caretaker) caretaker).initializeDatabaseConnection();
        ((Doctor) doctor).initializeDatabaseConnection();

        ArrayList<Patient> caretakerPatientList = ((Caretaker) caretaker).getPatients(); // gets all patients linked to patient
        ArrayList<Caretaker> patientCaretakerList = ((Patient) patient).getCaretakers(); // gets all caretakers linked to patient
        ArrayList<Record> patientRecordList = ((Patient) patient).getRecords(); // gets all records of the patient
        ArrayList<Record> allRecordList = ((Doctor) doctor).getRecords(); // gets all records in the database

        for (int i = 0; i < patientRecordList.size(); i++) {
            Record r = patientRecordList.get(i);
            System.out.println(r.getPatientEmail() + "\t" + r.getName() + "\t");
        }
        System.out.println();
        for (int i = 0; i < allRecordList.size(); i++) {
            Record r = patientRecordList.get(i);
            System.out.println(r.getPatientEmail() + "\t" + r.getName());
        }
        System.out.println();
        for (int i = 0; i < caretakerPatientList.size(); i++) {
            User u = caretakerPatientList.get(i);
            System.out.println(u.getName() + "\t" + u.getEmail() + "\t" + u.getClass().getSimpleName());
        }
        System.out.println();
        for (int i = 0; i < patientCaretakerList.size(); i++) {
            User u = patientCaretakerList.get(i);
            System.out.println(u.getName() + "\t" + u.getEmail() + "\t" + u.getClass().getSimpleName());
        }
        ((Patient) patient).insertReading(patientRecordList.get(0), 60.2); // inserts a reading for a vital
        // ((Admin) user).addUser(new Patient("Saif AlNajjar", "test6@gmail.com", "12345_", "0521112224", "0501234567"));
        // ((Admin) user).getUserList();
        // userList = ((Admin) user).userList;

        // for (int i = 0; i < userList.size(); i++) {
        //     User u = userList.get(i);
        //     System.out.println(u.getEmail());
        // }

       // ((Admin) user).deleteUser(new Patient("Saif AlNajjar", "test6@gmail.com", "12345_", "0521112224", "0501234567"));
    }
}