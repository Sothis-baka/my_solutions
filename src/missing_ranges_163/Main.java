package missing_ranges_163;

import java.util.ArrayList;
import java.util.List;

/*
    Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 */
public class Main {
    public static List<String> findMissingRanges(int[] a, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int length = upper - lower + 1;
        boolean[] cache = new boolean[length];
        for(int temp: a){
            cache[temp - lower] = true;
        }

        int index = 0;
        while(index < length){
            if(cache[index]){
                index++;
            }else{
                // Find range
                int end = index;
                while (++end != length && !cache[end]);
                end--;

                if(index == end){
                    result.add(String.valueOf(index));
                }else{
                    result.add(index + "->" + end);
                }
                index = end + 1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }
}
