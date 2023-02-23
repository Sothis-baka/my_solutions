package check_if_there_is_a_valid_partition_for_the_array_2369;

/*
    You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.

    We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:

    The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
    The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
    The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
    Return true if the array has at least one valid partition. Otherwise, return false.
 */
public class Main {
    public boolean validPartition(int[] nums) {
        // DP

        /*
            Status: empty, 1, same 2, increasing 2
         */
        boolean[] status = { false, true, false, false };

        int length = nums.length;
        for(int i=1; i<length; i++){
            boolean[] newStatus = new boolean[4];

            newStatus[1] = status[0];

            if(nums[i] == nums[i - 1]){
                newStatus[0] = status[1] || status[2];
                newStatus[2] = status[1];
            }

            if(nums[i] == nums[i - 1] + 1){
                if(status[1]) newStatus[3] = true;
                if(status[3]) newStatus[0] = true;
            }

            if(newStatus[0] || newStatus[1] || newStatus[2] || newStatus[3]){
                status = newStatus;
            }else return false;
        }

        return status[0];
    }

    public static void main(String[] args){
        int[] nums = {4,4,4,5,6};

        System.out.println(new Main().validPartition(nums));
    }
}
