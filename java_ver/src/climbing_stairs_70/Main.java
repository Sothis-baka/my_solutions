package climbing_stairs_70;

import java.util.HashMap;
import java.util.Map;

/*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Main {
    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return climbStairsHelper(n, cache);
    }

    private static int climbStairsHelper(int n, Map<Integer, Integer> cache){
        if(n == 0 || n == 1){
            return 1;
        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }

        int result = climbStairsHelper(n-1, cache) + climbStairsHelper(n-2, cache);
        cache.put(n, result);
        return result;
    }
}
