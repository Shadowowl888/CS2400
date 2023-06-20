package DataStructures.Tree;

public class Client {
    public static void main(String[] args) {
        BinaryTree<String> fTree = new BinaryTree<String>("F");
        BinaryTree<String> eTree = new BinaryTree<String>("E", fTree, null);
        BinaryTree<String> dTree = new BinaryTree<String>("D", eTree, null);
        BinaryTree<String> bTree = new BinaryTree<String>("B", null, dTree);
        BinaryTree<String> cTree = new BinaryTree<String>("C");
        BinaryTree<String> aTree = new BinaryTree<String>("A", bTree, cTree);

        aTree.preorderTraverse();
    }
}
