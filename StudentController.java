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
	
	//tested
	public static void addCourse(String matricNum, int newIndex) throws ClassNotFoundException, IOException,FileNotFoundException {
		int found=0;
		ArrayList<Student> studentList = StudentManager.extractDB();
		
		if(checkVacanciesForIndex(newIndex)>0) {
			for(Student s : studentList) {
				System.out.println("Searching DB");
				System.out.println("The matrics num is "+ s.getMatricNum());
				if(s.getMatricNum().equals(matricNum)) {
					for(Integer i: s.getRegisteredIndex()) {
						System.out.println("The value of i is " + i);
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
		}else {System.out.println("The slot that you want to add has full vacancies");}
	}
	
	//tested
	public static void removeCourse(String matricsNum, String courseCode) throws ClassNotFoundException, IOException, ConcurrentModificationException {
		
		ArrayList<Student> studentList = StudentManager.extractDB();
		
		boolean removed = false;
		Integer toDelete = -1;
		for(Student s : studentList) {
			if(s.getMatricNum().equals(matricsNum)) {
				ArrayList<Integer> registeredIndex = s.getRegisteredIndex();
				for(Integer i : registeredIndex) {
					if(IndexToCourseCode(i).equals(courseCode)) {
						System.out.println("Found course code");
						toDelete = i;
						//registeredIndex.remove(toDelete);
						//registeredIndex.remove(i);
						CourseManager.slotGivenBack(i, IndexToCourseCode(i));
						StudentManager.UpdateStudentDB(studentList);
						System.out.println("Course " + courseCode +" has been successfully removed");
						removed = true;
					}
				}
				if (toDelete != -1) registeredIndex.remove(toDelete);
				StudentManager.UpdateStudentDB(studentList);
			}
		}
		if (!removed) System.out.println("Course is not registered!");
	}
	
	//tested
		public static void printCourseRegistered(String matricsNum) throws ClassNotFoundException, IOException { 
			 ArrayList<Student> studentList = StudentManager.extractDB();
			 for(Student s: studentList) {
				 if(s.getMatricNum().equals(matricsNum)) {
					 System.out.println("Student name: " + s.getName()+ " is registered\nCourseCode: " );
					 for (Integer index : s.getRegisteredIndex()) {
						 System.out.println(IndexToCourseCode(index) + "\nIndexNum: " + index);
					 }
				 }
			 }	
		}
		
	//tested
		public static void changeIndex(String MatricNum, int newIndex, int oldIndex, String Coursecode) throws ClassNotFoundException, IOException, ConcurrentModificationException { //tested
			Integer toDelete  = -1;
	        ArrayList<Student> studentList = StudentManager.extractDB();
	        for(Student s : studentList) {
	        	ArrayList<Integer> indexList = s.getRegisteredIndex();
	            if(s.getMatricNum().equals(MatricNum)) {
	                 for (int index : s.getRegisteredIndex()) {
	                     if(index == oldIndex && IndexToCourseCode(index).equals(Coursecode)) {
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
	                	     	indexList.add(newIndex);
	                         }
	                         else System.out.println("Index is the same");

	                     }
	                 

	                 }

	        	StudentManager.UpdateStudentDB(studentList);
	            }
		     
	        }
    
	
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
								if (IndexToCourseCode(own).equals(IndexToCourseCode(peer))) {	
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
	
	public static boolean checkCourseRegistered(String matricNum, String courseCode) throws ClassNotFoundException, IOException {
		ArrayList <Student> studentList = StudentManager.extractDB();
		for(Student s : studentList){
			if(s.getMatricNum().equals(matricNum)) {
				for(Integer i : s.getRegisteredIndex()) {
					if(IndexToCourseCode(i).equals(courseCode)){
						System.out.println("Coursecode already registered");
						return false;
					}
				}
			}
		} return true;
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
}