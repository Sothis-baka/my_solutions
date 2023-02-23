package find_k_pairs_with_smallest_sums_373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

    Define a pair (u, v) which consists of one element from the first array and one element from the second array.

    Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 */
public class Main {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<int[]> candidates = new PriorityQueue<>(
                (a, b) -> a[0] + a[1] - b[0] - b[1]
        );
        for(int i=0; i<nums1.length && i < k; i++){
            candidates.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k > 0 && !candidates.isEmpty()){
            int[] cur = candidates.poll();
            List<Integer> list = new ArrayList<>();
            list.add(cur[0]);
            list.add(cur[1]);
            result.add(list);
            k--;

            if(cur[2] + 1 < nums2.length){
                candidates.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 10));
    }
}
