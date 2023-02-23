package binary_tree_right_side_view_199;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class Main {
    public List<Integer> rightSideView(TreeNode root) {
        /*
            DFS, save one value at each index
         */
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int depth, List<Integer> result){
        if(root == null) return;
        if(result.size() <= depth) result.add(root.val); // New element at current depth
        else result.set(depth, root.val); // Right-most element at current depth
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
    }
}
