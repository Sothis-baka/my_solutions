package range_sum_of_bst_938;

import structures.TreeNode;

/*
    Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class Main {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val < low) return rangeSumBST(root.right, low, high);
        else if(root.val > high) return rangeSumBST(root.left, low, high);
        else return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
