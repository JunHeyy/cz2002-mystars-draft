import java.io.Serializable;
import java.util.ArrayList;

/**
 * Concrete class for index object
 */

public class Index implements Serializable{
    
    private int indexNum;
    private String courseCode;
    private int maxSize;
    private int numStudents;
    private ArrayList<Lesson> lessons;

    /**
     * Constructor for index object
     * @param indexNum Integer variable, index number of the student.
     * @param courseCode String variable, Coursecode of the course.
     * @param maxSize Integer variable, Max number of students in the index.
     * @param numStudents Integer variable, Number of students in the index.
     * @param lessons Arraylist variable, an array list of lesson objects.
     */

    public Index(int indexNum, String courseCode, int maxSize, int numStudents, ArrayList<Lesson> lessons) {
        this.indexNum = indexNum;
        this.courseCode = courseCode;
        this.maxSize = maxSize;
        this.numStudents = numStudents;
        this.lessons = lessons;

    }
    
    public Index() {}

    /**
     * Accessor method for index number.
     * @return Index number of that course.
     */

    public int getIndexNum() {
        return this.indexNum;
    }

    /**
     * Mutator method to set index number.
     * @param indexNum Integer variable, index number of the student.
     */

    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    /**
     * Accessor method to get course code.
     * @return Returns String variable, course code.
     */

    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Mutator method to set coursecode.
     * @param courseCode Course code in string.
     */

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Accessor method to get max size for that index.
     * @return returns max size of that index.
     */

    public int getMaxSize() {
        return this.maxSize;
    }

    /**
     * Mutator method to set max size for the index.
     * @param maxSize Integer variable, Max number of students in the index.
     */

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Accessor method to get number of students for that index.
     * @return returns number of students in the lesson.
     */

    public int getNumStudents() {
        return this.numStudents;
    }

    /**
     * Mutator method to set number of students for that course.
     * @param numStudents Integer variable, Number of students in the index.
     */

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    /**
     * Returns the Arraylist lesson.
     * @return returns a lesson Arraylist
     */

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    /**
     * Mutator method to set Arraylist lesson for index.
     * @param lessons object
     */

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
    


    

    

}