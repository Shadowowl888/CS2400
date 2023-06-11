package Demos.Discussion1;

public class Main {
    public static void main(String[] args) {
        Name jamie = new Name();
        jamie.setFirst("Jamie");
        jamie.setLast("Jones");

        Name jane = new Name();
        jane.setFirst("Jane");
        jane.setLast("Doe");

        jamie.giveLastNameTo2(jane);
        
        System.out.println(jamie);
        System.out.println(jane);
    }
}