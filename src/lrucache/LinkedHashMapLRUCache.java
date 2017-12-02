package lrucache;

import java.util.LinkedHashMap;

public class LinkedHashMapLRUCache extends LinkedHashMap implements Cache {

    public LinkedHashMapLRUCache(int initialCapacity) {
        super(initialCapacity, 1.5f);
    }

    @Override
    public int getSize() {
        return super.size();
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public void insert(Object key, Object value) {

    }
}
