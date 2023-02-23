package minimize_xor_2429;

/*
    Given two positive integers num1 and num2, find the integer x such that:

    x has the same number of set bits as num2, and
    The value x XOR num1 is minimal.
    Note that XOR is the bitwise XOR operation.

    Return the integer x. The test cases are generated such that x is uniquely determined.

    The number of set bits of an integer is the number of 1's in its binary representation.
 */
public class Main {
    public int minimizeXor(int num1, int num2) {
        /*
            Find out how many 1 are contains in num2
            For binary representation of num1,
            from start to end, try to fill it with the same value

            if num1 has more 1s, change the remains to 0
            if num1 has less 1s, fill the 0s from end to start
         */

        int count = Integer.bitCount(num2), targetCount = Integer.bitCount(num1);
        String strNum1 = Integer.toBinaryString(num1);
        int length = strNum1.length();
        if(count >= length){
            // If count is even larger than length, return a value filled with 1
            return Integer.parseInt("1".repeat(count), 2);
        }

        StringBuilder strBd = new StringBuilder(strNum1);
        if(count > targetCount){
            /*
                We have more 1, from end to start, change some 0 to 1
             */
            int diff = count - targetCount;
            int index = length - 1;

            while (diff > 0){
                if(strBd.charAt(index) == '0') {
                    strBd.setCharAt(index, '1');
                    diff--;
                }

                index--;
            }
        }else if(count < targetCount){
            /*
                We don't have enough 1, from end to start, change some 1 to 0
             */

            int diff = targetCount - count ;
            int index = length - 1;

            while (diff > 0){
                if(strBd.charAt(index) == '1') {
                    strBd.setCharAt(index, '0');
                    diff--;
                }

                index--;
            }
        }

        return Integer.parseInt(strBd.toString(), 2);
    }
}
