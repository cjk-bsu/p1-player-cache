import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class CacheTest {
    private static long startTime, endTime;
    private static Cache<String> cache;

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
        LinkedList<String> entries;

        try {
            fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            entries = (LinkedList<String>) in.readObject();

            in.close();
        } catch (IOException e) {
            printUsage();
            return;
        } catch (ClassNotFoundException e) {
            printUsage();
            return;
        }

        cache = new Cache<String>(cacheSize);

        for (String entry : entries) {
            cache.getObject(entry);
        }

        endTime = System.currentTimeMillis();

        System.out.println(cache.toString());

        long timeElapsed = endTime - startTime;

        System.out.println("----------------------------------------------------------------\n" +
                "Time elapsed: " + timeElapsed + ".0 milliseconds\n" +
                "----------------------------------------------------------------\n");

    }
}
