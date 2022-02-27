package longest_substring_with_at_most_k_distinct_characters_340;

import java.util.HashSet;
import java.util.Set;

/*
    Given a string, find the length of the longest substring T that contains at most k distinct characters.
 */
public class Main {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int length = s.length();
        int[] count = new int[26];
        Set<Character> set = new HashSet<>();

        int start = 0, end = 0, maxLength = 0;
        while (end < length){
            char cur = s.charAt(end);
            if(++count[cur - 'a'] == 1){
                set.add(cur);

                if(set.size() > k){
                    while(start < end){
                        char ch = s.charAt(start);
                        if(--count[ch - 'a'] == 0){
                            set.remove(ch);
                        }
                        start++;
                    }
                }
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
    }
}