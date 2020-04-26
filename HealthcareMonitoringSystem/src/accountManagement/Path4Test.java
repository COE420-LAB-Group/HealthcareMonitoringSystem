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

public class Path4Test {

    private Admin admin;
    private ArrayList<User> userList;
    private User user;

    @BeforeEach
    public void beforeEach() throws Exception {
        System.out.println("Setting up...");
        admin = (Admin) new Account().validateUser("test3@gmail.com", "1234");
        user = new Doctor("Doctor Omar", "omar@gmail.com", "12345_", "0551115555"); // create user that is not in database
    }

    @Test
    public void testAddUser() throws SQLException, InputErrorException, UserNotFoundException {
        user = (Patient) new Account().validateUser("test6@gmail.com", "12345_");
        int checkIfAdded = admin.addUser(user); // modify the user
        assertEquals(-1, checkIfAdded);
        
    }

    @Test
    public void testModifyUser() throws SQLException, UserNotFoundException, InputErrorException {
        user.setName("Doctor Ali");
        User newUser = user;
        int checkIfModified = admin.modifyUser(user, newUser); // delete user
        assertEquals(-1, checkIfModified);
    }
}