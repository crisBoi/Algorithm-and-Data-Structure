package BinaryTree.KthSmallest;

import BinaryTree.BFS.TreeNode;

import java.util.Stack;

public class KthSmallest230 {
    public static void main(String[] args) {

    }
}

class Solution {
    int smallest;
    int kth;
    void getKthSmallest(TreeNode current) {
        if (current == null) {
            return;
        }

        getKthSmallest(current.left);
        if (kth != 0) {
            smallest = current.val;
            kth--;
        }
        getKthSmallest(current.right);
    }

    int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }

            current = current.right;
        }

        return 0;
    }
}
