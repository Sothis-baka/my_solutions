package coin_change_ii_518;

/*
    You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
    Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
    You may assume that you have an infinite number of each kind of coin.
    The answer is guaranteed to fit into a signed 32-bit integer.
 */
public class Main {
    public int change(int amount, int[] coins) {
        int[] cache = new int[amount + 1];
        cache[amount] = 1;
        for(int val: coins){
            for(int i=amount - val; i>=0; i--){
                cache[i] += cache[i+val];
            }
        }
        return cache[0];
    }
}
