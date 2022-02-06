package invert_binary_tree_226;

import structures.TreeNode;

/*
    Given the root of a binary tree, invert the tree, and return its root.
 */
public class Main {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
