package find_first_palindromic_string_in_the_array_2018;

/*
    Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
    A string is palindromic if it reads the same forward and backward.
 */
public class Main {
    public String firstPalindrome(String[] words) {
        // Iterate all strings
        for(String word: words){
            if(isPalindrome(word)) return word;
        }

        return "";
    }

    private boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while (left < right) {
            // Compare current chars
            if(str.charAt(left) != str.charAt(right)) return false;

            // Jump to next char
            left++;
            right--;
        }

        return true;
    }
}
