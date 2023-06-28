package DataStructures.Graph;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        Graph<String> matrix = new Graph<>(9);

        // Add edges of Node A
        matrix.addEdge(0, 1);
        matrix.addEdge(0, 3);
        matrix.addEdge(0, 4);
        // Add edges of Node B
        matrix.addEdge(1,4);
        // Add edges of Node C
        matrix.addEdge(2,1);
        // Add edges of Node D
        matrix.addEdge(3,6);
        // Add edges of Node E
        matrix.addEdge(4,7);
        matrix.addEdge(4,5);
        // Add edges of Node F
        matrix.addEdge(5,7);
        // Add edges of Node G
        matrix.addEdge(6,7);
        // Add edges of Node H
        matrix.addEdge(7,8);
        // Add edges of Node I
        matrix.addEdge(8,5);

        // Add vertex labels
        matrix.setLabel(0, "A");
        matrix.setLabel(1, "B");
        matrix.setLabel(2, "C");
        matrix.setLabel(3, "D");
        matrix.setLabel(4, "E");
        matrix.setLabel(5, "F");
        matrix.setLabel(6, "G");
        matrix.setLabel(7, "H");
        matrix.setLabel(8, "I");

        System.out.println("The size of the adjacency matrix is: " + matrix.size());

        System.out.println("Is there an edge between A and E? " + matrix.isEdge(0,4));

        System.out.println("Is there an edge between D and H? " + matrix.isEdge(3,7));

        System.out.println("Vertex " + matrix.getLabel(4) + " neighbors are " + Arrays.toString(matrix.neighbors(4)));
        System.out.println("Vertex 5 is " + matrix.getLabel(5));
        System.out.println("Vertex 7 is " + matrix.getLabel(7));
    }
}
