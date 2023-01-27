import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CacheTest {
    private static long startTime, endTime;
    private static Cache<Player> cache;

    private static void printUsage() {
        System.out.println("java CacheTest <cache-size> <serialized-data-filename>");
    }

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
