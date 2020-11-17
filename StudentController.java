import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.lang.reflect.Array;  
import java.util.Arrays;  

public class StudentController {
	
	Student student;
	String courseCode;
	int indexNum;
	public void addCourse(Student student, Index newIndex) throws ClassNotFoundException, IOException,FileNotFoundException {
		int found=0;
		for(Index i: student.getRegisteredIndex()) {
			if(newIndex == i) {
				System.out.println("Index is already registered with this student");
				found=1;
			}
		}
		if(found==0) {
			//Add new course into Index
			ArrayList<Student> studentList = StudentManager.extractDB();
			for(Student s : studentList) {
				if(s.getMatricNum().equals(student.getMatricNum())) {
					
					Index[] registeredIndex = s.getRegisteredIndex();
					int lenRegisteredIndex = Array.getLength(registeredIndex);
					Index[] newRegisteredIndex = new Index[lenRegisteredIndex+1];
					for(int i=0 ;i<lenRegisteredIndex;i++) {
						newRegisteredIndex[i] = registeredIndex[i];
					}
					newRegisteredIndex[lenRegisteredIndex] = newIndex;
					s.setRegisteredIndex(newRegisteredIndex);
					
					StudentManager.UpdateStudentDB(studentList);
					
				}
			}	
		}
	}
	public static void removeCourse( Student student, String courseCode) throws ClassNotFoundException, IOException {
		//TODO
		int found=0;
		for(Index i: student.getRegisteredIndex()) {
			if(i.getCourseCode().equals(courseCode)) {
				System.out.println("Index is already registered with this student");
				found=1;
				break;
			}
		}
		
		if(found==1) {
			ArrayList<Student> studentList = StudentManager.extractDB();
			for(Student s : studentList) {
				if(s.getMatricNum().equals(student.getMatricNum())) {
					Index[] registeredIndex = s.getRegisteredIndex();
					int lenRegisteredIndex = Array.getLength(registeredIndex);
					Index[] newRegisteredIndex = new Index[lenRegisteredIndex-1];
					
					int PosIndexToRemove =0;
					for(int i =0;i<lenRegisteredIndex ;i++) {
						if (registeredIndex[i].getCourseCode().equals(courseCode)) {
							PosIndexToRemove = i;
							break;
						}
					}
					
					int x=0;
					for(int i=0; i<lenRegisteredIndex-1;i++) {
						if(i != PosIndexToRemove) {
							newRegisteredIndex[x] = registeredIndex[i];
							x++;
						}
					}
					
					
					s.setRegisteredIndex(newRegisteredIndex);
					StudentManager.UpdateStudentDB(studentList);
					System.out.printf("Course code: %s has been removed from Student name: %s Matrics Num: %s \n", courseCode,s.getName(),s.getMatricNum());
					break;
				}
			}
			
		}

	}
	

	
	public void checkVacancies(int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Course> courseList = CourseManager.extractDB();
		for (Course c : courseList) {
			Index[] indexList = c.getIndexList();
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
            Index[] indexList = c.getIndexList();
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
	public void swapIndex(Student student, Index ownIndex, Index peerIndex, Student peer, String peerpw) throws ClassNotFoundException, IOException {
		
		//Assume peer pw is the verified.
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student source: studentList) {
			if(source.getMatricNum().equals(student.getMatricNum())) {
				
				for(Index i : source.getRegisteredIndex()) {
					if(ownIndex.getCourseCode().equals(i.getCourseCode())) {
						
					}
				}
					
					
				break;
			}
		}
		
		for(Student target : studentList) {
			if(target.getMatricNum().equals(peer.getMatricNum())) { //To change this part to use username instead.
				System.out.println("Found target object");
				break;
			}
		}
		
		

		
	}
}
