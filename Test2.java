import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Test2 {
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
		LoginUI.loginProcess();
        
        
	}
}
