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

        Map<Character, Character> cache = new HashMap<>();
        char left, right;
        for(int i=0; i<length; i++){
            left = s.charAt(i);
            right = t.charAt(i);

            if(cache.containsKey(left)){
                if(cache.get(left) != right){
                    return false;
                }
            }else{
                if(cache.containsValue(right)){
                    return false;
                }
                cache.put(left, right);
            }
        }

        return true;
    }
}
