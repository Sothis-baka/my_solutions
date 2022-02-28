package intersection_of_two_arrays_349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
*/
public class Main {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int num: nums1){
            set.add(num);
        }
        for(int num: nums2){
            if(set.contains(num)){
                result.add(num);
            }
        }

        int[] answer = new int[result.size()];
        int i=0;
        for(int num: new ArrayList<Integer>(result)){
            answer[i++] = num;
        }
        return answer;
    }
}
