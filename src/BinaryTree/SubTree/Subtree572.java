package BinaryTree.SubTree;

import com.sun.source.tree.Tree;

public class Subtree572 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.root = new TreeNode(1);

       /* bt.root.left = new TreeNode(4);
        bt.root.right = new TreeNode(5);

        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(2);
//        bt.root.left.right.left = new TreeNode(0);
*/

        bt.subtreeRoot =  new TreeNode(0);
      /*  bt.subtreeRoot.left = new TreeNode(1);
        bt.subtreeRoot.left.right = new TreeNode(1);
        bt.subtreeRoot.right = new TreeNode(2);*/

//        System.out.println("" + bt.isSubtree(bt.root, bt.subtreeRoot));
    }
}

class BinaryTree {

    boolean isSubtree = true;
    TreeNode root;
    TreeNode subtreeRoot;

    BinaryTree() {
        root = null;
        subtreeRoot = null;
    }

//    boolean isSubtree(TreeNode root, TreeNode subtree) {
//        isSubtree(root, subtree, false);
//        System.out.println("" + subtree.val);
//        return isSubtree;
//    }

  /*  private int isSubtree(TreeNode current, TreeNode subtreeCurrent, boolean checkForEquality) {


        if (current == null && subtreeRoot != null && checkForEquality) {
            isSubtree = false;
            return 0;
        } else if (current == null && subtreeCurrent != null) {
            isSubtree = false;
            return 0;
        } else if (current == null) {
            return 0;
        }

        if (checkForEquality && subtreeRoot == null) {
            isSubtree = false;
            return 0;
        } else if (current.val == subtreeCurrent.val) {
            isSubtree(current.left, subtreeCurrent.left, true);
            isSubtree(current.right, subtreeCurrent.right, true);
        } else {
            if (checkForEquality) {
                isSubtree = false;
                return 0;
            }
            isSubtree(current.left, subtreeCurrent, false);
            isSubtree(current.right, subtreeCurrent, false);
        }

        return 0;

    }*/

    boolean iterateTree(TreeNode root, TreeNode subCurrent) {
        if (subCurrent == null) return true;
        if (root == null) return false;

        return ((isSameTree(root, subCurrent)) || (iterateTree(root.right, subCurrent)) || (iterateTree(root.left, subCurrent)));
    }

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


