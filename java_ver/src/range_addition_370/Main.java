package range_addition_370;

/*
    Assume you have an array of length n initialized with all 0’s and are given k update operations.
    Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex … endIndex] (startIndex and endIndex inclusive) with inc.
    Return the modified array after all k operations were executed.
*/
public class Main {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for (int[] update : updates) {
            result[update[0]] += update[2];
            if (update[1] < length - 1) {
                result[update[1] + 1] -= update[2];
            }
        }
        for (int i = 1; i < length; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}