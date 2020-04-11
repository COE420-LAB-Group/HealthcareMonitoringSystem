package healthcareDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




public class DatabaseCommunication {
    Connection con;
    Statement statement;

    public DatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
      String url = "jdbc:oracle:thin:@database-1.cbtv7dznagjj.me-south-1.rds.amazonaws.com:1521:orcl";
      con = DriverManager.getConnection(url, dbUsername, dbPassword);
      statement = con.createStatement();
    }

    // validates entered account, returns array of strings containing details of user, returns null if user was not found
    public String[] validateUser(String email, String password) throws SQLException {
      String query = String.format(
        "SELECT * FROM Users WHERE (email = '%s' AND password = '%s' AND ROWNUM <= 1)", email, password
        );
      ResultSet result = statement.executeQuery(query);
      String[] userInfo = {};
      
      // if user is found, return array with info for that user, else, return an empty array
      if (result.next()) {
        String[] temp = {
          result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
        };

        userInfo = temp;
      }

      else {
        System.out.println("User not found in database!");
      }
      return userInfo;
    }

    // checks if the input provided is valid and can be inserted into database
    public String checkIfInputIsValid(String name, String email, String password, String contact, String userType, String emergencyContact)
        throws InputErrorException {
      
      char[] chars = name.toCharArray();

      for (char c : chars) {
          if(!Character.isLetter(c) && c != ' ' && c != '-') {
              
              return "Found invalid character " + "'" + c +"' Try again with no special characters or numbers";
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

        if(!email.contains(".") || !email.contains("@"))
          return "Please enter an appropriate email";
      return "Valid info";
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
      if (userType == "Patient") {
        // need to add the inserting of emergencyContact
      }
      return 0;
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
        throw new UserNotFoundException("User was not found in database.");
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
        System.out.println("Modified user with email " + currentEmail + " from database");
        return 1;
        // add implentation to remove user from other tables (if they are in other tables)
      }
      else {
        throw new UserNotFoundException("User was not found in database.");
      }
    }

    public ArrayList<String[]> getUserList() throws SQLException {
      ArrayList <String[]> userList = new ArrayList<String[]>();
      String query = String.format("SELECT * FROM Users");
      ResultSet result = statement.executeQuery(query);

      while(result.next()) {
        String[] tempUser = {
          result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
        };
        userList.add(tempUser);
      }
      return userList;
    }
  //   public static void main(String args[]) throws SQLException {
  //     String username = "admin";
  //     String password = "coe420project";

  //     DatabaseCommunication db = new DatabaseCommunication(username, password);
  //     String[] userInfo = db.validateUser("test@gmail.com", "1234");
      
  //     if (userInfo.length == 0) {
  //       System.out.println("Empty");
  //     }
  //     else {
  //       System.out.println(userInfo[0]);
  //     }
  //     String inputerror = db.checkIfInputIsValid("Karim Hodroj-Remmel", "testgmail.com", "12345@d", "0501112222", "Admin", "");
  //     System.out.println(inputerror);
  //     // db.addUser("Karim Hodroj-Remmel", "test@gmail.com", "1234", "0501112222", "Admin", "");
  //     db.modifyUser("test3@gmail", "Karim Hodroj-Remmel", "test3@gmail.com", "123456", "0501112224", "Admin", "");
  //     // comm.deleteUser("test@gmail.com");
  // }
}