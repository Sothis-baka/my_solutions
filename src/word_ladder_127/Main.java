package word_ladder_127;

import java.util.*;

/*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class Main {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        Map<String, Integer> distances = new HashMap<>();
        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> candidate = new HashSet<>();

        // Initialize
        candidate.add(beginWord);

        while(!candidate.isEmpty()){
            // Shouldn't visit lower distance words again
            unvisited.removeAll(candidate);

            Set<String> newCandidates = new HashSet<>();

            for(String word: candidate){
                // Find it, stop running
                if(word.equals(endWord)){
                    return distances.get(endWord);
                }

                for(String next: unvisited){
                    // Save to map
                    if(!distances.containsKey(next) && isAdjacent(word, next)){
                        distances.put(next, distances.getOrDefault(word, 1) + 1);
                        newCandidates.add(next);
                    }
                }
            }

            // Replace
            candidate = newCandidates;
        }

        return 0;
    }

    private boolean isAdjacent(String s1, String s2){
        int length = s1.length();
        boolean find = false;
        for(int i=0; i<length; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(find){
                    return false;
                }else{
                    find = true;
                }
            }
        }

        return find;
    }
}
