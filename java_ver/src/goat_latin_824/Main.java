package goat_latin_824;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String[] words = sentence.split(" ");

        StringBuilder strBf = new StringBuilder();
        int pos = 1;
        for(String word: words){
            strBf.append(helper(word, pos++, vowels));
            strBf.append(' ');
        }
        strBf.deleteCharAt(strBf.length()-1);

        return strBf.toString();
    }

    private String helper(String word, int pos, Set<Character> vowels){
        if(vowels.contains(Character.toLowerCase(word.charAt(0)))){
            return word + "ma" + "a".repeat(pos);
        }else{
            return word.substring(1) + word.charAt(0) + "ma" + "a".repeat(pos);
        }
    }
}
