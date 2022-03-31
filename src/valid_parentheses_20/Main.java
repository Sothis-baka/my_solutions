package valid_parentheses_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
 */
public class Main {
    public static boolean isValid(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<length; i++){
            char cur = s.charAt(i);
            switch(cur){
                case '(', '[', '{' -> stack.push(cur);
                case ')' -> {
                    if(stack.isEmpty() || stack.pop()!='(') return false;
                }
                case ']' -> {
                    if(stack.isEmpty() || stack.pop()!='[') return false;
                }
                case '}' -> {
                    if(stack.isEmpty() || stack.pop()!='{') return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isValid("{[]}"));
    }
}
