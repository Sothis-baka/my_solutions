package subtree_of_another_tree_572;

import structures.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
    A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
*/
public class Main {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode root2){
        if(root == null || root2 == null) return root == null && root2 == null;
        if(root.val != root2.val) return false;

        return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right);
    }
}
