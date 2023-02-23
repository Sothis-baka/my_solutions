package valid_word_abbreviation_408;

import java.util.Arrays;

/*
    A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
    Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.
 */
public class Main {
    public boolean validWordAbbreviation(String word, String abbr) {
        return validator(word.toCharArray(), abbr.toCharArray(), 0, 0, false);
    }

    private boolean validator(char[] word, char[] abbr, int indexWord, int indexAbbr, boolean last){
        if(indexAbbr == abbr.length)
            return indexWord == word.length;

        if(indexWord >= word.length) return false;

        char target = abbr[indexAbbr];
        /* Not a substitution */
        if(target >= 'a'){
            if(word[indexWord] == target) return validator(word, abbr, indexWord + 1, indexAbbr + 1, false);
            return false;
        }

        /* No continuous substitution && No leading zero */
        if(last || target == '0') return false;

        int num = 0;
        while (abbr[indexAbbr] < 'a'){
            num *= 10;
            num += abbr[indexAbbr] - '0';
            indexAbbr++;

            /* Try to substitute this part */
            if(validator(word, abbr, indexWord + num, indexAbbr, true)) return true;
            if(indexAbbr >= abbr.length) break;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(new Main().validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
