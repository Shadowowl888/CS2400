package DataStructures.Graph;

public class Graph<E> {
    private boolean[][] edges;
    private E[] labels;

    public Graph(int n) {
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    /**
     * Accessor method to get the label of a vertex of this Graph.
     * @param vertex
     * @return
     */
    public E getLabel(int vertex) {
        return labels[vertex];
    }

    /**
     * Test whether an edge exists.
     * @param source
     * @param target
     * @return
     */
    public boolean isEdge(int source, int target) {
        return edges[source][target];
    }

    /**
     * Add an edge.
     * @param source
     * @param target
     */
    public void addEdge(int source, int target) {
        edges[source][target] = true;
    }

    /**
     * Remove an edge.
     * @param source
     * @param target
     */
    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    /**
     * Obtain a list of neighbors of a specified vertex of this Graph.
     * @param vertex
     * @return
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
     * @param vertex
     * @param newLabel
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
}
