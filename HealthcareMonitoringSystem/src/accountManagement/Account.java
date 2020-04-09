package accountManagement;

public class Account {
    private User user;

    Account(User user) {
        this.user = user;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
    }
    
    public void validateUser(String email, String password) { // change return type to user
        // do validation of user, if validated create User
        // type of user created depends on type in database
        // after creating User with correct type, return it

        // User u = new User(name, email, password, contact)
        // return u
    }
}