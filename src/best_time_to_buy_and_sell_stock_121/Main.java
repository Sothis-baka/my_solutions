package best_time_to_buy_and_sell_stock_121;

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Main {
    public int maxProfit(int[] prices) {
        // From start to end, update max by using curMax - curMin
        int max = 0, curMin = prices[0];
        for(int price: prices){
            max = Math.max(max, price - curMin);
            curMin = Math.min(price, curMin);
        }
        return max;
    }
}
