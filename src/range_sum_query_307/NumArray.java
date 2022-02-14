package range_sum_query_307;

/*
    Given an integer array nums, handle multiple queries of the following types:

    Update the value of an element in nums.
    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
    Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    void update(int index, int val) Updates the value of nums[index] to be val.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
*/
public class NumArray {
    private static class Node{
        Node left, right;
        int start, end, mid, sum;
        int[] nums;

        Node(int[] nums, int start, int end){
            this.start = start;
            this.end = end;
            this.nums = nums;

            this.mid = (start + end) / 2;
            if(start <= mid - 1){
                this.left = new Node(nums, start, mid - 1);
            }
            if(end >= mid + 1){
                this.right = new Node(nums, mid + 1, end);
            }

            this.sum = nums[mid] + (this.left == null ? 0 : this.left.sum) + (this.right == null ? 0 : this.right.sum);
        }

        void update(int index, int diff){
            if(index < start || index > end){
                return;
            }

            this.sum += diff;
            if(this.left != null){
                this.left.update(index, diff);
            }
            if(this.right != null){
                this.right.update(index, diff);
            }
        }

        int getSum(int left, int right){
            if(right < start || left > end){
                return 0;
            }

            if(start >= left && end <= right){
                return this.sum;
            }

            return (this.left == null ? 0 : this.left.getSum(left, right)) + (this.right == null ? 0 : this.right.getSum(left, right)) + (mid >= left && mid <= right ? nums[mid] : 0);
        }
    }

    Node root;
    int[] nums;

    NumArray(int[] nums){
        this.root = new Node(nums, 0, nums.length - 1);
        this.nums = nums;
    }

    public void update(int index, int val) {
        this.root.update(index, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return root.getSum(left,right);
    }

    public static void main(String[] args){
        NumArray nArr = new NumArray(new int[]{0,9,5,7,3});
        System.out.println(nArr.sumRange(4,4));
        System.out.println(nArr.sumRange(2,4));
        System.out.println(nArr.sumRange(3,3));
        nArr.update(4,5);
        nArr.update(1,7);
        nArr.update(0, 8);
        System.out.println(nArr.sumRange(1,2));
        nArr.update(1, 9);
        System.out.println(nArr.sumRange(4,4));
        nArr.update(3, 4);
    }
}
