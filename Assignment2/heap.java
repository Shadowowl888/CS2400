package Assignment2;

import java.util.Arrays;

/**
 * Heap class for an array implementation of a heap.
 */
public class heap {
    private int[] heap;
    private int lastIndex;
    private int swapCount = 0;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 1000;

    /**
     * The constructor to create a heap array with default size.
     */
    public heap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * The constructor to create a heap with an initialCapacity.
     * @param initialCapacity  The initial size of the heap array.
     */
    public heap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY) {
            initialCapacity = DEFAULT_CAPACITY;
        } else if (initialCapacity > MAX_CAPACITY) {
            throw new ArrayIndexOutOfBoundsException("The capacity is too large.");
        }
        heap = new int[initialCapacity];
        lastIndex = 0;
        integrityOK = true;
    }

    /**
     * The constructor to create a optimal heap from an array of integers.
     * @param entries  The array of integers to create a heap of.
     */
    public heap(int[] entries) {
        this(entries.length + 1);
        lastIndex = entries.length;
        for (int index = 0; index < entries.length; index++) {
            heap[index + 1] = entries[index];
        }
        for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--) {
            reheap(rootIndex);
        }
    }

    /**
     * Adds a new entry to the heap array.
     * @param newEntry  The entry to be added to the heap array.
     */
    public void add(int newEntry) {
        checkIntegrity();
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ((parentIndex > 0) && (newEntry > heap[parentIndex])) {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            swapCount++;
        }
        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
    }

    /**
     * Removes the maximum integer from the heap array.
     * @return  The removed integer from the heap array.
     */
    public int removeMax() {
        checkIntegrity();
        int root = 0;
        if (!isEmpty()) {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    /**
     * Returns the maximum integer or root of the heap array.
     * @return  The integer value of the root in the heap array.
     */
    public int getMax() {
        checkIntegrity();
        int root = 0;
        if (!isEmpty()) {
            root = heap[1];
        }
        return root;
    }

    public int getValue(int index) {
        return heap[index];
    }

    /**
     * Checks if the heap array is empty or not.
     * @return  True if the heap is empty, or false otherwise.
     */
    public boolean isEmpty() {
        return lastIndex < 1;
    }

    /**
     * Retuns the size of the heap array.
     * @return  The size of the heap array.
     */
    public int getSize() {
        return lastIndex;
    }

    /**
     * Returns the reheap count of the reheap operation.
     * @return  The number of reheap operations.
     */
    public int getSwapCount() {
        return swapCount;
    }

    /**
     * Clears and removes the integers from the heap array.
     */
    public void clear() {
        checkIntegrity();
        while (lastIndex > 0) {
            heap[lastIndex] = 0;
            lastIndex--;
        }
        lastIndex = 0;
    }

    /**
     * Returns an array of the first ten integers of the heap.
     * @return  The first ten integers of the heap array.
     */
    public int[] getFirstTen() {
        int[] result = new int[10];
        int[] copy = this.toArray();
        for (int i = 0; i < 10; i++) {
            result[i] = copy[i+1];
        }
        return result;
    }

    /**
     * Returns an array of the heap.
     * @return  The array version of the heap.
     */
    public int[] toArray() {
        return Arrays.copyOf(heap, heap.length);
    }

    /**
     * Reheaps the heap array to meet the criteria of a heap.
     * @param rootIndex  The root index of the heap array.
     */
    private void reheap(int rootIndex) {
        boolean done = false;
        int orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while(!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) && (heap[rightChildIndex] > heap[largerChildIndex])) {
                largerChildIndex = rightChildIndex;
            }
            if (orphan < heap[largerChildIndex]) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
                swapCount++;
            } else {
                done = true;
            }
        }
        heap[rootIndex] = orphan;
    }

    /**
     * Ensures that the heap array has not reached its capacity, and doubles the size if it is.
     */
    private void ensureCapacity() {
        if (lastIndex + 1 >= heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    /**
     * Checks if the heap was intiated correctly.
     */
    private void checkIntegrity() {
        if (!integrityOK) {
            throw new IllegalStateException("The heap was not properly intialized.");
        }
    }
}
