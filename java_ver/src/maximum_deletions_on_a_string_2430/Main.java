package maximum_deletions_on_a_string_2430;

/*
    You are given a string s consisting of only lowercase English letters. In one operation, you can:

    Delete the entire string s, or
    Delete the first i letters of s if the first i letters of s are equal to the following i letters in s, for any i in the range 1 <= i <= s.length / 2.
    For example, if s = "ababc", then in one operation, you could delete the first two letters of s to get "abc", since the first two letters of s and the following two letters of s are both equal to "ab".

    Return the maximum number of operations needed to delete all of s.
 */
public class Main {
    public int deleteString(String s) {
        int length = s.length();

        /*
            gcd[i][j] = k means s[i, i + k] == s[j, j + k]
            if(k >= j - i), it means s[i, j] = s[j][2j - i]
         */
        int[][] gcd = new int[length + 1][length + 1];

        /*
            cache[i] = k means the max cut methods for i is k
         */
        int[] cache = new int[length];

        for(int i = length - 1; i >= 0; i--){
            cache[i] = 1;

            for(int j = i + 1; j < length; j++){
                if(s.charAt(i) == s.charAt(j)){
                    gcd[i][j] = gcd[i + 1][j + 1] + 1;

                    if(gcd[i][j] >= j - i) cache[i] = Math.max(cache[i], 1 + cache[j]);
                }
            }
        }

        return cache[0];
    }
}
