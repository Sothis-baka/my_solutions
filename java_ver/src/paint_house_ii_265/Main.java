package paint_house_ii_265;

/*
    There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different.
    You have to paint all the houses such that no two adjacent houses have the same color.
    The cost of painting each house with a certain color is represented by a n x k cost matrix.
    For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
    Find the minimum cost to paint all houses.
 */
public class Main {
    public static int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;

        int[][] cache = new int[n][k];
        // The last row should be cost 0 since nothing is painted
        System.arraycopy(costs[n - 1], 0, cache[n - 1], 0, k);

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<k; j++){
                int cur = costs[i][j], cost = Integer.MAX_VALUE;
                for(int m=0; m<k; m++){
                    if(m != j) cost = Math.min(cost, cur + cache[i+1][m]);
                }
                cache[i][j] = cost;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            min = Math.min(min, cache[0][i]);
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(minCostII(new int[][]{{1}}));
        System.out.println(minCostII(new int[][]{{1, 2}, {3, 1}}));
    }
}
