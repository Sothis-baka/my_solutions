package string_to_integer_8;


/*
    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

    The algorithm for myAtoi(string s) is as follows:

    Read in and ignore any leading whitespace.
    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    Return the integer as the final result.
    Note:

    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class Main {
    public static void main(String[] args){
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        boolean negative = false;

        String temp = s.trim();
        if(temp.startsWith("+")){
            temp = temp.substring(1);
        }else if(temp.startsWith("-")){
            negative = true;
            temp = temp.substring(1);
        }

        if(temp.matches("\\d+(.*)")){
            return getDigits(temp, negative);
        }

        return 0;
    }

    public static int getDigits(String str, boolean negative){
        int value=0;

        int length = str.length();
        for(int i=0; i<length; i++){
            int cur = str.charAt(i) - '0';
            if(cur >=0 && cur <= 9){
                if(!negative && (value > 214748364 || (value == 214748364 && cur>7)))
                    return 2147483647;

                if(negative && (value > 214748364 || (value == 214748364 && cur>8)))
                    return -2147483648;

                value *= 10;
                value += cur;
            }else {
                break;
            }
        }

        return negative ? -value : value;
    }
}
