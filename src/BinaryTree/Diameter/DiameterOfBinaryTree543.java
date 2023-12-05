package BinaryTree.Diameter;

public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
//        bt.root.right = new TreeNode(3);
//        bt.root.left.left = new TreeNode(4);
//        bt.root.left.right = new TreeNode(2);

        System.out.println("diaameter: " + bt.diameter());

    }
}

class BinaryTree {
    TreeNode root;

    int maxHeight;
    public BinaryTree() {
        root = null;
        maxHeight = Integer.MIN_VALUE;
    }

    public int diameter() {
//       int[] diameter =
//               recursiveDiameter(root);
       /*int lHeight = diameter[0];
       int rHeight = diameter[1];
        if (root.left != null && root.right != null) {
            if (lHeight + rHeight > maxHeight) {
                maxHeight = lHeight + rHeight;
            }
        } else if (root.left == null && root.right != null) {
            if (rHeight > maxHeight) {
                maxHeight = rHeight;
            }
        } else if (root.right == null && root.left != null) {
            if (lHeight > maxHeight) {
                maxHeight = lHeight;
            }
        }*/
       return maxHeight;
    }

    private int[] recursiveDiameter(TreeNode current, TreeNode p, TreeNode q) {

        if (p.val <= current.val) {
            if (q.val <= current.val) {

            } else {

            }
        }

        if (p.val >= current.val) {
            if (q.val <= current.val) {

            } else {

            }
        }



        return new int[]{};
    }

    int maxDiameter = 0;

    private int maxHeightRecursive(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int lHeight = maxHeightRecursive(current.left);
        int rHeight = maxHeightRecursive(current.right);

        if (lHeight + rHeight > maxDiameter) {
            maxDiameter = lHeight + rHeight;
        }

        if (lHeight > rHeight) {
            return lHeight + 1;
        } else {
            return rHeight + 1;
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