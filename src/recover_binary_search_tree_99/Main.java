package recover_binary_search_tree_99;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/*
    You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 */
public class Main {
    public static class TreeNode {
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

    public static void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recoverHelper(root, list);

        int length = list.size();
        TreeNode node1 = null, node2 = null;
        for(int i=0; i<length; i++){
            int left = i == 0 ? Integer.MIN_VALUE : list.get(i-1).val;
            int right = i == length-1 ? Integer.MAX_VALUE : list.get(i+1).val;
            int cur = list.get(i).val;

            if(right < cur && left < right){
                node1 = list.get(i);
            }else if(left > cur && right > cur && left < right){
                node2 = list.get(i);
            }
        }

        if(node1 != null && node2 != null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    private static void recoverHelper(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }

        recoverHelper(root.left, list);
        list.add(root);
        recoverHelper(root.right, list);
    }
}
