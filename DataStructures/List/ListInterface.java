package DataStructures.List;

public interface ListInterface<T> {
    public int getLength();
    public boolean isEmpty();
    public void add(T newEntry);    
    public void add(int newPosition, T newEntry);
    public T remove(int givenPosition);
    public T replace(int givenPosition, T newEntry);
    public void clear();
    public T getEntry(int givenPosition);
    public T[] toArray();
}