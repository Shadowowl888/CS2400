package DataStructures.Bag;

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(int initalCapacity) {
        integrityOK = false;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[initalCapacity];
        bag = tempBag;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        if (isArrayFull()) {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T remove() {
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    public void clear() {
        while(!isEmpty()) {
            remove();
        }
    }

    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            }
        }
        return counter;
    }
    
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    public boolean isArrayFull() {
        return numberOfEntries == bag.length;
    }

    public int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    public T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }

    public void doubleCapacity() {
        int newLength = 2 * bag.length;
        bag = Arrays.copyOf(bag, newLength);
    }
}
