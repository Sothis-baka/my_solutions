package divide_two_integers_29;

/*
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
    Return the quotient after dividing dividend by divisor.

    Return the quotient after dividing dividend by divisor.
    if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1, and if the quotient is strictly less than -2^31, then return -2^31.
    2147483647, -2147483648
 */
public class Main {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean positive = (dividend > 0) == (divisor > 0);
        int result = 0, x;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend - divisor >= 0){
            for(x=0; dividend - (divisor << x << 1) >=0; x++);
            result += 1 << x;
            dividend -= divisor << x;
        }

        return positive ? result : -result;
    }

    public static void main(String[] args){
        System.out.println(new Main().divide(10, 3));
    }
}
