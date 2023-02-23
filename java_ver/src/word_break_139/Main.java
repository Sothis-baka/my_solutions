package word_break_139;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class Main {
    public boolean wordBreak(String s, List<String> wordDict) {
        return breakHelper(s, 0, wordDict, new HashSet<>());
    }

    private boolean breakHelper(String s, int start, List<String> wordDict, Set<Integer> cache){
        // Cache saves failed attempts
        if(cache.contains(start)){
            return false;
        }

        int length = s.length();
        // Finished reading the string
        if(start == length){
            return true;
        }

        for(int i=start+1; i<=length; i++){
            String word = s.substring(start, i);
            if(wordDict.contains(word) && breakHelper(s, i, wordDict, cache)){
                return true;
            }
        }

        cache.add(start);
        return false;
    }
}
