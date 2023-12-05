package BinaryTree.SameTree;

public class SameTree100 {
    public static void main(String[] args) {

    }
}

class BinaryTree {

    boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) {
            return (isSameTree(p.left, q.left) && (isSameTree(p.right, q.right)));
        }

        return false;
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
