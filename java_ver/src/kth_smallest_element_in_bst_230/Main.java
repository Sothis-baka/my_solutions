package kth_smallest_element_in_bst_230;

import structures.TreeNode;

/*
    Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class Main {
    public int kthSmallest(TreeNode root, int k) {
        int[] cache = new int[1];

        count(root, cache, k);

        return cache[0];
    }

    private int count(TreeNode root, int[] cache, int k){
        if(root == null){
            return 0;
        }

        int leftCount = count(root.left, cache, k);
        if(leftCount < 0){
            // Finished
            return -1;
        }else if(leftCount + 1 == k){
            // Find target, stop recursion
            cache[0] = root.val;
            return -1;
        }

        int rightCount = count(root.right, cache, k - leftCount - 1);
        return rightCount < 0 ? -1 : 1 + leftCount + rightCount;
    }
}
