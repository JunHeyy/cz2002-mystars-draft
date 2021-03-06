import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Scanner;
/**
 * Controller class to handle all student related function.
 */
public class StudentController {

	Student student;
	String courseCode;
	int indexNum;


	//tested

	/**
	 * register a course for the student - Call the function by passing in String matrics number and Int index
	 * @param matricNum String variable, the student's matrics number
	 * @param newIndex Integer variable, the index of registering course
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	public static void addCourse(String matricNum, int newIndex) throws ClassNotFoundException, IOException,FileNotFoundException {
		int found=0;
		boolean waitList = false;
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> studentList = StudentManager.extractDB();

		if(checkVacanciesForIndex(newIndex)>0) {
			for(Student s : studentList) {
				System.out.println("Searching DB");
				System.out.println("The matrics num is "+ s.getMatricNum());
				if(s.getMatricNum().equals(matricNum)) {
					for(Integer i: s.getRegisteredIndex()) {
						//System.out.println("The value of i is " + i);
						if(i== newIndex) {
							System.out.println("Index is already registered with this student");
							found=1;
							break;
						}
					}
				}
			}

			if(found == 0 ) {

				//Add new course into Index
				for(Student s : studentList) {
					if(s.getMatricNum().equals(matricNum)) {
						ArrayList<Course> courseList = CourseManager.extractDB();
						for(Course c : courseList) {
							ArrayList<Index> indexList = c.getIndexList();
							for(Index i2 : indexList) {
								if(i2.getIndexNum() == newIndex) {
									String courseCode = i2.getCourseCode();
									System.out.println("Course code is " + courseCode);
									if(checkCourseRegistered(matricNum, courseCode)) {
										System.out.println("Registering Course");
										ArrayList<Integer> registeredIndex = s.getRegisteredIndex();
										registeredIndex.add(newIndex);
										CourseManager.slotTaken(i2.getIndexNum(), i2.getCourseCode());
										StudentManager.UpdateStudentDB(studentList);
										System.out.println("Succesfully added  index: " + i2.getIndexNum());
										break;
									}
								}
							}

						}
					}
				}
			}
		}else {
			System.out.println("The slot that you want to add has full vacancies, would you like to add to wait list?(Y/N)");
			char option =  sc.next().charAt(0);
			if (option == 'Y') WaitListManager.addWaitList(newIndex, matricNum);

		}//Run add to waitlist
	}


	//tested

	/**
	 * Drop a course registered by the student - Call the function by passing in String matric number and String course code
	 * @param matricsNum String variable, the student's matrics number
	 * @param courseCode String variable, the course code being removed
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws ConcurrentModificationException
	 */

	public static void removeCourse(String matricsNum, String courseCode) throws ClassNotFoundException, IOException, ConcurrentModificationException {

		ArrayList<Student> studentList = StudentManager.extractDB();

		boolean removed = false;
		Integer toDelete = -1;
		for(Student s : studentList) {
			if(s.getMatricNum().equals(matricsNum)) {
				ArrayList<Integer> registeredIndex = s.getRegisteredIndex();
				for(Integer i : registeredIndex) {
					if(CourseManager.IndexToCourseCode(i).equals(courseCode)) {
						System.out.println("Found course code");
						toDelete = i;
						//registeredIndex.remove(toDelete);
						//registeredIndex.remove(i);
						CourseManager.slotGivenBack(i, CourseManager.IndexToCourseCode(i));
						StudentManager.UpdateStudentDB(studentList);
						System.out.println("Course " + courseCode +" has been successfully removed");
						removed = true;
					}
				}
				if (toDelete != -1) {
					registeredIndex.remove(toDelete);
					WaitListManager.checkWaitList(toDelete);
				}
				StudentManager.UpdateStudentDB(studentList);
			}
		}
		if (!removed) System.out.println("Course is not registered!");
	}

	//tested

	/**
	 * Print all the course that is registered by the student - Call the function by passing in String Matrics number
	 * @param matricsNum String variable, The student's matrics number
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public static void printCourseRegistered(String matricsNum) throws ClassNotFoundException, IOException {
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s: studentList) {
			if(s.getMatricNum().equals(matricsNum)) {
				System.out.println("Student name: " + s.getName()+ " is registered\nCourseCode: " );
				for (Integer index : s.getRegisteredIndex()) {
					System.out.println(CourseManager.IndexToCourseCode(index) + "\nIndexNum: " + index);
				}
			}
		}
	}

	//tested

	/**
	 * Change an existing index with another index - Call the function by passing in String matrics number, Int New index, Int Old index and String course code
	 * @param MatricNum String variable of the student's matric number
	 * @param newIndex Integer variable of the new index
	 * @param oldIndex Integer variable of the existing index
	 * @param Coursecode String variable of the course
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws ConcurrentModificationException
	 */

	public static void changeIndex(String MatricNum, int newIndex, int oldIndex, String Coursecode) throws ClassNotFoundException, IOException, ConcurrentModificationException { //tested
		Integer toDelete  = -1;
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s : studentList) {
			ArrayList<Integer> indexList = s.getRegisteredIndex();
			if(s.getMatricNum().equals(MatricNum)) {
				for (int index : s.getRegisteredIndex()) {
					if(index == oldIndex && CourseManager.IndexToCourseCode(index).equals(Coursecode)) {
						if (checkVacanciesForIndex(newIndex)>0) {
							System.out.println("Changing Index...");
							System.out.println("Successful! Changed index from "+ index + " to "+ newIndex);
							for(Integer i : indexList) {
								if (i == oldIndex) {
									toDelete = i;
									System.out.println("To delete is "+ toDelete);
									break;
								}
							}
							oldIndex = newIndex;
							CourseManager.slotTaken(newIndex,Coursecode);
							CourseManager.slotGivenBack(oldIndex,Coursecode);
						}
						else {
							System.out.println("There is no vacancy for this index");
							break;
						}
						indexList.remove(toDelete);
						WaitListManager.checkWaitList(toDelete);
						indexList.add(newIndex);
					}
					else System.out.println("Index is the same");

				}


			}

			StudentManager.UpdateStudentDB(studentList);
		}

	}


	/**
	 * swap an index with another student - Call the function by passing in String own matric number, Int own index, Int peer index, String peer matric number and String peer password
	 * @param ownMatricNum String variable of the requestor's matrics number
	 * @param OwnIndex Integer variable of the requestor's index
	 * @param PeerIndex Integer variable of the requestee's index
	 * @param peerMatricNum String variable of the requestee's matrics number
	 * @param peerpw String variable of the requestee's password
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	public static void swapIndex(String ownMatricNum, int OwnIndex, int PeerIndex, String peerMatricNum, String peerpw) throws ClassNotFoundException, IOException {

		//Assume peer pw is the verified.
		int temp = OwnIndex;
		Integer toDelete1  = -1;
		Integer toDelete2  = -1;

		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s: studentList) {
			boolean Count = false;
			for (Student p : studentList) {
				ArrayList<Integer> indexList1 = s.getRegisteredIndex();
				ArrayList<Integer> indexList2 = p.getRegisteredIndex();
				if(s.getMatricNum().equals(ownMatricNum) && p.getMatricNum().equals(peerMatricNum)) {
					for (Integer own : s.getRegisteredIndex()) {
						for (Integer peer : p.getRegisteredIndex()) {
							if (own == OwnIndex && peer == PeerIndex) {
								if (CourseManager.IndexToCourseCode(own).equals(CourseManager.IndexToCourseCode(peer))) {
									Count = true;
									toDelete1 = own;
									toDelete2 = peer;

									System.out.println("Index swapped");
									StudentManager.UpdateStudentDB(studentList);
								}
								else System.out.println("Different courses!");
							}
						}
					}
				}
				if (Count) {
					indexList1.remove(toDelete1);
					indexList1.add(PeerIndex);
					indexList2.remove(toDelete2);
					indexList2.add(temp);
					StudentManager.UpdateStudentDB(studentList);}
			}


		}


	}

	/**
	 * check for vacancies for a specfic index - Call the function by passing in Int index number
	 * @param indexNum Int variable of the index being checked
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static int checkVacanciesForIndex(int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Course> courseList = CourseManager.extractDB();
		int vacancies;
		for (Course c : courseList) {
			ArrayList<Index> indexList = c.getIndexList();
			for(Index i :indexList) {
				if(i.getIndexNum() == indexNum) {
					vacancies = i.getMaxSize() - i.getNumStudents();
					return vacancies;
				}
			}
		} return 0;
	}

	/**
	 * Check if a specific course is registered under a student - Call the function by passing in String matric number and String coursecode
	 * @param matricNum String variable of the student's matrics number
	 * @param courseCode String variable of the course being registered
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static boolean checkCourseRegistered(String matricNum, String courseCode) throws ClassNotFoundException, IOException {
		ArrayList <Student> studentList = StudentManager.extractDB();
		for(Student s : studentList){
			if(s.getMatricNum().equals(matricNum)) {
				for(Integer i : s.getRegisteredIndex()) {
					if(CourseManager.IndexToCourseCode(i).equals(courseCode)){
						System.out.println("Coursecode already registered");
						return false;
					}
				}
			}
		} return true;
	}
	

	



		/*public static int checkVacancies(int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Course> courseList = CourseManager.extractDB();
		for (Course c : courseList) {
			ArrayList<Index> indexList = c.getIndexList();
			for(Index i :indexList) {
				if(i.getIndexNum() == indexNum) return i.getMaxSize() - i.getNumStudents();
			}
		}
		return -1;
	}*/
}