import java.io.Serializable;

/**
 * Concrete class to create staff object.
 */
public class Staff extends User implements Serializable{
    
    private int staffId;
    private static final long serialVersionUID = 11;

    /**
     * Staff contructor for staff object.
     * @param username String variable, username of the staff user.
     * @param password String variable, password of the staff user.
     * @param staffId Integer variable, staff id of the staff user.
     */

    public Staff(String username, String password, int staffId) {
        super(username, password, "Staff");
        this.staffId = staffId;
    }

    public int getStaffId() {
        return this.staffId;
    }
    
}
