package unique_word_abbreviation_288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    An abbreviation of a word follows the form . Below are some examples of word abbreviations:
    a) it                      --> it    (no abbreviation)
         1
    b) d|o|g                   --> d1g
                  1    1  1
         1---5----0----5--8
    c) i|nternationalizatio|n  --> i18n
                  1
         1---5----0
    d) l|ocalizatio|n          --> l10n
    Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 */
public class Main {
    // Replace all characters except the leading one and the ending one with the length of them
    public boolean ValidWordAbbr(String[] dictionary, String word) {
        Map<String, Set<Integer>> cache = new HashMap<>();
        for(String temp: dictionary){
            String key;
            int val;
            int length = temp.length();
            if(length <= 2){
                // No abbreviation
                key = temp;
                val = 0;
            }else{
                key = "" + temp.charAt(0) + temp.charAt(length - 1);
                val = length - 2;
            }
            if(cache.containsKey(key)){
                cache.get(key).add(val);
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(val);
                cache.put(key, set);
            }
        }

        int length = word.length();
        if(length <= 2){
            return !cache.containsKey(word) || !cache.get(word).contains(0);
        }else{
            String key = "" + word.charAt(0) + word.charAt(length - 1);
            int val = length - 2;
            return !cache.containsKey(word) || !cache.get(key).contains(val);
        }
    }
}
