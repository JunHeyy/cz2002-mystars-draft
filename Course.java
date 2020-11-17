import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable  {

    private String courseCode;
    private String courseName;
    private int numAUs;
    private ArrayList<Index> indexList;
    
    public Course(String courseCode, String courseName, int numAUs, ArrayList<Index> indexList) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numAUs = numAUs;
        this.indexList = indexList;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumAUs() {
        return this.numAUs;
    }

    public void setNumAUs(int numAUs) {
        this.numAUs = numAUs;
    }

    public ArrayList<Index> getIndexList() {
        return this.indexList;
    }

    public void setIndexList(ArrayList<Index> indexList) {
        this.indexList = indexList;
    }
    public int getVacancies() {
    	return 2; //TODO
    }
    
    @Override
    public String toString() {
    	return "hi";
    }

}
