package BinaryTree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS102 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);

        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);

        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);

        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(7);

        List<List<Integer>> x = bt.optimalBfs(bt.root);
        System.out.println("" + x);

    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    List<List<Integer>> printDfs() {
        int height = maxHeight(root);

        List<List<Integer>> global = new ArrayList<>();

        for (int i = 1; i <= height; i++) {
            List<Integer> levelWise = new ArrayList<>();
            printRecursively(root, i, levelWise);
            global.add(levelWise);
        }

        return global;
    }

    int maxHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int lHeight = maxHeight(current.left);
        int rHeight = maxHeight(current.right);

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }
    }

    void printRecursively(TreeNode current, int level, List<Integer> levelWise) {
        if (current == null) return;

        if (level == 1) {
            levelWise.add(current.val);
        } else {
            printRecursively(current.left, level - 1, levelWise);
            printRecursively(current.right, level - 1, levelWise);
        }


    }

    List<List<Integer>> optimalBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrap = new LinkedList<>();

        if (root == null) return wrap;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);

                list.add(queue.remove().val);
            }

            wrap.add(list);
        }

        return wrap;
    }


}

