package path_sum_ii_113;

import structures.ListNode;
import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
    A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */
public class Main {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void helper(TreeNode root, int curSum, int targetSum, List<Integer> curList, List<List<Integer>> result){
        if(root == null){
            return;
        }

        // Save to List
        List<Integer> copy = new ArrayList<>(curList);
        copy.add(root.val);

        // Add to sum
        curSum += root.val;
        if(curSum == targetSum && root.left == null && root.right == null){
            result.add(copy);
        }

        // Recursive run
        helper(root.left, curSum, targetSum, copy, result);
        helper(root.right, curSum, targetSum, copy, result);
    }
}
