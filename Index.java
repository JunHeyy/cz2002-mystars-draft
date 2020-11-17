import java.io.Serializable;
import java.util.ArrayList;

public class Index implements Serializable{
    
    private int indexNum;
    private String courseCode;
    private int maxSize;
    private int numStudents;
    private ArrayList<Lesson> lessons;



    public Index(int indexNum, String courseCode, int maxSize, int numStudents, ArrayList<Lesson> lessons) {
        this.indexNum = indexNum;
        this.courseCode = courseCode;
        this.maxSize = maxSize;
        this.numStudents = numStudents;
        this.lessons = lessons;

    }

    public int getIndexNum() {
        return this.indexNum;
    }

    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getNumStudents() {
        return this.numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
    


    
    public String toString() {
    	return this.indexNum + ","+ this.courseCode +  "," + this.maxSize+ ","+
        this.numStudents + "," + this.lessons ;
    }
    

}