package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import healthcareDatabase.UserNotFoundException;

public class Driver {
    public static void main(String[] args) throws SQLException, UserNotFoundException {
        Account acc = new Account();
        User user = acc.validateUser("test3@gmail.com", "1234");

        ((Admin) user).getUserList();
        ArrayList<User> userList = ((Admin) user).userList;

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println(u.getEmail());
        }

        ((Admin) user).addUser(new Patient("Saif AlNajjar", "test6@gmail.com", "12345_", "0521112224", "0501234567"));

        ((Admin) user).getUserList();
        userList = ((Admin) user).userList;

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println(u.getEmail());
        }

       // ((Admin) user).deleteUser(new Patient("Saif AlNajjar", "test6@gmail.com", "12345_", "0521112224", "0501234567"));
    }
}