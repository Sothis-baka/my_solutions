package expression_add_operations_282;

import java.util.*;

/*
    Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.
    Note that operands in the returned expressions should not contain leading zeros.
 */
public class Main {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        int length = num.length();
        List<String> expr = new ArrayList<>();
        expr.add(num.charAt(0) + "");

        if(length == 1){
            if(num.charAt(0) - '0' == target){
                result.add(num);
            }
            return result;
        }

        String[] ops = {"*", "+", "-", ""};
        for(int i=1; i<length; i++){
            char curNum = num.charAt(i);
            List<String> newExpr = new ArrayList<>();
            for(String cur: expr){
                for(String op: ops){
                    if(cur.isEmpty() || !op.isEmpty()){
                        newExpr.add(cur + op + curNum);
                    }else{
                        int index = cur.length() - 1;
                        while(cur.charAt(index) == '0'){
                            index--;
                            if(index < 0){
                                break;
                            }
                        }

                        if(index >=0 && cur.charAt(index) > '0'){
                            newExpr.add(cur + op + curNum);
                        }
                    }
                }
            }
            expr = newExpr;
        }

        for(String str: expr){
            if(eval(str) == (long) target){
                result.add(str);
            }
        }

        return result;
    }

    private static long eval(String expr){
        int index = expr.length() - 1;
        while(expr.charAt(index) - '0' >= 0){
            if(--index < 0){
                return Long.parseLong(expr);
            }
        }

        long value = Long.parseLong(expr.substring(index + 1));

        switch(expr.charAt(index)){
            case '+' -> { return eval(expr.substring(0, index)) + value; }
            case '-' -> { return eval(expr.substring(0, index)) - value; }
            case '*' -> {
                int index2 = index - 1;
                while(expr.charAt(index2) - '0' >= 0){
                    if(--index2 < 0){
                        return Long.parseLong(expr.substring(0, index)) * value;
                    }
                }

                return eval(expr.substring(0, index2 + 1) + Long.parseLong(expr.substring(index2 + 1, index)) * value);
            }

            default -> { return -1; }
        }
    }

    public static void main(String[] args){
        System.out.println(addOperators("1000000009", 9));
    }
}
