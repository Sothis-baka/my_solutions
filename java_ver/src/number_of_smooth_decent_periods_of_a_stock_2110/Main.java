package number_of_smooth_decent_periods_of_a_stock_2110;

/*
    You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
    A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.
    Return the number of smooth descent periods.
 */
public class Main {
    public long getDescentPeriods(int[] prices) {
        long total;
        int length = prices.length;
        // Array to save counts with end at index
        int[] cache = new int[length];

        // Base
        cache[0] = 1;
        total = 1;

        for(int i=1; i<length; i++){
            if(prices[i] == prices[i - 1] - 1) cache[i] = cache[i - 1] + 1;
            else cache[i] = 1;

            total += cache[i];
        }

        return total;
    }
}
