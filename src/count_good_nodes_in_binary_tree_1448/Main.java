package count_good_nodes_in_binary_tree_1448;

import structures.TreeNode;

/*
    Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
    Return the number of good nodes in the binary tree.
 */
public class Main {
    public int goodNodes(TreeNode root) {
        // DFS start from root
        return countHelper(root, Integer.MIN_VALUE);
    }

    private int countHelper(TreeNode root, int curMax) {
        if(root == null) return 0;

        int count = 0;
        if(root.val >= curMax){
            count++;
            curMax = root.val;
        }

        count += countHelper(root.left, curMax);
        count += countHelper(root.right, curMax);

        return count;
    }
}
