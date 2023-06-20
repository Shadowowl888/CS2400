package Assignment1;

/**
 * A class of bags whose entries are stored in a chain of linked nodes.
 */
public class LinkedBag<T> implements BagInterface<T> {
    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * The constructor to set the reference of the firstNode and numberOfEntries.
     */
    public LinkedBag() {
        firstNode = null;
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
        Node<T> newNode = new Node<>(newEntry);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return  Either the removed entry, if the removal was successful, or null.
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry  The entry to be removed.
     * @return  True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node<T> nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
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
        int frequency = 0;
        int counter = 0;
        Node<T> currentNode = firstNode;
        while((counter < numberOfEntries) && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    /**
     * Tests whether this bag contains a given entry.
     * @param anEntry  The entry to locate.
     * @return  True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while(!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this bag.
     * @return  A newly allocated array of all the entries in this bag.
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    /**
     * Locates a given entry within this bag.
     * @param anEntry  The entry to locate.
     * @return  The reference to the node containing the entry, if located, or null otherwise.
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }
    
    /**
     * The union of two collections consists of the contents combined into a new collection.
     * @param other  The other bag that is to have its contents combined with this bag.
     * @return  A new bag that contains the combined contents of this bag and the other bag.
     */
    @Override
    public BagInterface<T> union(BagInterface<T> other) {
        LinkedBag<T> result = new LinkedBag<>();
        T[] otherArray = other.toArray();
        for (T entry : otherArray) {
            result.add(entry);
        }
        T[] thisArray = this.toArray();
        for (T entry : thisArray) {
            result.add(entry);
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
        LinkedBag<T> result = new LinkedBag<>();
        T[] thisArray = this.toArray(); 
        for (int i = 0; i < numberOfEntries; i++) {
            T item = thisArray[i];
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
        LinkedBag<T> result = new LinkedBag<>();
        T[] thisArray = this.toArray();
        for (T entry : thisArray) {
            result.add(entry);
        }
        T[] otherArray = other.toArray();
        for (T entry : otherArray) {
            if (result.contains(entry)) {
                result.remove(entry);
            }
        }
        return result;
    }
}
