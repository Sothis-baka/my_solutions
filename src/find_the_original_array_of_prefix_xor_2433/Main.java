package find_the_original_array_of_prefix_xor_2433;

/*
    You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:

    pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
    Note that ^ denotes the bitwise-xor operation.

    It can be proven that the answer is unique.
 */
public class Main {
    public int[] findArray(int[] pref) {
        int length = pref.length;
        int[] result = new int[length];

        result[0] = pref[0];
        for(int i=1; i<length; i++)
            result[i] = ((pref[i - 1]) ^ (pref[i]));

        return result;
    }
}
