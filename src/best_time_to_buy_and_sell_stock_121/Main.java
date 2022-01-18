package best_time_to_buy_and_sell_stock_121;

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Main {
    public int maxProfit(int[] prices) {
        int max = 0;
        int prev = prices[0];

        for(int temp: prices){
            if(temp < prev){
                prev = temp;
            }else{
                max = Math.max(max, temp - prev);
            }
        }

        return max;
    }
}
