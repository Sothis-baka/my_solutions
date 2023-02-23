package maximum_product_of_word_lengths_318;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public int maxProduct(String[] words) {
        int max = 0;
        // Use a set to save all words
        Map<Integer, Integer> cache = new HashMap<>();

        /*
            Save a word using bit mask
            For each word, check if previous contains a word without any same chars using unary &
         */
        for(String word: words){
            int val = mask(word);
            int length = word.length();
            for(int prev: cache.keySet()){
                if((val & prev) == 0)
                    max = Math.max(max, length * cache.get(prev));
            }
            // Only keep the longer string
            cache.put(val, Math.max(length, cache.getOrDefault(val, 0)));
        }

        return max;
    }

    private int mask(String s){
        int val = 0;
        for(char ch: s.toCharArray()){
            val |= (1 << (ch - 'a'));
        }
        return val;
    }
}
