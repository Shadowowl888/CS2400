package DataStructures.Bag;

public class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

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
     * @return  True.
     */
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
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

    public boolean remove(T anEntry) {
        return false;
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
        Node currentNode = firstNode;
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
        Node currentNode = firstNode;
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
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T dataPortion) {
            this(dataPortion, null);
        }

        public Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T newData) {
            data = newData;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
