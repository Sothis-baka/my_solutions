package max_points_on_a_line;

import java.util.*;

public class Main {
    public int maxPoints(int[][] points) {
        /*
            A line can be represented as y = kx + b;

            Use a map to save the count for tuple (k, b)
            Iterate through the points
            For all point before it, connect them.
            If the line exists, increase the count by 1,
            Else, set the count to 2.

            Since k might be a float number, using the division of two integer to represent it.
         */

        int length = points.length, max = 1;
        for(int i=0; i<length; i++){
            // m, n -> b -> count where m / n = k
            Map<Map.Entry<Integer, Integer>, Integer> cache = new HashMap<>();
            for(int j=0; j<i; j++){
                Map.Entry<Integer, Integer> pair = getPair(points[j][1] - points[i][1], points[j][0] - points[i][0]);

                if(cache.containsKey(pair))
                    cache.put(pair, cache.get(pair) + 1);
                else
                    cache.put(pair, 2);

                max = Math.max(max, cache.get(pair));
            }
        }

        return max;
    }

    private Map.Entry<Integer, Integer> getPair(int y, int x){
        if(y == 0) return new AbstractMap.SimpleEntry<>(0, Integer.MAX_VALUE);
        if(x == 0) return new AbstractMap.SimpleEntry<>(Integer.MAX_VALUE, 0);

        if(y < 0 && x < 0) {
            y = -y;
            x = -x;
        }
        int gcd = getGcd(Math.abs(y), Math.abs(x));
        return new AbstractMap.SimpleEntry<>(y / gcd, x / gcd);
    }

    private int getGcd(int val1, int val2){
        if(val1 < val2) return getGcd(val2, val1);
        if(val2 == 0) return val1;
        return getGcd(val2, val1 % val2);
    }

    public static void main(String[] args){
        System.out.println(new Main().maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }
}
