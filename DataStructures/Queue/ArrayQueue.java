package DataStructures.Queue;

public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 3;
    private static final int MAX_CAPACITY = 10000;

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
        integrityOK = true;
    }

    @Override
    public void enqueue(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T result = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
            return result;
        }
    }

    @Override
    public T getFront() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return queue[frontIndex];
        }
    }

    @Override
    public boolean isEmpty() {
        checkIntegrity();
        return frontIndex == ((backIndex + 1) & queue.length);
    }

    @Override
    public void clear() {
        if (!isEmpty()) {
            for (int index = frontIndex; index != backIndex; index = (index + 1) % queue.length) {
                queue[index] = null;
            }
            queue[backIndex] = null;
        }
        frontIndex = 0;
        backIndex = queue.length - 1;
    }

    private void ensureCapacity() {
        if (frontIndex == ((backIndex + 2) % queue.length)) {
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            checkCapacity(newSize);
            integrityOK = false;

            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[]) new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            }

            frontIndex = 0;
            backIndex = oldSize - 2;
            integrityOK = true;
        }
    }

    private void checkCapacity(int initialCapacity) {
        if (initialCapacity > MAX_CAPACITY) {
            System.out.println("Error");
        }
    }

    private void checkIntegrity() {
        if (!integrityOK) {
            System.out.println("Error");
        }
    }
}