package BinaryTree.CountGoodNodes;

import BinaryTree.BFS.TreeNode;

public class CountGoodNodesSolution {
    public static void main(String[] args) {

    }

}

class Bt {
    int countGoodNodes(TreeNode current, int upperVal) {
        if (current == null) return 0;

        int res = current.val >= upperVal ? 1: 0;

        res += countGoodNodes(current.left, Math.max(current.val, upperVal));
        res += countGoodNodes(current.right, Math.max(current.val, upperVal));

        return res;
    }
}


