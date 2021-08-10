package roman_to_integer_13;

import java.util.HashMap;

/*
    Share
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer
 */
public class Main {
    public static void main(String[] args){
        System.out.println(romanToInt("MCDLXXVI"));
    }

    public static int romanToInt(String s) {
        int length = s.length();
        if(length == 0){
            return 0;
        }

        if(s.startsWith("CM")){
            return  900 + romanToInt(s.substring(2));
        }else if(s.startsWith("CD")) {
            return 400 + romanToInt(s.substring(2));
        }else if(s.startsWith("XC")) {
            return 90 + romanToInt(s.substring(2));
        }else if(s.startsWith("XL")) {
            return 40 + romanToInt(s.substring(2));
        }else if(s.startsWith("IX")) {
            return 9 + romanToInt(s.substring(2));
        }else if(s.startsWith("IV")) {
            return 4 + romanToInt(s.substring(2));
        }else if(s.startsWith("M")) {
            return 1000 + romanToInt(s.substring(1));
        }else if(s.startsWith("D")) {
            return 500 + romanToInt(s.substring(1));
        }else if(s.startsWith("C")){
            return 100 + romanToInt(s.substring(1));
        }else if(s.startsWith("L")){
            return 50 + romanToInt(s.substring(1));
        }else if(s.startsWith("X")){
            return 10 + romanToInt(s.substring(1));
        }else if(s.startsWith("V")){
            return 5 + romanToInt(s.substring(1));
        }else if(s.startsWith("I")){
            return 1 + romanToInt(s.substring(1));
        }else {
            return 0;
        }
    }
}
