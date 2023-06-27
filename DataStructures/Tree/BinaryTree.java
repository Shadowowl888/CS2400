package DataStructures.Tree;

public class BinaryTree<T extends Comparable<? super T>> {
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

    public BinaryNode<T> getRootNode() {
        return root;
    }

    public void setRootNode(BinaryNode<T> node) {
        root = node;
    }

    public T getEntry(T entry) {
        return findEntry(getRootNode(), entry);
    }

    public T add(T newEntry) {
        T result = null;
        if (isEmpty()) {
            setRootNode(new BinaryNode<T>(newEntry));
        } else {
            result = addEntry(getRootNode(), newEntry);
        }
        return result;
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

    private T findEntry(BinaryNode<T> rootNode, T entry) {
        T result = null;
        if (rootNode != null) {
            T rootEntry = rootNode.getData();
            if (entry.equals(rootEntry)) {
                result = rootEntry;
            } else if (entry.compareTo(rootEntry) < 0) {
                result = findEntry(rootNode.getLeftChild(), entry);
            } else {
                result = findEntry(rootNode.getRightChild(), entry);
            }
        }
        return result;
    }

    private T addEntry(T newEntry) {
        BinaryNode<T> currentNode = getRootNode();
        assert currentNode != null;
        T result = null;
        boolean found = false;
        while (!found) {
            T currentEntry = currentNode.getData();
            int comparison = newEntry.compareTo(currentEntry);
            if (comparison == 0) {
                // newEntry matches currentEntry
                // return and replace currentEntry
                found = true;
                result = currentEntry;
                currentNode.setData(newEntry);
            } else if (comparison < 0) {
                if (currentNode.hasLeftChild()) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    found = true;
                    currentNode.setLeftChild(new BinaryNode<>(newEntry));
                }
            } else {
                assert comparison > 0;
                if (currentNode.hasRightChild()) {
                    currentNode = currentNode.getRightChild();
                } else {
                    found = true;
                    currentNode.setRightChild(new BinaryNode<>(newEntry));
                }
            }
        }
        return result;
    }

    private T addEntry(BinaryNode<T> rootNode, T newEntry) {
        assert rootNode != null;
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());
        if (comparison == 0) {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        } else if (comparison < 0) {
            if (rootNode.hasLeftChild()) {
                result = addEntry(rootNode.getLeftChild(), newEntry);
            } else {
                rootNode.setLeftChild(new BinaryNode<>(newEntry));
            }
        } else {
            assert comparison > 0;
            if (rootNode.hasRightChild()) {
                result = addEntry(rootNode.getRightChild(), newEntry);
            } else {
                rootNode.setRightChild(new BinaryNode<>(newEntry));
            }
        }
        return result;
    }
}
