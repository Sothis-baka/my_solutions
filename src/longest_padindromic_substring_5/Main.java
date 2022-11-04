package longest_padindromic_substring_5;

/*
    Given a string s, return the longest palindromic substring in s.
    A string is called a palindrome string if the reverse of that string is the same as the original string.
 */
public class Main {
    public String longestPalindrome(String s) {
        /*
            There are two kinds of palindrome, length odd / even
            Start from an empty string or start with a character at any position,
            expand it to reach as long as possible
         */
        String max = "";

        /*
            Check for even length str
         */
        for(int i=0; i<s.length() - 1; i++){
            String result = maxPalindromeLength(s, i, i + 1);
            if(result.length() > max.length()) max = result;
        }


        /*
            Check for odd length str
         */
        for(int i=0; i<s.length() - 1; i++){
            String result = maxPalindromeLength(s, i, i + 2);
            if(result.length() > max.length()) max = result;
        }

        return max;
    }

    /*
        Return the maximum length of a palindrome with substring l + 1, r - 1 at center
     */
    private String maxPalindromeLength(String s, int l, int r){
        if(l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r))
            return s.substring(l + 1, Math.min(r, s.length()));

        return maxPalindromeLength(s, l - 1, r + 1);
    }
}
