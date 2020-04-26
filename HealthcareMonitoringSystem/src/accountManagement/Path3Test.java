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

public class Path3Test {

    private Admin admin;
    private ArrayList<User> userList;
    private User user;

    @BeforeEach
    public void beforeEach() throws Exception {
        System.out.println("Setting up...");
        admin = (Admin) new Account().validateUser("test3@gmail.com", "1234");
        user = new Patient("Patient Omar", "omar2@gmail.com", "12345_", "0551115555", "0501234567"); // add a new user
    }

    @Test
    public void testAddUser() throws SQLException, InputErrorException, UserNotFoundException {
        user = new Patient("Patient Omar", "omar2@gmail.com", "12345_", "0551115555", "0501234567"); // add a new user
        int checkIfAdded = admin.addUser(user); 
        assertEquals(checkIfAdded, 1);
    }

    @Test
    public void testModifyUser() throws SQLException, InputErrorException, UserNotFoundException {
        User newUser = new Patient("Patient Ahmad", "omar2@gmail.com", "12345_", "0551115555", "0501234567"); 
        int checkIfModified = admin.modifyUser(user, newUser); 
        user = newUser;
        assertEquals(checkIfModified, 1);
    }
}