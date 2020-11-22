import java.io.Serializable;
import java.util.ArrayList;

/**
 * Concrete class for course objects.
 */

public class Course implements Serializable  {

    private String courseCode;
    private String courseName;
    private int numAUs;
    private ArrayList<Index> indexList;

    /**
     * Course constructor
     * @param courseCode - String variable of the course code
     * @param courseName - String variable of the course name
     * @param numAUs - Int variable of the number of AU for the course
     * @param indexList - Array list of the Index in the course
     */
    public Course(String courseCode, String courseName, int numAUs, ArrayList<Index> indexList) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numAUs = numAUs;
        this.indexList = indexList;
    }

    /**
     * Accessor method to get Course code
     * @return
     */
    public String getCourseCode() {
        return this.courseCode;
    }

    /**
     * Accessor method to set Course code
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Accessor method to get Course name
     * @return
     */
    public String getCourseName() {
        return this.courseName;
    }

    /**
     * Accessor method to set Course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Accessor method to get the number of AUs for the course
     * @return
     */
    public int getNumAUs() {
        return this.numAUs;
    }

    /**
     * Accessor method to set the number of AUs for the course
     * @param numAUs
     */
    public void setNumAUs(int numAUs) {
        this.numAUs = numAUs;
    }

    /**
     * Accessor method to get the array list of Index in the course
     * @return
     */
    public ArrayList<Index> getIndexList() {
        return this.indexList;
    }

    /**
     * Accessor method to set the array list of Index in the course
     * @param indexList
     */
    public void setIndexList(ArrayList<Index> indexList) {
        this.indexList = indexList;
    }



    @Override
    public String toString() {
        return "hi";
    }

}
