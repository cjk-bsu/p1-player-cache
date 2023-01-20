/**
 * This document constitutes an interface to be used in the design and
 * implementation of a Cache class and defines the necessary methods
 * required by the specifications of the project.
 *
 * @author carsonkeller
 */
public interface CacheInterface<T> {

    /**
     *  This method searches the cache for a specified object and returns it
     *  if it "hits" and the object is present. The returned object is then
     *  moved into the first position of the cache given the MRU scheme. If
     *  the object is not present and the cache "misses", the application
     *  adds the object to the first position in the cache. If the cache is
     *  full, the last, meaning the Least Recently Used (LRU), entry in the
     *  cache is removed before the new entry is added since the size of the
     *  cache is fixed.
     *
     * @param target - This parameter is the element to be searched for in
     *                  the cache and returned.
     * @return - This method returns the object once it is either found in or
     *           added to the cache.
     */
    public T getObject(T target);

    /**
     * This method simply adds an object to the front of the cache assuming it
     * isn't already in the cache and the cache has room.
     */
    public void addObject(T target);

    /**
     * This method simply removes the specified object from the cache assuming
     * the object is already in the cache.
     */
    public void removeObject(T target);

    /**
     * This method clears all entries from the cache.
     */
    public void clearCache();

    /**
     * This method prints out the number of entries in the cache along with the
     * number of references, number of hits, and the hit ratio (as a percentage).
     *
     * @return - This method returns a string displaying information as previously
     *           specified.
     */
    public String toString();
}
