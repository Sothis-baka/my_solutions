package binary_tree_zigzag_level_order_traversal_103;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class Main {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // BFS
        boolean toRight = false;
        // Use to save candidates
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Stack<TreeNode> nextStack = new Stack<>();
            List<Integer> row = new ArrayList<>();

            while(!stack.isEmpty()){
                TreeNode node = stack.pop();

                if(node == null){
                    continue;
                }

                row.add(node.val);
                if(toRight){
                    nextStack.push(node.left);
                    nextStack.push(node.right);
                }else{
                    nextStack.push(node.right);
                    nextStack.push(node.left);
                }
            }

            // Save this row
            if(!row.isEmpty())
                result.add(row);
            // Replace stack
            stack = nextStack;
            // Change direction
            toRight = !toRight;
        }

        return result;
    }
}
