import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Test2 {

	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//ArrayList<Index> s1Index = new ArrayList<Index>();
		//Student s1 = new Student("dan_user", "pw123", "dan", "U192456", 'M', "SG", 4, s1Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
       // StaffController.addStudent(s1);
		
		StudentController SC = new StudentController();
        
		//StudentController.addCourse("U192456", 2);
        //SC.addCourse(s1, 1);
		//StudentController.removeCourseByMatricsNum("U192456", "CZ2002");
		//StudentController.removeCourseByMatricsNum("U192456", "CZ2005");
		//StudentController.printCourseRegisteredbyMatrics("U192456");
		
		ArrayList<Index> s2Index = new ArrayList<Index>();
		Student s2 = new Student("nic_user", "pw123", "nic", "U199999", 'M', "SG", 4, s2Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
        StaffController.addStudent(s2);
        //StudentController.removeCourseByMatricsNum("U199999", "CZ2005");
        StudentController.addCourse("U199999", 1);
        StudentController.printCourseRegisteredbyMatrics("U199999");
        //StudentController.printCourseRegisteredbyMatrics("U199999");
        //StudentController.changeIndexByMatric("U192456", 5, 4, "CZ2002");
       // StudentController.removeCourseByMatricsNum("U199999", "CZ2002");
        //StudentController.swapIndex("U192456", 1, 4, "U199999", "123");
       // StudentController.changeIndexByMatric("U199999", 4, 1, "CZ2005");;
       // StudentController.printCourseRegisteredbyMatrics("U199999");
        //StudentController.printCourseRegisteredbyMatrics("U199999");
        
	}
}
