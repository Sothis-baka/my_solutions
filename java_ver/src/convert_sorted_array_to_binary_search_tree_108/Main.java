package convert_sorted_array_to_binary_search_tree_108;

import structures.TreeNode;

/*
    Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
    A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class Main {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }else if(start == end){
            return new TreeNode(nums[start]);
        }else{
            int mid = (start + end) / 2;
            return new TreeNode(nums[mid], helper(nums, start, mid-1), helper(nums, mid+1, end));
        }
    }
}
