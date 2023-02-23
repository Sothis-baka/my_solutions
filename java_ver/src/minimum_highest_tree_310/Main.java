package minimum_highest_tree_310;

import java.util.*;

/*
    A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
    Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
    Return a list of all MHTs' root labels. You can return the answer in any order.
    The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class Main {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> links = new HashMap<>();
        int[] heights = new int[n];
        for(int[] edge: edges){
            int from = edge[0], to = edge[1];
            heights[from]++;
            heights[to]++;

            if(links.containsKey(from)){
                links.get(from).add(to);
            }else{
                Set<Integer> newSet = new HashSet<>();
                newSet.add(to);
                links.put(from, newSet);
            }

            if(links.containsKey(to)){
                links.get(to).add(from);
            }else{
                Set<Integer> newSet = new HashSet<>();
                newSet.add(from);
                links.put(to, newSet);
            }
        }

        // Init
        Set<Integer> unvisited = new HashSet<>();
        Set<Integer> candidates = new HashSet<>();
        for(int i=0; i<n; i++){
            if(heights[i] == 1){
                candidates.add(i);
            }else{
                unvisited.add(i);
            }
        }

        while(!unvisited.isEmpty() && !candidates.isEmpty()){
            Set<Integer> newCandidates = new HashSet<>();

            for(int cur: candidates){
                for(int target: links.getOrDefault(cur, new HashSet<>())){
                    if(unvisited.contains(target) && (--heights[target] == 0 || heights[target] == 1)){
                        newCandidates.add(target);
                        unvisited.remove(target);
                    }
                }
            }

            candidates = newCandidates;
        }

        return new ArrayList<>(unvisited.isEmpty() ? candidates : unvisited);
    }

    public static void main(String[] args){
        int n = 6;
        int[][] edges = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};

        System.out.println(findMinHeightTrees(n, edges));
    }
}
