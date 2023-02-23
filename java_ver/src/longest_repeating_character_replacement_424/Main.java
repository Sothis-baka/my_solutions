package longest_repeating_character_replacement_424;

import java.util.*;

/*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class Main {
    public static int characterReplacement(String s, int k) {
        int length = s.length();
        int[] counts = new int[26];

        int start = 0, max = 0, maxCount = 0;
        for(int i=0; i<length; i++){
            int cur = s.charAt(i) - 'A';
            maxCount = Math.max(maxCount, ++counts[cur]);

            while(i - start + 1 - maxCount > k){
                counts[s.charAt(start++) - 'A']--;
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF",4));
    }
}
