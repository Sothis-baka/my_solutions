package evaluate_reverse_polish_notation_150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
    Note that division between two integers should truncate toward zero.
    It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 */
public class Main {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String temp: tokens){
            // Check if it's an integer or an operation
            if(temp.matches("-?\\d+")){
                // Save num to stack
                stack.push(Integer.valueOf(temp));
            }else{
                // Use last two value to do the operation then save the result
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(operation(num1, num2, temp));
            }
        }

        return stack.pop();
    }

    private static int operation(int num1, int num2, String op){
        return switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }

    public static void main(String[] args){
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
