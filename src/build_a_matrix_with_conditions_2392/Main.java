package build_a_matrix_with_conditions_2392;

import java.util.*;

/*
    You are given a positive integer k. You are also given:

    a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and
    a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].
    The two arrays contain integers from 1 to k.

    You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells should have the value 0.

    The matrix should also satisfy the following conditions:

    The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all i from 0 to n - 1.
    The number lefti should appear in a column that is strictly left of the column at which the number righti appears for all i from 0 to m - 1.
    Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.
*/
public class Main {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Use to save position ranks
        Map<Integer, Set<Integer>> rowMap = new HashMap<>(), colMap = new HashMap<>();

        for(int[] rowCondition: rowConditions){
            rowMap.computeIfAbsent(rowCondition[1], n -> new HashSet<>()).add(rowCondition[0]);
        }
        for(int[] colCondition: colConditions){
            colMap.computeIfAbsent(colCondition[1], n -> new HashSet<>()).add(colCondition[0]);
        }

        Map<Integer, Integer> rowIndexes = new HashMap<>();
        Map<Integer, Integer> colIndexes = new HashMap<>();
        int[] rowVisited = new int[k + 1];
        int[] colVisited = new int[k + 1];

        for(int i=1; i<=k; i++){
            if(!dfs(i, rowMap, rowVisited, rowIndexes) || !dfs(i, colMap, colVisited, colIndexes)){
                return new int[][]{};
            }
        }

        int[][] result = new int[k][k];
        for(int i=1; i<=k; i++){
            result[rowIndexes.get(i)][colIndexes.get(i)] = i;
        }

        return result;
    }

    private boolean dfs(int index, Map<Integer, Set<Integer>> map, int[] visited, Map<Integer, Integer> indexes){
        // Visited, but in current stack. It can't be finished
        if(visited[index] == 1) return false;
        // Visited and has a value
        if(visited[index] == 2) return true;

        // Started, mark current with value 1;
        visited[index] = 1;

        // Complete all prerequisite
        for(int candidate: map.getOrDefault(index, new HashSet<>())){
            if(!dfs(candidate, map, visited, indexes)) return false;
        }

        // Put it to the end index
        indexes.put(index, indexes.size());
        // Mark it as finished
        visited[index] = 2;

        return true;
    }
}
