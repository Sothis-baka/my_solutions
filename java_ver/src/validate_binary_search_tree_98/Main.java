package validate_binary_search_tree_98;

import structures.TreeNode;

/*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
 */
public class Main {
    public boolean isValidBST(TreeNode root) {
        // Recursive
        // Start from a node, check if its children are both valid
        // A node should be valid if it's in range

        return validateHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateHelper(TreeNode root, int min, int max){
        // Empty is valid
        if(root == null) return true;
        // Out of range is not valid
        if(root.val < min || root.val > max) return false;

        if(root.val == min && root.left != null) return false;
        if(root.val == max && root.right != null) return false;

        // Check children
        return (validateHelper(root.left, min, root.val - 1) && validateHelper(root.right, root.val + 1, max));
    }
}
