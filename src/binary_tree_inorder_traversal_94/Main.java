package binary_tree_inorder_traversal_94;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class Main {
    private static class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        addHelper(root, result);

        return result;
    }

    private void addHelper(TreeNode root, List<Integer> result){
        if(root != null){
            addHelper(root.left, result);
            result.add(root.val);
            addHelper(root.right, result);
        }
    }
}
