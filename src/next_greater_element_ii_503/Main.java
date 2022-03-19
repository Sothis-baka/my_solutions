package next_greater_element_ii_503;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
    The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 */
public class Main {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--){
            int num = nums[i];
            // Only keep greater value
            while(!stack.isEmpty() && stack.peek() < num) stack.pop();
            // Update result
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Save to stack
            stack.push(num);
        }

        for(int i=nums.length-1; i>=0; i--){
            int num = nums[i];
            // Only keep greater value
            while(!stack.isEmpty() && stack.peek() <= num) stack.pop();
            // Update result
            if(result[i] == -1) result[i] = stack.isEmpty() ? -1 : stack.peek();
            // Save to stack
            stack.push(num);
        }

        return result;
    }
}
