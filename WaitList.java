import java.io.Serializable;

/**
 * Concrete class to create waitlist object.
 */

public class WaitList implements Serializable {
    private int indexNum;
    private String matricsNum;

    /**
     * Constructor for Waitlist object
     * @param indexNum Int variable
     * @param matricsNum String variable
     */
    public WaitList(int indexNum, String matricsNum){
        this.indexNum = indexNum;
        this.matricsNum= matricsNum;
    }

    /**
     * Accessor method to get index number.
     * @return  Index number.
     */

    public int getIndexNum() {
        return indexNum;
    }

    /**
     * Mutator method to set index number of the student.
     * @param indexNum Index number of the student.
     */

    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    /**
     * Accessor method to get the matrics number of the student.
     * @return Return the matrics number of the student.
     */

    public String getMatricsNum() {
        return matricsNum;
    }

    /**
     * Mutator method to set the matrics number of the student.
     * @param matricsNum Matrics number of the student.
     */

    public void setMatricsNum(String matricsNum) {
        this.matricsNum = matricsNum;
    }
}
