package word_break_ii_140;

import java.util.*;

/*
    Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class Main {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return breakHelper(s, 0, wordDict, new HashMap<>());
    }

    private static List<String> breakHelper(String s, int start, List<String> wordDict, Map<Integer, List<String>> cache){
        if(cache.containsKey(start)){
            return cache.get(start);
        }

        List<String> curWithRemain = new ArrayList<>();

        int length = s.length();
        for(int i=start; i<=length; i++){
            String word = s.substring(start, i);
            if(wordDict.contains(word)){
                if(i == length){
                    curWithRemain.add(word);
                }else{
                    List<String> remains = breakHelper(s, i, wordDict, cache);
                    for(String remain: remains){
                        curWithRemain.add(word + " " + remain);
                    }
                }
            }
        }

        // Save to cache
        cache.put(start, curWithRemain);
        return curWithRemain;
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(wordBreak("catsanddog", list));
    }
}
