package Demos.Demo3;

public class LinkedBagDemo {
    public static void main(String[] args) {
        BagInterface<String> aBag = new LinkedBag<>();

        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};

        for (int index = 0; index < contentsOfBag.length; index++) {
            aBag.add(contentsOfBag[index]);
        }

        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < contentsOfBag.length; index++) {
            System.out.print(bagArray[index]);
        }
    }
}
