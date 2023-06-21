package DataStructures.Tree;

public class BinaryTree<T> {
    private BinaryNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<>(rootData);
    }

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        // root = new BinaryNode<>(rootData);
        // if (leftTree != null) {
        //     root.setLeftChild(leftTree.root);
        // }
        // if (rightTree != null) {
        //     root.setRightChild(rightTree.root);
        // }
        privateSetTree(rootData, leftTree, rightTree);
    }

    private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new BinaryNode<>(rootData);
        if ((leftTree != null) && !leftTree.isEmpty()) {
            root.setLeftChild(leftTree.root);
        }
        if ((rightTree != null) && !rightTree.isEmpty()) {
            if (rightTree != leftTree) {
                root.setRightChild(rightTree.root);
            } else {
                root.setRightChild(rightTree.root.copy());
            }
        }
        if ((leftTree != null) && (leftTree != this)) {
            leftTree.clear();
        }
        if ((rightTree != null) && (rightTree != this)) {
            rightTree.clear();
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void preorderTraverse() {
        //preorderTraverse(root);
        root.preorderTraverse_binaryNode();
    }

    public void inorderTraverse() {
        //inorderTraverse(root);
        root.inorderTraverse_binaryNode();
    }

    public void postorderTraverse() {
        //postorderTraverse(root);
        root.postorderTraverse_binaryNode();
    }

    public int getNumberOfNodes() {
        //return getNumberOfNodes(root);
        return root.getNumberOfNodes_binaryNode();
    }

    public int getHeight() {
        return getHeight(root);
        //return root.getHeight_binaryNode();
    }

    public T getLeftmostData() {
        //return getLeftmostData(root);
        return root.getLeftmostData_binaryNode();
    }

    public T getRightmostData() {
        //return getRightmostData(root);
        return root.getRightmostData_binaryNode();
    }

    public BinaryNode<T> removeLeftmost() {
        return root.removeLeftmost();
    }

    public BinaryNode<T> removeRightmost() {
        return root.removeRightmost();
    }

    private void preorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderTraverse(node.getLeftChild());
            preorderTraverse(node.getRightChild());
        }
    }

    private void inorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            inorderTraverse(node.getLeftChild());
            System.out.println(node.getData());
            inorderTraverse(node.getRightChild());
        }
    }

    private void postorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            postorderTraverse(node.getLeftChild());
            postorderTraverse(node.getRightChild());
            System.out.println(node.getData());
        }
    }

    private int getNumberOfNodes(BinaryNode<T> node) {
        int leftNum = 0;
        int rightNum = 0;
        if (node.getLeftChild() != null) {
            leftNum = getNumberOfNodes(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            rightNum = getNumberOfNodes(node.getRightChild());
        }
        return leftNum + rightNum + 1;
    }

    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
        }
        return height;
    }

    private T getLeftmostData(BinaryNode<T> node) {
        if (node == null) {
            return node.getData();
        } else {
            return getLeftmostData(node.getLeftChild());
        }
    }

    private T getRightmostData(BinaryNode<T> node) {
        if (node == null) {
            return node.getData();
        } else {
            return getRightmostData(node.getRightChild());
        }
    }
}
