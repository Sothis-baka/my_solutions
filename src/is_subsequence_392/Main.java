package is_subsequence_392;

/*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class Main {
    public boolean isSubsequence(String s, String t) {
        // Get length of both string
        int length1 = s.length(), length2 = t.length();

        // Compare chs 1 by 1. if same, go to next index, if not same, move pointer on t
        int l = 0, r = 0;

        while (l < length1 && r < length2){
            if(s.charAt(l) == t.charAt(r)){
                l++;
            }
            r++;
        }

        return (l == length1);
    }
}
