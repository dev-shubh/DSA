package lrucache;

public interface Cache<K,V> {
    public int getSize();
    public V get(K key);
    public void insert(K key, V value);

}
