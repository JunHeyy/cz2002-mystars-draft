import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class WaitListManager {
    private static String filename = "data/WaitList.dat";

    public static void addWaitList(Index newIndex) throws IOException, ClassNotFoundException {
        ArrayList<WaitList> waitList = IOController.readFile(filename);

    }

    public static void removeWaitList(int index) throws IOException, ClassNotFoundException {


    }
    public static void checkWaitList(int index){

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
