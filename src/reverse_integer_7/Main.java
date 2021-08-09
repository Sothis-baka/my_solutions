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
        StringBuilder strBl = new StringBuilder();
        String strNum = Integer.toString(x);

        if(x < 0){
            strNum = strNum.substring(1);
            strBl.append("-");
        }

        int length = strNum.length();
        for(int i=length-1; i>=0; i--){
            strBl.append(strNum.charAt(i));
        }

        BigInteger temp = new BigInteger(strBl.toString());
        if(temp.compareTo(new BigInteger("2147483647")) > 0 || temp.compareTo(new BigInteger("-2147483648")) < 0){
            return 0;
        }

        return temp.intValue();
    }
}
