package longest_substring_without_repeat_ch_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Given a string s, find the length of the longest substring without repeating characters. */
public class Main {
    public static void main(String[] args){
        String temp = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(temp));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> cache = new HashSet<>();

        int start = 0, max = 0;
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);
            if(cache.contains(ch)){
                for(; s.charAt(start) != ch; start++){
                    cache.remove(s.charAt(start));
                }
                start++;
            }

            cache.add(ch);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
