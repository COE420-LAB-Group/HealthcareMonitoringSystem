package healthcareDatabase;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecordsDatabaseCommunication extends DatabaseCommunication {

    public RecordsDatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
        super(dbUsername, dbPassword);
    }

    // gets all records from Records table
    public ArrayList<String[]> getRecordList() throws SQLException {
        ArrayList <String[]> recordList = new ArrayList<String[]>();
        String query = String.format("SELECT * FROM Records");
        ResultSet result = statement.executeQuery(query);
  
        while(result.next()) {
          String[] tempRecord = {
            result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
          };
          recordList.add(tempRecord);
        }
        return recordList;
      }
  
      public ResultSet findRecord(String patientEmail, String recordName) throws SQLException {
        String findDuplicatesQuery = String.format(
          "SELECT * FROM Records WHERE (email = '%s' AND recordName = '%s' AND ROWNUM <= 1)", patientEmail, recordName
          );
        ResultSet result = statement.executeQuery(findDuplicatesQuery);
        return result;
      }
  
      public int addRecord(String patientEmail, String doctorEmail, String recordName, String frequency, String recordType)
            throws SQLException {
          // checkIfRecordIsValid(patientEmail, doctorEmail, recordName, frequency, recordType);
          ResultSet result = findRecord(patientEmail, recordName); // check if record already exists
  
          // if the record  already exists, do not add user
          if (result.next()) {
            System.out.println("Record is already in database!");
            return -1;
          }
  
          String query = String.format("INSERT INTO Records " + 
              "VALUES ('%s', '%s','%s', '%s', '%s')",
              patientEmail, doctorEmail, recordName, frequency, frequency
            );
          statement.executeUpdate(query);
          System.out.print("Added record " + recordName + " to database");
          return 1;
        }
  
      // deletes record with that patient email and name
      public int deleteRecord(String patientEmail, String recordName) throws SQLException, UserNotFoundException {
        ResultSet result = findRecord(patientEmail, recordName);
        // if Record was found, delete it, else return -1 because record was not found
        if (result.next()) {
          String query = String.format("DELETE FROM Users WHERE email = '%s'", patientEmail);
          statement.executeUpdate(query);
          System.out.println("Removed record with patient email " + patientEmail + " from database");
          return 1;
          // need to remove user from other tables (if they are in other tables)
        }
        else {
          return -1;
        }
      }
  
      public int modifyRecord(String currentPatientEmail, String currentRecordName, String patientEmail, String doctorEmail, String recordName, String frequency, String recordType)
          throws SQLException {
        // checkIfInputIsValid(name, email, password, contact, userType, emergencyContact);
        ResultSet result = findRecord(currentPatientEmail, currentRecordName); // check if user already exists
  
        if (result.next()) {
          String query = String.format("UPDATE Users" + 
          " SET patientEmail = '%s', doctorEmail = '%s', recordName = '%s', frequency = '%s', recordType = '%s' WHERE (email = '%s' AND recordName = '%s')",
          patientEmail, doctorEmail, recordName, frequency, recordType, currentPatientEmail
          );
          statement.executeUpdate(query);
          System.out.println("Modified user with email " + currentPatientEmail + " from database");
          return 1;
        }
        else {
          return -1;
        }
      }
}