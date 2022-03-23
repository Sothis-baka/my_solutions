package find_duplicate_subtrees_652;

import structures.TreeNode;

import java.util.*;

/*
    Given the root of a binary tree, return all duplicate subtrees.
    For each kind of duplicate subtrees, you only need to return the root node of any one of them.
    Two trees are duplicate if they have the same structure with the same node values.
 */
public class Main {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> result = new HashSet<>();
        Map<String, TreeNode> visited = new HashMap<>();
        serialize(root, visited, result);
        return new ArrayList<>(result);
    }

    private String serialize(TreeNode root, Map<String, TreeNode> visited, Set<TreeNode> result){
        if(root == null) return "n";
        String str = root.val + "," + serialize(root.left, visited, result) + "," + serialize(root.right, visited, result);
        if(visited.containsKey(str)) result.add(visited.get(str));
        else visited.put(str, root);
        return str;
    }
}
