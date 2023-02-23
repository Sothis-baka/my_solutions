package n_ary_tree_Level_order_traversal_429;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        List<Node> candidates = new ArrayList<>();
        candidates.add(root);
        while(!candidates.isEmpty()){
            List<Node> newCandidates = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for(Node node: candidates){
                list.add(node.val);
                for(Node child: node.children){
                    if(child != null) newCandidates.add(child);
                }
            }
            result.add(list);
            candidates = newCandidates;
        }

        return result;
    }
}
