import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

public class StaffController{
	

	public static void editStudentAccessPeriod(String matricNum, LocalTime startTime, LocalTime endTime) { //tested
		try {
	        ArrayList<Student> studentList = StudentManager.extractDB();
	        for (Student s: studentList) { 
        		if(s.getMatricNum().equals(matricNum)) {
        			System.out.println("Found student");
        			s.setStartAccessTime(startTime);
        			s.setEndAccessTime(endTime);
        			System.out.println("Student " + s.getName() + " can only access the portal from "+
        						startTime + " to " + endTime);  
        			StudentManager.UpdateStudentDB(studentList);
        			break;
        		
        		}
	        	
	        }
		}
		catch(Exception e) {
			System.out.println("File not found");
			
		}
	}
	public static void printSelectedStudent(String matricsNum) throws ClassNotFoundException, IOException {
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s: studentList){
			if(s.getMatricNum().equals(matricsNum)) {
				System.out.printf("Student name: " + s.getName() +" Matrics Number: " + s.getMatricNum() +  " Gender: " + 
						 " Nationality: " + s.getNationality() + " Year of Study: " + s.getYearOfStudy()+  " Access time from " + s.getStartAccessTime() + " to " + s.getEndAccessTime() +"\n");
				StudentController.printCourseRegistered(matricsNum);
			}
		}
		
	}
	public static void addStudent(String username, String password, String name,  //tested
    		String matricNum, char gender, String nationality, 
    		int yearOfStudy, LocalTime startAccessTime,
    		LocalTime endAccessTime) {
		ArrayList<Index> registeredIndex = new ArrayList<Index>();
		Student student = new Student ( username,  password,  name, matricNum,  gender,  nationality, 
										yearOfStudy,  registeredIndex,  startAccessTime, endAccessTime);
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
	
	
	
	public static void addCourse(String courseCode, String courseName, int numAUs, ArrayList<Index> indexList) { //Tested
		Course newCourse = new Course(courseCode, courseName, numAUs,  indexList);
		try {
			CourseManager.addCourse(newCourse);
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();		}
		catch(Exception e) {
			System.out.println("There was an error");
		}
	}
	
	public void updateCourse(String newCode, String newAUS, ArrayList<Index> newIndexlist) {
		//TODO

	}
	
	public void addIndex(String courseCode, Index newIndex) {
		//TODO
	}
	public static void printStudentByIndex(int IndexNum) { //tested
		//Need to test!!
		try {
	        ArrayList<Student> studentList = StudentManager.extractDB();
	        for (Student s: studentList) { 
	        	ArrayList<Index> registeredIndex;
	        	//Get the indexArray the student object register
	        	registeredIndex = s.getRegisteredIndex();
	        	if(registeredIndex == null) System.out.println("There are no students registered");
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
	
	public static void printStudentByCourse(String courseCode) { //Tested
		try {
	        ArrayList<Student> studentList = StudentManager.extractDB();
	        
	        for (Student s: studentList) { 
	        	ArrayList<Index> registeredIndex= s.getRegisteredIndex();
	        	
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
	
	public static void printAllCourses() { //Tested
		try {
	        ArrayList<Course> courseList = CourseManager.extractDB();
	        System.out.println("These are the following Courses registered in the course database");
	        for (Course c: courseList) { 
	        	System.out.println(c.getCourseName());

	        	
	        }
		}catch(Exception e) {System.out.println("File not found");}
	}
	
}