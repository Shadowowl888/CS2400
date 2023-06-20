package Assignment1;

import java.util.Arrays;

/**
 * A class of bags whose entries are stored in an array.
 */
public class ResizeableArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    
    /**
     * The default constructor to create an array with DEFAULT_CAPACITY size.
     */
    public ResizeableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * The constructor to create an array with desiredCapacity.
     * @param desiredCapacity  the size of the array
     */
    public ResizeableArrayBag(int desiredCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[desiredCapacity];
        bag = tempBag;
        numberOfEntries = 0;
    }

    /**
     * Gets the number of entries currently in this bag.
     * @return  The integer number of entries currently in this bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     * @return  True if this bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Adds a new entry to this bag.
     * @param newEntry  The object to be added as a new entry.
     * @return  True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        if (isArrayFull()) {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        T result = removeEntry(numberOfEntries - 1);
        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry  The entry to be removed.
     * @return  True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while(!isEmpty()) {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry  The entry to be counted.
     * @return  The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            }
        }
        return counter;
    }
    
    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry  The entry to locate.
     * @return  True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }

    /**
     * Retrieves all entries that are in this bag.
     * @return  A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }
    /**
     * Checks if the array has reached its capacity.
     * @return  True if the array is full, or false if not.
     */
    public boolean isArrayFull() {
        return numberOfEntries == bag.length;
    }

    /**
     * Finds the index of a specified entry in the array.
     * @param anEntry  The entry to locate.
     * @return  The index of the entry in the array.
     */
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

    /**
     * Removes a specific entry at a given index in the array.
     * @param givenIndex  The index of the entry to remove.
     * @return  The removed entry.
     */
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

    /**
     * Doubles the capacity of the array and copies the elements into a new array.
     */
    public void doubleCapacity() {
        int newLength = 2 * bag.length;
        bag = Arrays.copyOf(bag, newLength);
    }

    /**
     * The union of two collections consists of the contents combined into a new collection.
     * @param other  The other bag that is to have its contents combined with this bag.
     * @return  A new bag that contains the combined contents of this bag and the other bag.
     */
    @Override
    public BagInterface<T> union(BagInterface<T> other) {
        ResizeableArrayBag<T> result = new ResizeableArrayBag<>();
        for (int i = 0; i < numberOfEntries; i++) {
            result.add(bag[i]);
        }
        for (Object ob : other.toArray()) {
            result.add((T) ob);
        }
        return result;
    }

    /**
     * A new collection of the entries that occur in both bags.
     * @param other  The other bag is to have its contents compared with this bag.
     * @return  A new bag that contains overlapping contents of this bag and the other bag.
     */
    @Override
    public BagInterface<T> intersection(BagInterface<T> other) {
        ResizeableArrayBag<T> result = new ResizeableArrayBag<>();
        for (int i = 0; i < numberOfEntries; i++) {
            T item = bag[i];
            if (!result.contains(item) && other.contains(item)) {
                int commonCount = Math.min(getFrequencyOf(item), other.getFrequencyOf(item));
                for (int j = 0; j < commonCount; j++) {
                    result.add(item);
                }   
            }
        }
        return result;
    }

    /**
     * A new collection of the entries that are leftover in one collection after removing the overlapping entries.
     * @param other  The other bag is to have its contents compared with this bag.
     * @return  A new bag containing the contents that are left in this new bag after removing overlapping entries that occur in this bag and the other bag.
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> other) {
        ResizeableArrayBag<T> result = new ResizeableArrayBag<T>();
        for (int i = 0; i < numberOfEntries; i++) {
            T item = bag[i];
            if (!result.contains(item)) {
                int difference = getFrequencyOf(item) - other.getFrequencyOf(item);
                for (int j = 0; j < difference; j++) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}
