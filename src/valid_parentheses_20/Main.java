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
        // Use list to save comparable parentheses
        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();

        left.add('(');
        left.add('{');
        left.add('[');

        right.add(')');
        right.add('}');
        right.add(']');

        // Use stack to save candidates
        Stack<Character> stack = new Stack<>();

        int length = s.length();
        for(int i=0; i<length; i++){
            char temp = s.charAt(i);

            if(left.contains(temp)){
                // Save lefts
                stack.push(temp);
            }else if(right.contains(temp)){
                // no candidate
                if(stack.size() == 0){
                    return false;
                }

                // Compare rights with saved lefts
                char correspond = stack.pop();
                if(left.indexOf(correspond) != right.indexOf(temp)){
                    return false;
                }
            }else {
                // Invalid character
                return false;
            }
        }

        return stack.size() <= 0;
    }

    public static void main(String[] args){
        System.out.println(isValid("{[]}"));
    }
}
