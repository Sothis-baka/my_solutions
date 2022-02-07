package strobogrammatic_number_iii_248;

import java.util.HashMap;
import java.util.Map;

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
    Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 */
public class Main {
    public static int strobogrammaticInRange(String low, String high) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(6, 9);
        cache.put(8, 8);
        cache.put(9, 6);

        int[] count = {0};
        String[] candidates = {"", "0", "1", "8"};
        for(String temp: candidates){
            if(compareInts(temp, low) >= 0 && compareInts(temp, high) <= 0){
                count[0]++;
            }

            countHelper(temp, cache, low, high, count);
        }

        return count[0];
    }

    private static void countHelper(String cur, Map<Integer, Integer> cache, String low, String high, int[] count){
        for(int num: cache.keySet()){
            String next = num + cur + cache.get(num);

            if(next.charAt(0) != '0' && compareInts(next, low) >= 0 && compareInts(next, high) <= 0){
                count[0]++;
            }

            if(compareInts(next, high) >= 0){
                return;
            }

            countHelper(next, cache, low, high, count);
        }
    }

    private static int compareInts(String num, String target){
        // Either should be a valid integer.
        int l1 = num.length(), l2 = target.length();
        if(l1 < l2){
            return -1;
        }else if(l1 == l2){
            return num.compareTo(target);
        }else{
            return 1;
        }
    }

    public static void main(String[] args){
        System.out.println(strobogrammaticInRange("50", "100"));
    }
}
