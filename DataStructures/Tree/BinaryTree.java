package DataStructures.Tree;

public class BinaryTree<T> {
    public void preorderTraverse() {
        preorderTraverse(root);
    }

    private void preorderTraverse(BinaryNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderTraverse(node.getLeftChild());
            preorderTraverse(node.getRightChild());
        }
    }
    
    private class BinaryNode {
        private T data;
        private BinaryNode leftChild;
        private BinaryNode rightChild;

        public BinaryNode() {
            this(null);
        }

        public BinaryChild(T dataPortion) {
            this(dataPortion, null, null);
        }

        public BinaryChild(T dataPortion, BinaryNode newLeftChild, BinaryNode newRightChild) {
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

        public BinaryNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BinaryNode newLeftChild) {
            leftChild = newLeftChild;
        }

        public boolean hasLeftChild() {
            return leftChild != null;
        }

        public boolean isLeaf() {
            return (leftChild == null) && (rightChild == null);
        }

        public BinaryNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BinaryNode newRightChild) {
            rightChild = newRightChild;
        }

        public boolean hasRightChild() {
            return rightChild != null;
        }
    }
}
