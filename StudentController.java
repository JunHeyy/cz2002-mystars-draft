import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.lang.reflect.Array;  
import java.util.Arrays;
import java.util.ConcurrentModificationException;  

public class StudentController {
	
	Student student;
	String courseCode;
	int indexNum;
	public static void addCourse(String matricNum, int newIndex) throws ClassNotFoundException, IOException,FileNotFoundException {
		int found=0;
		ArrayList<Student> studentList = StudentManager.extractDB();
		
		if(checkVacanciesForIndex(newIndex)>0) {
			for(Student s : studentList) {
				if(s.getMatricNum().equals(matricNum)) {
					for(Index i: s.getRegisteredIndex()) {
						if(newIndex == i.getIndexNum()) {
							System.out.println("Index is already registered with this student");
							found=1;	
						}				
					}	
				}
			}
			
			if(found == 0 ) {
				System.out.println("Entering Found = 0");
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
										ArrayList<Index> registeredIndex = s.getRegisteredIndex();
										registeredIndex.add(i2);
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
		}else {System.out.println("The slot that you want to add has full vacancies");}
	}
	
	public static boolean checkCourseRegistered(String matricNum, String courseCode) throws ClassNotFoundException, IOException {
		ArrayList <Student> studentList = StudentManager.extractDB();
		for(Student s : studentList){
			if(s.getMatricNum().equals(matricNum)) {
				for(Index i : s.getRegisteredIndex()) {
					if(i.getCourseCode().equals(courseCode)){
						System.out.println("Coursecode already registered");
						return false;
					}
				}
				
			}
		}return true;
	}
	public static void removeCourse( Student student, String courseCode) throws ClassNotFoundException, IOException {
		//TODO
		int found=0;
		for(Index i: student.getRegisteredIndex()) {
			if(i.getCourseCode().equals(courseCode)) {
				System.out.println("The coursecode is registered with this student object");
				found=1;
				break;
			}
		}
		
		if(found==1) {
			ArrayList<Student> studentList = StudentManager.extractDB();
			for(Student s : studentList) {
				if(s.getMatricNum().equals(student.getMatricNum())) {
					
					for(Index i : s.getRegisteredIndex()) {
						if(i.getCourseCode().equals(courseCode)) {
							ArrayList<Index> registeredIndex = s.getRegisteredIndex();
							System.out.println("Removing the requested index...");
							registeredIndex.remove(i);
							CourseManager.slotGivenBack(i.getIndexNum(), i.getCourseCode());
							StudentManager.UpdateStudentDB(studentList);
							break;
						}
					}
					

					
					
					//s.setRegisteredIndex(newRegisteredIndex);
					
					System.out.printf("Course code: %s has been removed from Student name: %s Matrics Num: %s \n", courseCode,s.getName(),s.getMatricNum());
					break;
				}
			}
			
		}

	}
	
	public static void removeCourseByMatricsNum ( String matricsNum, String courseCode) throws ClassNotFoundException, IOException, ConcurrentModificationException {
		
		ArrayList<Student> studentList = StudentManager.extractDB();
		
		for(Student s : studentList) {
			if(s.getMatricNum().equals(matricsNum)) {
				ArrayList<Index> registeredIndex = s.getRegisteredIndex();
				for(Index i : registeredIndex) {
					if(i.getCourseCode().equals(courseCode)) {
						registeredIndex.remove(i);
						CourseManager.slotGivenBack(i.getIndexNum(), i.getCourseCode());
						StudentManager.UpdateStudentDB(studentList);
					}
				}
			}
		}
	}
	
	public static void addCourseByMatricsNum(String matricsNum, int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s : studentList) {
			if(s.getMatricNum().equals(matricsNum)) {
				ArrayList<Index> registeredIndex = s.getRegisteredIndex();
				for(Index i : registeredIndex) {
					if(i.getIndexNum() == indexNum) {
						int found =1;
						System.out.print("IndexNum already registered");
					}
				}
				//registeredIndex.add
			}
		}
		
	}
	

	
	public void checkVacancies(int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Course> courseList = CourseManager.extractDB();
		for (Course c : courseList) {
			ArrayList<Index> indexList = c.getIndexList();
			for(Index i :indexList) {
				if(i.getIndexNum() == indexNum) {
					int vacancies = i.getMaxSize() - i.getNumStudents();
					System.out.printf("Vacancies left %d for Course Index: %s\n", vacancies, indexNum);
					break;
				}
			}
		}
		
	}
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
        }
        return 0;
    }
	
	public static void changeIndex(Student student, int newIndex, String Coursecode, int oldIndex) throws ClassNotFoundException, IOException { //tested
        ArrayList<Student> studentList = StudentManager.extractDB();
        for(Student s : studentList) {
            if(s.getMatricNum().equals(student.getMatricNum())) {
                 for (Index index : s.getRegisteredIndex()) {
                     if(index.getCourseCode().equals(Coursecode)) {
                         if(newIndex != index.getIndexNum()) {
                            if (checkVacanciesForIndex(newIndex)>0) {
                                System.out.println("Changing Index...");
                             System.out.println("Successful! Changed index from "+ index.getIndexNum() + " to "+ newIndex);
                             index.setIndexNum(newIndex);

                             CourseManager.slotTaken(newIndex,Coursecode);
                             CourseManager.slotGivenBack(oldIndex,Coursecode);
                             StudentManager.UpdateStudentDB(studentList);
                             break;
                             }
                            else { System.out.println("There is no vacancy for this index"); break;}
                         }
                         else System.out.println("Index is the same");
                     }
                 }
            }
        }
    }
	
	public static void changeIndexByMatric(String MatricNum, int newIndex, int oldIndex, String Coursecode) throws ClassNotFoundException, IOException { //tested
        ArrayList<Student> studentList = StudentManager.extractDB();
        for(Student s : studentList) {
            if(s.getMatricNum().equals(MatricNum)) {
                 for (Index index : s.getRegisteredIndex()) {
                     if(index.getIndexNum() == oldIndex && index.getCourseCode().equals(Coursecode)) {
                            if (checkVacanciesForIndex(newIndex)>0) {
                            	index.setIndexNum(newIndex);
                            	StudentManager.UpdateStudentDB(studentList);
                                System.out.println("Changing Index...");
                                System.out.println("Successful! Changed index from "+ index.getIndexNum() + " to "+ newIndex);
                      

                                CourseManager.slotTaken(newIndex,Coursecode);
                                CourseManager.slotGivenBack(oldIndex,Coursecode);
                                

                             }
                            else { System.out.println("There is no vacancy for this index"); break;}
                         }
                         else System.out.println("Index is the same");
                     }
                 }
            }
        }
    
	
	public static void printCourseRegistered(Student student) throws ClassNotFoundException, IOException { //tested
		 ArrayList<Student> studentList = StudentManager.extractDB();
		 for(Student s: studentList) {
			 if(s.getMatricNum().equals(student.getMatricNum())) {
				 System.out.println("Student name: " + s.getName()+ " is registered\nCourseCode: " );
				 for (Index index : s.getRegisteredIndex()) {
					 System.out.println(index.getCourseCode() + "\nIndexNum: " + index.getIndexNum());
				 }
			 }
		 }	
	}
	
	public static void printCourseRegisteredbyMatrics(String matricsNum) throws ClassNotFoundException, IOException { //tested
		 ArrayList<Student> studentList = StudentManager.extractDB();
		 for(Student s: studentList) {
			 if(s.getMatricNum().equals(matricsNum)) {
				 System.out.println("Student name: " + s.getName()+ " is registered\nCourseCode: " );
				 for (Index index : s.getRegisteredIndex()) {
					 System.out.println(index.getCourseCode() + "\nIndexNum: " + index.getIndexNum());
				 }
			 }
		 }	
	}
	public static void swapIndex(String ownMatricNum, int OwnIndex, int PeerIndex, String peerMatricNum, String peerpw) throws ClassNotFoundException, IOException {
		
		//Assume peer pw is the verified.
		int temp = OwnIndex;
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s: studentList) {
			if(s.getMatricNum().equals(ownMatricNum)) {
				for(Index i : s.getRegisteredIndex()) {
					if(i.getIndexNum() == OwnIndex) {
						i.setIndexNum(PeerIndex);
						StudentManager.UpdateStudentDB(studentList);
					}
				}
			}
		} 
		
		for (Student s: studentList) {
			if (s.getMatricNum().equals(peerMatricNum)) {
				for (Index i : s.getRegisteredIndex())
				{
					if (i.getIndexNum() == PeerIndex)
						i.setIndexNum(temp);
					System.out.println("Index swapped");
					StudentManager.UpdateStudentDB(studentList);
					
				}
			} 
		} 

	}
}
