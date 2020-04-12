package healthcareDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DatabaseCommunication {
    Connection con;
    Statement statement;

    public DatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
      String url = "jdbc:oracle:thin:@database-1.cbtv7dznagjj.me-south-1.rds.amazonaws.com:1521:orcl";
      con = DriverManager.getConnection(url, dbUsername, dbPassword);
      statement = con.createStatement();
    }

    // // #################################################
    // // ############### USER FUNCTIONS ##################
    // // #################################################
    // // validates entered account, returns array of strings containing details of user, returns null if user was not found
    // public String[] validateUser(String email, String password) throws SQLException, UserNotFoundException {
    //   String query = String.format(
    //     "SELECT users.*, patientinfo.emergencycontact FROM users FULL OUTER JOIN patientinfo ON users.email = patientinfo.patientemail " + 
    //     "WHERE (email = '%s' AND password = '%s' AND ROWNUM <= 1)", email, password
    //     );
    //   ResultSet result = statement.executeQuery(query);
    //   String[] userInfo = {};
      
    //   // if user is found, return array with info for that user, else, return an empty array
    //   if (result.next()) {
    //     if (result.getString(5).equals("Patient")) { // if user type is patient
    //       String[] temp = {
    //         result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)
    //       };
    //       userInfo = temp;
    //     } 
    //     else {
    //       String[] temp = {
    //         result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
    //       };
    //       userInfo = temp;
    //     }
    //   }

    //   else {
    //     throw new UserNotFoundException("User was not found in database.");
    //   }
    //   return userInfo;
    // }

    // // checks if the input provided is valid and can be inserted into database
    // public String checkIfInputIsValid(String name, String email, String password, String contact, String userType, String emergencyContact)
    //     throws InputErrorException {
      
    //   char[] chars = name.toCharArray();

    //   for (char c : chars) {
    //     if(!Character.isLetter(c) && c != ' ' && c != '-') {
            
    //         throw new InputErrorException( "Found invalid character " + "'" + c +"' Try again with no special characters or numbers");
    //     }
    //     }
    //   char[] chars2 = password.toCharArray();
    //   int digits = 0;
    //   int specials = 0;

    //   for (char c : chars2) {
    //       if(!Character.isLetter(c)) {
    //           if (!Character.isDigit(c))
    //             specials++;
    //           else 
    //             digits++;
    //       }
    //   }

    //   if(specials == 0 || digits == 0 || password.length() < 5)
    //     throw new InputErrorException( "Password must have atleast 1 number, 1 special character and must be longer than 5 characters");

    //     char[] chars3 = contact.toCharArray();

    //     for (char c : chars3) {
    //         if(!Character.isDigit(c)) {
    //             throw new InputErrorException("Contact information must only contain numbers"); 
    //         }
    //       }

    //   if (!email.contains(".") || !email.contains("@"))
    //     throw new InputErrorException("Please enter an appropriate email");
      
    //   if (!userType.equals("Admin") && !userType.equals("Caretaker") && !userType.equals("Patient") && !userType.equals("Doctor")) {
    //     throw new InputErrorException("Incorrect user type");
    //   }
    //   return "Valid info";
    // }

    // // finds user in database and returs the resultset, result.next() will be false if the user was not found
    // public ResultSet findUser(String email) throws SQLException {
    //   String findDuplicatesQuery = String.format(
    //     "SELECT * FROM Users WHERE (email = '%s' AND ROWNUM <= 1)", email
    //     );
    //   ResultSet result = statement.executeQuery(findDuplicatesQuery);
    //   return result;
    // }
  
    // // adds a user to the database, if the user is not a Patient then emergency contact is empty
    // public int addUser(String name, String email, String password, String contact, String userType, String emergencyContact)
    //     throws SQLException, InputErrorException {
    //   checkIfInputIsValid(name, email, password, contact, userType, emergencyContact);
    //   ResultSet result = findUser(email); // check if user already exists

    //   // if an account with that email already exists, do not add user
    //   if (result.next()) {
    //     System.out.println("Email is already in database!");
    //     return -1;
    //   }

    //   String query = String.format("INSERT INTO Users " + 
    //       "VALUES ('%s', '%s','%s', '%s', '%s')",
    //       name, email, password, contact, userType
    //     );
    //   statement.executeUpdate(query);
    //   System.out.print("Added user " + name + " to database");
    //   // if the userType is a Patient, then the emergencyContact needs to be added as well 
    //   if (userType.equals("Patient")) {
    //     query = String.format("INSERT INTO PatientInfo VALUES ('%s', '%s')", email, emergencyContact);
    //     statement.executeUpdate(query);
    //     System.out.print("Added user " + name + " to patienfo database");
    //   }
    //   return 1;
    // }

    // // deletes user with that email
    // public int deleteUser(String email) throws SQLException, UserNotFoundException {
    //   ResultSet result = findUser(email);
    //   // if user was found, delete it, else return -1 because user was not found
    //   if (result.next()) {
    //     String query = String.format("DELETE FROM Users WHERE email = '%s'", email);
    //     statement.executeUpdate(query);
    //     System.out.println("Removed user with email " + email + " from database");
    //     return 1;
    //     // need to remove user from other tables (if they are in other tables)
    //   }
    //   else {
    //     throw new UserNotFoundException("User was not found in database");
    //   }
    // }

    // public int modifyUser(String currentEmail, String name, String email, String password, String contact, String userType, String emergencyContact)
    //     throws SQLException, UserNotFoundException, InputErrorException {
    //   checkIfInputIsValid(name, email, password, contact, userType, emergencyContact);
    //   ResultSet result = findUser(currentEmail); // check if user already exists

    //   // if an account with that email already exists, do not add user
    //   if (result.next()) {
    //     String query = String.format("UPDATE Users" + 
    //     " SET name = '%s', email = '%s', password = '%s', contact = '%s', userType = '%s' WHERE email = '%s'",
    //     name, email, password, contact, userType, currentEmail
    //       );
    //     statement.executeUpdate(query);
    //     if (userType == "Patient") {
    //       query = String.format("UPDATE PatientInfo VALUES ('%s', '%s') WHERE email = '%'", email, emergencyContact, currentEmail);
    //       statement.executeUpdate(query);
    //     }
    //     System.out.println("Modified user with email " + currentEmail + " from database");
    //     return 1;
    //     // add implentation to remove user from other tables (if they are in other tables)
    //   }
    //   else {
    //     throw new UserNotFoundException("User was not found in database");
    //   }
    // }

    // // gets all users from Users table
    // public ArrayList<String[]> getUserList() throws SQLException {
    //   ArrayList <String[]> userList = new ArrayList<String[]>();
    //   String query = "SELECT users.*, patientinfo.emergencycontact FROM users FULL OUTER JOIN patientinfo ON users.email = patientinfo.patientemail";
    //   ResultSet result = statement.executeQuery(query);

    //   while(result.next()) {
    //     String[] userToAddToList;

    //     if (result.getString(5).equals("Patient")) { // if user type is patient get emergency contact
    //       String[] tempUser = {
    //         result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6)
    //       };
    //       userToAddToList = tempUser;
    //     }
    //     else {
    //       String[] tempUser = {
    //         result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
    //       };
    //       userToAddToList = tempUser;
    //     }

    //     userList.add(userToAddToList);
    //   }
    //   return userList;
    // }

    // // #################################################
    // // ############ END OF USER FUNCTIONS ##############
    // // #################################################

    // // gets all records from Records table
    // public ArrayList<String[]> getRecordList() throws SQLException {
    //   ArrayList <String[]> recordList = new ArrayList<String[]>();
    //   String query = String.format("SELECT * FROM Records");
    //   ResultSet result = statement.executeQuery(query);

    //   while(result.next()) {
    //     String[] tempRecord = {
    //       result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
    //     };
    //     recordList.add(tempRecord);
    //   }
    //   return recordList;
    // }

    // public ResultSet findRecord(String patientEmail, String recordName) throws SQLException {
    //   String findDuplicatesQuery = String.format(
    //     "SELECT * FROM Records WHERE (email = '%s' AND recordName = '%s' AND ROWNUM <= 1)", patientEmail, recordName
    //     );
    //   ResultSet result = statement.executeQuery(findDuplicatesQuery);
    //   return result;
    // }

    // public int addRecord(String patientEmail, String doctorEmail, String recordName, String frequency, String recordType)
    //       throws SQLException {
    //     // checkIfRecordIsValid(patientEmail, doctorEmail, recordName, frequency, recordType);
    //     ResultSet result = findRecord(patientEmail, recordName); // check if record already exists

    //     // if the record  already exists, do not add user
    //     if (result.next()) {
    //       System.out.println("Record is already in database!");
    //       return -1;
    //     }

    //     String query = String.format("INSERT INTO Records " + 
    //         "VALUES ('%s', '%s','%s', '%s', '%s')",
    //         patientEmail, doctorEmail, recordName, frequency, frequency
    //       );
    //     statement.executeUpdate(query);
    //     System.out.print("Added record " + recordName + " to database");
    //     return 1;
    //   }

    // // deletes record with that patient email and name
    // public int deleteRecord(String patientEmail, String recordName) throws SQLException, UserNotFoundException {
    //   ResultSet result = findRecord(patientEmail, recordName);
    //   // if Record was found, delete it, else return -1 because record was not found
    //   if (result.next()) {
    //     String query = String.format("DELETE FROM Users WHERE email = '%s'", patientEmail);
    //     statement.executeUpdate(query);
    //     System.out.println("Removed record with patient email " + patientEmail + " from database");
    //     return 1;
    //     // need to remove user from other tables (if they are in other tables)
    //   }
    //   else {
    //     return -1;
    //   }
    // }

    // public int modifyRecord(String currentPatientEmail, String currentRecordName, String patientEmail, String doctorEmail, String recordName, String frequency, String recordType)
    //     throws SQLException {
    //   // checkIfInputIsValid(name, email, password, contact, userType, emergencyContact);
    //   ResultSet result = findRecord(currentPatientEmail, currentRecordName); // check if user already exists

    //   if (result.next()) {
    //     String query = String.format("UPDATE Users" + 
    //     " SET patientEmail = '%s', doctorEmail = '%s', recordName = '%s', frequency = '%s', recordType = '%s' WHERE (email = '%s' AND recordName = '%s')",
    //     patientEmail, doctorEmail, recordName, frequency, recordType, currentPatientEmail
    //     );
    //     statement.executeUpdate(query);
    //     System.out.println("Modified user with email " + currentPatientEmail + " from database");
    //     return 1;
    //   }
    //   else {
    //     return -1;
    //   }
    // }
}