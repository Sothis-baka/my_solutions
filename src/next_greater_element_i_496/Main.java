package next_greater_element_i_496;

import java.util.*;

/*
    The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
    Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
*/
public class Main {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> targets = new HashSet<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for(int num: nums1) targets.add(num);

        for(int i=nums2.length - 1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            if(targets.contains(nums2[i])){
                if(stack.isEmpty()){
                    cache.put(nums2[i], -1);
                }else{
                    cache.put(nums2[i], stack.peek());
                }
            }
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i] = cache.get(nums1[i]);
        }
        return result;
    }
}
