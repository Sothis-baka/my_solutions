package divide_two_integers_29;

/*
    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
    Return the quotient after dividing dividend by divisor.

    Return the quotient after dividing dividend by divisor.
    if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1, and if the quotient is strictly less than -2^31, then return -2^31.
    2147483647, -2147483648
 */
public class Main {
    final static int MAX_N = 2147483647, MIN_N = -2147483648;

    public static int divide(int dividend, int divisor) {
        // No need to calculate cases
        if(dividend == 0){
            return 0;
        }
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            // Special case -2147483648 / -1
            if(dividend == MIN_N){
                return MAX_N;
            }else {
                return -dividend;
            }
        }

        // Negative symbol, turn positive into negative won't affect the number
        boolean neg = false;
        if(dividend < 0){
            neg = true;
        }else {
            dividend = -dividend;
        }
        if(divisor < 0){
            neg = !neg;
        }else {
            divisor = - divisor;
        }

        int result = quickDivide(dividend, divisor);

        return neg ? -result : result;
    }

    /* Recursive */
    public static int quickDivide(int a, int b){
        if(a > b){
            return 0;
        }

        int result = 1, curNum = b;
        // Prevent number exceeding bound
        if(curNum < -1073741824){
            return result;
        }

        // Logarithm increase
        int temp = curNum + curNum;
        while (a < temp){
            result += result;
            curNum = temp;
            // Prevent number exceeding bound
            if(curNum < -1073741824){
                return result + quickDivide(a-curNum, b);
            }
            temp = curNum + curNum;
        }

        return result + quickDivide(a-curNum, b);
    }

    public static void main(String[] args){
        System.out.println(divide(MIN_N, 2));
    }
}
