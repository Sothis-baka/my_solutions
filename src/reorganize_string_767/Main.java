package reorganize_string_767;

import java.util.PriorityQueue;

/*
    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
    Return any possible rearrangement of s or return "" if not possible.
 */
public class Main {
    public String reorganizeString(String s) {
        /*
            Iterate the array to count all characters.
            Sort the chars by their frequency using PriorityQueue
            Every time we poll of two chars, append the larger one first, then another.
            Add them back to the queue with count - 1 (if count still > 0).
            If there is only one chars available, append the char,
            If new count of the char is 0, finish the reorganization
            Otherwise there is no valid solution, return empty string.
         */
        // Init
        int[] counts = new int[26];
        PriorityQueue<Character> orderedChs = new PriorityQueue<>(
                (a, b) -> counts[b - 'a'] - counts[a - 'a']
        );

        // Count the chars
        for(char ch: s.toCharArray())
            counts[ch - 'a']++;

        // Save to priority queue
        for(int i=0; i<26; i++){
            if(counts[i] != 0)
                orderedChs.offer((char) (i + 'a'));
        }

        // Construct new string
        StringBuilder strBd = new StringBuilder();
        while (!orderedChs.isEmpty()){
            // Append 1st char
            char ch1 = orderedChs.poll();
            strBd.append(ch1);
            counts[ch1 - 'a']--;

            // There is only one char available
            if(orderedChs.isEmpty()){
                // There are letters left, no way to reorganize.
                if(counts[ch1 - 'a'] != 0) return "";
                // All finished
                break;
            }

            // Append 2nd char
            char ch2 = orderedChs.poll();
            strBd.append(ch2);
            counts[ch2 - 'a']--;

            if(counts[ch1 - 'a'] != 0) orderedChs.offer(ch1);
            if(counts[ch2 - 'a'] != 0) orderedChs.offer(ch2);
        }

        return  strBd.toString();
    }
}
