package distance_to_a_cycle_in_undirected_graph_2204;

import java.util.*;

/*
    You are given a positive integer n representing the number of nodes in a connected undirected graph containing exactly one cycle. The nodes are numbered from 0 to n - 1 (inclusive).
    You are also given a 2D integer array edges, where edges[i] = [node1i, node2i] denotes that there is a bidirectional edge connecting node1i and node2i in the graph.
    The distance between two nodes a and b is defined to be the minimum number of edges that are needed to go from a to b.
    Return an integer array answer of size n, where answer[i] is the minimum distance between the ith node and any node in the cycle.
 */
public class Main {
    public int[] distanceToCycle(int n, int[][] edges) {
        /*
            Use DFS to find the cycle.
            Use BFS to find the distance from each node to the cycle.
         */

        /*
            Create the graph.
         */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        /*
            Find the cycle.
         */
        int[] lengths = new int[n];
        Arrays.fill(lengths, -1);
        dfsHelper(0, -1, graph, lengths);

        /*
            Find the distance from each node to the cycle.
         */
        return bfsHelper(lengths, graph, n);
    }

    private int dfsHelper(int node, int from, Map<Integer, List<Integer>> graph, int[] lengths){
        // Visited
        if(lengths[node] != -1) return lengths[node];

        // Visiting
        lengths[node] = node;

        for(int neighbor: graph.get(node)){
            if(neighbor == from) continue;

            int length = dfsHelper(neighbor, node, graph, lengths);
            // Unreachable end, the neighbor will form a cycle.
            if(length != Integer.MAX_VALUE){
                lengths[node] = length;

                if(length == node) return Integer.MAX_VALUE; // The cycle ends here. Current node won't be affected
                return length; // The cycle ends somewhere else. Current node will be affected.
            }
        }

        // Not in the cycle, mark it
        return lengths[node] = Integer.MAX_VALUE;
    }

    private int[] bfsHelper(int[] lengths, Map<Integer, List<Integer>> graph, int n){
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Queue<Integer> candidates = new LinkedList<>();
        for(int i=0; i<n; i++)
            if(lengths[i] != -1 && lengths[i] != Integer.MAX_VALUE)
                candidates.add(i);

        int depth = 0;
        while (!candidates.isEmpty()){
            int currentSize = candidates.size();
            /*
                Mark all nodes at current depth.
             */
            for(int i=0; i<currentSize; i++){
                int node = candidates.poll();
                // Visited, ignore it
                if(result[node] != -1) continue;
                result[node] = depth;
                candidates.addAll(graph.get(node));
            }

            depth++;
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] edges = {{1,2},{2,3},{3,4},{4,1},{0,1},{5,2},{6,5}};
        System.out.println(Arrays.toString(m.distanceToCycle(7, edges)));
    }
}
