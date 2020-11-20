public class WaitList {
    private int indexNum;
    private String matricsNum;

    public WaitList(int indexNum, String matricsNum){
        this.indexNum = indexNum;
        this.matricsNum= matricsNum;
    }

    public int getIndexNum() {
        return indexNum;
    }


    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    public String getMatricsNum() {
        return matricsNum;
    }

    public void setMatricsNum(String matricsNum) {
        this.matricsNum = matricsNum;
    }
}
