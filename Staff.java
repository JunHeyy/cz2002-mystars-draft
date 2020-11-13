import java.io.Serializable;
public class Staff extends User implements Serializable{
    
    private int staffId;
    private static final long serialVersionUID = 11;

    public Staff(String username, String password, int staffId) {
        super(username, password, "Staff");
        this.staffId = staffId;
    }

    public int getStaffId() {
        return this.staffId;
    }
    
}
