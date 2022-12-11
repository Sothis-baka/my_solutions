package group_shifted_strings_249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    We can shift a string by shifting each of its letters to its successive letter.
    Given an array of strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.
 */
public class Main {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strings){
            String mask = bitmask(s);
            map.computeIfAbsent(mask, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String bitmask(String str){
        char init = str.charAt(0);
        int digit = 0;
        StringBuilder mask = new StringBuilder();
        for(char ch: str.toCharArray())
            mask.append((1 + (ch - init < 0 ? ch - init + 26 : ch - init)) * Math.pow(27, digit++));
        return mask.toString();
    }
}
