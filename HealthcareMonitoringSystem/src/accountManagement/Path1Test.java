package accountManagement;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import healthcareDatabase.InputErrorException;
import healthcareDatabase.UserNotFoundException;

public class Path1Test {

    private Admin admin;
    private ArrayList<User> userList;
    private User user;

    @BeforeEach
    public void beforeEach() throws Exception {
        System.out.println("Setting up...");
        admin = (Admin) new Account().validateUser("test3@gmail.com", "1234");
        user = new Doctor("Doctor Omar", "omar@gmail.com", "12345_", "0551115555"); // add a new user
    }

    @Test
    public void testAddUser() throws SQLException, InputErrorException, UserNotFoundException {
        user = new Doctor("Doctor Omar", "omar@gmail.com", "12345_", "0551115555");
        int checkIfAdded = admin.addUser(user); // modify the user
        assertEquals(checkIfAdded, 1);
    }

    @Test
    public void testModifyUser() throws SQLException, InputErrorException, UserNotFoundException {
        User newUser = new Doctor("Doctor Omar", "omar@gmail.com", "123456_", "0551115555");
        int checkIfModified = admin.modifyUser(user, newUser); // delete user
        user = newUser;
        assertEquals(checkIfModified, 1);
    }

    @Test
    public void testDeleteUser() throws SQLException, InputErrorException, UserNotFoundException {
        int checkIfDeleted = admin.deleteUser(user.getEmail());
        assertEquals(checkIfDeleted, 1);
    }
}