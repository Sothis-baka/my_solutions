package longest_word_in_dictionary_through_deleting_524;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
*/
public class Main {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        for(String str: dictionary){
            int i = 0;
            for(char c: s.toCharArray()){
                if(i < str.length() && c == str.charAt(i)) i++;
            }
            if(i == str.length()) return str;
        }

        return "";
    }
}
