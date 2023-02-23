package unique_binary_search_trees_ii_95;

import java.util.ArrayList;
import java.util.List;

/*
    Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 */
public class Main {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generatorHelper(1, n);
    }

    private List<TreeNode> generatorHelper(int start, int end){
        List<TreeNode> result = new ArrayList<>();

        if(start > end){
            result.add(null);
        }else if(start == end){
            result.add(new TreeNode(start));
        }else{
            for(int i=start; i<=end; i++){
                List<TreeNode> leftCandidates = generatorHelper(start, i-1);
                List<TreeNode> rightCandidates = generatorHelper(i+1, end);
                for(TreeNode left: leftCandidates){
                    for(TreeNode right: rightCandidates){
                        TreeNode cur = new TreeNode(i);
                        cur.left = left;
                        cur.right = right;
                        result.add(cur);
                    }
                }
            }
        }

        return result;
    }
}
