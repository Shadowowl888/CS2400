package DataStructures.Tree;

public class BinaryTree<T> {
    private BinaryNode<T> root;

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        root = new BinaryNode<T>(rootData);
        if (leftTree != null) {
            root.setLeftChild(leftTree.root);
        }
        if (rightTree != null) {
            root.setRightChild(rightTree.root);
        }
    }

    public BinaryTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    public void preorderTraverse() {
        //preorderTraverse(root);
        root.preorderTraverse_binaryNode();
    }

    private void preorderTraverse(BinaryNode<T> node) {
        if (node != null) {
            System.out.println(node.getData());
            preorderTraverse(node.getLeftChild());
            preorderTraverse(node.getRightChild());
        }
    }
}
