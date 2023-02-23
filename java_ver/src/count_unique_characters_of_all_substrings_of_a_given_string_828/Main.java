package count_unique_characters_of_all_substrings_of_a_given_string_828;

import java.util.Arrays;

public class Main {
    public int uniqueLetterString(String s) {
        /*
            To sum the count of unique chars in all substrings,
            In the other word.
            For each char, find out in how many substrings it is unique.
         */
        int count = 0;

        // Use an array to save last appearance index for each char (A-Z).
        int[] indexes = new int[26];
        Arrays.fill(indexes, -1);
        // Use an array to save min start pos for each char (A-Z).
        int[] lasts = new int[26];
        Arrays.fill(lasts, -1);

        /*
            Iterate through the string
            For a char ch at index i,
            If it has appeared, for the previous ch at index indexes[ch],
            the max substring is [lasts[ch], i)
            The number of substrings for it is (i - indexes[ch]) * (indexes[ch] - lasts[ch])
         */
        int length = s.length();
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);

            // Count for indexes[ch]l
            if(indexes[ch - 'A'] != -1)
                count += (i - indexes[ch- 'A']) * (indexes[ch - 'A'] - lasts[ch - 'A']);

            lasts[ch - 'A'] = indexes[ch - 'A'];
            indexes[ch - 'A'] = i;
        }

        /*
            Count those not at the end
         */
        for(int i=0; i<26; i++){
            if(indexes[i] != -1)
                count += (length - indexes[i]) * (indexes[i] - lasts[i]);
        }

        return count;
    }

    public static void main(String[] args){
        System.out.println(new Main().uniqueLetterString("ABC"));
        System.out.println(new Main().uniqueLetterString("ABA"));
        System.out.println(new Main().uniqueLetterString("LEETCODE"));
    }
}
