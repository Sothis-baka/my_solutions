package house_robber_iii_337;

import structures.TreeNode;

/*
    The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
    Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
    Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
*/
public class Main {
    public int rob(TreeNode root) {
        int[] result = robHelper(root);

        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        return new int[]{Math.max(left[0], left[1]) + Math.max(right[0], right[1]), root.val + left[0] + right[0]};
    }
}
