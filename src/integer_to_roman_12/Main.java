package integer_to_roman_12;

/*
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
    Given an integer, convert it to a roman numeral.
 */

public class Main {
    public static void main(String[] args){
        System.out.println(intToRoman(3999));
    }

    public static String intToRoman(int num) {
        int thousand = num / 1000, hundred = num % 1000 / 100, ten = num % 100 / 10, digit = num % 10;
        StringBuilder strBl = new StringBuilder();

        concat(strBl, thousand, 'M', ' ', ' ');
        concat(strBl, hundred, 'C', 'D', 'M');
        concat(strBl, ten, 'X', 'L', 'C');
        concat(strBl, digit, 'I', 'V', 'X');

        return strBl.toString();
    }

    public static void concat(StringBuilder strBl, int digit, char One, char Five, char Ten){
        if(digit < 4){
            strBl.append(String.valueOf(One).repeat(digit));
        }else if(digit == 4){
            strBl.append(One);
            strBl.append(Five);
        }else if(digit < 9){
            strBl.append(Five);
            strBl.append(String.valueOf(One).repeat(digit-5));
        }else{
            strBl.append(One);
            strBl.append(Ten);
        }
    }
}
