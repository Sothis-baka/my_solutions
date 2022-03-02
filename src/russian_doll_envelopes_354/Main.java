package russian_doll_envelopes_354;

import java.util.Arrays;

/*
    ou are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
    One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
    Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 */
public class Main {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int length = envelopes.length;
        int[] cache = new int[length];
        int count = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int left = Arrays.binarySearch(cache, 0, count, height);
            if (left < 0) left = -left - 1;
            if (left == count) count++;
            cache[left] = height;
        }

        return count;
    }
}
