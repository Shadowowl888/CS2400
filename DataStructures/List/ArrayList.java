package DataStructures.List;

import java.util.Arrays;

public class ArrayList<T> {
    private T[] list;
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        integrityOK = false;

        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        } else {
            checkCapacity(initialCapacity);
        }

        @SuppressWarnings("unchecked")
        T[] tempList = (T[])new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
        integrityOK = true;
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public void add(T newEntry) {
        add(numberOfEntries + 1, newEntry);
    }

    public void add(int givenPosition, T newEntry) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            if (givenPosition <= numberOfEntries) {
                makeRoom(givenPosition);
            }
            list[givenPosition] = newEntry;
            numberOfEntries++;
            ensureCapacity();
        } else {
            throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
        }
    }

    public T remove(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            T result = list[givenPosition];
            if (givenPosition <= numberOfEntries - 1) {
                removeGap(givenPosition);
            }
            list[numberOfEntries] = null;
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");  
        }
    }

    public T replace(int givenPosition, T newEntry) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }
    
    public void clear() {
        checkIntegrity();
        for (int index = 1; index <= numberOfEntries; index++) {
            list[index] = null;
        }
        numberOfEntries = 0;
    }

    public T getEntry(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return list[givenPosition];
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    public T[] toArray() {
        checkIntegrity();
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];
        }
        return result;
    }

    public boolean contains(T anEntry) {
        checkIntegrity();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries)) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }

    private void ensureCapacity() {
        int capacity = list.length - 1;
        if (numberOfEntries >= capacity) {
            int newCapacity = 2 * capacity;
            checkCapacity(newCapacity);
            list = Arrays.copyOf(list, newCapacity + 1);
        }
    }

    private void checkCapacity(int capacity) {
        
    }

    private void checkIntegrity() {

    }

    private void makeRoom(int givenPosition) {
        int newIndex = givenPosition;
        int lastIndex = numberOfEntries;
        for (int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        for (int index = removedIndex; index < numberOfEntries; index++) {
            list[index] = list[index + 1];
        }
    }
}
