package DataStructures.Dictionary;

public class ArrayUnsortedDictionary<K,V> implements DictionaryInterface<K,V> {
    private Entry<K,V>[] dictionary;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 5;
    private static final int MAX_CAPACTIY = 10000;

    public ArrayUnsortedDictionary() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayUnsortedDictionary(int initialCapacity) {
        @SuppressWarnings("unchecked")
        Entry<K,V>[] tempDictionary = (Entry<K,V>[]) new Entry[initialCapacity];
        dictionary = tempDictionary;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public V add(K key, V value) {
        V result = dictionary[key];
        return result;
        if ((key == null) || (value == null)) {
            throw new IllegalArgumentException("Cannot add null to this dictionary.");
        } else {
            V result = null;
            int keyIndex = locateIndex(key);
            if (keyIndex < numberOfEntries) {
                result = dictionary[keyIndex].getValue();
                dictionary[keyIndex].setValue(value);
            } else {
                dictionary[numberOfEntries] = new Entry<>(key, value);
                numberOfEntries++;
                ensureCapacity();
            }
            return result;
        }
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

    private int locateIndex(K key) {
        
    }

    private void ensureCapacity() {

    }

    private class Entry<K,V> {
        private K key;
        private V value;

        private Entry(K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V dataValue) {
            value = dataValue;
        }
    }
}
