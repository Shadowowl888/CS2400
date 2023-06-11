package Demos.Demo2;

public class Test {
    public static void main(String[] args) {
        OrderedPair<String> fruit = new OrderedPair<String>("apple", "banana");
        System.out.println(fruit);
        OrderedPair<Integer> fruit2 = new OrderedPair<Integer>(1, 2);
        System.out.println(fruit2);
    }
}
