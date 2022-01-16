package balanced_binary_tree_110;

import structures.TreeNode;

/*
    Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined as:
    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class Main {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root){
        // empty
        if(root == null){
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        if(leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) <= 1){
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
