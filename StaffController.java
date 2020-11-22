import java.io.IOException;
import java.time.*;
import java.util.ArrayList;

/**
 * Controller class to handle all staff related functions.
 */

public class StaffController{


	/**
	 * Change the access time for students
	 * @param matricNum String variable, Matrics number of the student.
	 * @param startTime LocalTime Varable, Time that student can access Stars.
	 * @param endTime LocalTime Varable Time after student is unable to access stars.
	 */
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

	/**
	 * Print all the information of a specific student
	 * @param matricsNum String varaible
	 * @throws IOException File does not exist.
	 * @throws ClassNotFoundException Mentioned classes are not found in the
	 */
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


	/**
	 * Add a student into the database
	 * @param username String variable, Username of the student
	 * @param password String variable, Password of the student account.
	 * @param name String variable, Name of the student
	 * @param matricNum String variable, Matrics number of the student.
	 * @param gender Character variable, Gender of the student.
	 * @param nationality String variable, Nationality of the student.
	 * @param yearOfStudy Integer variable, The year of study the student is in.
	 * @param startAccessTime LocalTime variable, Time that student can start accessing stars.
	 * @param endAccessTime LocalTime variable, Time after student is unable to access stars.
	 */
	public static void addStudent(String username, String password, String name,  //tested
								  String matricNum, char gender, String nationality,
								  int yearOfStudy, LocalTime startAccessTime,
								  LocalTime endAccessTime) {
		ArrayList<Integer> registeredIndex = new ArrayList<Integer>();
		Student student = new Student ( username,  hashing.hashPassword(password),  name, matricNum,  gender,  nationality,
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


	/**
	 * Add new course into the database - Call the function by passing in String course code, String course name, Int number of AUs and Arraylist list
	 * @param courseCode String variable, Coursecode of the course.
	 * @param courseName String variable, Name of the course.
	 * @param numAUs Integer variable, Number of AU of the course.
	 * @param indexList Index object variable, Array list of index objects.
	 */

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

	/**
	 * update an existing course - Call the function by passing in String old course code, String new course code, String new course name, Int number of AU and Arraylist Index
	 * @param oldCode String variable, Old coursecode
	 * @param newCode String variable, new Coursecode
	 * @param newCourseName String variable, New course name
	 * @param newAUS Integer Variable, Number of AUS/Credits
	 * @param newIndexlist Index object variable, Arraylist of index objects
	 */
	public static void updateCourse(String oldCode,String newCode, String newCourseName, int newAUS, ArrayList<Index> newIndexlist) {


		//TODO
		ArrayList<Course> courseList = CourseManager.extractDB();
		for(Course c : courseList){
			if(c.getCourseCode().equals(oldCode)) {
				c.setCourseCode(newCode);
				c.setNumAUs(newAUS);
				c.setIndexList(newIndexlist);
				c.setCourseName(newCourseName);
				CourseManager.UpdateDB(courseList);
			}
		}


	}


	/**
	 * add more Index to existing course - Call the function by passing String courseCode and new Index object
	 * @param courseCode String Variable, Course code of the course.
	 * @param newIndex Integer Variable, Index object.
	 */
	public static void addIndex(String courseCode, Index newIndex) {

		//TODO
		ArrayList<Course> courseList = CourseManager.extractDB();
		int found =0;
		for(Course c1 : courseList) {
			if(c1.getCourseCode().equals(courseCode)) {
				ArrayList<Index> indexList = c1.getIndexList();
				for(Index i : indexList) {
					if(i.getIndexNum() == newIndex.getIndexNum()){
						found=1;
						System.out.println("Index already exists in this course, unable to add the requested Index");
					}
				}
			}
		}
		if(found == 0) {
			for(Course c : courseList){
				if(c.getCourseCode().equals(courseCode)) {
					ArrayList<Index> indexList = c.getIndexList();
					indexList.add(newIndex);
					CourseManager.UpdateDB(courseList);

				}
			}
		}
	}

	/**
	 *  Print the students that are taking a specific index
	 * @param IndexNum Integer variable, Index number of the course.
	 */
	public static void printStudentByIndex(int IndexNum) {

		//Need to test!!
		try {
			ArrayList<Student> studentList = StudentManager.extractDB();
			for (Student s: studentList) {
				ArrayList<Integer> registeredIndex;
				//Get the indexArray the student object register
				registeredIndex = s.getRegisteredIndex();
				if(registeredIndex == null) System.out.println("There are no students registered");
				for(Integer index : registeredIndex) {
					if(index == IndexNum) {
						System.out.println("Student " + s.getName() + " is registered in "+
								IndexToCourseCode(index) + " , and index number: " + index );

					}
				}

			}
		}
		catch(Exception e) {
			System.out.println("File not found");

		}
	}


	/**
	 *  Print all students that are taking a specific course - Call the function by passing in String course code
	 * @param courseCode String variable, Coursecode of the course.
	 */

	public static void printStudentByCourse(String courseCode) {

		try {
			ArrayList<Student> studentList = StudentManager.extractDB();

			for (Student s: studentList) {
				ArrayList<Integer> registeredIndex= s.getRegisteredIndex();

				for(int index : registeredIndex) {
					String indexcourseCode = IndexToCourseCode(index);
					if(indexcourseCode.equals(courseCode)) {
						System.out.println("Student " + s.getName() + " is registered in "+
								indexcourseCode + " and Index number: "  + index);
					}
				}

			}
		}
		catch(Exception e) {
			System.out.println("File not found");

		}
	}


	/**
	 *
	 * @param IndexNum Index Object variable, Index number of the course.
	 * @return returns Coursecode not found if no such index or the coursecode for the corresponding index.
	 */

	private static String IndexToCourseCode(int IndexNum) {

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

	/**
	 * print all courses in the school
	 */
	public static void printAllCourses() {

		try {
			ArrayList<Course> courseList = CourseManager.extractDB();
			System.out.println("These are the following Courses registered in the course database");
			for (Course c: courseList) {
				System.out.println(c.getCourseName());
				ArrayList<Index> indexList = c.getIndexList();
				System.out.println("Indexes registered in this course: ");
				for(Index i : indexList){
					System.out.println(i.getIndexNum());
				}


			}
		}catch(Exception e) {System.out.println("File not found");}
	}

}