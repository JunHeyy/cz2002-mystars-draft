public class WaitList {
    private int indexNum, matricsNum;

    public WaitList(int indexNum, int matricsNum){
        this.indexNum = indexNum;
        this.matricsNum= matricsNum;
    }


    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    public int getMatricsNum() {
        return matricsNum;
    }

    public void setMatricsNum(int matricsNum) {
        this.matricsNum = matricsNum;
    }
}
