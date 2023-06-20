package Assignment1;

import java.util.Arrays;

/**
 * Client program to create linked bags.
 */
public class LinkedBagTest {
    public static void main(String[] args) {
        // Create two linked bags and add specified elements.
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();
        bag1.add("a");
        bag1.add("b");
        bag1.add("c");
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");

        // Print out the elements of each bag
        System.out.println("Bag1: " + Arrays.toString(bag1.toArray()));
        System.out.println("Bag2: " + Arrays.toString(bag2.toArray()));
        
        // Find the union of the two bags and print it
        BagInterface<String> everything = bag1.union(bag2);
        System.out.println("Union of Bag1 and Bag2: " + Arrays.toString(everything.toArray()));

        // Find the intersection of the two bags and print it
        BagInterface<String> commonItems = bag1.intersection(bag2);
        System.out.println("Intersection of Bag1 and Bag2: " + Arrays.toString(commonItems.toArray()));

        // Find the two differences of the two bags and print it
        BagInterface<String> leftOver1 = bag1.difference(bag2);
        BagInterface<String> leftOver2 = bag2.difference(bag1);
        System.out.println("Difference of Bag1 from Bag2: " + Arrays.toString(leftOver1.toArray()));
        System.out.println("Difference of Bag2 from Bag1: " + Arrays.toString(leftOver2.toArray()));
    }
}
