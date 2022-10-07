package temp;

import java.util.*;

public class Main {
    public int deleteString(String s) {
        int length = s.length();

        /*
            gcd[i][j] = k means s[i, i + k] == s[j, j + k]
            if(k >= j - i), it means s[i, j] = s[j][2j - i]
         */
        int[][] gcd = new int[length + 1][length + 1];

        /*
            cache[i] = k means the max cut methods for i is k
         */
        int[] cache = new int[length];

        for(int i = length - 1; i >= 0; i--){
            cache[i] = 1;

            for(int j = i + 1; j < length; j++){
                if(s.charAt(i) == s.charAt(j)){
                    gcd[i][j] = gcd[i + 1][j + 1] + 1;

                    if(gcd[i][j] >= j - i)
                        cache[i] = Math.max(cache[i], 1 + cache[j]);
                }
            }
        }

        return cache[0];
    }


    public static void main(String[] args){
        System.out.println(new Main().deleteString("abcabcdabc"));
    }
}
