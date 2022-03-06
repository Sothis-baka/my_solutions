package longest_substring_with_at_least_k_repeat_characters_395;

import java.util.HashSet;
import java.util.Set;

/*
    Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
*/
public class Main {
    public static int longestSubstring(String s, int k) {
        return helper(s, 0, s.length() - 1, k);
    }

    private static int helper(String s, int l, int r, int k){
        if(r < l){
            return 0;
        }

        int[] counts = new int[26];

        for(int i=l; i<=r; i++){
            counts[s.charAt(i) - 'a']++;
        }

        Set<Character> insufficient = new HashSet<>();
        for(int i=0; i<26; i++){
            if(counts[i] > 0 && counts[i] < k){
                insufficient.add((char)(i + 'a'));
            }
        }

        if(insufficient.isEmpty()){
            return r - l + 1;
        }

        int left = l, right = l, max = 0;
        while (right <= r){
            char cur = s.charAt(right);
            if(insufficient.contains(cur)){
                max = Math.max(max, helper(s, left, right - 1, k));
                left = ++right;
            }else{
                right++;
            }
        }

        return Math.max(max, helper(s, left, right - 1, k));
    }

    public static void main(String[] args){
        System.out.println(longestSubstring("bbaaacbd", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }
}
