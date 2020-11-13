import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;

public class Test2 {

	
	public static void main(String[] args) {
		System.out.println("Time");
        int [] weeks = new int[3];
        weeks[0] = 1;
        weeks[1] = 2;
        weeks[2] = 3;
        Timeslot [] time = new Timeslot[2];
        time[0] = new Timeslot(DayOfWeek.of(5), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);
        time[1] = new Timeslot(DayOfWeek.of(6), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);

        Lesson [] lesson = new Lesson[2];
        lesson[0] = new Lesson("abc", "Jurong", "SSP3", time);
        lesson[1] = new Lesson("abc", "Jurong", "SSP3", time);

        Index [] index = new Index[2];
        
        index[0] = new Index(1, "abcd", 2, 3, lesson);
        index[1] = new Index(2, "cdef", 3, 4, lesson);
        
        Index index2 = new Index(1, "abcd", 2, 3, lesson);
        
       

        Course course1 = new Course("abc", "cde", 3, index);
        User user = new User("jj", "asd", "Staff");
        Staff staff = new Staff("jj", "asd", 1234);
        Student student = new Student("student3", "zxc", "Nic", 
        		"U19223", 'm', "Singaporean", 
        		3, index, LocalTime.of(10,43,12),
        		LocalTime.of(12,43,12));
      
        		
        		/*try {
			IndexManager.addIndex(index2);
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}*/
        
        try {
			StudentManager.addStudent(student);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        StaffController.printStudentByCourse("cdef");
        
	}
}
