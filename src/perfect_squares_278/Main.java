package perfect_squares_278;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer n, return the least number of perfect square numbers that sum to n.
    A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class Main {
    public static int numSquares(int n) {
        int[] cache = new int[n+1];
        return squareHelper(n, cache);
    }

    private static int squareHelper(int n, int[] cache){
        if(cache[n] != 0){
            return cache[n];
        }

        int maxI = (int)Math.sqrt(n);
        // Exactly
        if(maxI * maxI == n){
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for(int i=maxI/2 + 1; i<=maxI; i++){
            int sqr = i * i;
            cache[sqr] = 1;
            min = Math.min(min, squareHelper(n - sqr, cache) + 1);
        }

        cache[n] = min;
        return min;
    }

    public static void main(String[] args){
        System.out.println(numSquares(12));
    }
}
