import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

public class StaffController{
	

	public void editStudentAccessPeriod(String matricNum, LocalTime startTime, LocalTime endTime) {
		try {
	        ArrayList<Student> studentList = IOController.readFile("src/data/Students.dat");
	        for (Student s: studentList) { 
        		if(s.getMatricNum() == matricNum) {
        			s.setStartAccessTime(startTime);
        			s.setEndAccessTime(endTime);
        			System.out.println("Student " + s.getName() + "can only access the portal from "+
        						startTime + "to" + endTime);  
        			break;
        		
        		}
	        	
	        }
		}
		catch(Exception e) {
			System.out.println("File not found");
			
		}
	}
	
	public void addStudent(Student student) {
		try {
			StudentManager.addStudent(student);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("There was an error");
		}
	}
	
	public void addCourse(Course newCourse) {
		try {
			CourseManager.addCourse(newCourse);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("There was an error");
		}
	}
	
	public void updateCourse(String newCode, String newAUS, Index[] newIndexlist) {
		//TODO

	}
	
	public static void printStudentByIndex(int IndexNum) {
		//Need to test!!
		try {
	        ArrayList<Student> studentList = StudentManager.extractDB();
	        for (Student s: studentList) { 
	        	Index[] registeredIndex;
	        	//Get the indexArray the student object register
	        	registeredIndex = s.getRegisteredIndex();
	        	if(registeredIndex ==null) System.out.println("There are no students registered");
	        	for(Index index : registeredIndex) {
	        		if(index.getIndexNum() == IndexNum) {
	        			System.out.println("Student " + s.getName() + " is registered in "+
	        								index.getCourseCode() + " , and index number: " + index.getIndexNum() );
	        			
	        		}
	        	}
	        	
	        }
		}
		catch(Exception e) {
			System.out.println("File not found");
			
		}
	}
	
	public static void printStudentByCourse(String courseCode) {
		try {
	        ArrayList<Student> studentList = StudentManager.extractDB();
	        
	        for (Student s: studentList) { 
	        	Index[] registeredIndex;
	        	registeredIndex = s.getRegisteredIndex();
	        	for(Index index : registeredIndex) {
	        		if(index.getCourseCode().equals(courseCode)) {
	        			System.out.println("Student " + s.getName() + " is registered in "+
	        								index.getCourseCode() + " and Index number: "  + index.getIndexNum());
	        		}
	        	}
	        	
	        }
		}
		catch(Exception e) {
			System.out.println("File not found");
			
		}
	}
	
	public void printAllCourses() {
		try {
	        ArrayList<Course> courseList = CourseManager.extractDB();
	        System.out.println("These are the following Courses registered");
	        for (Course c: courseList) { 
	        	System.out.println(c.getCourseName());

	        	
	        }
		}catch(Exception e) {System.out.println("File not found");}
	}
	
}