package fraction_to_recurring_decimal_166;

import java.util.HashMap;
import java.util.Map;

// So many edge cases = =

/*
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
    If the fractional part is repeating, enclose the repeating part in parentheses.
    If multiple answers are possible, return any of them.
    It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */
public class Main {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder strBd = new StringBuilder();

        strBd.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);

        long intPart = n / d;
        n %= d;

        strBd.append(intPart);
        if(n == 0){
            return strBd.toString();
        }

        strBd.append('.');

        Map<Long, Integer> map = new HashMap<>();
        long remainder;
        while(n != 0){
            n *= 10;
            remainder = n / d;
            strBd.append(remainder);
            n %= d;

            if(map.containsKey(n)){
                strBd.insert(map.get(n), "(");
                strBd.append(")");
                break;
            }else{
                map.put(n, strBd.length());
            }
        }
        
        return strBd.toString();
    }
}
