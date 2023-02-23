package graph_valid_tree_261;

import java.util.*;

/*
    Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 */
public class Main {
    public static boolean validTree(int[][] edges, int count){
        Map<Integer, Set<Integer>> cache = new HashMap<>();
        // Init
        for(int i=0; i<count; i++){
            cache.put(i, new HashSet<>());
        }
        // Save edges
        for(int[] edge: edges){
            cache.get(edge[0]).add(edge[1]);
            cache.get(edge[1]).add(edge[0]);
        }

        Set<Integer> unvisited = new HashSet<>();
        // Init
        for(int i=0; i<count; i++){
            unvisited.add(i);
        }

        // Explore from 0
        if(!explore(0, -1, unvisited, cache)){
            return false;
        }

        // All nodes should be connected
        return unvisited.isEmpty();
    }

    private static boolean explore(int cur, int last, Set<Integer> unvisited, Map<Integer, Set<Integer>> cache){
        // Formed a cycle
        if(!unvisited.contains(cur)) return false;
        // Shouldn't visit again
        unvisited.remove(cur);

        for(int temp: cache.get(cur)){
            // Shouldn't go back
            if(temp == last){
                continue;
            }

            // Explore further
            if(!explore(temp, cur, unvisited, cache)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(validTree(new int[][]{{0,1},{0,2},{0,3},{1,4}}, 5));
        System.out.println(validTree(new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}, 5));
    }
}
