package reverse_integer_7;

import java.math.BigInteger;

/*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */

/*
    provided solution use % 10^? to add each digit :)
 */

public class Main {
    public static void main(String[] args){
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        boolean neg = false;
        long cpy = x;
        if(cpy < 0){
            neg = true;
            cpy = -cpy;
        }

        long result = 0;
        while(cpy > 0){
            int digit = (int) (cpy % 10);
            result = 10 * result + digit;
            cpy /= 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return neg ? (int) -result : (int) result;
    }
}
