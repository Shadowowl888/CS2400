package DataStructures.Stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {
    private Vector<T> stack;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public VectorStack() {
        this(DEFAULT_CAPACITY);
    }

    public VectorStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);
        stack = new Vector<>(initialCapacity);
        integrityOK = true;
    }

    public void push(T newEntry) {
        checkIntegrity();
        stack.add(newEntry);
    }

    public T pop() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    public T peek() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.lastElement();
        }
    }

    public boolean isEmpty() {
        checkIntegrity();
        return stack.isEmpty();
    }

    public void clear() {
        checkIntegrity();
        stack.clear();
    }

    private void checkCapacity(int initialCapacity) {
        if (initialCapacity >= MAX_CAPACITY) {
            throw new Exception("Capacity exceeded");
        }
    }

    private void checkIntegrity() {
        if (integrityOK == false) {
            throw new Exception("Integrity bad");
        }
    }
}
