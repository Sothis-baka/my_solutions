package longest_palindrome_409;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public int longestPalindrome(String s) {
        int length = 0;

        // Save counts in a set
        Set<Character> set = new HashSet<>();

        // When a char count get 2, we add it to length of palindrome
        for(char ch: s.toCharArray()){
            if(set.contains(ch)){
                set.remove(ch);
                length += 2;
            }else set.add(ch);
        }

        // Middle char
        if(set.size() > 0){
            length++;
        }

        return length;
    }
}
