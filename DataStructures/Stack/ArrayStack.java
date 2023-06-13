package DataStructures.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
    private T[] stack;
    private int topIndex;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        integrityOK = false;
        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    public void push(T newEntry) {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    public T pop() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    public T peek() {
        checkIntegrity();
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[topIndex];
        }
    }

    public boolean isEmpty() {
        return topIndex < 0;
    }

    public void clear() {
        checkIntegrity();
        while(topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        }
    }
    
    private void ensureCapacity() {
        if (topIndex >= stack.length - 1) {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
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
