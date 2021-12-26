package group_anagrams_49;

import java.util.*;

/*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class Main {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String temp = String.valueOf(chs);

            if(map.containsKey(temp)){
                map.get(temp).add(str);
            }else{
                List<String> li = new ArrayList<>();
                li.add(str);
                map.put(temp, li);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{"aaaah", "hhhha", "agh"}));
    }
}
