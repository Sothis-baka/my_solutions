package isomorphic_string_205;

import java.util.HashMap;
import java.util.Map;

/*
    Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */
public class Main {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        // s(i) -> t(cache[i][0])
        // t(i) -> s(cache[i][1])
        Character[][] cache = new Character[255][2];

        for(int i=0; i<length; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(cache[ch1][0] == null && cache[ch2][1] == null){
                // Both are available, save pair
                cache[ch1][0] = ch2;
                cache[ch2][1] = ch1;
            }else if(cache[ch1][0] != null && cache[ch2] != null){
                // Both are filled, compare
                if(cache[ch1][0] != ch2 || cache[ch2][1] != ch1){
                    return false;
                }
            }else return false;
        }

        return true;
    }
}
