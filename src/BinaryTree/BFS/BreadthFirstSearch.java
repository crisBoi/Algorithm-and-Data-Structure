package BinaryTree.BFS;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        BinaryT bt = new BinaryT();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);

        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);

        System.out.println("height: " + bt.maxHeight());

        System.out.println("level order traversal/ BFS");

        bt.printLevelOrder();
    }
}

class BinaryT {
    TreeNode root;

    BinaryT() {
        root = null;
    }

    public int maxHeight() {
        return recursiveMaxHeight(root);
    }

    public int recursiveMaxHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int lHeight = recursiveMaxHeight(current.left);
        int rHeight = recursiveMaxHeight(current.right);

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
        }

    }

    public void printLevelOrder() {
        int height = maxHeight();

        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
            System.out.println();
        }
    }

    void printCurrentLevel(TreeNode current, int level) {
        if (current == null) {
            return;
        }

        if (level == 1) {
            System.out.print("" + current.val + " ");
        } else {
            printCurrentLevel(current.left, level - 1);
            printCurrentLevel(current.right, level - 1);
        }

    }
}

class BT {
    TreeNode root;

    BT() {
        root = null;
    }

    void BFS(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}


