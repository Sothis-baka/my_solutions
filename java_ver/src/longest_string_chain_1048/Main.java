package longest_string_chain_1048;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public int longestStrChain(String[] words) {
        int result = 0;

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> cache = new HashMap<>();

        // Iterate from shortest to longest
        for(String word: words){
            int max = 1;
            for(int i=0; i<word.length(); i++){
                // Try to remove a char
                String prev = word.substring(0, i) + word.substring(i + 1);
                // If exist, append the length by 1
                max = Math.max(max, 1 + cache.getOrDefault(prev, 0));
            }

            // Save to cache
            cache.put(word, max);
            // Update result
            result = Math.max(result, max);
        }

        return result;
    }


}
