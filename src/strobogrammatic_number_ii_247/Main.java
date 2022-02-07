package strobogrammatic_number_ii_247;

import java.util.*;

/*
    A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    Find all strobogrammatic numbers that are of length = n.
    For example, Given n = 2, return ["11","69","88","96"].
 */
public class Main {
    public static List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();

        if(n == 0){
            return result;
        }else if(n == 1){
            result.add("0");
            result.add("1");
            result.add("8");

            return result;
        }

        int half = n / 2;

        int[] solo = {0, 1, 8};
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(6, 9);
        cache.put(8, 8);
        cache.put(9, 6);

        Stack<Integer> candidate = new Stack<>();
        candidate.add(1);
        candidate.add(6);
        candidate.add(8);
        candidate.add(9);

        for(int i=1; i<half; i++){
            Stack<Integer> newCandidate = new Stack<>();
            while(!candidate.isEmpty()){
                int cur = candidate.pop();
                for(int temp: cache.keySet()){
                    newCandidate.add(cur * 10 + temp);
                }
            }
            candidate = newCandidate;
        }

        if(n % 2 == 1){
            Stack<Integer> newCandidate = new Stack<>();
            while(!candidate.isEmpty()){
                int cur = candidate.pop();
                for(int temp: solo){
                    newCandidate.add(cur * 10 + temp);
                }
            }
            candidate = newCandidate;
        }

        while(!candidate.isEmpty()){
            StringBuilder strBd = new StringBuilder(candidate.pop().toString());
            for(int i=half-1; i>=0; i--){
                strBd.append(cache.get(strBd.charAt(i) - '0'));
            }
            result.add(strBd.toString());
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(findStrobogrammatic(0));
        System.out.println(findStrobogrammatic(1));
        System.out.println(findStrobogrammatic(2));
        System.out.println(findStrobogrammatic(3));
    }
}
