package scramble_string_87;

import java.util.HashMap;
import java.util.Map;

/*
    We can scramble a string s to get a string t using the following algorithm:

    If the length of the string is 1, stop.
    If the length of the string is > 1, do the following:
    Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
    Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
    Apply step 1 recursively on each of the two substrings x and y.
    Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
*/
public class Main{
    public static boolean isScramble(String s1, String s2) {
        Map<String, Boolean> cache = new HashMap<>();
        return checkScramble(s1, s2, cache);
    }

    private static boolean checkScramble(String s1, String s2, Map<String, Boolean> cache){
        if(s1.equals(s2)){
            return true;
        }

        String concat = s1.concat(s2);
        if(cache.containsKey(concat)){
            return cache.get(concat);
        }

        int length = s1.length();
        for(int i=1; i<length; i++){
            if(checkScramble(s1.substring(0, i), s2.substring(0, i), cache) && checkScramble(s1.substring(i), s2.substring(i), cache)
            || checkScramble(s1.substring(0, i), s2.substring(length-i), cache) && checkScramble(s1.substring(i), s2.substring(0, length-i), cache)){
                cache.put(concat, true);
                return true;
            }
        }

        cache.put(concat, false);
        return false;
    }

    public static void main(String[] args){
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("abcde", "caebd"));
        System.out.println(isScramble("a", "a"));
    }
}
