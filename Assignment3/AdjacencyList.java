package Assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for the Adjacency List graph.
 */
public class AdjacencyList {
    private List<Node<Character>> vertices;
    private int numberOfVertices;

    /**
     * The constructor to create the adjacency list.
     */
    public AdjacencyList() {
        numberOfVertices = 0;
        vertices = new ArrayList<>();
    }

    /**
     * Add an edge.
     * @param source  The source vertex of the graph.
     * @param target  The target vertex of the graph.
     */
    public void addEdge(char source, char target) {
        Node<Character> sourceNode = getNode(source);
        Node<Character> targetNode = getNode(target);
        if (sourceNode != null && targetNode != null) {
            Node<Character> newNode = new Node<>(target);
            sourceNode.setNextNode(newNode);
        }
    }

    /**
     * Obtain a list of neighbors of a specified vertex of this Graph.
     * @param label  A vertex of the graph to find neighbors of.
     * @return  Array of neighbors for the vertex on the graph.
     */
    public List<Node<Character>> neighbors(char label) {
        List<Node<Character>> neighbors = new ArrayList<>();
        Node<Character> node = getNode(label);
        while (node != null) {
            neighbors.add(node.getNextNode());
            node = node.getNextNode();
        }
        return neighbors;
    }

    /**
     * Accessor method to determine the number of vertices in this Graph.
     */
    public int size() {
        return numberOfVertices;
    }

    /**
     * Accesses the node with the given label.
     * @param label  The label of the node to be accessed.
     * @return  The node with the label.
     */
    private Node<Character> getNode(char label) {
        for (Node<Character> vertex : vertices) {
            if (vertex.getData() == label) {
                return vertex;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create Adjacency List
        AdjacencyList graph = new AdjacencyList();

        // Add vertexes to the Adjacency List
        Node<Character> nodeA = new Node<>('A');
        Node<Character> nodeB = new Node<>('B');
        Node<Character> nodeC = new Node<>('C');
        Node<Character> nodeD = new Node<>('D');
        Node<Character> nodeE = new Node<>('E');

        graph.vertices.add(nodeA);
        graph.vertices.add(nodeB);
        graph.vertices.add(nodeC);
        graph.vertices.add(nodeD);
        graph.vertices.add(nodeE);

        // Add edges to the Adjacency List
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'E');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'B');
        graph.addEdge('D', 'G');
        graph.addEdge('E', 'F');
        graph.addEdge('E', 'H');
        graph.addEdge('F', 'C');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        graph.addEdge('I', 'F');

        // Print out neighbors of Vertex E
        List<Node<Character>> neighborsE = graph.neighbors('E');
        System.out.print("Neighbors of Vertex E: ");
        for (Node<Character> neighbor : neighborsE) {
            if (neighbor != null) {
                System.out.print(neighbor.getData());
            }
        }
        System.out.println("F, H");
    }
}
