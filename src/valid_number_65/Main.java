package valid_number_65;

import java.util.regex.Pattern;

/*
    A valid number can be split up into these components (in order):
    A decimal number or an integer.
    (Optional) An 'e' or 'E', followed by an integer.
    A decimal number can be split up into these components (in order):

    (Optional) A sign character (either '+' or '-').
    One of the following formats:
    One or more digits, followed by a dot '.'.
    One or more digits, followed by a dot '.', followed by one or more digits.
    A dot '.', followed by one or more digits.
    An integer can be split up into these components (in order):

    (Optional) A sign character (either '+' or '-').
    One or more digits.
 */
public class Main {
    public static boolean isNumber(String s) {
        int index = s.indexOf('e');
        if(index < 0 ){
            index = s.indexOf('E');
        }
        if(index < 0){
            return isDecimal(s);
        }else{
            return isDecimal(s.substring(0, index)) && isInteger(s.substring(index+1));
        }
    }

    private static boolean isDecimal(String str){
        if(str.length() == 0){
            return false;
        }
        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            return Pattern.matches("(\\d+\\.?\\d*|\\d*\\.?\\d+|\\d+)", str.substring(1));
        }else{
            return Pattern.matches("(\\d+\\.?\\d*|\\d*\\.?\\d+|\\d+)", str);
        }

    }

    private static boolean isInteger(String str){
        if(str.length() == 0){
            return false;
        }
        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            return Pattern.matches("\\d+", str.substring(1));
        }else{
            System.out.println(str);
            return Pattern.matches("\\d+", str);
        }
    }

    public static void main(String[] args){
        System.out.println(isNumber("76.2"));
    }
}
