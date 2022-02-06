package repeated_dna_sequences_187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

    For example, "ACGAATTCCG" is a DNA sequence.
    When studying DNA, it is useful to identify repeated sequences within the DNA.

    Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
 */
public class Main {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10){
            return new ArrayList<>();
        }

        Set<String> cache = new HashSet<>();
        Set<String> result = new HashSet<>();

        int length = s.length();
        StringBuilder strBf = new StringBuilder(s.substring(0, 10));
        String str;
        cache.add(strBf.toString());
        for(int i=10; i<length; i++){
            strBf.deleteCharAt(0);
            strBf.append(s.charAt(i));
            str = strBf.toString();
            if(!cache.add(str)){
                result.add(str);
            }
        }

        return new ArrayList<>(result);
    }
}
