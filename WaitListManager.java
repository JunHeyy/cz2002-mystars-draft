import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class WaitListManager {
    private static String filename = "data/WaitList.dat";
    private static ArrayList<WaitList> waitList;

    public static void addWaitList(int indexNum, String matricsNum) throws IOException, ClassNotFoundException {
        waitList = extractDB();
        int found =0;
        for(WaitList w : waitList) {
            if(w.getIndexNum() == indexNum &&  w.getMatricsNum().equals(matricsNum)) {
                System.out.println("You have already registered this index into your wait list.");
                found=1;
                break;
            }
        }
        WaitList wl = new WaitList(indexNum, matricsNum);
        if(found==0) {
            waitList.add(wl);
            System.out.println("Succesfully added Course into the database");
            IOController.writeFile(filename, waitList);
        }

    }

    public static void removeWaitList(int index, int matricsNum) throws IOException, ClassNotFoundException {
        waitList = extractDB();
        WaitList toDelete = null;
        for (WaitList w: waitList) {
            if (w.getMatricsNum().equals(matricsNum) && w.getIndexNum() == index) {
                toDelete = w;
                break;
            }
        }
        if (toDelete != null) {
            System.out.println("Removing you from the wait list...");
            waitList.remove(toDelete);
            System.out.println("Success");
            IOController.writeFile(filename, waitList);
        }
        else {
            System.out.println("You do not have this index in the wait list");
        }


    }
    public static void checkWaitList(int index) throws IOException, ClassNotFoundException {

        //Send email to student that is waiting and vacancies is available
        String assignToMatrics = null;
        Boolean indexAvailable = false;
        waitList = extractDB();
        for(WaitList w : waitList){
            if(w.getIndexNum() == index && CourseManager.checkVacancies(index) > 0) {
                assignToMatrics = waitList.get(0).getMatricsNum();
                indexAvailable = true;
                break;
            }
        }
        if(indexAvailable){
            StudentController.addCourse(assignToMatrics,index);
            //Send email
        }


    }
    public static void printCurrentWaitList() throws IOException, ClassNotFoundException {
        waitList = extractDB();
        for(WaitList w : waitList){
            System.out.printf("%s : %i\n", w.getMatricsNum(), w.getIndexNum() );
        }
    }






    public static ArrayList<WaitList> extractDB() throws IOException, ClassNotFoundException {
        try {
            ArrayList<WaitList> waitList = IOController.readFile(filename);
            return waitList;
        }
        catch(FileNotFoundException exception) {
            System.out.println("File not found");
            return null;
        }
    }

    public static void UpdateWaitListDB(ArrayList<WaitList> waitList) {
        try {
            IOController.writeFile(filename, waitList);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
