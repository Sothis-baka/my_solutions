package substring_with_concatenation_of_all_words_30;

import java.util.*;

/*
    You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
    You can return the answer in any order.
 */
public class Main {
    /*
        Important !!! Map is much faster than List.
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        // Save to map
        Map<String, Integer> wordsMap = new HashMap<>();
        for(String temp: words){
            wordsMap.put(temp, wordsMap.getOrDefault(temp, 0) + 1);
        }

        int length = s.length();
        int wordLength = words[0].length();
        int neededLength = wordLength * words.length - 1;

        for(int i=0; i<length-neededLength; i++){
            // Do check if it starts with a word
            if(wordsMap.containsKey(s.substring(i, i+wordLength)) && check(s, new HashMap<>(wordsMap), i, wordLength)){
                result.add(i);
            }
        }

        return result;
    }

    public static boolean check(String s, HashMap<String, Integer> words, int index, int wordLength){
        if(words.size() == 0){
            return true;
        }

        String temp = s.substring(index, index + wordLength);

        int times = words.getOrDefault(temp, 0);
        if(times > 0){
            // Get one match, check remains
            if(times == 1){
                words.remove(temp);
            }else {
                words.put(temp, times - 1);
            }
            return check(s, words, index + wordLength, wordLength);
        }

        return false;
    }

    public static void main(String[] args){
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println(findSubstring(s, words));
    }
}
