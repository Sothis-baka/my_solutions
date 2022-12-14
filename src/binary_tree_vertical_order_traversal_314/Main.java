package binary_tree_vertical_order_traversal_314;

import structures.TreeNode;

import java.util.*;

/*
    Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
    If two nodes are in the same row and column, the order should be from left to right.
 */
public class Main {
    static class WrappedNode{
        TreeNode node;
        int pos;

        WrappedNode(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        /*
            BFS, top to bottom, left to right
            Put nodes with same pos into a bracket
            Use treemap because it's sorted by key
         */
        Map<Integer, List<Integer>> map = new TreeMap<>();
        LinkedList<WrappedNode> unvisited = new LinkedList<>();
        unvisited.add(new WrappedNode(root, 0));

        while (!unvisited.isEmpty()){
            WrappedNode cur = unvisited.pop();
            map.computeIfAbsent(cur.pos, k -> new ArrayList<>()).add(cur.node.val);

            if(cur.node.left != null)
                unvisited.offer(new WrappedNode(cur.node.left, cur.pos - 1));

            if(cur.node.right != null)
                unvisited.offer(new WrappedNode(cur.node.right, cur.pos + 1));
        }

        return new ArrayList<>(map.values());
    }
}
