package validate_binary_search_tree_98;

/*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
 */
public class Main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validHelper(root, null, null);
    }

    private boolean validHelper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        int val = root.val;
        if((min != null && val <= min) || (max != null && val >= max)){
            return false;
        }

        return validHelper(root.left, min, val) && validHelper(root.right, val, max);
    }
}
