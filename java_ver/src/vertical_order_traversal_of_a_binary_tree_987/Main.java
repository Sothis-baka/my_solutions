package vertical_order_traversal_of_a_binary_tree_987;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
    For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
    The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
    Return the vertical order traversal of the binary tree.
 */
public class Main {
    class Node{
        int row, col, val;

        Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Node> queue = new PriorityQueue<>(
                (a, b) -> a.col == b.col
                            ? (a.row == b.row
                                ? a.val - b.val : a.row - b.row)
                            : a.col - b.col
        );
        iterateTree(root, queue, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        int curCol = Integer.MIN_VALUE;
        List<Integer> curList = new ArrayList<>();
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.col != curCol){
                curList = new ArrayList<>();
                result.add(curList);
                curCol = node.col;
            }
            curList.add(node.val);
        }

        return result;
    }

    private void iterateTree(TreeNode root, PriorityQueue<Node> queue, int row, int col){
        if(root == null) return;
        queue.offer(new Node(row, col, root.val));
        iterateTree(root.left, queue, row + 1, col - 1);
        iterateTree(root.right, queue, row + 1, col + 1);
    }
}
