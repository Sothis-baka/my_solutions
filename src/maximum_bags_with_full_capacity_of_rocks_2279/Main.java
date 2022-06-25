package maximum_bags_with_full_capacity_of_rocks_2279;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.
    Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.
 */
public class Main {
    // Structure used to save filled bag position and used rock number
    static class BagPair{
        int index, num;

        BagPair(int index, int num){
            this.index = index;
            this.num = num;
        }
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int length = capacity.length, max = 0;

        // Queue to save all, put the largest at first
        Queue<BagPair> queue = new PriorityQueue<>((a, b) -> b.num - a.num);
        for(int i=0; i<length; i++){
            // Number of rocks need to fill current bag
            int diff = capacity[i] - rocks[i];

            // Already full
            if(diff == 0){
                max++;
                continue;
            }

            // Queue is empty
            if(queue.isEmpty()){
                // Not able to fill
                if(diff > additionalRocks) continue;
            }else{
                // Can't add directly
                if (diff > additionalRocks) {
                    // Current one is not worth to replace pairs existed
                    if (diff >= queue.peek().num) continue;

                    // Remove one pair
                    additionalRocks += queue.poll().num;
                    max--;
                }
            }

            // Add new pair
            queue.offer(new BagPair(i, diff));
            additionalRocks -= diff;

            // Update max
            max++;
        }

        return max;
    }
}
