package optimal_account_balancing_465;

import java.util.HashMap;
import java.util.Map;

/*
    A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
    Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
 */
public class Main {
    public static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> status = new HashMap<>();
        for(int[] transaction: transactions){
            int from = transaction[0], to = transaction[1], amount = transaction[2];
            status.put(from, status.getOrDefault(from, 0) - amount);
            status.put(to, status.getOrDefault(to, 0) + amount);
        }

        int[] amounts = new int[status.size()];
        int i=0;
        for(int temp: status.values()){
            amounts[i++] = temp;
        }

        return helper(amounts, 0);
    }

    private static int helper(int[] amount, int index){
        while(index < amount.length && amount[index] == 0) index++;
        if(index == amount.length) return 0;

        int value = amount[index], min = Integer.MAX_VALUE;
        for(int i=index + 1; i<amount.length; i++){
            amount[i] += value;
            min = Math.min(min, 1 + helper(amount, index + 1));
            amount[i] -= value;
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(minTransfers(new int[][]{{0,1,5}, {1,2,5}}));
        System.out.println(minTransfers(new int[][]{{0,1,10}, {2,0,5}}));
        System.out.println(minTransfers(new int[][]{{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}}));
    }
}
