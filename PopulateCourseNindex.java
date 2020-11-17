import java.io.IOException;
import java.util.ArrayList;

public class PopulateCourseNindex {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList <Lesson>CZ2002lesson1 = new ArrayList<Lesson>();
		Lesson CZ2002lesson1a = new Lesson("Lecture", "LT 1", null, "Monday", "0900", "1100", "1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2002lesson1b = new Lesson("Tut", "Tut room 1", "SS1", "Tuesday", "1000", "1100", "2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2002lesson1c = new Lesson("Lab", "SW Lab 1", "SS1", "Wednesday", "1200", "1400", "2,4,6,8,10,12");
		CZ2002lesson1.add(CZ2002lesson1a);
		CZ2002lesson1.add(CZ2002lesson1b);
		CZ2002lesson1.add(CZ2002lesson1c);
		
		
		ArrayList <Lesson>CZ2002lesson2 = new ArrayList<Lesson>();
		Lesson CZ2002lesson2a = new Lesson("Lecture", "LT 1", null, "Monday", "0900", "1100", "1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2002lesson2b = new Lesson("Tut","Tut room 2","SS2","Tuesday","1100","1200","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2002lesson2c = new Lesson("Lab","SW lab 1","SS2","Thursday","1200","1400","3,5,7,9,11,13");
		CZ2002lesson2.add(CZ2002lesson2a);
		CZ2002lesson2.add(CZ2002lesson2b);
		CZ2002lesson2.add(CZ2002lesson2c);
		
		ArrayList <Lesson>CZ2002lesson3 = new ArrayList<Lesson>();
		Lesson CZ2002lesson3a = new Lesson("Lecture", "LT 1", null, "Monday", "0900", "1100", "1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2002lesson3b = new Lesson("Tut","Tut room 3","SS3","Wednesday","1100","1200","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2002lesson3c = new Lesson("Lab","SW lab 1","SS3","Friday","1200","1400","3,5,7,9,11,13");
		CZ2002lesson3.add(CZ2002lesson3a);
		CZ2002lesson3.add(CZ2002lesson3b);
		CZ2002lesson3.add(CZ2002lesson3c);
		
		
		ArrayList <Index>CZ2002Index = new ArrayList<Index>();
		Index CZ2002Index1a = new Index (1, "CZ2002", 20, 0, CZ2002lesson1);
		Index CZ2002Index1b = new Index (2, "CZ2002", 20, 0, CZ2002lesson2);
		Index CZ2002Index1c = new Index (3, "CZ2002", 20, 0, CZ2002lesson3);
		CZ2002Index.add(CZ2002Index1a);
		CZ2002Index.add(CZ2002Index1b);
		CZ2002Index.add(CZ2002Index1c);
		
		Course CZ2002 = new Course("CZ2002", "OODP", 3, CZ2002Index);
		
		/************************************************/
		
		ArrayList <Lesson>CZ2005lesson1 = new ArrayList<Lesson>();
		Lesson CZ2005lesson1a = new Lesson("Lecture","LT 2",null,"Monday" ,"1400", "1500", "1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2005lesson1b = new Lesson("Tut","Tut room 1" ,"SSP3", "Tuesday" ,"0800","1000","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2005lesson1c = new Lesson("Lab","SW lab 3" ,"SSP3", "Wednesday","1000","1200","2,4,6,8,10,12");
		CZ2005lesson1.add(CZ2005lesson1a);
		CZ2005lesson1.add(CZ2005lesson1b);
		CZ2005lesson1.add(CZ2005lesson1c);
		
		
		ArrayList <Lesson>CZ2005lesson2 = new ArrayList<Lesson>();
		Lesson CZ2005lesson2a = new Lesson("Lecture","LT 2",null ,"Monday" ,"1400", "1500", "1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2005lesson2b = new Lesson("Tut","Tut room 2","SSP4", "Tuesday","0800","1000","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2005lesson2c = new Lesson("Lab","SW lab 3","SSP4","Thursday","1000","1200","3,5,7,9,11,13");
		CZ2005lesson2.add(CZ2005lesson2a);
		CZ2005lesson2.add(CZ2005lesson2b);
		CZ2005lesson2.add(CZ2005lesson2c);
		
		ArrayList <Lesson>CZ2005lesson3 = new ArrayList<Lesson>();
		Lesson CZ2005lesson3a = new Lesson("Lecture","LT 2",null ,"Monday" ,"1400", "1500", "1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2005lesson3b = new Lesson("Tut","Tut room 3","SS3", "Wednesday","1000","1200","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2005lesson3c = new Lesson("Lab","SW lab 1","SS3","Friday","1200","1400","3,5,7,9,11,13");
		CZ2005lesson3.add(CZ2005lesson3a);
		CZ2005lesson3.add(CZ2005lesson3b);
		CZ2005lesson3.add(CZ2005lesson3c);
		
		
		ArrayList <Index>CZ2005Index = new ArrayList<Index>();
		Index CZ2005Index1a = new Index (4, "CZ2005", 20, 0, CZ2005lesson1);
		Index CZ2005Index1b = new Index (5, "CZ2005", 20, 0, CZ2005lesson2);
		Index CZ2005Index1c = new Index (6, "CZ2005", 20, 0, CZ2005lesson3);
		CZ2005Index.add(CZ2005Index1a);
		CZ2005Index.add(CZ2005Index1b);
		CZ2005Index.add(CZ2005Index1c);
		
		Course CZ2005 = new Course("CZ2005", "OS", 3, CZ2005Index);
		
		/**************************************************/
		
		ArrayList <Lesson>CZ2007lesson1 = new ArrayList<Lesson>();
		Lesson CZ2007lesson1a = new Lesson("Lecture","LT 3", null, "Thursday", "0800","0900","1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2007lesson1b = new Lesson("Tut","Tut room 4","SSP3", "Tuesday","1100","1200","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2007lesson1c = new Lesson("Lab","SW lab 2","SSP3","Wednesday","1000","1200","2,4,6,8,10,12");
		CZ2007lesson1.add(CZ2007lesson1a);
		CZ2007lesson1.add(CZ2007lesson1b);
		CZ2007lesson1.add(CZ2007lesson1c);
		
		
		ArrayList <Lesson>CZ2007lesson2 = new ArrayList<Lesson>();
		Lesson CZ2007lesson2a = new Lesson("Lecture","LT 3", null, "Thursday", "0800","0900","1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2007lesson2b = new Lesson("Tut","Tut room 5","SSP4", "Tuesday","1300","1400","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2007lesson2c = new Lesson("Lab","SW lab 3","SSP4", "Thursday","1600","1800","3,5,7,9,11,13");
		CZ2007lesson2.add(CZ2007lesson2a);
		CZ2007lesson2.add(CZ2007lesson2b);
		CZ2007lesson2.add(CZ2007lesson2c);
		
		ArrayList <Lesson>CZ2007lesson3 = new ArrayList<Lesson>();
		Lesson CZ2007lesson3a = new Lesson("Lecture","LT 3", null, "Thursday", "0800","0900","1,2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2007lesson3b = new Lesson("Tut","Tut room 6","SS3", "Wednesday","1300","1400","2,3,4,5,6,7,8,9,10,11,12,13");
		Lesson CZ2007lesson3c = new Lesson("Lab","SW lab 1","SS3", "Friday","1600","1800","3,5,7,9,11,13");
		CZ2007lesson3.add(CZ2007lesson3a);
		CZ2007lesson3.add(CZ2007lesson3b);
		CZ2007lesson3.add(CZ2007lesson3c);
		
		
		ArrayList <Index>CZ2007Index = new ArrayList<Index>();
		Index CZ2007Index1a = new Index (7, "CZ2007", 20, 0, CZ2007lesson1);
		Index CZ2007Index1b = new Index (8, "CZ2007", 20, 0, CZ2007lesson2);
		Index CZ2007Index1c = new Index (9, "CZ2007", 20, 0, CZ2007lesson3);
		CZ2007Index.add(CZ2007Index1a);
		CZ2007Index.add(CZ2007Index1b);
		CZ2007Index.add(CZ2007Index1c);
		
		Course CZ2007 = new Course("CZ2007", "Database", 3, CZ2007Index);
		//CourseManager.removeCourse("CZ2007");
		//CourseManager.removeCourse("CZ2005");
		//CourseManager.removeCourse("CZ2002");
		CourseManager.addCourse(CZ2007);
		CourseManager.addCourse(CZ2005);
		CourseManager.addCourse(CZ2002);
	}
}
