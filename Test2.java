import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Test2  implements Serializable {
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, NoSuchAlgorithmException {
		//ArrayList<Integer> s1Index = new ArrayList<Integer>();
		//Student s1 = new Student("dan_user", "pw123", "dan", "U192456", 'M', "SG", 4, s1Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
        //StudentManager.addStudent(s1);
		//ArrayList<Integer> s2Index = new ArrayList<Integer>();
		//Student s2 = new Student("nic_user", "pw123", "nic", "U199999", 'M', "SG", 4, s2Index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
		//StudentManager.addStudent(s2);
		
		//LoginUI.loginProcess();
		//StudentManager.removeUser("JTOH050");
		//StaffController.addStudent("JTOH050","abc123", "Toh Jun Jie" , "U1922277E", 'M',"Singaporean",
				//2019, LocalTime.of(8,00,00), LocalTime.of(22,0,0));
		//LoginUI.loginProcess();
		//System.out.println(CourseManager.checkVacancies(1));
		//StudentController.printCourseRegistered("U1922277E");
		//StudentController.removeCourse("U1922277E","CZ2002");
		//WaitListManager.removeWaitList(1,"U1922277E");


		//This function is called in addCourse
		WaitListManager.addWaitList(1,"U1922277E");
		//This function is called in removeCourse,SwapCourse
        WaitListManager.checkWaitList(1);

	}
}
