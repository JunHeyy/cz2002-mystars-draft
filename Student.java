import java.time.*;

public class Student extends User {

    private String name;
    private String matricNum;
    private char gender;
    private String nationality;
    private int yearOfStudy;
    private Index[] registeredIndex;
    private LocalTime startAccessTime;
    private LocalTime endAccessTime;
    private static final long serialVersionUID = 10;

    public Student(String username, String password, String name, 
    		String matricNum, char gender, String nationality, 
    		int yearOfStudy, Index[] registeredIndex, LocalTime startAccessTime,
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

    public Index[] getRegisteredIndex() {
        return this.registeredIndex;
    }
    
    public void setRegisteredIndex(Index[] index) {
    	this.registeredIndex = index;
    }
    
    public void addRegisteredIndex(Index index) {
    	Index[] currentRegisteredIndex = this.registeredIndex;
    	
    	
    	
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