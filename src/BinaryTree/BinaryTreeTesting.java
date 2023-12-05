package BinaryTree;

public class BinaryTreeTesting {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left =  new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.right = new TreeNode(5);
        root.left.left.left.right.left = new TreeNode(6);
        root.left.left.left.right.left.left = new TreeNode(7);
        root.left.left.left.right.left.left.right = new TreeNode(8);

    /*    BinaryTree.SameTree.BinaryTree bt = new BinaryTree.SameTree.BinaryTree();
        bt.root = root;

        System.out.println("max zigZag: " + bt.longestZigZag(root));*/
    }
}
