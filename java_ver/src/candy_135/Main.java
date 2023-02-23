package candy_135;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
    There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    Return the minimum number of candies you need to have to distribute the candies to the children.
 */
public class Main {
    /*
        If ratings[i-1] >= ratings[i] <= ratings[i+1], candies for the middle one can be 1
        From these indexes, increase 1 by 1.
     */
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] candies = new int[length];
        Arrays.fill(candies, 1);

        for(int i=1; i<length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = Math.max(candies[i-1] + 1, candies[i]);
            }
        }

        int sum = candies[length-1];
        for(int i=length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
            sum += candies[i];
        }

        return sum;
    }
}
