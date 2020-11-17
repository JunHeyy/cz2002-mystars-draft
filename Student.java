import java.time.*;
import java.util.ArrayList;

public class Student extends User {

    private String name;
    private String matricNum;
    private char gender;
    private String nationality;
    private int yearOfStudy;
    private ArrayList<Integer> registeredIndex;
    private LocalTime startAccessTime;
    private LocalTime endAccessTime;
    private static final long serialVersionUID = 10;

    public Student(String username, String password, String name, 
    		String matricNum, char gender, String nationality, 
    		int yearOfStudy, ArrayList<Integer> registeredIndex, LocalTime startAccessTime,
    		LocalTime endAccessTime) {
        super(username, password, "Student");
        this.name = name;
        this.matricNum = matricNum;
        this.gender = gender;
        this.nationality = nationality;
        this.yearOfStudy = yearOfStudy;
        this.registeredIndex = registeredIndex;
        this.startAccessTime = startAccessTime;
        this.endAccessTime = endAccessTime;
    }

    public String getName() {
        return this.name;
    }

    public String getMatricNum() {
        return this.matricNum;
    }

    public char getGender() {
        return this.gender;
    }

    public String getNationality() {
        return this.nationality;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public ArrayList<Integer> getRegisteredIndex() {
        return this.registeredIndex;
    }
    
    public void setRegisteredIndex(ArrayList<Integer> index) {
    	this.registeredIndex = index;
    }


    public LocalTime getStartAccessTime() {
        return this.startAccessTime;
    }

    public void setStartAccessTime(LocalTime startTime) {
        this.startAccessTime = startTime;
    }

    public LocalTime getEndAccessTime() {
        return this.endAccessTime;
    }

    public void setEndAccessTime(LocalTime endTime) {
        this.endAccessTime = endTime;
    }
}