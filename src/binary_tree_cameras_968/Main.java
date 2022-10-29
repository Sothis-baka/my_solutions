package binary_tree_cameras_968;

import structures.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
    You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
    Return the minimum number of cameras needed to monitor all nodes of the tree.
 */
public class Main {
    final int MAX = 10000;

    public int minCameraCover(TreeNode root) {
        return coverHelper(root, 1, new HashMap<>());
    }

    private int coverHelper(TreeNode node, int status, Map<TreeNode, int[]> cache){
        if(node == null) return status == 2 ? MAX : 0;

        // visited
        int[] curCache = cache.computeIfAbsent(node, k -> new int[3]);
        if(curCache[status] != 0) return curCache[status];

        int min = MAX;
        /*
            status:
                0 -> upper covered, don't care upper
                1 -> upper not covered, don't care upper because upper is covered by others
                2 -> upper not covered, care upper

                if 0:
                    C -> l0 r0,
                    UC -> l1 r1,
                if 1:
                    C -> l0 r0,
                    UC -> l1 r2, l2 r1
                if 2:
                    C -> l0 r0
         */
        switch (status) {
            case 0 -> {
                min = Math.min(
                        1 + coverHelper(node.left, 0, cache) + coverHelper(node.right, 0, cache),
                        coverHelper(node.left, 1, cache) + coverHelper(node.right, 1, cache)
                );
            }

            case 1 -> {
                min = Math.min(
                        1 + coverHelper(node.left, 0, cache) + coverHelper(node.right, 0, cache),
                        coverHelper(node.left, 1, cache) + coverHelper(node.right, 2, cache)
                );

                min = Math.min(
                        min,
                        coverHelper(node.left, 2, cache) + coverHelper(node.right, 1, cache)
                );
            }

            case 2 -> {
                min = 1 + coverHelper(node.left, 0, cache) + coverHelper(node.right, 0, cache);
            }
        }

        return curCache[status] = min;
    }
}
