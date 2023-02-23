package binary_tree_level_order_traversal_102;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class Main {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // BFS
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        // Save current candidates to inspect
        List<TreeNode> candidates = new ArrayList<>();
        // Init value
        candidates.add(root);

        while (!candidates.isEmpty()){
            // Saves the values of a row
            List<Integer> row = new ArrayList<>();
            List<TreeNode> newCandidates = new ArrayList<>();

            for(TreeNode node: candidates){
                if(node != null){
                    // Save value
                    row.add(node.val);
                    // Add children to next list
                    newCandidates.add(node.left);
                    newCandidates.add(node.right);
                }
            }

            // We don't save empty array
            if(!row.isEmpty()) result.add(row);
            // Update candidates
            candidates = newCandidates;
        }

        return result;
    }
}
