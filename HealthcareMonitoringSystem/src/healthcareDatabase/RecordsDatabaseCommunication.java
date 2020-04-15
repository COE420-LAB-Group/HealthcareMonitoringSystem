package healthcareDatabase;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import recordManagement.Prescription;
import recordManagement.Record;
import recordManagement.Vital;

public class RecordsDatabaseCommunication extends DatabaseCommunication {
  public RecordsDatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
    super(dbUsername, dbPassword);
  }

  public Record createRecord(ResultSet result) throws SQLException {
    String recordType = result.getString(4);
    Record tempRecord;
    if (recordType.equals("Prescription")) 
      tempRecord = new Prescription(result.getString(3), result.getDate(6), result.getString(2), true, result.getInt(4), result.getInt(1));
    else {
      tempRecord = new Vital(result.getString(3), result.getDate(6), result.getString(2), true, result.getInt(4), result.getInt(1), result.getDouble(7));
    }
    return tempRecord;
  }
  
  public ArrayList<Record> getPatientRecordList(String patientEmail) throws SQLException {
    ArrayList<Record> recordList = new ArrayList<Record>();
    String query = String.format(
        "SELECT Records.*, vitalReading.reading FROM Records FULL OUTER JOIN vitalReading ON Records.RecordID = vitalReading.VitalID "
        + "WHERE (patientEmail = '%s')",
        patientEmail);
    ResultSet result = statement.executeQuery(query);

    // read all values in row into a string array (the integers are turned into a string, which is really stupid because we turn them back to ints in upper layer)
    while (result.next()) 
      recordList.add(createRecord(result));
    
    return recordList;
  }
  
  public int getRecordID(String patientEmail, String recordName) throws SQLException {
    ResultSet result = findRecordWithEmail(patientEmail, recordName);
    if (result.next())
      return result.getInt(1); // returns the record's ID
    else
      return -1;
    }

  // gets all records from Records table
  public ArrayList<Record> getRecordList() throws SQLException {
    ArrayList<Record> recordList = new ArrayList<Record>();
    String query = "SELECT Records.*, vitalReading.reading FROM Records FULL OUTER JOIN vitalReading ON Records.RecordID = vitalReading.VitalID";
    ResultSet result = statement.executeQuery(query);

    // read all values in row into a string array (the integers are turned into a string, which is really stupid because we turn them back to ints in upper layer)
    while (result.next()) {
      recordList.add(createRecord(result));
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
      String query = String.format("DELETE FROM Records WHERE recordid = %d", id);
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

  // this function can be used by the patient for both inserting and for modifying a vital
  public int insertReading(int id, String patientEmail, double reading) throws SQLException {
    if (reading <= 0) {
      System.out.println("Reading <= 0 not possible");
      return -1;
    }
    // check if the record actually exists
    ResultSet result = findRecord(id);
    if (result.next()) {
      // check if the record is not a vital, return -1 if it is not, and emails match
      if (!result.getString(5).equals("Vital") || !result.getString(2).equals(patientEmail))
        return -1; 
      String query = String.format("UPDATE VitalReading " +
      "SET reading = %f WHERE (vitalID = %d)", reading, id
      );
      statement.executeUpdate(query);
      System.out.println("vital with id " + id + " reading was modified in database");
      return 1;
    }
    else {
      System.out.println("Record not found in VitalReading");
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
}