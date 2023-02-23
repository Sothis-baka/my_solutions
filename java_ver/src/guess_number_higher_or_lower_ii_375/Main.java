package guess_number_higher_or_lower_ii_375;

/*
    We are playing the Guessing Game. The game will work as follows:

    I pick a number between 1 and n.
    You guess a number.
    If you guess the right number, you win the game.
    If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
    Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
    Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.
*/
public class Main {
    public int getMoneyAmount(int n) {
        return moneyHelper(1, n, new int[n + 1][n + 1]);
    }

    private int moneyHelper(int start, int end, int[][] cache){
        if(start >= end){
            return 0;
        }

        if(cache[start][end] != 0){
            return cache[start][end];
        }

        int min = Integer.MAX_VALUE;
        for(int i=start; i<end; i++){
            min = i + Math.min(min, i + Math.max(moneyHelper(start, i-1, cache), moneyHelper(i+1, end, cache)));
        }

        cache[start][end] = min;
        return min;
    }
}
