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

    public void closeDatabaseConnection() throws SQLException {
      statement.close();
      con.close();
    }
}