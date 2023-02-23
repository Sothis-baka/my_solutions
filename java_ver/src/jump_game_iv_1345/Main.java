package jump_game_iv_1345;

import java.util.*;

/*
    Given an array of integers arr, you are initially positioned at the first index of the array.

    In one step you can jump from index i to index:

    i + 1 where: i + 1 < arr.length.
    i - 1 where: i - 1 >= 0.
    j where: arr[i] == arr[j] and i != j.
    Return the minimum number of steps to reach the last index of the array.

    Notice that you can not jump outside of the array at any time.
 */
public class Main {
    public static int minJumps(int[] arr) {
        // Save indexes of all values
        Map<Integer, List<Integer>> map = new HashMap<>();
        // Save min number of jump operations at an index
        Integer[] cache = new Integer[arr.length];
        // If a number is marked, shouldn't visit it again
        Set<Integer> visitedNumber = new HashSet<>();

        // Save indexes
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            if(map.containsKey(val)){
                map.get(val).add(i);
            }else{
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(val, newList);
            }
        }

        Stack<Integer> candidates = new Stack<>();
        candidates.push(arr.length - 1);
        fill(candidates, 0, arr, cache, map, visitedNumber);
        return cache[0];
    }

    private static void fill(Stack<Integer> candidates, int count, int[] arr, Integer[] cache, Map<Integer, List<Integer>> map, Set<Integer> visitedNumber){
        Stack<Integer> next = new Stack<>();

        for(int candidate: candidates){
            if(candidate < 0 || candidate >= arr.length){
                // Out of bound
                continue;
            }

            if(cache[candidate] != null){
                // Visited
                continue;
            }

            // Save to cache
            cache[candidate] = count;
            if(candidate == 0){
                // Start index, stop running
                return;
            }

            // Move left
            next.push(candidate - 1);
            // Move right
            next.push(candidate + 1);
            // Jump
            int val = arr[candidate];
            if(!visitedNumber.contains(val)){
                visitedNumber.add(val);
                for(int temp: map.get(val)){
                    next.push(temp);
                }
            }
        }

        fill(next, count+1, arr, cache, map, visitedNumber);
    }

    public static void main(String[] args){
        System.out.println(minJumps(new int[]{1}));
        System.out.println(minJumps(new int[]{7,6,9,6,9,6,9,7}));
        System.out.println(minJumps(new int[]{8,5,6,7,6,9,6,9,6,9,7}));
    }
}
