package race_car_818;

import java.util.*;

/*
    Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):

    When you get an instruction 'A', your car does the following:
    position += speed
    speed *= 2
    When you get an instruction 'R', your car does the following:
    If your speed is positive then speed = -1
    otherwise speed = 1
    Your position stays the same.
    For example, after commands "AAR", your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

    Given a target position target, return the length of the shortest sequence of instructions to get there.
 */
public class Main {
    public int racecar(int target) {
         /*
            Case 1: go pos, reach target. target = 2^k - 1
            Case 2: go pos, then go back. target = 2^k - 1 - newTarget
            new Target is less than target
          */
        List<Integer> preSum = new ArrayList<>();
        int p = 1, cur;
        do{
            cur = (1 << p++) - 1;
            preSum.add(cur);
        }while (cur < 2 * target);
        System.out.println(preSum);

        int[] dp = new int[2 * target];
        racecarDFS(target, dp, preSum);

        System.out.println(Arrays.toString(dp));
        return dp[target];
    }

    private int racecarDFS(int target, int[] dp, List<Integer> preSum){
        System.out.println(target);
        System.out.println(Arrays.toString(dp));
        // Reach
        if(target == 0) return 0;

        // Visited
        if(dp[target] != 0) return dp[target];

        // Directly
        int index = preSum.indexOf(target);
        if(index >= 0) return index + 1;

        dp[target] = Integer.MAX_VALUE;

        for(int i=0; i<preSum.size(); i++){
            if(preSum.get(i) >= target){
                dp[target] = Math.min(dp[target], i + 1 + 1 + racecarDFS(preSum.get(i) - target, dp, preSum));
                break;
            }

            // Turn twice
            dp[target] = Math.min(dp[target], i + 1 + 2 + racecarDFS(target - preSum.get(i), dp, preSum));

            // Go neg and return to pos
            for(int j=0; j<i; j++){
                dp[target] = Math.min(dp[target], i + 1 + j + 1 + 2 + racecarDFS(target - preSum.get(i) + preSum.get(j), dp, preSum));
            }
        }

        return dp[target];
    }

    public static void main(String[] args){
        System.out.println(new Main().racecar(4));
    }
}
