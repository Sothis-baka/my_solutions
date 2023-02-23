package wild_card_matching_44;

import java.util.ArrayList;
import java.util.List;

/*
    Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).
 */
public class Main {
    public static boolean isMatch(String s, String p) {
        // Dynamic programming
        int[][] cache = new int[s.length()+1][p.length()+1];

        return matchHelper(s, p, cache);
    }

    public static boolean matchHelper(String s, String p, int[][] cache){
        int l1 = s.length(), l2 = p.length();

        // Read from cache
        if(cache[l1][l2] != 0){
            return cache[l1][l2] == 1;
        }

        // s is empty, p should be empty or filled with *
        if(l1 == 0){
            for(int i=0; i<l2; i++){
                if(p.charAt(i) != '*'){
                    cache[l1][l2] = -1;
                    return false;
                }
            }

            cache[l1][l2] = 1;
            return true;
        }

        // s is not empty but p is empty
        if(l2 == 0){
            cache[l1][l2] = -1;
            return false;
        }

        char init = p.charAt(0);
        // Not match
        if(init != '*' && init != '?' && init != s.charAt(0)){
            cache[l1][l2] = -1;
            return false;
        }

        // Flex match
        if (init == '*') {
            if (matchHelper(s, p.substring(1), cache)) {
                cache[l1][l2] = 1;
                return true;
            } else {
                if (matchHelper(s.substring(1), p, cache)) {
                    cache[l1][l2] = 1;
                    return true;
                } else {
                    cache[l1][l2] = -1;
                    return false;
                }
            }
        }

        // Same init or ?
        boolean temp = matchHelper(s.substring(1), p.substring(1), cache);
        if (temp) {
            cache[l1][l2] = 1;
            return true;
        } else {
            cache[l1][l2] = -1;
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("", "**"));
        System.out.println(isMatch("cb", ""));
        System.out.println(isMatch("aaabbabaabaaabbabbbbbbbbaabaaaaaaaaaaaaaaaaababbabbbaaaaba", "a**********************b"));
        System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb","**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}
