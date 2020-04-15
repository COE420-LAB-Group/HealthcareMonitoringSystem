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

        ((Patient) user).initializeDatabaseConnection();
        // ArrayList<Patient> userList = ((Caretaker) user).getPatients();
        ArrayList<Record> recordList = ((Patient) user).getRecords();

        // for (int i = 0; i < userList.size(); i++) {
        //     User u = userList.get(i);
        //     System.out.println(u.getEmail());
        // }
        for (int i = 0; i < recordList.size(); i++) {
            Record r = recordList.get(i);
            System.out.println(r.getID());
        }

        ((Patient) user).insertReading(recordList.get(0), 60.2);
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