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

public class deleteLinkTest {
    Admin admin;
    User user;

    @BeforeEach
    public void BeforeEach() throws SQLException, UserNotFoundException {
        System.out.println("Setting up...");
        admin = (Admin) new Account().validateUser("test3@gmail.com", "1234");
        user = new Doctor("Doctor Omar", "omar@gmail.com", "12345_", "0551115555"); // add a new user
    }

    @Test
    public void path1Test() throws Exception {
        int checkIfDeleted = admin.deleteLink("test6@gmail.com", "test5@gmail.com");
        assertEquals(1, checkIfDeleted);
    }

    @Test
    public void path2Test() throws Exception {
        int checkIfDeleted = admin.deleteLink("test2@gmail.com", "test5@gmail.com");
        assertEquals(-1, checkIfDeleted);
    }
}