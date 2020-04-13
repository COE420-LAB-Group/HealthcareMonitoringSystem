package healthcareDatabase;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class RecordsDatabaseCommunication extends DatabaseCommunication {
  public RecordsDatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
    super(dbUsername, dbPassword);
  }

  public ArrayList<String[]> getPatientRecordList(String patientEmail) throws SQLException {
    ArrayList<String[]> recordList = new ArrayList<String[]>();
    String query = String.format(
        "SELECT Records.*, vitalReading.reading FROM Records FULL OUTER JOIN vitalReading ON Records.RecordID = vitalReading.RecordID "
            + "(patientEmail = '%s')",
        patientEmail);
    ResultSet result = statement.executeQuery(query);

    while (result.next()) {
      String[] tempRecord = { result.getString(1), result.getString(2), result.getString(3), result.getString(4),
          result.getString(5) };
      recordList.add(tempRecord);
    }

    return recordList;
  }

  // gets all records from Records table
  public ArrayList<String[]> getRecordList() throws SQLException {
    ArrayList<String[]> recordList = new ArrayList<String[]>();
    String query = String.format("SELECT * FROM Records");
    ResultSet result = statement.executeQuery(query);

    while (result.next()) {
      String[] tempRecord = { result.getString(1), result.getString(2), result.getString(3), result.getString(4),
          result.getString(5) };
      recordList.add(tempRecord);
    }
    return recordList;
  }

  // checks if input for record is valid
  public boolean checkIfInputIsValid(String patientEmail, int frequency, String recordType, String recordName)
      throws InputErrorException {
    if (patientEmail.length() == 0 || recordType.length() == 0 || recordName.length() == 0)
      throw new InputErrorException("One of the inputs was empty. Please fill all inputs.");
    if (!patientEmail.contains(".") || !patientEmail.contains("@"))
      throw new InputErrorException("Please enter an appropriate patient email");

    if (!recordType.equals("Vital") && !recordType.equals("Prescription")) {
      throw new InputErrorException("Incorrect record type");
    }
    char[] chars2 = recordName.toCharArray();
    for (char c : chars2) {
      if (!Character.isLetter(c) && c != ' ' && c != '-') {
        throw new InputErrorException(
            "Found invalid character " + "'" + c + "' Try again with no special characters or numbers");
      }
    }
    return true;
  }

  public ResultSet findRecord(int id) throws SQLException {
    String findDuplicatesQuery = String.format("SELECT * FROM Records WHERE (recordID = %d AND ROWNUM <= 1)", id);
    ResultSet result = statement.executeQuery(findDuplicatesQuery);
    return result;
  }

  public ResultSet findRecordWithEmail(String patientEmail, String recordName) throws SQLException {
    String findDuplicatesQuery = String.format(
        "SELECT * FROM Records WHERE (patientEmail = '%s' AND recordName = '%s' AND ROWNUM <= 1)", patientEmail,
        recordName);
    ResultSet result = statement.executeQuery(findDuplicatesQuery);
    return result;
  }

  public int addRecord(String patientEmail, String recordName, int frequency, String recordType, Date dateToTake)
      throws SQLException, InputErrorException {
    checkIfInputIsValid(patientEmail, frequency, recordType, recordName); // WHY ARE THE VARIABLES FLIPPED AROUND :(
    ResultSet result = findRecordWithEmail(patientEmail, recordName); // check if record already exists

    // if the record already exists, do not add user
    if (result.next()) {
      System.out.println("Record is already in database!");
      return -1;
    }
    String dateString = dateToString(dateToTake);
    String query = String.format("INSERT INTO Records " + "VALUES (seq_recordid.nextval, '%s','%s', %d, '%s', "
    + "TO_DATE('%s', 'dd/mm/yyyy HH24:mi:ss'))",
        patientEmail, recordName, frequency, recordType, dateString);
    statement.executeUpdate(query);

    // add to vitalReading table if the type is a vital
    if (recordType.equals("Vital")) {
      query = "INSERT INTO vitalReading VALUES (seq_recordid.currval, -1)";
      statement.executeUpdate(query);
    }

    System.out.print("Added record " + recordName + " to database");
    return 1;
  }

  // deletes record with that patient email and name
  public int deleteRecord(int id) throws SQLException, UserNotFoundException {
    ResultSet result = findRecord(id);
    // if Record was found, delete it, else return -1 because record was not found
    if (result.next()) {
      String query = String.format("DELETE FROM Users WHERE recordid = %d", id);
      statement.executeUpdate(query);
      System.out.println("Removed record with record id " + id + " from database");
      return 1;
      // need to remove user from other tables (if they are in other tables)
    } else {
      return -1;
    }
  }

  public int modifyRecord(int currentID, String patientEmail, String recordName, int frequency, String recordType, Date dateToTake)
      throws SQLException, InputErrorException {
    checkIfInputIsValid(patientEmail, frequency, recordType, recordName);
    ResultSet result = findRecord(currentID); // check if user already exists
    
    String dateString = dateToString(dateToTake);
    if (result.next()) {
      String query = String.format("UPDATE records "
          + "SET patientEmail = '%s', recordName = '%s', frequency = %d, recordType = '%s', "
          + "dateToTake = TO_DATE('%s', 'dd/mm/yyyy HH24:mi:ss') WHERE (recordID = %d)",
          patientEmail, recordName, frequency, recordType, dateString, currentID );
      statement.executeUpdate(query);
      System.out.println("Modified record with id " + currentID + " from database");
      return 1;
    } else {
      return -1;
    }
  }

  public Date stringToDate(String s) {
    Date result = null;
    try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        result  = dateFormat.parse(s);
    }
    catch(ParseException e){
        e.printStackTrace();

    }
    return result;
  }

  public String dateToString(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String strDate = dateFormat.format(date);
    return strDate;
  }

  public static void main(String args[]) throws SQLException, UserNotFoundException, InputErrorException {
    RecordsDatabaseCommunication db = new RecordsDatabaseCommunication("admin", "coe420project");
    Date date = db.stringToDate("12/07/2020 12:21:25");
    
    db.deleteRecord(8);

  }
}