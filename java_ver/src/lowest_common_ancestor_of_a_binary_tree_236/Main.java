package lowest_common_ancestor_of_a_binary_tree_236;

import structures.TreeNode;

/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class Main {
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Start from a node, if the node contains both, check its children
        findHelper(root, p, q);
        return result;
    }

    private int findHelper(TreeNode node, TreeNode p, TreeNode q){
        // End
        if(node == null) return 0;

        int val = 0;
        // Matched
        if(node == p || node == q) val++;

        // If value is two, it's an ancestor
        val +=  findHelper(node.left, p, q) + findHelper(node.right, p, q);
        if(result == null && val == 2) result = node;
        return val;
    }
}
