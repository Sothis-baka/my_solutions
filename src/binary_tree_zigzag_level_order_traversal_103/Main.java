package binary_tree_zigzag_level_order_traversal_103;

import structures.TreeNode;

import java.util.*;

/*
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class Main {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // BFS
        boolean toRight = true;
        // Use to save candidates
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> row = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node == null) continue;

                row.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }

            // Save this row
            if(!row.isEmpty()) {
                if(!toRight) Collections.reverse(row);
                result.add(row);
            }
            // Change direction
            toRight = !toRight;
        }

        return result;
    }
}
