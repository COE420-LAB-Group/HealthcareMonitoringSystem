package accountManagement;

import healthcareDatabase.DatabaseCommunication;

public class Admin extends User {
    DatabaseCommunication db;
    
    public Admin(String name, String email, String password, String contact) {
        super(name, email, password, contact);
    }
    
    public int addUser(User user) {
        return 0;
    }

    public int modifyUser(User user) {
        return 0;
    }

    public int deleteUser(User user) {
        return 0;
    }

    public int linkUsers(User user1, User user2)  {
        return 0;
    }
}