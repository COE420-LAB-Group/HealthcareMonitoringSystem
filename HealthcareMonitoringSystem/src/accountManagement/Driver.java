package accountManagement;

import java.sql.SQLException;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws SQLException {
        Account acc = new Account();
        User user = acc.validateUser("test3@gmail.com", "1234");

        ((Admin) user).getUserList();
        ArrayList<User> userList = ((Admin) user).userList;

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println(u.getEmail());
        }

        ((Admin) user).addUser(new Caretaker("Saif AlNajjar", "test6@gmail.com", "1234", "0521112224"));

        ((Admin) user).getUserList();
        userList = ((Admin) user).userList;

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            System.out.println(u.getEmail());
        }

        ((Admin) user).deleteUser(new Caretaker("Saif AlNajjar", "test6@gmail.com", "1234", "0521112224"));
    }
}