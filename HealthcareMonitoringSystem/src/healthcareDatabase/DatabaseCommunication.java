package healthcareDatabase;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.xml.crypto.Data;

public class DatabaseCommunication {
    Connection con;
    Statement statement;

    public DatabaseCommunication(String dbUsername, String dbPassword) throws SQLException {
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";
      con = DriverManager.getConnection(url, dbUsername, dbPassword);
      statement = con.createStatement();
    }
    // validates entered account, returns array of strings containing details of user, returns null if user was not found
    public String[] validateUser(String email, String password) throws SQLException {
      String query = String.format("SELECT * FROM Users WHERE (email = '%s' AND password = '%s' AND ROWNUM <= 1)", email, password);
      System.out.println(query);
      ResultSet result = statement.executeQuery(query);
      String[] userInfo = {};
      
      // if user is found, create array with info for that user, else, create an empty array
      if (result.next()) {
        String[] temp = {result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)};
        userInfo = temp;
      }
      return userInfo;
    }

    public static void main(String args[]) throws SQLException {
      String username = "system";
      String password = "coe420project";

      DatabaseCommunication comm = new DatabaseCommunication(username, password);
      String[] userInfo = comm.validateUser("test@gmail.com", "1234");
      
      if (userInfo.length == 0) {
        System.out.println("Empty");
      }
      else {
        System.out.println(userInfo[0]);
      }
  }
}