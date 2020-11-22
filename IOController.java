import java.io.*;
import java.util.ArrayList;

/**
 * Controller class to handle all IO operations.
 * @param <T>
 */
public class IOController <T> {
    /**
     * Function to write the file with the respective array list.
     * @param filename String variable, location of the file.
     * @param list Arraylist variable, the array list to write the file into.
     * @param <T> Object, the object to place inside the array list.
     * @throws IOException File does not exist.
     */

    public static <T> void writeFile(String filename, ArrayList<T> list) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(list);
    }

    /**
     * Function to read file with the array list.
     * @param filename String Variable, the name of the file.
     * @param <T> Object, the object to input in the arraylist.
     * @return the array list inside the .dat file.
     * @throws IOException File does not exist.
     * @throws ClassNotFoundException Mentioned classes are not found in the classpath.
     */

    public static <T> ArrayList<T> readFile(String filename) throws IOException, ClassNotFoundException {
        ArrayList<T> list = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            list = (ArrayList<T>) ois.readObject();
        } catch (Exception e) {
            list = new ArrayList<T>();
        }
        return list;
    }

}
