package is_subsequence_392;

/*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class Main {
    public boolean isSubsequence(String s, String t) {
        return subsequenceHelper(s, t, 0, 0, new boolean[s.length()][t.length()]);
    }

    private boolean subsequenceHelper(String s, String t, int l, int r, boolean[][] cache){
        if(l == s.length())
            return true;

        if(r == t.length()){
            return false;
        }

        if(cache[l][r]){
            // Visited
            return false;
        }

        char cur = s.charAt(l);
        int lengthT = t.length();
        for(int i=r; i<lengthT; i++){
            if(t.charAt(i) == cur && subsequenceHelper(s, t, l+1, i+1, cache)){
                return true;
            }
        }

        cache[l][r] = true;
        return false;
    }
}
