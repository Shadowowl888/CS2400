package Demos.Demo1;

public class Main {
    public static void main(String[] args) {
        char joeMI = 'T';
        Name joe = new Name();

        joe.setMiddleInitial(joeMI);

        System.out.println(joe.getInitial());
        System.out.println(joe.getFirst());
        System.out.println(joe.getLast());
    }
}
