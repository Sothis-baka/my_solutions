package maximum_segment_sum_after_removals_2382;

import java.util.Arrays;

public class Main {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        // Do it in reverse order
        // Start from an empty array, add element to it
        // Union find

        int length = nums.length;
        long[] union = new long[length], result = new long[length];
        Arrays.fill(union, Integer.MAX_VALUE);

        for(int i=length - 1; i>0; i--) {
            // The index to be removed
            int index = removeQueries[i];
            union[index] = -nums[index];

            if(index > 0 && union[index - 1] != Integer.MAX_VALUE) merge(index-1, index, union);
            if(index < length - 1 && union[index + 1] != Integer.MAX_VALUE) merge(index, index+1, union);

            result[i - 1] = Math.max(result[i], -union[(int)find(index, union)]);
        }

        return result;
    }

    private long find(int index, long[] union){
        // If value < 0 , it's the root
        // else, point the node to root and return index of root
        return union[index] < 0 ? index : (union[index] = find((int) union[index], union));
    }

    private void merge(int index1, int index2, long[] union){
        long root1 = find(index1, union), root2 = find(index2, union);
        // sum together
        union[(int) root2] += union[(int) root1];
        // point to a single root
        union[(int) root1] = root2;
    }

    public static void main(String[] args){
        new Main().maximumSegmentSum(new int[]{1,2,5,6,1}, new int[]{0,3,2,4,1});
    }
}
