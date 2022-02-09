package alien_dictionary_269;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    There is a new alien language which uses the latin alphabet.
    However, the order among letters are unknown to you.
    You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
    Derive the order of letters in this language.
 */
public class Main {
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> prerequisites = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();

        int length = words.length;
        for(int i=1; i<length; i++){
            countHelper(words[i-1], words[i], prerequisites, count);
        }

        for(char ch: prerequisites.keySet()){
            if(!count.containsKey(ch)){
                count.put(ch, 0);
            }
        }

        StringBuilder strBd = new StringBuilder();
        while(!count.isEmpty()){
            Set<Character> candidates = new HashSet<>();
            for(char ch: count.keySet()){
                if(count.get(ch) == 0){
                    strBd.insert(0, ch);
                    for(char next: prerequisites.getOrDefault(ch, new HashSet<>())){
                        count.put(next, count.get(next)-1);
                    }
                    candidates.add(ch);
                }
            }
            for(char ch: candidates){
                count.remove(ch);
            }
        }

        return strBd.toString();
    }

    private static void countHelper(String str1, String str2, Map<Character, Set<Character>> prerequisites, Map<Character, Integer> count){
        int length1 = str1.length();
        for(int i=0; i<length1; i++){
            char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
            if(ch1 != ch2){
                if(prerequisites.containsKey(ch2)){
                    prerequisites.get(ch2).add(ch1);
                }else{
                    Set<Character> newSet = new HashSet<>();
                    newSet.add(ch1);
                    prerequisites.put(ch2, newSet);
                }

                count.put(ch1, count.getOrDefault(ch1, 0)+1);

                break;
            }
        }
    }

    public static void main(String[] args){
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(alienOrder(new String[]{"aa", "ab"}));
    }
}
