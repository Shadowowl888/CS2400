package Assignment1;

/**
 * An interface that describes the operations of a bag of objects.
 */
public interface BagInterface<T> {
    /**
     * Gets the number of entries currently in this bag.
     * @return  The integer number of entries currently in this bag.
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty.
     * @return  True if this bag is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     * @param newEntry  The object to be added as a new entry.
     * @return  True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or null.
     */
    public T remove();

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry  The entry to be removed.
     * @return  True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry);

    /**
     * Removes all entries from this bag.
     */
    public void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry  The entry to be counted.
     * @return  The number of times anEntry appears in this bag.
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry  The entry to locate.
     * @return  True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     * @return  A newly allocated array of all the entries in this bag.
     */
    public T[] toArray();

    /**
     * The union of two collections consists of the contents combined into a new collection.
     * @param other  The other bag that is to have its contents combined with this bag.
     * @return  A new bag that contains the combined contents of this bag and the other bag.
     */
    public BagInterface<T> union(BagInterface<T> other);

    /**
     * A new collection of the entries that occur in both bags.
     * @param other  The other bag is to have its contents compared with this bag.
     * @return  A new bag that contains overlapping contents of this bag and the other bag.
     */
    public BagInterface<T> intersection(BagInterface<T> other);

    /**
     * A new collection of the entries that are leftover in one collection after removing the overlapping entries.
     * @param other  The other bag is to have its contents compared with this bag.
     * @return  A new bag containing the contents that are left in this new bag after removing overlapping entries that occur in this bag and the other bag.
     */
    public BagInterface<T> difference(BagInterface<T> other);
}
