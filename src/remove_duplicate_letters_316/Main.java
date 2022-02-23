package remove_duplicate_letters_316;

import java.util.*;

/*
    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 */
public class Main {
    public static String removeDuplicateLetters(String s) {
        if(s.isEmpty()) return "";

        // Count all characters
        int length = s.length(), pos = 0;
        int[] cache = new int[26];
        for(int i=0; i<length; i++){
            cache[s.charAt(i) - 'a']++;
        }

        // Find the smallest char until we meet the last one of a character
        for(int i=0; i<length; i++){
            char cur = s.charAt(i);
            if(cur < s.charAt(pos)){
                pos = i;
            }
            if(--cache[cur - 'a'] == 0){
                break;
            }
        }

        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos), ""));
    }

    /*public static String removeDuplicateLetters(String s) {
        List<Character> result = new ArrayList<>();
        removeHelper(new ArrayList<>(), s, 0, result);

        StringBuilder strBd = new StringBuilder();
        for(char ch: result){
            strBd.append(ch);
        }

        return strBd.toString();
    }

    private static void removeHelper(List<Character> cur, String s, int index, List<Character> result){
        if(index == s.length()){
            // Update the result
            if(result.isEmpty() || isSmaller(cur, result)){
                result.clear();
                result.addAll(cur);
            }

            return;
        }

        char ch = s.charAt(index);
        int pos = cur.indexOf(ch);
        if(pos >= 0){
            removeHelper(cur, s, index+1, result);
            cur.remove(pos);
        }

        cur.add(ch);
        removeHelper(cur, s, index+1, result);
        cur.remove(cur.size() - 1);

        if(pos >= 0){
            cur.add(pos, ch);
        }
    }

    private static boolean isSmaller(List<Character> li1, List<Character> li2){
        int length = li1.size();
        for(int i=0; i<length; i++){
            if(li1.get(i) < li2.get(i)){
                return true;
            }else if(li1.get(i) > li2.get(i)){
                return false;
            }
        }

        return false;
    }*/

    public static void main(String[] args){
        System.out.println(removeDuplicateLetters("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"));
    }
}
