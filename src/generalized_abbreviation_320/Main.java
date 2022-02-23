package generalized_abbreviation_320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Write a function to generate the generalized abbreviations of a word.
    Example:
    Given word ="word", return the following list (order does not matter):
    ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/
public class Main {
    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        generateHelper(word, result);
        return result;
    }

    private static void generateHelper(String word, List<String> result){
        if(result.contains(word)){
            return;
        }

        // Save current one
        result.add(word);

        int length = word.length();
        for(int i=0; i<length; i++){
            char ch = word.charAt(i);
            if(ch > '9'){
                // It's a letter
                int count = 1;

                // Merge with the number on both sides (if it exists)
                StringBuilder newStr = new StringBuilder();
                int left = i - 1;
                while (left >= 0 && word.charAt(left) <= '9'){
                    left--;
                }
                count += myParseInt(word.substring(left + 1, i));
                newStr.append(word, 0, left + 1);

                int right = i + 1;
                while (right < length && word.charAt(right) <= '9'){
                    right++;
                }
                count += myParseInt(word.substring(i+1, right));
                newStr.append(count);
                newStr.append(word.substring(right));

                // Recursively run
                generateHelper(newStr.toString(), result);
            }
        }
    }

    private static int myParseInt(String s){
        if(s.isEmpty()){
            return 0;
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args){
        System.out.println(generateAbbreviations("word"));
    }
}
