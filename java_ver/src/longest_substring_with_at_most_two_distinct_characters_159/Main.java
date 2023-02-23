package longest_substring_with_at_most_two_distinct_characters_159;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 */
public class Main {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chs = new char[2];
        int[] lastIndexes = new int[2];

        int length = s.length(), start = 0, max = 0;
        for(int i=0; i<length; i++){
            char cur = s.charAt(i);

            if(chs[0] == '\0'){
                chs[0] = cur;
                lastIndexes[0] = i;
            }else if(chs[1] == '\0'){
                chs[1] = cur;
                lastIndexes[1] = i;
            }else{
                if(cur == chs[0]){
                    lastIndexes[0] = i;
                }else if(cur == chs[1]){
                    lastIndexes[1] = i;
                }else{
                    int index1 = lastIndexes[0], index2 = lastIndexes[1];
                    if(index1 < index2){
                        start = index1 + 1;
                        chs[0] = cur;
                        lastIndexes[0] = i;
                    }else{
                        start = index2 + 1;
                        chs[1] = cur;
                        lastIndexes[1] = i;
                    }
                }
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringTwoDistinct("ecebaafafss"));
    }
}
