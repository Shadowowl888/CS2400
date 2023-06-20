package DataStructures.Tree;

public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public BinaryNode() {
        this(null);
    }

    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null);
    }

    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<T> newLeftChild) {
        leftChild = newLeftChild;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<T> newRightChild) {
        rightChild = newRightChild;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    public void preorderTraverse_binaryNode() {
        System.out.println(data);
        if (leftChild != null) {
            leftChild.preorderTraverse_binaryNode();
        }
        if (rightChild != null) {
            rightChild.preorderTraverse_binaryNode();
        }
    }
}
