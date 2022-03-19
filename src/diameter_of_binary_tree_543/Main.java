package diameter_of_binary_tree_543;

import structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
    Given the root of a binary tree, return the length of the diameter of the tree.
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    The length of a path between two nodes is represented by the number of edges between them.
 */
public class Main {
    Map<TreeNode, Integer> heights = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), height(root.left) + height(root.right));
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        if(!heights.containsKey(root)) heights.put(root, 1 + Math.max(height(root.left), height(root.right)));
        return heights.get(root);
    }
}
