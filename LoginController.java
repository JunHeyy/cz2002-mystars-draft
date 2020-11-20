import java.util.ArrayList;

public class LoginController {

    public static boolean validate(String accountType, String username, String password) {
        User toMatch = null;
        if (accountType.equals("Student")) {
            try {
                ArrayList<Student> studentList = IOController.readFile("data/Students.dat");
                for (Student s: studentList) {
                    if (s.getUsername().equals(username)) {
                        System.out.println("Please wait while we log you in...");
                        toMatch = s;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("No user database found. Please try again.");
                return false;
            }
        }
        else if (accountType.equals("Staff")) {
            try {
                ArrayList<Staff> staffList = IOController.readFile("data/Staff.dat");
                for (Staff s: staffList) {
                    if (s.getUsername().equals(username)) {
                        System.out.println("Please wait while we log you in...");
                        toMatch = s;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("No user database found. Please try again.");
                return false;
            }
        }
    
        if (toMatch == null) {
            return false;
        }
        else {
            if (toMatch.getPassword().equals(hashing.hashPassword(password))) return true;
            else return false;
        }
    }
}