package is_graph_bipartite_785;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Boolean> cache = new HashMap<>();
        int length = graph.length;
        for(int i=0; i<length; i++){
            if(!cache.containsKey(i)){
                if(!helper(i, true, graph, cache)) return false;
            }
        }

        return true;
    }

    private boolean helper(int i, boolean marked, int[][] graph, Map<Integer, Boolean> cache){
        if(cache.containsKey(i)) return marked == cache.get(i);

        cache.put(i, marked);
        for(int node: graph[i]){
            if(!helper(node, !marked, graph, cache)) return false;
        }

        return true;
    }
}
