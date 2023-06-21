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
        System.out.print(data + " ");
        if (leftChild != null) {
            leftChild.preorderTraverse_binaryNode();
        }
        if (rightChild != null) {
            rightChild.preorderTraverse_binaryNode();
        }
    }

    public void inorderTraverse_binaryNode() {
        if (leftChild != null) {
            leftChild.inorderTraverse_binaryNode();
        }
        System.out.print(data + " ");
        if (rightChild != null) {
            rightChild.inorderTraverse_binaryNode();
        }
    }

    public void postorderTraverse_binaryNode() {
        if (leftChild != null) {
            leftChild.postorderTraverse_binaryNode();
        }
        if (rightChild != null) {
            rightChild.postorderTraverse_binaryNode();
        }
        System.out.print(data + " ");
    }
    
    public BinaryNode<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (leftChild != null) {
            newRoot.setLeftChild(leftChild.copy());
        }
        if (rightChild != null) {
            newRoot.setRightChild(rightChild.copy());
        }
        return newRoot;
    }

    public int getNumberOfNodes_binaryNode() {
        int leftNum = 0;
        int rightNum = 0;
        if (leftChild != null) {
            leftNum = leftChild.getNumberOfNodes_binaryNode();
        }
        if (rightChild != null) {
            rightNum = rightChild.getNumberOfNodes_binaryNode();
        }
        return leftNum + rightNum + 1;
    }

    public int getHeight_binaryNode() {
        int height = 0;
        if (this != null) {
            height = 1 + Math.max(leftChild.getHeight_binaryNode(), rightChild.getHeight_binaryNode());
        }
        return height;
    }

    public T getLeftmostData_binaryNode() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.getLeftmostData_binaryNode();
        }
    }

    public T getRightmostData_binaryNode() {
        if (leftChild == null) {
            return data;
        } else {
            return rightChild.getRightmostData_binaryNode();
        }
    }

    public BinaryNode<T> removeLeftmost() {
        if (leftChild == null) {
            return rightChild;
        } else {
            leftChild = leftChild.removeLeftmost();
            return this;
        }
    }

    public BinaryNode<T> removeRightmost() {
        if (rightChild == null) {
            return leftChild;
        } else {
            rightChild = rightChild.removeRightmost();
            return this;
        }
    }
}
