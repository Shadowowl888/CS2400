package Demos.Demo3;

public class LinkedBag<T> implements BagInterface<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null; 
        numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNextNode(firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

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

    public void clear() {
        while(!isEmpty()) {
            remove();
        }
    }

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