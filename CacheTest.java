import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * This class acts as the main driver for the creation and implementation of the
 * Cache class to act as a cache for serialized data being read in from provided
 * filenames given a provided cache size.
 *
 * @author carsonkeller
 */
public class CacheTest {
    private static long startTime, endTime;
    private static Cache<Player> cache;

    /**
     * This method prints usage instructions to the console.
     */
    private static void printUsage() {
        System.out.println("java CacheTest <cache-size> <serialized-data-filename>");
    }

    /**
     * This main method parses the required command line arguments, instantiates a
     * new cache of the specified size, deserializes and reads in the contents of a
     * specified file to be added to that cache. The necessary command line args
     * consist of: 1. the integer value of the cache size or the number of objects
     * it can hold, and 2. the name of the file to be read in.
     *
     * @param args - string values for both the integer value of the cache size
     *               followed by the filename of the data file to be read in
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        int cacheSize;

        try {
            cacheSize = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            printUsage();
            return;
        }

        String fileName = args[1];

        if (!fileName.contains(".data")) {
            printUsage();
            return;
        }

        startTime = System.currentTimeMillis();

        FileInputStream fileIn;
        ArrayList<Player> entries;

        try {
            fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            entries = (ArrayList<Player>) in.readObject();

            cache = new Cache<Player>(cacheSize);

            for (Player entry : entries) {
                cache.getObject(entry);
            }

            endTime = System.currentTimeMillis();

            System.out.println(cache.toString());

            long timeElapsed = endTime - startTime;

            System.out.println("----------------------------------------------------------------\n" +
                    "Time elapsed: " + timeElapsed + ".0 milliseconds\n" +
                    "----------------------------------------------------------------");

            in.close();
        } catch (IOException e) {
            printUsage();
            return;
        } catch (ClassNotFoundException e) {
            printUsage();
            return;
        }
    }
}
