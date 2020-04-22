// package accountManagement;

// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Date;

// import healthcareDatabase.UserNotFoundException;
// import recordManagement.*;
// public class Driver {
//     public static void main(String[] args) throws SQLException, UserNotFoundException {
//         Account acc = new Account();
        
//         // login to all 4 different types of users from database to test
//         User patient = acc.validateUser("test8@gmail.com", "12345_");
//         User caretaker = acc.validateUser("test5@gmail.com", "1234");
//         User doctor = acc.validateUser("test@gmail.com", "1234");
//         User admin = acc.validateUser("test3@gmail.com", "1234");

//         ((Patient) patient).initializeDatabaseConnection();
//         ((Caretaker) caretaker).initializeDatabaseConnection();
//         ((Doctor) doctor).initializeDatabaseConnection();

//         // Admin and Doctor testing
//         // Doctor testing
//         ArrayList<Record> records = ((Doctor) doctor).getRecords();
//         System.out.println("The current record list: \n");
//         for (int i = 0; i<records.size(); i++)
//             System.out.println("ID: " + records.get(i).getID() + "\tName: " + records.get(i).getName() + "\t Email: " + records.get(i).getPatientEmail());
//         Record Med = new Prescription ("Cortisol", new Date(2020 - 1900, 04, 15), "test8@gmail.com", 1);
//         ((Doctor) doctor).addRecord(Med);
//         Med.setFrequency(3);
//         ((Doctor) doctor).modifyRecord(Med);
//         ((Doctor) doctor).deleteRecord(Med);
//         ArrayList<Record> rUpdated = ((Doctor) doctor).getRecords();
//         System.out.println("The current record list: \n");
//         for (int i = 0; i<rUpdated.size(); i++)
//             System.out.println("ID: " + rUpdated.get(i).getID() + "\tName: " + rUpdated.get(i).getName() + "\t Email: " + rUpdated.get(i).getPatientEmail());

//         // Admin testing
//         ArrayList<User> users = ((Admin) admin).getUserList();
//         System.out.println("The current User list: \n");
//         for (int i = 0; i<users.size(); i++)
//             System.out.println("Name: " + users.get(i).getName() + "\t Email: " + users.get(i).getEmail() + "\tType: " + users.get(i).getClass());
        
//         User Ismat = new Patient("Ismat Maarouf", "testo@gmail.com", "IamV/m1", "0521293992", "0563334432");
//         User babaKhawaja = new Caretaker("Ahmad Khawaja", "testOK@gmail.com", "IamV/m1", "0521293992");
//         User mamaKarima = new Caretaker("Karima HodrojRemmel", "testOA@gmail.com", "IamV/m1", "0521293993");
//         ((Admin) admin).addUser(Ismat);
//         ((Admin) admin).addUser(babaKhawaja);
//         ((Admin) admin).addUser(mamaKarima);
//         User Issam = new Patient("Issam Maarouf", "testo@gmail.com", "IamV/m1", "0521293992", "0563334432");
//         ((Admin) admin).modifyUser(Ismat, Issam);
//         ((Admin) admin).deleteUser(mamaKarima);
//         ((Admin) admin).linkUsers(Issam, babaKhawaja);
//         ArrayList<User> uUpdated = ((Admin) admin).getUserList();
//         System.out.println("The current User list: \n");
//         for (int i = 0; i<uUpdated.size(); i++)
//            System.out.println("Name: " + uUpdated.get(i).getName() + "\t Email: " + uUpdated.get(i).getEmail() + "\tType: " + uUpdated.get(i).getClass());


//         // Patient and Caretaker testing
//         ArrayList<Patient> caretakerPatientList = ((Caretaker) caretaker).getLinkedPatientList(); // gets all patients linked to patient
//         ArrayList<Caretaker> patientCaretakerList = ((Patient) patient).getCaretakers(); // gets all caretakers linked to patient
//         ArrayList<Record> patientRecordList = ((Patient) patient).getRecords(); // gets all records of the patient

//         for (int i = 0; i < patientRecordList.size(); i++) {
//             Record r = patientRecordList.get(i);
//             System.out.println(r.getPatientEmail() + "\t" + r.getName() + "\t");
//         }
//         System.out.println();
//         for (int i = 0; i < caretakerPatientList.size(); i++) {
//             User u = caretakerPatientList.get(i);
//             System.out.println(u.getName() + "\t" + u.getEmail() + "\t" + u.getClass().getSimpleName());
//         }
//         System.out.println();
//         for (int i = 0; i < patientCaretakerList.size(); i++) {
//             User u = patientCaretakerList.get(i);
//             System.out.println(u.getName() + "\t" + u.getEmail() + "\t" + u.getClass().getSimpleName());
//         }
//         ((Patient) patient).insertReading(patientRecordList.get(0), 42.01); // inserts a reading for a vital
//     }
// }