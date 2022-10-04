package reachable_nodes_with_restrictions_2368;

import java.util.*;

/*
    There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
    You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.
    Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.
    Note that node 0 will not be a restricted node.
 */
public class Main {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // Using a map to store valid edges
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // Using a set to store restricted nodes
        Set<Integer> set = new HashSet<>();

        for(int num: restricted){
            set.add(num);
        }

        for(int[] edge: edges){
            if(set.contains(edge[0]) || set.contains(edge[1])){
                continue;
            }

            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        // Using a set to store visitable nodes
        Set<Integer> visited = new HashSet<>();
        // Using a list to store possible candidates
        List<Integer> candidates = new ArrayList<>();

        visited.add(0);
        candidates.add(0);

        while (!candidates.isEmpty()){
            List<Integer> newCandidates = new ArrayList<>();
            for(int node: candidates){
                for(int target: map.getOrDefault(node, new HashSet<>())){
                    // Add new nodes
                    if(!visited.contains(target)){
                        visited.add(target);
                        newCandidates.add(target);
                    }
                }
            }
            candidates = newCandidates;
        }

        return visited.size();
    }
}
