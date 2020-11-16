import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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
			else {
				//Add new course into Index
				ArrayList<Student> studentList = StudentManager.extractDB();
				for(Student s : studentList) {
					if(s.getMatricNum().equals(student.getMatricNum())) {
						//TODO
					}
				}
				


			}
		}
	}
	public static void removeCourse( Student student, String courseCode) throws ClassNotFoundException, IOException {
		//TODO
		ArrayList<Student> studentList = StudentManager.extractDB();
		for(Student s : studentList) {
			if(s.getMatricNum().equals(student.getMatricNum())) {
				Index[] registeredIndex = s.getRegisteredIndex();
				for(Index i : registeredIndex){
					//TODO remove index from registeredIndex array then update the db.
				
				}
			}
		}

	}
	

	
	public void checkVacancies(int indexNum) throws ClassNotFoundException, IOException {
		ArrayList<Index> indexList = IndexManager.extractDB();
		for (Index i : indexList) {
			if(i.getIndexNum() == indexNum) {
				int vacancies = i.getMaxSize() - i.getNumStudents();
				System.out.printf("Vacancies left %d for Course Index: %s", vacancies, indexNum);
			}
		}
		
	}
	
	public static void changeIndex(Student student, int newIndex, String Coursecode, int oldIndex) throws ClassNotFoundException, IOException { //tested
        ArrayList<Student> studentList = StudentManager.extractDB();
        for(Student s : studentList) {
            if(s.getMatricNum().equals(student.getMatricNum())) {
            	System.out.println("Found student");
                 for (Index index : s.getRegisteredIndex()) {
                     if(index.getCourseCode().equals(Coursecode)) {
                    	 if(newIndex != index.getIndexNum()) {
	                         index.setIndexNum(newIndex);
	                         System.out.println("Successful! Changed index from "+ index.getIndexNum() + " to "+ newIndex);
	                         IndexManager.slotGiven(newIndex);
	                         IndexManager.slotRemoved(oldIndex);
	                         StudentManager.UpdateStudentDB(studentList);
	                         break;}
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
				 System.out.println("Student found");
				 for (Index index : s.getRegisteredIndex()) {
					 System.out.println("Student name: " + s.getName()+ " is registered\nCourseCode: " + index.getCourseCode() + "\nIndexNum: " + index.getIndexNum());
				 }
			 }
		 }	
	}
	public void swapIndex(Student student, Index ownIndex, Index peerIndex, Student peer, String peerpw) {
		Index temp = ownIndex;
		for (Index i : student.getRegisteredIndex()) {
			if (i == ownIndex) ownIndex= peerIndex;
			}
		for (Index i : peer.getRegisteredIndex()) {
			if (i == peerIndex) peerIndex = temp;
		}
		
	}
}
