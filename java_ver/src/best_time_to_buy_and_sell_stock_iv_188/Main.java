package best_time_to_buy_and_sell_stock_iv_188;

/*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
    Find the maximum profit you can achieve. You may complete at most k transactions.
*/
public class Main {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if(length <= 1){
            return 0;
        }

        if(k >= length / 2){
            int profit = 0;
            for(int i=1; i<length; i++){
                if(prices[i] > prices[i-1]){
                    profit += prices[i];
                    profit -= prices[i-1];
                }
            }
            return profit;
        }

        int[][] cache = new int[k+1][length];
        for(int i=1; i<=k; i++){
            int max = cache[i-1][0] - prices[0];
            for(int j=1; j<length; j++){
                cache[i][j] = Math.max(cache[i][j-1], prices[j] + max);
                max = Math.max(max, cache[i-1][j] - prices[j]);
            }
        }
        return cache[k][length-1];
    }
}
