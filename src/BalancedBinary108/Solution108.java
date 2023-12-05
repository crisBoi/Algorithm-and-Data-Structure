package BalancedBinary108;
/*
    Given an integer array nums where the elements are sorted in ascending order, convert it to a
    height-balanced
    binary search tree.*/

import com.sun.source.tree.Tree;

public class Solution108 {

}

class BinaryTree {

    TreeNode root = null;

    public void inOrderTraversal() {
        recursiveInOrderReversal(root);
    }

    private void recursiveInOrderReversal(TreeNode current) {
        if (current == null) {
            return;
        }

        recursiveInOrderReversal(current.right);
        System.out.println("" + current.val);
        recursiveInOrderReversal(current.left);
    }


    public void insert(int val) {
//        root = insertRecursively();
    }

    private void insertRecursively(int val, TreeNode cuurent) {

    }

}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
