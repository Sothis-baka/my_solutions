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
        /*
            BFS.
            Use a Set to save visited words.
            Use a Set to save current candidates
            We start from beginWord with depth 0.
            For word with depth i
            Find all words with depth i + 1 (by changing a letter).
            If visited, stop.
            else, continue to find.
         */

        // Not in the list
        if(!wordList.contains(endWord)) return 0;

        // Init
        Set<String> unvisited = new HashSet<>(wordList);
        unvisited.remove(beginWord);

        Set<String> candidates = new HashSet<>();
        candidates.add(beginWord);

        // BFS
        int depth = 1;
        while (!candidates.isEmpty()){
            depth++;
            Set<String> newCandidates = new HashSet<>();

            for(String candidate: candidates){
                for(String str: unvisited){
                    if(!newCandidates.contains(str) && canBeChanged(candidate, str))
                        newCandidates.add(str);
                }
            }

            if(newCandidates.contains(endWord)) return depth;

            // Replace the candidates
            candidates = newCandidates;
            unvisited.removeAll(newCandidates);
        }

        return 0;
    }

    /*
        Helper function to find if we can change from a string to another
        Return true if they only have one letter diff
     */
    private boolean canBeChanged(String from, String to){
        int length = from.length(), count = 0;
        for(int i=0; i<length; i++){
            if(from.charAt(i) != to.charAt(i)){
                // Already find one
                if(count > 0)
                    return false;

                // Find one, continue search
                count++;
            }
        }

        return count == 1;
    }
}
