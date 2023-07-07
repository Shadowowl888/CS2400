package DataStructures.Graph;
import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    ArrayList<LinkedList<Node>> adjacencyList;

    public AdjacencyList() {
        adjacencyList = new ArrayList<>();
    }

    /**
     * Adds a given vertex to the adjacency list.
     * @param node  The node vertex to add.
     */
    public void addNode(Node node) {
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        adjacencyList.add(currentList);
    }

    /**
     * Add an edge to the adjacency list.
     * @param source  The source vertex of the graph.
     * @param target  The target vertex of the graph.
     */
    public void addEdge(int source, int destination) {
        LinkedList<Node> currentList = adjacencyList.get(source);
        Node destinationNode = adjacencyList.get(destination).get(0);
        currentList.add(destinationNode);
    }

    /**
     * Test whether an edge exists.
     * @param source  The source vertex of the graph.
     * @param target  The target vertex of the graph.
     * @return  True if an edge exists between the source and target vertexes, or False otherwise.
     */
    public boolean isEdge(int source, int destination) {
        LinkedList<Node> currentList = adjacencyList.get(source);
        Node destinationNode = adjacencyList.get(destination).get(0);
        
        for (Node node : currentList) {
            if (node == destinationNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtain a list of neighbors of a specified vertex of this Graph.
     * @param vertex  A vertex of the graph to find neighbors of.
     * @return  Array of neighbors for the vertex on the graph.
     */
    public char[] neighbors(int vertex) {
        LinkedList<Node> vertexList = adjacencyList.get(vertex);
        char[] result = new char[vertexList.size()];
        int count = 0;
        for (LinkedList<Node> currentList : adjacencyList) {
            for (Node node : currentList) {
                result[count++] = node.getData();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Create Adjacency List
        AdjacencyList graph = new AdjacencyList();

        // Add vertices to the Adjacency List
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));

        // Add edges to the Adjacency List
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 7);
        graph.addEdge(5, 2);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 5);

        System.out.print("Neighbors of Vertex E: ");
        graph.neighbors(4);
    }

    /**
     * A class to keep track of the node objects in the linked chain.
     */
    private class Node {
        private char data;
        private Node next;

        /**
         * The constructor to create a Node object with a specified data value.
         * @param dataPortion  The data value of the node.
         */
        public Node(char dataPortion) {
            this(dataPortion, null);
        }

        /**
         * The constructor to create a Node object with a specified data value and reference to the next Node in the list.
         * @param dataPortion  The data value of the node.
         * @param nextNode  The reference of the next node.
         */
        public Node(char dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /**
         * Retrieves the data of the node.
         * @return  The data value of the node.
         */
        public char getData() {
            return data;
        }

        /**
         * Updates the data of the node.
         * @param newData  The new data value to set the node.
         */
        public void setData(char newData) {
            data = newData;
        }

        /**
         * Retrieves the reference of the next node.
         * @return  The reference of the next node in the list.
         */
        public Node getNextNode() {
            return next;
        }

        /**
         * Updates the reference of the next node.
         * @param nextNode  The new reference for the next node.
         */
        public void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
