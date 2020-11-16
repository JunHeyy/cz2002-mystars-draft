import java.io.*;
import java.util.ArrayList;

public class StaffManager {

    private static ArrayList<Staff> staffList;
    private static final String filename = "data/Staff.dat";

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
    
    public static void UpdateStaffDB(ArrayList<Staff> staffList) {
    	try {
			IOController.writeFile(filename, staffList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
}