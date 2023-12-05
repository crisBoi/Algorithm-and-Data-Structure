package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class BinaryTree {

    private static int LEFT = 0;
    private static int RIGHT = 1;
//    private int maxZigZag = 0;
    private List<Integer> inOrderList = new ArrayList<>();
    public TreeNode root;
    private Boolean isValidBinaryTree = true;

    BinaryTree() {
        root = null;
    }

    public void add(int val) {
        root = addRecursively(root, val);
    }


    public void printInOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    int max=0; // to store max
    public int longestZigZag(TreeNode root) {
        if(root.left!=null){
            helper(root.left,true,1);    // going left adding 1 node
        }
        if(root.right!=null){
            helper(root.right,false,1); // going right adding 1 node
        }
        return max;

    }
    //BOOLEAN LEFT to know if arrived at this node by traversing left or right
    public void helper(TreeNode root,boolean left,int val){
//        System.out.println("line 41: " + "(" + root.val + ", " + left + ", " + val + ")");
        if(root.left==null && root.right==null){
            //LEAF NODE return val
            System.out.println("line 44: " + root.val + ", " + val);
            max=Math.max(val,max);
            return;
        }

        if(left){
            //if arrived from left then right node should be included
            if(root.right!=null){
//                System.out.println("line 51: " + "(" + root.val);
                helper(root.right,false,val+1);  //+1 node as right node is present
            }else{
                max=Math.max(val,max);    //if right node not present compare the val to max
            }
            if(root.left!=null){
                helper(root.left,true,1);   // starting as 1st node as it has already arrived from left so going left would be starting a new chain

            }
        }else{

            if(root.right!=null){
                helper(root.right,false,1);
            }
            //if arrived from right then left node should be included
            if(root.left!=null){
                helper(root.left,true,val+1); //+1 node as right node is present

            }
            else{
                max=Math.max(val,max);    //if left node not present compare the val to max
            }

        }

    }

/*    public int maximumZigZag() {
        maxZigZagRecursive(root);
        return maxZigZag;
    }
    private void maxZigZagRecursive(TreeNode current) {
        if (current == null) {
            return;
        }

        maxZigZagRecursive(current.left);
        maxZigZag(current.left, LEFT);
        maxZigZagRecursive(current.right);
        maxZigZag(current.right, RIGHT);

    }

    private void maxZigZag(TreeNode current, int direction) {
        int zigZag = 0;
        int lastDirection = direction;

        while (current != null) {
            if (lastDirection == LEFT) {
                current = current.right;
                zigZag++;
                lastDirection = RIGHT;
            } else if (lastDirection == RIGHT) {
                current = current.left;
                zigZag++;
                lastDirection = LEFT;
            }
        }

        if (zigZag > maxZigZag) {
            maxZigZag = zigZag;
        }
    }*/
    private void inOrderTraversalRecursive(TreeNode current) {
        if (current == null) {
            return;
        }

        inOrderTraversalRecursive(current.left);
        inOrderList.add(current.val);
        System.out.println("" + current.val);
        inOrderTraversalRecursive(current.right);
    }

    private TreeNode addRecursively(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.val) {
            current.left = addRecursively(current.left, val);
        } else {
            current.right = addRecursively(current.right, val);
        }

        return current;
    }

    public Boolean validateBinaryTree() {
        for (int i = 0; i < inOrderList.size(); i++) {
            if (i != 0 && inOrderList.get(i - 1) > inOrderList.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void validateTreeRecursively(TreeNode current) {
        if (current == null) {
            return;
        }

        if  (current.left != null && current.left.val >= current.val) {
            isValidBinaryTree = false;
        }

        if (current.right != null && current.right.val <= current.val) {
            isValidBinaryTree = false;
        }
        validateTreeRecursively(current.right);

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


