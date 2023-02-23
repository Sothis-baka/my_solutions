package word_ladder_ii_126;

import java.util.*;

/*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 */
public class Main {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Never reach
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }

        Map<String, List<List<String>>> routes = new HashMap<>();
        Set<String> unvisited = new HashSet<>(wordList);
        unvisited.add(beginWord);
        Set<String> candidates = new HashSet<>();

        // Initialize
        /* [[${beginWord}]] */
        List<String> first = new ArrayList<>();
        first.add(endWord);
        List<List<String>> outer = new ArrayList<>();
        outer.add(first);
        routes.put(endWord, outer);
        /* <endWord> */
        candidates.add(endWord);

        // Recursively go from distance 0 to higher until find the word or nothing (Search from end to start)
        while(!candidates.isEmpty()){
            Set<String> newCandidates = new HashSet<>();

            // Shouldn't visit lower distance words again
            for(String cur: candidates){
                unvisited.remove(cur);
            }

            for(String cur: candidates){
                // Find begin word, stop running
                if(cur.equals(beginWord)){
                    return routes.get(beginWord);
                }

                for(String next: unvisited){
                    // Distance of the word to the current one is 1
                    if(isAdjacent(cur, next)){
                        // Copy the paths to this one
                        List<List<String>> curRoute = routes.get(cur);
                        List<List<String>> route = new ArrayList<>();
                        for(List<String> temp: curRoute){
                            route.add(new ArrayList<>(temp));
                        }

                        // Add new word to the paths
                        for(List<String> list: route){
                            list.add(0, next);
                        }

                        // Save back to the map
                        if(routes.containsKey(next)){
                            routes.get(next).addAll(route);
                        }else{
                            routes.put(next, route);
                        }

                        newCandidates.add(next);
                    }
                }
            }

            // Update
            candidates = newCandidates;
        }

        // Not found
        return new ArrayList<>();
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
