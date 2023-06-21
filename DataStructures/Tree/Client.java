package DataStructures.Tree;

public class Client {
    public static void main(String[] args) {
        BinaryTree<String> fTree = new BinaryTree<String>("F");
        BinaryTree<String> eTree = new BinaryTree<String>("E", fTree, null);
        BinaryTree<String> dTree = new BinaryTree<String>("D", eTree, null);
        BinaryTree<String> bTree = new BinaryTree<String>("B", null, dTree);
        BinaryTree<String> cTree = new BinaryTree<String>("C");
        BinaryTree<String> aTree = new BinaryTree<String>("A", bTree, cTree);

        System.out.println("Preorder:");
        aTree.preorderTraverse();
        System.out.println("\nInorder:");
        aTree.inorderTraverse();
        System.out.println("\nPostorder:");
        aTree.postorderTraverse();
        System.out.println();

        System.out.println("Number of Nodes: " + aTree.getNumberOfNodes());
        System.out.println("Height of Binary Tree: " + aTree.getHeight());
        System.out.println("Leftmost Data: " + aTree.getLeftmostData());
        System.out.println("Rightmost Data: " + aTree.getRightmostData());

        System.out.println("Remove Leftmost: " + aTree.removeLeftmost().getData());
        System.out.println("Preorder: ");
        aTree.preorderTraverse();
        System.out.println();

        System.out.println("Remove Rightmost: " + aTree.removeRightmost().getData());
        System.out.println("Preorder: ");
        aTree.preorderTraverse();
        System.out.println();
    }
}
