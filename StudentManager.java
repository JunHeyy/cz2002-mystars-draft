import java.io.*;
import java.util.ArrayList;


/**
 * Controller class that handles all student related functions.
 */
public class StudentManager {

    private static ArrayList<Student> studentList;
    private static final String filename = "data/Students.dat";

	/**
	 * Adds student into the studentDB.
	 * @param student Student object
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */

    public static void addStudent(Student student) throws IOException, ClassNotFoundException {
        try {
	    	studentList = IOController.readFile(filename);
	        int found=0;
	        for (Student s: studentList) {
	            if (s.getUsername().equals(student.getUsername())|| s.getMatricNum().equals(student.getMatricNum())) {
	                System.out.println("This student already exist in the database, unable to add student");
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

     /**
	 * Removes Student from the Student Database
	 * @param username String variable, Username of the student.
	  * @throws IOException File does not exist.
	  * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */
    public static void removeUser(String username) throws IOException, ClassNotFoundException {
       try {
	    	studentList = IOController.readFile(filename);
	        Student toDelete = null;
	        for (Student s: studentList) {
	            if (s.getUsername().equals(username)) {
	            	System.out.println("Removing student from database");
	                toDelete = s;
	                break;
	            }
	        }
	        if (toDelete != null) studentList.remove(toDelete);
	        else if(toDelete == null) System.out.println("Student does not exist in database");
	        IOController.writeFile(filename, studentList);
       }
       catch (FileNotFoundException exception) {
    	   System.out.println("File not found");
       }
       
    }

	/**
	 * Returns the current Arraylist of Students in the Student database.
	 * @return Returns the arraylist of student in database.
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */
    public static ArrayList<Student> extractDB() throws IOException, ClassNotFoundException {
    	try {
	        ArrayList<Student> studentList = IOController.readFile(filename);
	        return studentList;
		}
		catch(FileNotFoundException exception) {
			System.out.println("File not found");	
			return null;
		}
    	
    }

	/**
	 * This function updates the StudentDB.dat file
	 * @param studentList Arraylist of student objects.
	 */

	public static void UpdateStudentDB(ArrayList<Student> studentList) {
    	try {
			IOController.writeFile(filename, studentList);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
}