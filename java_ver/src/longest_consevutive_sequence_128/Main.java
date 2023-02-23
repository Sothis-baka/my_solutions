package longest_consevutive_sequence_128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.
 */
public class Main {
    public int longestConsecutive(int[] nums) {
        int max = 0;

        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int temp: nums){
            set.add(temp);
        }

        for(int temp: set){
            if(visited.contains(temp)){
                continue;
            }
            visited.add(temp);

            int length = 1;
            int copy = temp;
            while (set.contains(temp - 1)){
                temp--;
                visited.add(temp);

                length++;
            }

            while (set.contains(copy + 1)){
                copy++;
                visited.add(copy);

                length++;
            }

            max = Math.max(max, length);
        }

        return max;
    }
}
