import java.time.*;
import java.util.ArrayList;

/**
 * Concrete class to create student object.
 */

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

    /**
     *
     * @param username String Variable, Username of the student account.
     * @param password String Variable, Password of the student account.
     * @param name String Variable, Name of the student.
     * @param matricNum String Variable, Matrics number of the student.
     * @param gender Character Variable, Gender of the student.
     * @param nationality String Variable, Nationality of the student.
     * @param yearOfStudy Integer variable, Year that the student enrolled into the school/
     * @param registeredIndex Arraylist Index variable, Arraylist of index objects.
     * @param startAccessTime Local Time Variable, Start time that the student can access the stars system.
     * @param endAccessTime Local Time Variable, End time that the student is able to access the stars until.
     */

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

    /**
     * Accessors method to get the name of the student object.
     * @return The name of the student.
     */
    public String getName() {
        return this.name;
    }

    /**
     *  Accessor method to get matrics number of the student.
     * @return returns the matrics number of the student.
     */

    public String getMatricNum() {
        return this.matricNum;
    }

    /**
     * Accessor method to get gender of the student.
     * @return
     */

    public char getGender() {
        return this.gender;
    }

    /**
     * Accessor method to get nationality of the student.
     * @return The nationality of the student.
     */

    public String getNationality() {
        return this.nationality;
    }

    /**
     * Accessor method to get year of study of the student.
     * @return Year of study of the student.
     */

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    /**
     * Accessor method to get arraylist of the registered index of the student.
     * @return Arraylist of index object that the student has registered for.
     */


    public ArrayList<Integer> getRegisteredIndex() {
        return this.registeredIndex;
    }

    /**
     * Mutator method to set the registered index of the student.
     * @param index Index object.
     */
    
    public void setRegisteredIndex(ArrayList<Integer> index) {
    	this.registeredIndex = index;
    }

    /**
     * Accessor method to get get the start access time of the student.
     * @return The start access time of the object.
     */
    public LocalTime getStartAccessTime() {
        return this.startAccessTime;
    }

    /**
     * Mutator method to set the start access time of the student.
     * @param startTime Localtime variable, start time of the student object.
     */
    public void setStartAccessTime(LocalTime startTime) {
        this.startAccessTime = startTime;
    }

    /**
     * Accessor method to get end access time of the student.
     * @return endaccess time of the student.
     */

    public LocalTime getEndAccessTime() {
        return this.endAccessTime;
    }

    /**
     * Mutator method to set the end access time of the student.
     * @param endTime Localtime variable, the end time that the student can access the stars system.
     */
    public void setEndAccessTime(LocalTime endTime) {
        this.endAccessTime = endTime;
    }
}