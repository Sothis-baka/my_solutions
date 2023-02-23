package all_nodes_distance_k_in_binary_tree_863;

import com.sun.source.tree.Tree;
import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

    You can return the answer in any order.
 */
public class Main {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        /*
            From root, DFS to find the target node.
            Find the nodes below the target node with distance k.
            Find the nodes above the target node with distance k. (if k >= distance from root)
            Find the nodes with distance k - distance from root that's not on the path.
         */
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> path = new LinkedList<>();
        findPath(root, target.val, path);

        findNodesBelow(target, k, result, new ArrayList<>());

        for(int i=0; i < path.size() - 1; i++){
            findNodesBelow(path.get(i), k - path.size() + i + 1, result, path);
        }


        return result;
    }

    /*
        DFS to find the path
     */
    private boolean findPath(TreeNode root, int target, LinkedList<TreeNode> path) {
        // Reach a leaf, cancel
        if(root == null) return false;

        path.offer(root);

        // Find the target, stop
        if(root.val == target) return true;

        // Not found in future search
        if(!findPath(root.left, target, path) && !findPath(root.right, target, path)){
            path.removeLast();
            return false;
        }

        return true;
    }

    private void findNodesBelow(TreeNode root, int k, List<Integer> result, List<TreeNode> forbidden){
        if(k < 0 || root == null) return;

        if(k == 0) {
            result.add(root.val);
            return;
        }

        if(root.left != null && !forbidden.contains(root.left)) findNodesBelow(root.left, k - 1, result, forbidden);
        if(root.right != null && !forbidden.contains(root.right)) findNodesBelow(root.right, k - 1, result, forbidden);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(3);
        root.right.left.left.left = new TreeNode(4);
        root.right.left.left.left.left = new TreeNode(5);

        Main m = new Main();
        System.out.println(m.distanceK(root, root, 2));
    }
}
