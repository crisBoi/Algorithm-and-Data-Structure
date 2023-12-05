package BinaryTree.InvertBinaryTree;



public class InvertBinaryTree226 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(4);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(7);
        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(3);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(9);

        bt.inorderTraverse();
        bt.invertTree();
        bt.inorderTraverse();
    }
}

class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void inorderTraverse() {
        recursiveInOrderTraverse(root);
        System.out.println();
    }

    private void recursiveInOrderTraverse(TreeNode current) {
        if (current == null) {
            return;
        }

        recursiveInOrderTraverse(current.left);
        System.out.print(current.val + " ");
        recursiveInOrderTraverse(current.right);
    }
    public void invertTree() {
        recursiveInvert(root);
    }

    private void recursiveInvert(TreeNode current) {
        if (current == null) {
            return;
        }

        recursiveInvert(current.left);
        recursiveInvert(current.right);
        TreeNode left = current.left;
        TreeNode right = current.right;

        current.left = right;
        current.right = left;

    }
}
class TreeNode {
    public int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}


