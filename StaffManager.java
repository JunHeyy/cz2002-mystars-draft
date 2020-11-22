import java.io.*;
import java.util.ArrayList;

/**
 * Controller class that handles all staff related functions.
 */

public class StaffManager {

    private static ArrayList<Staff> staffList;
    private static final String filename = "data/Staff.dat";

    /**
     * Add staff into the staff database.
     * @param staff Staff object
     * @throws IOException File does not exist.
     * @throws ClassNotFoundException Mentioned classes are not found in the
     */

    public static void addStaff(Staff staff) throws IOException, ClassNotFoundException {
        staffList = IOController.readFile(filename);
        int found = 0;
        for (Staff s : staffList){
        	if(s.getStaffId() == staff.getStaffId()) {
        		System.out.println("Staff is already in database");
        		found =1;
        	}
        }
        if(found==0) {
        	staffList.add(staff);
        	System.out.println("Succesfully added staff into the database");
            UpdateStaffDB(staffList);
        }
        
    }

    /**
     * Remove staff from the database.
     * @param username String variable, Username of the staff.
     * @throws IOException File does not exist.
     * @throws ClassNotFoundException Mentioned classes are not found in the
     */
    public static void removeStaff(String username) throws IOException, ClassNotFoundException {
        staffList = IOController.readFile(filename);
        Staff toDelete = null;
        for (Staff s: staffList) {
            if (s.getUsername().equals(username)) {
                toDelete = s;
                break;
            }
        }
        if (toDelete != null) staffList.remove(toDelete);
        UpdateStaffDB(staffList);
    }

    /**
     * Returns the current Arraylist of staff in the staffDB.
     * @return Return staff arraylist.
     */
    
    public static ArrayList<Staff> extractStaffs() {
    	try {
	        ArrayList<Staff> staffList = IOController.readFile("src/data/Staff.dat");
	        return staffList;
		}
		catch(Exception e) {
			System.out.println("File not found");	
			return null;
		}
    }

    /**
     * Updates Staff DB.
     * @param staffList Array list of staff objects.
     */
    public static void UpdateStaffDB(ArrayList<Staff> staffList) {
    	try {
			IOController.writeFile(filename, staffList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
}