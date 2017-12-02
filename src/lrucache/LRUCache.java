package lrucache;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K, V> implements Cache{

    private final int size;
    private final HashMap<K, V> cache;  // Hashmap of page Number and Page.
    private final LinkedList<K> list;

    public LRUCache(int cacheSize) {
        if (cacheSize > 0) {
            this.size = cacheSize;
            this.cache = new HashMap<K, V>(cacheSize);
            this.list = new LinkedList<K>();
        }
        else throw new RuntimeException("Unable to create Cache, given size should be more than 0.");
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Object get(Object key) {
        if (cache.containsKey(key)) { // if the page is already cached, make it the the most recently page in list.
            V value = cache.get(key);
            list.remove(key);
            list.add((K) key);
            return value;
        }
        else{

        }
        return null;
    }

    @Override
    public void insert(Object key, Object value) {

    }
}
