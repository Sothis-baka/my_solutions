package populating_next_right_pointer_in_each_node_ii_117;

import structures.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public Node connect(Node root) {
        Queue<Node> candidates = new LinkedList<>();
        Queue<Integer> depths = new LinkedList<>();
        if(root != null) {
            candidates.offer(root);
            depths.offer(1);
        }

        Stack<Node> stack = new Stack<>();
        Stack<Integer> sDepths = new Stack<>();

        while(!candidates.isEmpty()){
            Node cur = candidates.poll();
            int depth = depths.poll();
            if(cur.left != null) {
                candidates.offer(cur.left);
                depths.offer(depth + 1);
            }
            if(cur.right != null) {
                candidates.offer(cur.right);
                depths.offer(depth + 1);
            }

            if(!stack.isEmpty()){
                int prevDepth = sDepths.peek();
                if(prevDepth == depth){
                    Node prev = stack.peek();
                    prev.next = cur;
                }else{
                    stack.clear();
                    sDepths.clear();
                }
            }

            stack.push(cur);
            sDepths.push(depth);
        }

        return root;
    }
}
