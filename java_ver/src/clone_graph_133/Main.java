package clone_graph_133;

import structures.Node;
import structures.Node2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
 */
public class Main {
    // Deep clone
    public Node2 cloneGraph(Node2 node) {
        Map<Integer, Node2> cache = new HashMap<>();

        return cloneHelper(node, cache);
    }

    private Node2 cloneHelper(Node2 node, Map<Integer, Node2> cache){
        // Empty
        if(node == null){
            return null;
        }

        int val = node.val;

        // Already copied
        if(cache.containsKey(val)){
            return cache.get(val);
        }

        Node2 newNode = new Node2(val);

        // Clone references
        List<Node2> newNeighbors = newNode.neighbors;
        List<Node2> neighbors = node.neighbors;
        for(Node2 temp: neighbors){
            newNeighbors.add(cloneHelper(temp, cache));
        }
        // Save to cache
        cache.put(val, newNode);

        return newNode;
    }
}
