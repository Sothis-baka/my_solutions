package happy_number_202;

import java.util.HashSet;
import java.util.Set;

/*
    Write an algorithm to determine if a number n is happy.

    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.
 */
public class Main {
    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<>();

        while (n != 1){
            if(cache.contains(n)){
                return false;
            }
            cache.add(n);

            int newNum = 0;
            while (n > 0){
                int remainder = n % 10;
                newNum += remainder * remainder;
                n /= 10;
            }
            n = newNum;
        }

        return true;
    }
}
