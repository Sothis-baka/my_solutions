package two_sum_iv_input_is_a_bst_653;

import structures.TreeNode;

import java.util.*;

/*
    Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class Main {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> visited = new HashSet<>();
        return visit(root, k, visited);
    }

    private boolean visit(TreeNode root, int k, Set<Integer> visited){
        if(root == null) return false;
        if(visited.contains(k - root.val)) return true;
        visited.add(root.val);
        return visit(root.left, k, visited) || visit(root.right, k, visited);
    }
}
