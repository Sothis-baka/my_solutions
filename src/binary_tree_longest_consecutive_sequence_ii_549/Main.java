package binary_tree_longest_consecutive_sequence_ii_549;

import structures.TreeNode;

/*
    Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
    Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
*/
public class Main {
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        path(root);
        return max;
    }

    private int[] path(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int inc = 1, dec = 1;
        if(root.left != null){
            int[] l = path(root.left);
            if(root.val == root.left.val+ 1) dec = 1 + l[1];
            else inc = 1 + l[0];
        }

        if(root.right != null){
            int[] r = path(root.right);
            if(root.val == root.right.val + 1) dec = Math.max(dec, 1 + r[1]);
            else inc = Math.max(inc, 1 + r[0]);
        }

        max = Math.max(max, inc + dec + 1);
        return new int[]{inc, dec};
    }
}