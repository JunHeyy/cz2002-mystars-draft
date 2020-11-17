import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
public class Test {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
        int [] weeks = new int[3];
        weeks[0] = 1;
        weeks[1] = 2;
        weeks[2] = 3;
       /* Timeslot [] time = new Timeslot[2];
        time[0] = new Timeslot(DayOfWeek.of(5), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);
        time[1] = new Timeslot(DayOfWeek.of(6), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);*/

        /*
        Lesson [] lesson = new Lesson[2];
        lesson[0] = new Lesson("abc", "Jurong", "SSP3", time);
        lesson[1] = new Lesson("abc", "Jurong", "SSP3", time);

        Index [] index = new Index[2];
        
        index[0] = new Index(1, "abcd", 2, 3, lesson);
        index[1] = new Index(2, "cdef", 3, 4, lesson);
        
        Index index4 = new Index(1, "xxxx", 2, 3, lesson);
        Index index5 = new Index(2, "zzzz", 3, 4, lesson);
        
        IndexManager.addIndex(index4);
        IndexManager.addIndex(index5);*/

    //    Course course1 = new Course("abc", "cde", 3, index);
        StaffController SC = new StaffController();
       // SC.addCourse(course1);
       // SC.printAllCourses();
        
        //Student s = new Student("tom", "123", "tom", "123", 'M', "SG", 3, index, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
        
        int [] weeks1 = new int[3];
        weeks1[0] = 1;
        weeks1[1] = 2;
        weeks1[2] = 3;
        ArrayList<Timeslot> time = new ArrayList<Timeslot>();
        Timeslot time1 = new Timeslot(DayOfWeek.of(5), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);
        Timeslot time2 = new Timeslot(DayOfWeek.of(6), LocalTime.of(10,43,12), LocalTime.of(12,43,12), weeks);
        time.add(time1);
        time.add(time2);
        
        //Lesson(String type, String venue, String groupId, String day, String startTime, String endTime)
        
        ArrayList<Lesson> lesson = new ArrayList<Lesson>();
        Lesson lesson1 = new Lesson("abc", "Lecture", "SSP3", "Monday", "08:30", "09:30");
        Lesson lesson2 = new Lesson("abc", "Tutorial", "SSP3", "Tuesday", "09:30", "09:30");
        lesson.add(lesson1); //CZ2002 Lesson
        lesson.add(lesson2);
        
       // Index [] index1 = new Index[3];
        //Index(int indexNum, String courseCode, int maxSize, int numStudents, Lesson[] lessons)
        ArrayList<Index> indexStudent = new ArrayList<Index>();
        
        Index index1 = new Index(2, "CZ2005", 4, 4, lesson);
        indexStudent.add(index1);
        Index index2 = new Index(9, "CZ2006", 5, 4, lesson);
        indexStudent.add(index2);
        Index index3 = new Index(10, "CZ2007", 4, 2, lesson);
        indexStudent.add(index3);
        
       // index1[0] = new Index(1, "CZ2005", 4, 4, lesson);
       // index1[1] = new Index(9, "CZ2006", 5, 4, lesson);
       // index1[2] = new Index(10, "CZ2007", 4, 2, lesson);
        
        ArrayList<Index> indexCourse = new ArrayList<Index>();
        //Index(int indexNum, String courseCode, int maxSize, int numStudents, Lesson[] lessons)
        
        Index index51 = new Index(1, "CZ2005", 4, 4, lesson);
        indexCourse.add(index51);
        Index index52 = new Index(2, "CZ2005", 5, 4, lesson);
        indexCourse.add(index52);
        Index index53 = new Index(3, "CZ2005", 4, 2, lesson);
        
        indexCourse.add(index53);
        
        ArrayList<Index> indexCourseOodp = new ArrayList<Index>();
        Index index54 = new Index(8, "CZ2002", 4, 2, lesson);
        indexCourseOodp.add(index54);
        //indexCourse[1] = new Index(2, "CZ2005", 5, 4, lesson);
        //indexCourse[2] = new Index(3, "CZ2005", 4, 2, lesson);
        
        // Coursecode, coursename, num AU, Index
        Course course2 = new Course("CZ2005", "Operating Systems", 3, indexCourse);
       
        CourseManager.removeCourse("CZ2005");
        CourseManager.addCourse(course2);
        
        Course course3= new Course("CZ2002", "Oodp", 3, indexCourseOodp);
        CourseManager.removeCourse("CZ2002");
        CourseManager.addCourse(course3);
        
        StaffController.printAllCourses();
        
        //Student(String username, String password, String name, String matricNum, char gender, String nationality,  int yearOfStudy, Index[] registeredIndex, LocalTime startAccessTime,
        		//LocalTime endAccessTime)
        
        Index newIndexTest = new Index(8,"CZ2002", 4,4 ,lesson);
        Student s1 = new Student("dan_user", "pw123", "dan", "U192456", 'M', "SG", 4, indexStudent, LocalTime.of(10,43,12), LocalTime.of(12,43,12));
        StudentManager.removeUser("dan_user");
        StudentManager.addStudent(s1);
        StudentController sc = new StudentController();
        sc.printCourseRegisteredbyMatrics("U192456");
        sc.checkVacancies(1);
        sc.addCourse(s1,newIndexTest);
        sc.changeIndex(s1, 3, "CZ2005", 2);
       // sc.removeCourse(s1, "CZ2005");
        sc.checkVacancies(1);
        sc.printCourseRegistered(s1);
        
        
       // sc.checkVacancies(1);

       // StudentController.printCourseRegistered(s1);
       // sc.checkVacancies(1);
        // new index, old index
       // StudentController.changeIndex(s1, 3, "CZ2005", 1);
       // StudentController.printCourseRegistered(s1);
        //sc.checkVacancies(1);
        
	}


}
