package Demos.Demo2;

/**
 * Pariable
 */
public interface Pairable<T> {
    public T getFirst();
    public T getSecond();
    public void changeOrder();
}