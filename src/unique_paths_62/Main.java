package unique_paths_62;

import java.math.BigInteger;

public class Main {
    /*public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }

        m--;
        n--;

        int sum = m+n;
        int min = Math.min(m, n);
        BigInteger result = new BigInteger("1");
        for(int i=0; i<min; i++){
            result = result.multiply(new BigInteger(String.valueOf(sum-i)));
        }
        for(int i=0; i<min; i++){
            result = result.divide(new BigInteger(String.valueOf(min - i)));
        }

        return result.intValue();
    }*/

    public static int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    // Top left
                    cache[i][j] = 1;
                    continue;
                }

                // Result is the sum of top and left
                cache[i][j] = (i==0 ? 0 : cache[i-1][j]) + (j==0 ? 0 : cache[i][j-1]);
            }
        }

        return cache[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(10, 10));
    }
}
