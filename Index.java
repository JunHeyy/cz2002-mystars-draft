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
     * @param indexNum
     * @param courseCode
     * @param maxSize
     * @param numStudents
     * @param lessons
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
     * @return
     */

    public int getIndexNum() {
        return this.indexNum;
    }

    /**
     * Mutator method to set index number.
     * @param indexNum
     */

    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    /**
     * Accessor method to get course code.
     * @return
     */

    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Mutator method to set coursecode.
     * @param courseCode
     */

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Accessor method to get max size for that index.
     * @return
     */

    public int getMaxSize() {
        return this.maxSize;
    }

    /**
     * Mutator method to set max size for the index.
     * @param maxSize
     */

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Accessor method to get number of students for that index.
     * @return
     */

    public int getNumStudents() {
        return this.numStudents;
    }

    /**
     * Mutator method to set number of students for that course.
     * @param numStudents
     */

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    /**
     * Returns the Arraylist lesson.
     * @return
     */

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    /**
     * Mutator method to set Arraylist lesson for index.
     * @param lessons
     */

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
    


    

    

}