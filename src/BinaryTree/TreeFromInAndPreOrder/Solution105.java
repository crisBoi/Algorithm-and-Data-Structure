package BinaryTree.TreeFromInAndPreOrder;

import BinaryTree.BFS.TreeNode;

import java.util.Arrays;

public class Solution105 {
    public static void main(String[] args) {

    }
}

class Solution {
    TreeNode getTreeFromInOrder(int[] preOrder, int[] inOrder) {
        if (inOrder.length == 0 || preOrder.length == 0) return null;

        TreeNode root = new TreeNode(preOrder[0]);

        int mid = 0;

        for (int i = 0; i < inOrder.length; i++) {
            if (preOrder[0] == inOrder[i]) {
                mid = i;
            }
        }

        root.left = getTreeFromInOrder(Arrays.copyOfRange(preOrder, 1, mid + 1), Arrays.copyOfRange(inOrder, 0, mid));

        root.right = getTreeFromInOrder(Arrays.copyOfRange(preOrder, mid + 1, preOrder.length), Arrays.copyOfRange(inOrder, mid + 1, inOrder.length));

        return root;

    }
}
