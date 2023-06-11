package Demos.Demo1;

public class Name {
    private String first;
    private char initial;
    private String last;

    public void setMiddleInitial(char middleInitial) {
        initial = middleInitial;
    }

    public char getInitial() {
        return initial;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}