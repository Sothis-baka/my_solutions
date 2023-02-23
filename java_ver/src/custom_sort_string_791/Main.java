package custom_sort_string_791;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
    You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
    Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
    Return any permutation of s that satisfies this property.
 */
public class Main {
    public String customSortString(String order, String s) {
        int[] cache = new int[26];
        Arrays.fill(cache, -1);
        for(int i=0; i<order.length(); i++){
            cache[order.charAt(i) - 'a'] = i;
        }
        Character[] charArr = new Character[s.length()];
        for(int i=0; i<s.length(); i++) charArr[i] = s.charAt(i);

        Arrays.sort(charArr, Comparator.comparingInt(a -> cache[a - 'a']));
        StringBuilder strBd = new StringBuilder();
        for(char ch: charArr) strBd.append(ch);
        return strBd.toString();
    }
}
