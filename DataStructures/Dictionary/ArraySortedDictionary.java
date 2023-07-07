package DataStructures.Dictionary;

public class ArraySortedDictionary<K,V> implements DictionaryInterface<K,V> {
    private Entry<K,V>[] dictionary;
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MAX_CAPACTIY = 10000;

    public void add(K key, V value) {
        
    }

    public V remove(K key) {
        V result = dictionary[key];
        return result;
    }
    
    public V getValue(K key) {
        return dictionary[key];
    }

    public boolean contains(K key) {
        
    }

    public boolean isEmpty() {

    }

    public int getSize() {

    }

    public void clear() {

    }
}
