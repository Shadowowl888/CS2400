package Demos.Demo4;

public class LinkedBagDemo {
    public static void main(String[] args) {
        BagInterface<String> aBag = new LinkedBag<>();

        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};

        for (int index = 0; index < contentsOfBag.length; index++) {
            aBag.add(contentsOfBag[index]);
        }

        display(aBag);
        System.out.println();
    }

    private static void display(BagInterface<String> aBag) {
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.print(bagArray[index]);
        }
    }
}
