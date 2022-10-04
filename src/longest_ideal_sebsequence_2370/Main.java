package longest_ideal_sebsequence_2370;

/*
    You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:

    t is a subsequence of the string s.
    The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
    Return the length of the longest ideal string.

    A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

    Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.
 */
public class Main {
    public int longestIdealString(String s, int k) {
        int[] cache = new int[26];

        int maxCount = 0;
        for(char ch: s.toCharArray()){
            int max = 0;
            for(int i = ch - 'a' - k; i <= ch - 'a' + k; i++){
                if(i < 0 || i >= 26) continue;
                max = Math.max(max, cache[i]);
            }

            cache[ch - 'a'] = Math.max(cache[ch - 'a'], max + 1);
            maxCount = Math.max(maxCount, cache[ch - 'a']);
        }

        return maxCount;
    }
}
