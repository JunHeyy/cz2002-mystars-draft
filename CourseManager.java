import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Controller class that handles all course related functions.
 */
public class CourseManager implements StarsManager{
	
    private static ArrayList<Course> courseList;
    private static final String filename = "data/Course.dat";

	/**
	 * Adds Course into the database
	 * @param course Course object
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the
	 */
    
    public static void addCourse(Course course) throws IOException, ClassNotFoundException {
        
        ArrayList<Course> courseList = IOController.readFile(filename);
        int found =0;
        for(Course c : courseList) {
        	if(c.getCourseCode().equals(course.getCourseCode())) {
        		System.out.println("The course is already in the database");
        		found=1;
        		break;
        	}
        }
        if(found==0) {
        	courseList.add(course);
	        System.out.println("Succesfully added Course into the database");
	        IOController.writeFile(filename, courseList);
        }
    }

	/**
	 * Remove course from the database.
	 * @param courseCode String variable course code of the Course.
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */

    public static void removeCourse(String courseCode) throws IOException, ClassNotFoundException {
    	courseList = IOController.readFile(filename);
        Course toDelete = null;
        for (Course c: courseList) {
            if (c.getCourseCode().equals(courseCode)) {
                toDelete = c;
                break;
            }
        }
        if (toDelete != null) {
        	System.out.println("Removing index...");
        	courseList.remove(toDelete);
        	System.out.println("Success");
        	IOController.writeFile(filename, courseList);
        }
        else {
        	System.out.println("There is no such Course in the database");
        }
        
    }

	/**
	 * Removes a slot from the course.
	 * @param newIndex Integer variable New Index number of student.
	 * @param CourseCode  String variable Coursecode related to the index number.
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */
    
    public static void slotTaken(int newIndex, String CourseCode) throws IOException, ClassNotFoundException{
   	 ArrayList<Course> courseList = extractDB();
   	 for(Course c: courseList) {
   		 if(c.getCourseCode().equals(CourseCode)) {
   			 for(Index i : c.getIndexList()) {
   				 if(i.getIndexNum() == newIndex) {
   					 
   					 i.setNumStudents(i.getNumStudents()+ 1);
   					 System.out.println("Slot taken, Vacancies has been updated to: " + (i.getMaxSize()-i.getNumStudents())+ " For Index: " + newIndex);
   					 UpdateDB(courseList);
   					 
   					 break;
   				 }
   			 }
   		 }
   	 }
   }

	/**
	 * Gives back a slot to the Course Index.
	 * @param oldIndex Integer variable, Old index of the student.
	 * @param CourseCode String variable, Coursecode of the index.
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */
   public static void slotGivenBack(int oldIndex, String CourseCode) throws IOException, ClassNotFoundException{
	   	 ArrayList<Course> courseList = extractDB();
	   	 for(Course c: courseList) {
	   		 if(c.getCourseCode().equals(CourseCode)) {
	   			 for(Index i : c.getIndexList()) {
	   				 if(i.getIndexNum() == oldIndex) {
	   					 
	   					 i.setNumStudents(i.getNumStudents() - 1);
	   					 System.out.println("Slot given back, Vacancies available now: " + (i.getMaxSize()-i.getNumStudents()) + " For Index: " + oldIndex);
	   					 UpdateDB(courseList);
	   					 
	   					 break;
	   				 }
	   			 }
	   		 }
	   	 }
  }

	/**
	 * Returns the Arraylist of the course in the database.
	 * @return returns the arraylist of courses.
	 */

	public static ArrayList<Course> extractDB() {
    	try {
	        ArrayList<Course> courseList = IOController.readFile(filename);
	        return courseList;
		}
		catch(Exception e) {
			System.out.println("File not found");	
			return null;
		}
    }

	/**
	 * This function updates the Course.dat file
	 * @param courseList Arraylist of course objects.
	 */

	public static void UpdateDB(ArrayList<Course> courseList) {
    	try {
			IOController.writeFile(filename, courseList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * Checks the vacancies left in the course.
	 * @param indexNum Integer variable,Index number of student.
	 * @return Return -1 if no such index number. Else returns the index number.
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
	 */

	public static int checkVacancies(int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Course> courseList = CourseManager.extractDB();
		for (Course c : courseList) {
			ArrayList<Index> indexList = c.getIndexList();
			for(Index i :indexList) {
				if(i.getIndexNum() == indexNum) return i.getMaxSize() - i.getNumStudents();
			}
		}
		return -1;
	}

	/**
	 * Converts Index Num and returns Coursecode.
	 * @param IndexNum Integer variable, Index number of student.
	 * @return Returns the int index number.
	 */

	static String IndexToCourseCode(int IndexNum) {

		ArrayList<Course> courseList = CourseManager.extractDB();
		for(Course c: courseList) {
			for(Index i : c.getIndexList()) {
				if(i.getIndexNum() == IndexNum) {
					return i.getCourseCode();
				}
			}
		}
		return "CourseCode not found";
	}
}
