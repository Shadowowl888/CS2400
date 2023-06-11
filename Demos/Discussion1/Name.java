package Demos.Discussion1;

public class Name {
    private String first;
    private char initial;
    private String last;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String firstName) {
        first = firstName;
    }

    public void setLast(String lastName) {
        last = lastName;
    }

    public void giveLastNameTo2(Name child) {
        String firstName = child.getFirst();
        child = new Name();
        child.setFirst(firstName);
        child.setLast(last);
    }

    public String toString() {
        return first + " " + last;
    }
}