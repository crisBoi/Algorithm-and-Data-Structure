package BinaryTree.LowestCommonAncestor;

public class LowestCommonAncestor235 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(6);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(8);
        bt.root.left.left= new TreeNode(0);
        bt.root.left.right = new TreeNode(4);
        bt.root.left.right.left = new TreeNode(3);
        bt.root.left.right.right = new TreeNode(5);

        bt.root.right.left= new TreeNode(7);
        bt.root.right.right= new TreeNode(9);

        System.out.println("lowest common ancestor: " + bt.lowestCommonAncestor(new TreeNode(2), new TreeNode(8)).val);
        
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        root = null;
    }

    TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            TreeNode temp = q;
            q = p;
            p = temp;
        }

        return lowestCommonAncestorRecursive(root, p, q);
    }

    TreeNode lowestCommonAncestorRecursive(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return null;
        }


        if (p.val <= current.val && q.val >= current.val) {
            return current;
        } else if (p.val >= current.val && q.val <= current.val) {
            return current;
        } else if (p.val > current.val) {
            return lowestCommonAncestorRecursive(current.right, p, q);
        } else {
            return lowestCommonAncestorRecursive(current.left, p, q);
        }
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


