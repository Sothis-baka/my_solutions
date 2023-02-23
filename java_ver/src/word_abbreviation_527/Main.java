package word_abbreviation_527;

import java.util.*;

/*
    Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.

    Begin with the first character and then the number of characters abbreviated, which followed by the last character.
    If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
    If the abbreviation doesn't make the word shorter, then keep it as original.
 */
public class Main {
    public static String[] wordsAbbreviation(String[] dict){
        List<String> copy = new ArrayList<>(Arrays.asList(dict));
        copy.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        Map<String, String> result = new HashMap<>();
        for(String str: copy) abbreviationHelper(str, str.length() - 2, result);
        String[] answer = new String[dict.length];
        for(int i=0; i<dict.length; i++) answer[i] = result.get(dict[i]);
        return answer;
    }

    private static void abbreviationHelper(String str, int val,  Map<String, String> result){
        if(val <= 1){
            result.put(str, str);
            return;
        }

        String cur = str.substring(0, str.length() - 1 - val) + val + str.charAt(str.length() - 1);
        if(result.containsValue(cur)) abbreviationHelper(str, val - 1, result);
        else result.put(str, cur);
    }

    public static void main(String[] args){
        String[] dict = new String[]{"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        String[] answer = wordsAbbreviation(dict);
        for(String str: answer){
            System.out.println(str);
        }
    }
}
