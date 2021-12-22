package jump_game_ii_45;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    You can assume that you can always reach the last index.
*/
public class Main {
    public static int jump(int[] nums) {
        int[] map = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int range = nums[i];
            for(int j=1; j<=range; j++){
                if(i+j >= nums.length){
                    break;
                }

                if(map[i+j] != 0){
                    map[i+j] = Math.min(map[i+j], map[i] + 1);
                }else{
                    map[i+j] =  map[i] + 1;
                }
            }
        }

        return map[nums.length-1];
    }

    public static void main(String[] args){
        Random roll = new Random();
        int[] test = new int[1000];
        for(int i=0; i<1000; i++){
            test[i] = roll.nextInt(1001);
        }


        System.out.println(test[1]);
        System.out.println(jump(test));
    }
}
