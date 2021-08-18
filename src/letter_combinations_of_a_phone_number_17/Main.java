package letter_combinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class Main {
    public static void main(String[] args){
        List<String> result = letterCombinations("2");
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    // map to save corresponding chars
    static Map<Character, char[]> map = new HashMap<>();

    static {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int length = digits.length();

        // no need to run the rest
        if(length == 0){
            return result;
        }

        // save char arrays need to use
        char[][] chars = new char[length][];
        // save char array length
        int[] maxes = new int[length];
        // save char array index currently working on
        int[] indexes = new int[length];

        // init these structures
        for(int i=0; i<length; i++){
            chars[i] = map.get(digits.charAt(i));
            maxes[i] = chars[i].length - 1;
            indexes[i] = 0;
        }

        do {
            // save current string
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < length; i++) {
                temp.append(chars[i][indexes[i]]);
            }
            result.add(temp.toString());
        } while (updateIndex(maxes, indexes, length) > 0);

        return result;
    }

    /*
        use to update index to form next string
        if finished all possible combinations, return -1 to end main process.
     */
    public static int updateIndex(int[] maxes, int[] indexes, int length){
        int index = length - 1;
        do{
            if(indexes[index] == maxes[index]){
                indexes[index] = 0;
                index--;
                if(index < 0){
                    return -1;
                }
            }else {
                indexes[index]++;
                return 1;
            }
        }while (true);
    }
}
