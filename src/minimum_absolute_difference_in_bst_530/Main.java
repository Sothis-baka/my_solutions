package minimum_absolute_difference_in_bst_530;

import structures.TreeNode;

/*
    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 */
public class Main {
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMax(root);
        getMin(root);
        return result;
    }

    private int getMax(TreeNode root){
        if(root.left != null){
            int val = getMax(root.left);
            result = Math.min(result, root.val - val);
        }
        if(root.right == null) return root.val;
        else return getMax(root.right);
    }

    private int getMin(TreeNode root){
        if(root.right != null){
            int val = getMin(root.right);
            result = Math.min(result, val - root.val);
        }
        if(root.left == null) return root.val;
        else return getMin(root.left);
    }
}
