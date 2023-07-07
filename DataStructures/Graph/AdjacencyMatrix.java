package DataStructures.Graph;


import java.util.Arrays;

public class AdjacencyMatrix<E> {
    private boolean[][] edges;
    private E[] labels;

    public AdjacencyMatrix(int n) {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    /**
     * Accessor method to get the label of a vertex of this Graph.
     * @param vertex  A vertex of the graph.
     * @return  The label of the specificed vertex.
     */
    public E getLabel(int vertex) {
        return labels[vertex];
    }

    /**
     * Test whether an edge exists.
     * @param source  The source vertex of the graph.
     * @param target  The target vertex of the graph.
     * @return  True if an edge exists between the source and target vertexes, or False otherwise.
     */
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    /**
     * Add an edge.
     * @param source  The source vertex of the graph.
     * @param target  The target vertex of the graph.
     */
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    /**
     * Remove an edge.
     * @param source  The source vertex of the graph.
     * @param target  The target vertex of the graph.
     */
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    /**
     * Obtain a list of neighbors of a specified vertex of this Graph.
     * @param vertex  A vertex of the graph to find neighbors of.
     * @return  Array of neighbors for the vertex on the graph.
     */
    public int[] neighbors(int vertex) {
        int i;
        int count = 0;
        int[] answer;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                count++;
            }
        }
        answer = new int[count];
        count = 0;
        for (i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                answer[count++] = i;
            }
        }
        return answer;
    }

    /**
     * Change the label of a vertex of this Graph.
     * @param vertex  The vertex on the graph.
     * @param newLabel  The new label for the vertex.
     */
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    /**
     * Accessor method to determine the number of vertices in this Graph.
     */
    public int size() {
        return labels.length;
    }
    
    public static void main(String[] args) {
        AdjacencyMatrix<String> matrix = new AdjacencyMatrix<>(9);

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
        matrix.addEdge(5,2);
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

        // Print neighbors of Vertex E
        System.out.println("Vertex " + matrix.getLabel(4) + " neighbors are " + Arrays.toString(matrix.neighbors(4)));
        System.out.println("Vertex 5 is " + matrix.getLabel(5));
        System.out.println("Vertex 7 is " + matrix.getLabel(7));
    }
}
