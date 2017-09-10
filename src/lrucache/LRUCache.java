package lrucache;
import java.util.HashMap;
import java.util.LinkedList;

/*You are required to complete below class */
public class LRUCache {

    int cacheSize;
    HashMap<Integer, Page> cache = new HashMap();  // Hashmap of page Number and Page.
    LinkedList<Integer> list;

    public LRUCache(int cacheSize) {
        if (cacheSize > 0) this.cacheSize = cacheSize;
        else throw new RuntimeException("Unable to create Cache, given size should be more than 0.");
    }

    /*Returns the value of the key x if
         present else returns -1 */
    public int get(int x) {
        if (cache.containsKey(x)) {
            return (int) cache.get(x);
        }
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here
    }


}
