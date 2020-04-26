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

public class Path2Test {

    private Admin admin;
    private ArrayList<User> userList;
    private User user;

    @BeforeEach
    public void beforeEach() throws Exception {
        System.out.println("Setting up...");
        admin = (Admin) new Account().validateUser("test3@gmail.com", "1234");
        user = new Doctor("Doctor Omar", "omar@gmail.com", "1234", "0551115555"); // invalid input so user will not be added
    }

    @Test
    public void testAddUser() throws SQLException {
        user = new Patient("Patient Omar", "omar@gmail.com", "1234", "0551115555", "0501234567");
        try {
            int checkIfAdded = admin.addUser(user); // modify the user
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Password must have atleast 1 number, 1 special character and must be longer than 5 characters");
        }
    }

    @Test
    public void testModifyUser() throws SQLException, UserNotFoundException {
        User databaseUser = (Caretaker) new Account().validateUser("test5@gmail.com", "1234");
        databaseUser.setName("ex-Baba Khawaja");
        databaseUser.setPassword("1234");
        User newUser = databaseUser;
        try {
            int checkIfModified = admin.modifyUser(databaseUser, newUser); // delete user
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Password must have atleast 1 number, 1 special character and must be longer than 5 characters");
        }
    }

    @Test
    public void testDeleteUser() throws SQLException, InputErrorException {
        int checkIfDeleted = admin.deleteUser(user.getEmail());
        assertEquals(checkIfDeleted, -1);
    }
}