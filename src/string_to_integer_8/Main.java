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
        // remove no-use space
        s = s.trim();
        boolean pos = true;
        if(s.isEmpty()) return 0;
        else if(s.charAt(0) == '-'){
            pos = false;
            s = s.substring(1);
        }else if(s.charAt(0) == '+'){
            s = s.substring(1);
        }

        if(s.isEmpty()) return 0;
        int length = s.length();
        long result = 0;
        for(int i=0; i<length; i++){
            int digit = s.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;
            result = result * 10 + digit;

            if((pos ? result : - result) >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if((pos ? result : - result) <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        result = pos ? result : - result;
        return (int) result;
    }
}
