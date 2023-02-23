package find_all_anagrams_in_a_string_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] target = new int[26], cur = new int[26];
        int lengthS = s.length(), lengthP = p.length();
        if(lengthS < lengthP) return result;

        // Count and save
        for(int i=0; i<lengthP; i++){
            target[p.charAt(i) - 'a']++;
            cur[s.charAt(i) - 'a']++;
        }

        // Base case
        if(Arrays.equals(target, cur)) result.add(0);
        int pos = lengthP;
        while(pos < lengthS){
            cur[s.charAt(pos - lengthP) - 'a']--;
            cur[s.charAt(pos++) - 'a']++;

            if(Arrays.equals(target, cur)) result.add(pos - lengthP);
        }

        return result;
    }
}
