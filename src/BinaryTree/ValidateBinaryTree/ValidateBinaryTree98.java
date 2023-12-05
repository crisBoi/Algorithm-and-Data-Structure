package BinaryTree.ValidateBinaryTree;

import BinaryTree.BFS.TreeNode;

public class ValidateBinaryTree98 {
    public static void main(String[] args) {

    }
}

class ValidateBST {
    boolean validateHelper(TreeNode root) {
        if (root == null) return true;

        return recursiveValidate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean recursiveValidate(TreeNode current, int leftBound, int rightBound) {
        if (current == null) return true;

        if (current.val > leftBound || current.val < rightBound) return false;

        return recursiveValidate(current.left, leftBound, current.val) && recursiveValidate(current.right, current.val, rightBound);
    }
}
