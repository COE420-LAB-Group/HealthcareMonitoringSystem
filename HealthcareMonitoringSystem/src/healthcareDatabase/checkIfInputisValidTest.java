package healthcareDatabase;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import healthcareDatabase.InputErrorException;
import healthcareDatabase.UserNotFoundException;

public class checkIfInputisValidTest {

 
    UserDatabaseCommunication db;
    String one, two, three, four, five, six;
    @BeforeEach
    public void BeforeEach() throws SQLException, UserNotFoundException {
        System.out.println("Setting up...");
        db = new UserDatabaseCommunication("admin","coe420project");
        one = "Sami";
        two = "Sami@alnajjar.com";
        three = "KarimisN;ice2";
        four = "0521112119";
        five = "Patient";
        six = "052111212";


    }





// 1 2 4 5 6 7 8 10 11 9
// 1 2 4 5 6 7 8 10 11 12 9
// 1 2 4 5 6 7 8 10 11 12 13
    @Test
    public void path1Test() throws Exception {
        try {
            boolean checkifinputisvalid = db.checkIfInputIsValid(one,"","","","","");
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(),"One of the inputs was empty. Please fill all inputs.");
        }
    }
    @Test
    public void path2Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid("S4mi",two ,three ,four,five, six);
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Found invalid character, try again with no special characters or numbers");
        }
    }
    @Test
    public void path3Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,four,five, "");
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(),"Please fill in the emergency Contact no.");
        }
    }
    @Test
    public void path4Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,four,five, "0232w020");
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(),"Emergency contact information must only contain numbers");
        }
    }
    @Test
    public void path5Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,"karimisnice" ,four,five, six);
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Password must have atleast 1 number, 1 special character and must be longer than 5 characters");
        }
    }
    @Test
    public void path6Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,"karimisnice" ,four,"Caretaker", "");
    }
    catch (InputErrorException ex) {
        assertEquals(ex.getMessage(), "Password must have atleast 1 number, 1 special character and must be longer than 5 characters");
    }
    }
    @Test
    public void path7Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,"050302j203","Caretaker", "");
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Contact information must only contain numbers");
        }
 
    }
    @Test
    public void path8Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,"samigmailcom" ,three ,four,"Caretaker", "");
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Please enter an appropriate email");
        }    }
    @Test
    public void path9Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,four,"carkerr", "");
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Incorrect user type");
        }
       
    }
    @Test
    public void path10Test() throws Exception {
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,four,"Caretaker", "");
        assertEquals(true, checkifinputisvalid);
    }
    @Test
    public void path11Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,"0503iri30",five, six);
    }
         catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Contact information must only contain numbers");
        }
    }
    @Test
    public void path12Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,"sngimcom" ,three ,four,five, six);
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Please enter an appropriate email");
        } 
    }
    @Test
    public void path13Test() throws Exception {
        try{
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,four,"patnt", six);
        }
        catch (InputErrorException ex) {
            assertEquals(ex.getMessage(), "Incorrect user type");
        }
    }
    @Test
    public void path14Test() throws Exception {
        boolean checkifinputisvalid = db.checkIfInputIsValid(one,two ,three ,four,five, six);
        assertEquals(true, checkifinputisvalid);
    }
}

