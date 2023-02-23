package n_ary_tree_preorder_traversal_589;

import java.util.ArrayList;
import java.util.List;

/*
    Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
    Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value
 */
public class Main {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        itHelper(root, result);
        return result;
    }

    private void itHelper(Node node, List<Integer> result){
        if(node == null) return;
        result.add(node.val);

        for(Node temp: node.children){
            itHelper(temp, result);
        }
    }


    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
