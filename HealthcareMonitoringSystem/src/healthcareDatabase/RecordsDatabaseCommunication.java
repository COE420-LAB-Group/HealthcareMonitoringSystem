package healthcareDatabase;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RecordsDatabaseCommunication extends DatabaseCommunication {
  public RecordsDatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
      super(dbUsername, dbPassword);
  }

  public ArrayList<String[]> getPatientRecordList(String patientEmail) throws SQLException {
    ArrayList <String[]> recordList = new ArrayList<String[]>();
    String query = String.format(
      "SELECT Records.*, vitalReading.reading FROM Records FULL OUTER JOIN vitalReading ON Records.RecordID = vitalReading.RecordID " + 
      "(patientEmail = '%s')", patientEmail
      );
    ResultSet result = statement.executeQuery(query);

    while(result.next()) {
      String[] tempRecord = {
        result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)
      };
      recordList.add(tempRecord);
    }

    return recordList;
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

    // checks if input for record is valid
    public boolean checkIfInputIsValid(String patientEmail, int frequency, String recordType, String recordName)
    throws InputErrorException {
      if(patientEmail.length() == 0 || recordType.length() == 0 || recordName.length() == 0)
        throw new InputErrorException( "One of the inputs was empty. Please fill all inputs.");
      if (!patientEmail.contains(".") || !patientEmail.contains("@"))
        throw new InputErrorException("Please enter an appropriate patient email");

        if (!recordType.equals("Vital") && !recordType.equals("Prescription")) {
          throw new InputErrorException("Incorrect record type");
        }
        char[] chars2 = recordName.toCharArray();
        for (char c : chars2) {
          if(!Character.isLetter(c) && c != ' ' && c != '-') {
              throw new InputErrorException( "Found invalid character " + "'" + c +"' Try again with no special characters or numbers");
          }
          }
      return true;
    }

    public ResultSet findRecord(int id) throws SQLException {
      String findDuplicatesQuery = String.format(
        "SELECT * FROM Records WHERE (recordID = %i AND ROWNUM <= 1)", id
        );
      ResultSet result = statement.executeQuery(findDuplicatesQuery);
      return result;
    }

    public ResultSet findRecordWithEmail(String patientEmail, String recordName) throws SQLException {
      String findDuplicatesQuery = String.format(
        "SELECT * FROM Records WHERE (recordID = '%s' AND recordName = '%s' AND ROWNUM <= 1)", patientEmail, recordName
        );
      ResultSet result = statement.executeQuery(findDuplicatesQuery);
      return result;
    }

    public int addRecord(String patientEmail, String recordName, int frequency, String recordType)
          throws SQLException {
      // checkIfRecordIsValid(patientEmail, recordName, frequency, recordType);
      ResultSet result = findRecordWithEmail(patientEmail, recordName); // check if record already exists

      // if the record  already exists, do not add user
      if (result.next()) {
        System.out.println("Record is already in database!");
        return -1;
      }

      String query = String.format("INSERT INTO Records " + 
          "VALUES (seq_recordid.nextval, '%s','%s', %i, '%s')",
          patientEmail, recordName, frequency, recordType
        );
      statement.executeUpdate(query);
      System.out.print("Added record " + recordName + " to database");
      return 1;
    }

    // deletes record with that patient email and name
    public int deleteRecord(int id) throws SQLException, UserNotFoundException {
      ResultSet result = findRecord(id);
      // if Record was found, delete it, else return -1 because record was not found
      if (result.next()) {
        String query = String.format("DELETE FROM Users WHERE recordid = %i", id);
        statement.executeUpdate(query);
        System.out.println("Removed record with record id " + id + " from database");
        return 1;
        // need to remove user from other tables (if they are in other tables)
      }
      else {
        return -1;
      }
    }

    public int modifyRecord(int currentID, String currentRecordName, String patientEmail, String recordName, int frequency, String recordType)
        throws SQLException {
      // checkIfInputIsValid(name, email, password, contact, userType, emergencyContact)
      ResultSet result = findRecord(currentID); // check if user already exists

      if (result.next()) {
        String query = String.format("UPDATE Users" + 
        " SET patientEmail = '%s', recordName = '%s', frequency = '%s', recordType = '%s' WHERE (recordID = %i)",
        patientEmail, recordName, frequency, recordType, currentID
        );
        statement.executeUpdate(query);
        System.out.println("Modified record with id " + id + " from database");
        return 1;
      }
      else {
        return -1;
      }
    }
}