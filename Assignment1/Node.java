package Assignment1;

/**
 * A class to keep track of the node objects in the linked chain.
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * The constructor to create a Node object with a specified data value.
     * @param dataPortion  The data value of the node.
     */
    public Node(T dataPortion) {
        this(dataPortion, null);
    }

    /**
     * The constructor to create a Node object with a specified data value and reference to the next Node in the list.
     * @param dataPortion  The data value of the node.
     * @param nextNode  The reference of the next node.
     */
    public Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    }

    /**
     * Retrieves the data of the node.
     * @return  The data value of the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Updates the data of the node.
     * @param newData  The new data value to set the node.
     */
    public void setData(T newData) {
        data = newData;
    }

    /**
     * Retrieves the reference of the next node.
     * @return  The reference of the next node in the list.
     */
    public Node<T> getNextNode() {
        return next;
    }

    /**
     * Updates the reference of the next node.
     * @param nextNode  The new reference for the next node.
     */
    public void setNextNode(Node<T> nextNode) {
        next = nextNode;
    }
}
