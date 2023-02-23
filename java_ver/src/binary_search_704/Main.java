package binary_search_704;

public class Main {
        public int search(int[] nums, int target) {
            // Range bounds
            int l = 0, r = nums.length - 1;
            // At edge
            if(nums[l] == target) return l;
            if(nums[r] == target) return r;
            // Out of range
            if(nums[l] > target || nums[r] < target) return -1;

            // Binary search
            while(l < r - 1){
                int mid = (r - l) / 2 + l;
                if(nums[mid] == target) return mid;
                else if(nums[mid] < target) l = mid;
                else r = mid;
            }

            return -1;
        }
}
