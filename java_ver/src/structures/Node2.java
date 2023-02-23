package structures;

import java.util.ArrayList;
import java.util.List;

/*
    Provided structure (repeated name)
 */
public class Node2 {
    public int val;
    public List<Node2> neighbors;
    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
