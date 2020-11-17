import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//ArrayList<Integer> s1Index = new ArrayList<Integer>();
		//Student s1 = new Student("dan_user", "pw123", "dan", "U192456", 'M', "SG", 4, s1Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
        //StudentManager.addStudent(s1);
		//ArrayList<Integer> s2Index = new ArrayList<Integer>();
		//Student s2 = new Student("nic_user", "pw123", "nic", "U199999", 'M', "SG", 4, s2Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
		//StudentManager.addStudent(s2);
		
		StudentController SC = new StudentController();
        
		//StudentController.addCourse("U192456", 2);
		//StudentController.addCourse("U199999", 1);
        //SC.addCourse(s1, 1);
		

		StudentController.printCourseRegistered("U192456");
		StudentController.printCourseRegistered("U199999");
		
		//StudentController.addCourse("U199999", 1);
		//StudentController.removeCourse("U192456", "CZ2005");
		//StudentController.changeIndex("U192456", 5, 4, "CZ2005");
		StudentController.swapIndex("U192456", 1, 2, "U199999", "123");
		
		StudentController.printCourseRegistered("U192456");
		StudentController.printCourseRegistered("U199999");
        
        
	}
}
