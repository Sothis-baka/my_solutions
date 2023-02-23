package boundary_of_binary_tree_545;


import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        result.add(root.val);
        addLeft(root.left, result);
        addLeaves(root.left, result);
        addLeaves(root.right, result);
        addRight(root.right, result);

        return result;
    }

    // Iterate to find all left boundaries
    private void addLeft(TreeNode node, List<Integer> list){
        if(node == null) return;

        if(node.left == null && node.right == null) return;
        list.add(node.val);

        if(node.left == null) addLeft(node.right, list);
        else addLeft(node.left, list);
    }

    // Iterate to find all right boundaries
    private void addRight(TreeNode node, List<Integer> list){
        if(node == null) return;

        if(node.left == null && node.right == null) return;

        if(node.right == null) addRight(node.left, list);
        else addRight(node.right, list);

        list.add(node.val);
    }

    private void addLeaves(TreeNode root, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null) list.add(root.val);

        if(root.left != null) addLeaves(root.left, list);
        if(root.right != null) addLeaves(root.right, list);
    }
}
