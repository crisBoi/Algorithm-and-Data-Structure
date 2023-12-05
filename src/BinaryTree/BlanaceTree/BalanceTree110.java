package BinaryTree.BlanaceTree;

public class BalanceTree110 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(2);

        bt.root.left.left = new TreeNode(3);
        bt.root.right.right = new TreeNode(3);

        bt.root.left.left.left = new TreeNode(4);
        bt.root.right.right.right = new TreeNode(4);

        bt.maxHeight(bt.root);
        System.out.println("" + bt.isBalanced);

    }
}

class BinaryTree {
    TreeNode root;
    boolean isBalanced = true;

    BinaryTree() {
        root = null;
    }

    /*boolean isBalanced(TreeNode current) {
        if (current == null) return true;

        int lHeight = maxHeight(current.left);
        int rHeight = maxHeight(current.right);

        if
    }*/

    int maxHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int lHeight = maxHeight(current.left);
        int rHeight = maxHeight(current.right);

        if (lHeight != rHeight && Math.abs(lHeight - rHeight) > 1) {
            isBalanced = false;
        }

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }
}

class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

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
