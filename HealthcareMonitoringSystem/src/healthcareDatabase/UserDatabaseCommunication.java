package healthcareDatabase;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDatabaseCommunication extends DatabaseCommunication {

    public UserDatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
        super(dbUsername, dbPassword);
    }

    public String[] validateUser(String email, String password) throws SQLException, UserNotFoundException {
        String query = String.format(
          "SELECT users.*, patientinfo.emergencycontact FROM users FULL OUTER JOIN patientinfo ON users.email = patientinfo.patientemail " + 
          "WHERE (email = '%s' AND password = '%s' AND ROWNUM <= 1)", email, password
          );
        ResultSet result = statement.executeQuery(query);
        String[] userInfo = {};
        
        // if user is found, return array with info for that user, else, return an empty array
        if (result.next()) {
          if (result.getString(5).equals("Patient")) { // if user type is patient
            String[] temp = {
              result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)
            };
            userInfo = temp;
          } 
          else {
            String[] temp = {
              result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
            };
            userInfo = temp;
          }
        }
  
        else {
          throw new UserNotFoundException("User was not found in database.");
        }
        return userInfo;
      }
  
      // checks if the input provided is valid and can be inserted into database
      public boolean checkIfInputIsValid(String name, String email, String password, String contact, String userType, String emergencyContact)
          throws InputErrorException {
        
        char[] chars = name.toCharArray();
        if(name.length() == 0 || email.length() == 0 || contact.length() == 0 || userType.length() == 0)
          throw new InputErrorException( "One of the inputs was empty. Please fill all inputs.");
        for (char c : chars) {
          if(!Character.isLetter(c) && c != ' ' && c != '-') {
              
              throw new InputErrorException( "Found invalid character " + "'" + c +"' Try again with no special characters or numbers");
          }
          }
        if( userType.equals("Patient") )
          if(emergencyContact.length() == 0)
            throw new InputErrorException("Please fill in the emergency Contact no.");
          else {
            char[] chars4 = emergencyContact.toCharArray();
            for (char c : chars4) {
              if(!Character.isDigit(c)) {
                  throw new InputErrorException("Emergency contact information must only contain numbers"); 
              }
            }

          }
        char[] chars2 = password.toCharArray();
        int digits = 0;
        int specials = 0;
  
        for (char c : chars2) {
            if(!Character.isLetter(c)) {
                if (!Character.isDigit(c))
                  specials++;
                else 
                  digits++;
            }
        }
        if(specials == 0 || digits == 0 || password.length() < 5)
          throw new InputErrorException( "Password must have atleast 1 number, 1 special character and must be longer than 5 characters");
  
          char[] chars3 = contact.toCharArray();
  
          for (char c : chars3) {
              if(!Character.isDigit(c)) {
                  throw new InputErrorException("Contact information must only contain numbers"); 
              }
            }
  
        if (!email.contains(".") || !email.contains("@"))
          throw new InputErrorException("Please enter an appropriate email");
        
        if (!userType.equals("Admin") && !userType.equals("Caretaker") && !userType.equals("Patient") && !userType.equals("Doctor")) {
          throw new InputErrorException("Incorrect user type");
        }
        return true;
      }
  
      // finds user in database and returs the resultset, result.next() will be false if the user was not found
      public ResultSet findUser(String email) throws SQLException {
        String findDuplicatesQuery = String.format(
          "SELECT * FROM Users WHERE (email = '%s' AND ROWNUM <= 1)", email
          );
        ResultSet result = statement.executeQuery(findDuplicatesQuery);
        return result;
      }
    
      // adds a user to the database, if the user is not a Patient then emergency contact is empty
      public int addUser(String name, String email, String password, String contact, String userType, String emergencyContact)
          throws SQLException, InputErrorException {
        checkIfInputIsValid(name, email, password, contact, userType, emergencyContact);
        ResultSet result = findUser(email); // check if user already exists
  
        // if an account with that email already exists, do not add user
        if (result.next()) {
          System.out.println("Email is already in database!");
          return -1;
        }
  
        String query = String.format("INSERT INTO Users " + 
            "VALUES ('%s', '%s','%s', '%s', '%s')",
            name, email, password, contact, userType
          );
        statement.executeUpdate(query);
        System.out.print("Added user " + name + " to database");
        // if the userType is a Patient, then the emergencyContact needs to be added as well 
        if (userType.equals("Patient")) {
          query = String.format("INSERT INTO PatientInfo VALUES ('%s', '%s')", email, emergencyContact);
          statement.executeUpdate(query);
          System.out.print("Added user " + name + " to patienfo database");
        }
        return 1;
      }
  
      // deletes user with that email
      public int deleteUser(String email) throws SQLException, UserNotFoundException {
        ResultSet result = findUser(email);
        // if user was found, delete it, else return -1 because user was not found
        if (result.next()) {
          String query = String.format("DELETE FROM Users WHERE email = '%s'", email);
          statement.executeUpdate(query);
          System.out.println("Removed user with email " + email + " from database");
          return 1;
          // need to remove user from other tables (if they are in other tables)
        }
        else {
          throw new UserNotFoundException("User was not found in database");
        }
      }
  
      public int modifyUser(String currentEmail, String name, String email, String password, String contact, String userType, String emergencyContact)
          throws SQLException, UserNotFoundException, InputErrorException {
        checkIfInputIsValid(name, email, password, contact, userType, emergencyContact);
        ResultSet result = findUser(currentEmail); // check if user already exists
  
        // if an account with that email already exists, do not add user
        if (result.next()) {
          String query = String.format("UPDATE Users" + 
          " SET name = '%s', email = '%s', password = '%s', contact = '%s', userType = '%s' WHERE email = '%s'",
          name, email, password, contact, userType, currentEmail
            );
          statement.executeUpdate(query);
          if (userType == "Patient") {
            query = String.format("UPDATE PatientInfo VALUES ('%s', '%s') WHERE email = '%'", email, emergencyContact, currentEmail);
            statement.executeUpdate(query);
          }
          System.out.println("Modified user with email " + currentEmail + " from database");
          return 1;
          // add implentation to remove user from other tables (if they are in other tables)
        }
        else {
          throw new UserNotFoundException("User was not found in database");
        }
      }
  
      // gets all users from Users table
      public ArrayList<String[]> getUserList() throws SQLException {
        ArrayList <String[]> userList = new ArrayList<String[]>();
        String query = "SELECT users.*, patientinfo.emergencycontact FROM users FULL OUTER JOIN patientinfo ON users.email = patientinfo.patientemail";
        ResultSet result = statement.executeQuery(query);
  
        while(result.next()) {
          String[] userToAddToList;
  
          if (result.getString(5).equals("Patient")) { // if user type is patient get emergency contact
            String[] tempUser = {
              result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)
            };
            userToAddToList = tempUser;
          }
          else {
            String[] tempUser = {
              result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
            };
            userToAddToList = tempUser;
          }
  
          userList.add(userToAddToList);
        }
        return userList;
      }

      // Inserts into takeCareOf table to link a patient and caretaker together
      public int linkPatientAndCaretaker(String patientEmail, String caretakerEmail) throws SQLException {
        // check if both patient and careTaker actually exist in database
        // also, if one of them is not the correct type, then we return -1
        ResultSet patientResult = findUser(patientEmail);
        if (!patientResult.next()) {
          return -1;
        }
        ResultSet caretakerResult = findUser(caretakerEmail);
        if (!caretakerResult.next()) {
            return -1;
        }
        if (!patientResult.getString(4).equals("Patient") || !caretakerResult.getString(4).equals("Caretaker"))
          return -1;

        String query = String.format("INSERT INTO takeCareOf " + 
            "VALUES ('%s', '%s')", patientEmail, caretakerEmail
          );
        
        statement.executeUpdate(query);
        System.out.print("Added " + patientEmail + " to takeCareOf table database");
        return 1;
      }

      // gets list of linked patients
      public ArrayList<String[]> getLinkedPatientList(String caretakerEmail) throws SQLException {
        ArrayList<String[]> userList = new ArrayList<String[]>();
        String query = String.format(
        "SELECT users.*, patientinfo.emergencycontact FROM users FULL OUTER JOIN patientinfo ON users.email = patientinfo.patientemail " +
        "WHERE email in (SELECT patientEmail FROM takeCareOf where caretakerEmail = '%s');", caretakerEmail
        );
        ResultSet result = statement.executeQuery(query); 
        
        while(result.next()) {
          String[] tempUser = {
            result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)
          };

          userList.add(tempUser);
        }
        return userList;
      }

      // get list of linked caretakers
      public ArrayList<String[]> getLinkedCaretakerList(String patientEmail) throws SQLException {
        ArrayList<String[]> userList = new ArrayList<String[]>();
        String query = String.format("SELECT * FROM Users " +
        "WHERE email in (SELECT caretakerEmail FROM takeCareOf where patientEmail = '%s');", patientEmail
        );
        ResultSet result = statement.executeQuery(query); 
        
        while(result.next()) {
          String[] tempUser = {
            result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
          };
          // random comment
          userList.add(tempUser);
        }
        return userList;
      }
}