package circular_array_loop_457;

import java.util.HashSet;

/*
    You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

    If nums[i] is positive, move nums[i] steps forward, and
    If nums[i] is negative, move nums[i] steps backward.
    Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

    A cycle in the array consists of a sequence of indices seq of length k where:

    Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
    Every nums[seq[j]] is either all positive or all negative.
    k > 1
    Return true if there is a cycle in nums, or false otherwise.
 */
public class Main {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] cache = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(visit(nums, i, cache)) return true;
        }

        return false;
    }

    private boolean visit(int[] nums, int index, boolean[] cache){
        boolean[] visited = new boolean[nums.length];
        boolean dir = nums[index] > 0;
        while(!visited[index]){
            if(cache[index] || nums[index] > 0 != dir){
                for(int i=0; i<visited.length; i++){
                    if(visited[i]){
                        cache[i] = true;
                    }
                }

                return false;
            }

            visited[index] = true;
            int nextIndex = index + nums[index];

            while (nextIndex >= nums.length) nextIndex -= nums.length;
            while (nextIndex < 0) nextIndex += nums.length;

            if(nextIndex == index){
                for(int i=0; i<visited.length; i++){
                    if(visited[i]){
                        cache[i] = true;
                    }
                }

                return false;
            }else{
                index = nextIndex;
            }
        }

        return true;
    }
}
