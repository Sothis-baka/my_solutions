package lowest_common_ancester_of_a_binary_tree_iii;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> visited = new HashSet<>();
        visited.add(p.val);
        visited.add(q.val);

        while (p.parent != null || q.parent != null){
            if(p.parent != null){
                p = p.parent;
                if(visited.contains(p.val)) return p;
                visited.add(p.val);
            }
            if(q.parent != null){
                q = q.parent;
                if(visited.contains(q.val)) return q;
                visited.add(q.val);
            }
        }

        return null;
    }
}
