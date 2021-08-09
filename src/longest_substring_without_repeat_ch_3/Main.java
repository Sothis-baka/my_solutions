package longest_substring_without_repeat_ch_3;

import java.util.ArrayList;
import java.util.List;

/* Given a string s, find the length of the longest substring without repeating characters. */
public class Main {
    public static void main(String[] args){
        String temp = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(temp));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();

        List<Character> list = new ArrayList<>();
        int max = 0;

        for(int i=0; i<length; i++){
            char temp = s.charAt(i);

            int index = list.indexOf(temp);
            // if it's not in list, add it
            if(index < 0){
                list.add(temp);
            }else {
                // update size
                int size = list.size();
                if(size > max){
                    max = size;
                }

                // remove chars before that one, add the new one.
                list = list.subList(index + 1, size);
                list.add(temp);
            }
        }

        return Math.max(list.size(), max);
    }
}
