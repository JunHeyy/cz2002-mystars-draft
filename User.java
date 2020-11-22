import java.io.Serializable;

/**
 * Concrete class to create user objects.
 */

public class User implements Serializable {

    private String username;
    private String password;
    private String accountType;
    private static final long serialVersionUID = 1;

    /**
     *  Constructor of user object.
     * @param username String variable, Username of the user
     * @param password String variable, Password of the user
     * @param accountType String variable, Account type: Staff/Student
     */

    public User(String username, String password, String accountType) {
        this.username = username;
        this.password = hashing.hashPassword(password);
        this.accountType = accountType;
    }

    /**
     * Accessor method to get the username
     * @return The username of the user.
     */

    public String getUsername() {
        return this.username;
    }
    /**
     * Accessor method to get the password of the user.
     */



    public String getPassword() {
        return this.password;
    }

    /**
     * Accessor method to get the account type of the user account.
     * @return The account type of the user.
     */

    public String getAccountType() {
        return this.accountType;
    }
}