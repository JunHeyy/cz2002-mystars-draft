import java.io.IOException;
import java.time.*;
public class Test {
	public static void main(String[] args) {
		
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
       

        Course course1 = new Course("abc", "cde", 3, index);
        StaffController SC = new StaffController();
        
        SC.addCourse(course1);
        SC.printAllCourses();
        
        Student s = new Student("tom", "123", "tom", "123", 'M', "SG", 3, index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
        
        int [] weeks1 = new int[3];
        weeks1[0] = 1;
        weeks1[1] = 2;
        weeks1[2] = 3;
        Timeslot [] time1 = new Timeslot[2];
        time1[0] = new Timeslot(DayOfWeek.of(5), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);
        time1[1] = new Timeslot(DayOfWeek.of(6), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);

        Lesson [] lesson1 = new Lesson[2];
        lesson1[0] = new Lesson("abc", "Jurong", "SSP3", time);
        lesson1[1] = new Lesson("abc", "Jurong", "SSP3", time);

        Index [] index1 = new Index[2];
        
        index1[0] = new Index(1, "xxxx", 2, 3, lesson);
        index1[1] = new Index(2, "zzzz", 3, 4, lesson);
       

        Course course2 = new Course("def", "cde", 3, index1);
        
        Student s1 = new Student("dan", "456", "dan", "456", 'M', "SG", 4, index1, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
		
        //System.out.println(s.getRegisteredIndex());
        //Staff s2 = new Staff("lll", "4523", 1);
        StudentController.printCourseRegistered(s1);
        //StudentController.printCourseRegistered(s);
        StudentController.changeIndex(s1, 2, "dcf");
        //StudentController.swapIndex(s, index[0], index1[1], s1, "456");
        StudentController.printCourseRegistered(s1);
        //StudentController.printCourseRegistered(s);
	}
}
