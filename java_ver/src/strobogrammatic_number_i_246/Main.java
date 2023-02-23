package strobogrammatic_number_i_246;

import java.util.HashMap;
import java.util.Map;

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Write a function to determine if a number is strobogrammatic. The number is represented as a string.
    For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Main {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> cache = new HashMap<>();
        cache.put('0', '0');
        cache.put('1', '1');
        cache.put('6', '9');
        cache.put('8', '8');
        cache.put('9', '6');

        int left = 0, right = num.length()-1;
        while(left <= right){
            if(cache.get(num.charAt(left++)) != num.charAt(right++))    return false;
        }

        return true;
    }
}
