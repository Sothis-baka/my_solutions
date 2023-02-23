package n_queens_51;

import java.util.*;

/*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class Main {
    public static List<List<String>> solveNQueens(int n) {
        // Map to save candidates for a certain cell
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int length = n*n;
        for(int i=0; i<length; i++){
            Set<Integer> candidates = new HashSet<>();
            for(int j=i; j<length; j++){
                if(i/n != j/n && i%n != j%n && Math.abs(i/n - j/n) != Math.abs(i%n-j%n))
                    candidates.add(j);
            }
            map.put(i, candidates);
        }

        // List to save answers
        List<List<String>> result = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> cur = new ArrayList<>(4);
            cur.add(i);
            complete(cur, n, map, result);
        }

        return result;
    }

    private static void complete(List<Integer> cur, int n, Map<Integer, Set<Integer>> map, List<List<String>> result){
        if(cur.size() == n){
            // Completed
            List<String> answer = new ArrayList<>();
            for(int i=0; i<n; i++){
                // Row
                StringBuilder strBd = new StringBuilder();
                for(int j=0; j<n; j++){
                    // Column
                    if(cur.contains(i*n+j)){
                        strBd.append('Q');
                    }else{
                        strBd.append('.');
                    }
                }
                answer.add(strBd.toString());
            }
            // Save and quit
            result.add(answer);
            return;
        }

        for(int temp: map.get(cur.get(cur.size()-1))){
            // Find a valid candidate
            boolean isValid = true;

            for(int i=0; i<cur.size()-1; i++){
                if(!map.get(cur.get(i)).contains(temp)){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                // Add candidate to a copy array, recursively call the function to complete the array.
                List<Integer> copy = new ArrayList<>(cur);
                copy.add(temp);
                complete(copy, n, map, result);
            }
        }
    }

    public static void main(String[] args){
        List<List<String>> result = solveNQueens(9);
        for(List<String> temp: result){
            System.out.println(temp);
        }
    }
}
