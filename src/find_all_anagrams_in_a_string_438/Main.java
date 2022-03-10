package find_all_anagrams_in_a_string_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<Integer> findAnagrams(String s, String p) {
        int length = s.length(), lengthP = p.length();
        int[] target = new int[26];
        int[] cache = new int[26];

        for(int i=0; i<lengthP; i++){
            target[p.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        for(int end = 0; end < length; end++){
            cache[s.charAt(end) - 'a']++;

            if(end - start + 1 > lengthP){
                cache[s.charAt(start++) - 'a']--;
            }

            if(Arrays.equals(cache, target)){
                result.add(start);
            }
        }

        return result;
    }
}
