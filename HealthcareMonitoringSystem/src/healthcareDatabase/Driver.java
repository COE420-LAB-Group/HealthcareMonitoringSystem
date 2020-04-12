// package healthcareDatabase;

// import java.sql.SQLException;

// public class Driver {
//     public static void main(String[] args) throws SQLException {
//         String username = "admin";
//         String password = "coe420project";
  
//         DatabaseCommunication db = new DatabaseCommunication(username, password);
//         String[] userInfo = db.validateUser("test@gmail.com", "1234");
        
//         if (userInfo.length == 0) {
//           System.out.println("Empty");
//         }
//         else {
//           System.out.println(userInfo[0]);
//         }
  
//         // db.addUser("Karim Hodroj-Remmel", "test@gmail.com", "1234", "0501112222", "Admin", "");
//         // db.modifyUser("test3@gmail.com", "Karim Hodroj-Remmel", "test3@gmail.com", "123456", "0501112224", "Admin", "");
//         db.addRecord("patient@gmail.com", "test@gmail.com", "Blood Presure", "0501112226", "Vital");
//         // comm.deleteUser("test@gmail.com");
//     }
// }