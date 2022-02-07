package valid_anagram_242;

/*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class Main {
    public boolean isAnagram(String s, String t) {
        int length = s.length();
        if(t.length() != length) return false;
        int[] cache = new int[26];
        for(int i=0; i<length; i++){
            cache[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<length; i++){
            if(--cache[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }

        return true;
    }
}
