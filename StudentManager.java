import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    private static ArrayList<Student> studentList;
    private static final String filename = "data/Students.dat";

    public static void addStudent(Student student) throws IOException, ClassNotFoundException {
        try {
	    	studentList = IOController.readFile(filename);
	        int found=0;
	        for (Student s: studentList) {
	            if (s.getUsername().equals(student.getUsername())) {
	                System.out.println("There is already an existing username");
	                found =1;
	                break;
	            }
	        }
	        if (found==0) {
	        	studentList.add(student);
	        	System.out.println("Succesfully added student into the database");
	        	IOController.writeFile(filename, studentList);
	        	}
        }
        catch (FileNotFoundException exception){
        	System.out.println("File not found");
        }
        
    }

    public static void removeUser(String username) throws IOException, ClassNotFoundException {
       try {
	    	studentList = IOController.readFile(filename);
	        Student toDelete = null;
	        for (Student s: studentList) {
	            if (s.getUsername().equals(username)) {
	                toDelete = s;
	                break;
	            }
	        }
	        if (toDelete != null) studentList.remove(toDelete);
	        IOController.writeFile(filename, studentList);
       }
       catch (FileNotFoundException exception) {
    	   System.out.println("File not found");
       }
       
    }
    
    public static ArrayList<Student> extractStudents() throws IOException, ClassNotFoundException {
    	try {
	        ArrayList<Student> studentList = IOController.readFile(filename);
	        return studentList;
		}
		catch(FileNotFoundException exception) {
			System.out.println("File not found");	
			return null;
		}
    	
    }
    
    public static void UpdateStudentDB(ArrayList<Student> studentList) {
    	try {
			IOController.writeFile(filename, studentList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
}