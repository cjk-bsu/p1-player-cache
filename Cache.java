import java.util.LinkedList;

/**
 * This class implements a pre-defined interface to create a cache designed to
 * store frequently used data items and reduce data retrieval and access time.
 *
 * @author carsonkeller
 */
public class Cache<T> implements CacheInterface<T> {
    private LinkedList<T> cache;
    private int cacheSize;
    private int hits;
    private int totalCalls;

    /**
     * This method is the primary constructor for the Cache class and instantiates
     * a new Linked List to hold entries into the cache.
     *
     * @param cacheSize - integer value of the number of entries the cache can
     *                    hold at once
     */
    public Cache(int cacheSize) {
        this.cacheSize = cacheSize;
        cache = new LinkedList<T>();
        hits = 0;
        totalCalls = 0;
    }

    @Override
    public T getObject(T target) {
        totalCalls++;
        boolean inCache = cache.contains(target);

        if (inCache) {
            hits++;
            removeObject(target);
            addObject(target);
        } else {
            if (cache.size() >= cacheSize) {
                cache.removeLast();
                addObject(target);
            } else {
                addObject(target);
            }

        }

        return(target);
    }

    @Override
    public void addObject(T target) {
        cache.addFirst(target);
    }

    @Override
    public void removeObject(T target) {
        cache.remove(target);
    }

    @Override
    public void clearCache() {
        cache.clear();
    }

    @Override
    public String toString() {
        int getCalls = (totalCalls - cacheSize);

        return("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "LinkedList Cache with " + getCalls + "entries has been created\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Total number of references:        " + cacheSize + "\n" +
                "Total number of cache hits:        " + hits + "\n" +
                "Cache hit ratio:                   " + (hits / getCalls) + "%\n\n");
    }
}