package predict_the_winner_486;

/*
    You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.
    Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.
    Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.
 */
public class Main {
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] cache = new Integer[nums.length][nums.length];
        int future = canWin(nums, 0, nums.length - 1, cache);
        return future >= 0;
    }

    private int canWin(int[] nums, int start, int end, Integer[][] cache){
        if(start == end) return nums[start];
        if(cache[start][end] == null) cache[start][end] = Math.max(nums[start] - canWin(nums, start + 1, end, cache), nums[end] - canWin(nums, start, end - 1, cache));
        return cache[start][end];
    }
}
