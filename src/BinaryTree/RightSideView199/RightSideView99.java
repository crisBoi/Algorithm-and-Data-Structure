package BinaryTree.RightSideView199;

import BinaryTree.BFS.TreeNode;

public class RightSideView99 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);

        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);

        bt.root.left.right = new TreeNode(5);
        bt.root.left.right.left = new TreeNode(4);

        bt.root.right.left = new TreeNode(6);

        bt.rightViewRecursive(bt.root, 1);
    }
}

class BinaryTree {
    TreeNode root;
    int maxRightLevel = 0;

    public BinaryTree() {
        root = null;
    }

    public void rightViewRecursive(TreeNode current, int level) {
        if (current == null) {
            return;
        }

        if (level > maxRightLevel) {
            System.out.println(" " + current.val);
            maxRightLevel = level;
        }

        rightViewRecursive(current.right, level + 1);
        rightViewRecursive(current.left, level + 1);

    }
}
