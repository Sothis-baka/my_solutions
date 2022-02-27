package largest_bst_subtree_333;

import structures.TreeNode;

/*
    Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 */
public class Main {
    public int largestBSTSubtree(TreeNode root) {
        return largestHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int largestHelper(TreeNode root, int min, int max){
        if(root == null){
            return 0;
        }

        int val = root.val;
        // Not valid
        if(min > val || max < val){
            return -1;
        }

        int left = largestHelper(root.left, min, val), right = largestHelper(root.right, val, max);
        if(left < 0){
            if(right < 0){
                return -1;
            }

            return right + 1;
        }
        if(right < 0){
            return left + 1;
        }
        return 1 + Math.max(left, right);
    }
}
