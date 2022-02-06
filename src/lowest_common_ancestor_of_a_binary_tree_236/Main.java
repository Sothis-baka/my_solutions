package lowest_common_ancestor_of_a_binary_tree_236;

import structures.TreeNode;

/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class Main {
    TreeNode lastOne;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchHelper(root, p, q);
        return lastOne;
    }

    private int searchHelper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return 0;
        }

        int result = 0;
        if(node == p || node == q){
            result += 1;
        }

        result += searchHelper(node.left, p, q);
        if(result == 2 && lastOne == null){
            lastOne = node;
            return 2;
        }

        result += searchHelper(node.right, p, q);
        if(result == 2 && lastOne == null){
            // Will overwrite its children
            lastOne = node;
        }

        return result;
    }
}
