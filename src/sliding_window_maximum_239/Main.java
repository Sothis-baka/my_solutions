package sliding_window_maximum_239;

import java.util.LinkedList;
import java.util.List;

/*
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    Return the max sliding window.
 */
public class Main {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            int[] result = new int[length - k + 1];

            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i<length; i++){
                // Out of range
                if(!list.isEmpty() && i - list.peek() + 1 > k){
                    list.poll();
                }

                // Useless
                while(!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                    list.removeLast();
                }

                list.offer(i);

                if(i - k + 1 >= 0){
                    result[i - k + 1] = nums[list.peek()];
                }
            }

            return result;
        }

        /*public static int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            int[] result = new int[length - k + 1];

            // Sort from largest
            Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
            for(int i=0; i<k; i++){
                queue.offer(nums[i]);
            }
            result[0] = queue.peek();

            for(int i=k; i<nums.length; i++){
                int left = i - k;
                queue.remove(nums[left]);
                queue.offer(nums[i]);
                result[left+1] = queue.peek();
            }

            return result;
        }*/

        private static void printArr(int[] arr){
            for(int num: arr){
                System.out.print(num);
            }
            System.out.println();
        }

        public static void main(String[] args){
            int[] arr = {1,3,-1,-3,5,3,6,7};
            printArr(maxSlidingWindow(arr, 3));
        }
}
