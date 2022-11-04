package remove_invalid_parentheses_301;

import java.util.*;

/*
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
    Return all the possible results. You may return the answer in any order.
 */
public class Main {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        // Use helper function to calculate the result
        dfsRemove(s, 0, 0, '(', ')', result);
        return result;
    }

    /*
        The part before start is balanced
        For the remain part, when it's not balanced, try to remove a parenthesis to make it balanced
        (Only close parenthesis is too much will cause a problem)
     */
    private void dfsRemove(String s, int start, int lastRemove, char openParenthesis, char closeParenthesis, List<String> result){
        int count = 0, length = s.length();
        for(int i=start; i<length; i++){
            if(s.charAt(i) == openParenthesis) count++;
            else if(s.charAt(i) == closeParenthesis) count--;

            // Invalid situation
            if(count < 0){
                // Try to remove a close parentheses at index j
                for(int j=lastRemove; j<=i; j++){
                    // We only remove a close parenthesis is the previous one isn't used in previous loop
                    if(s.charAt(j) == closeParenthesis && (j == lastRemove || s.charAt(j - 1) != closeParenthesis)) {
                        // Since we removed a char at j, i here is actually pointing to i+1 and j is pointing to j + 1 in new string
                        dfsRemove(s.substring(0, j) + s.substring(j+1), i, j, openParenthesis, closeParenthesis, result);
                    }
                }

                return;
            }
        }

        // Reached the end of the string
        // Do it reversely to check openParenthesis
        String reversed = new StringBuilder(s).reverse().toString();
        if(openParenthesis == '('){
            // it's not reversed yet, reverse it
            dfsRemove(reversed, 0, 0, closeParenthesis, openParenthesis, result);
        }else{
            // Finished both dir, reverse back and return
            result.add(reversed);
        }
    }

    public static void main(String[] args){
        System.out.println(new Main().removeInvalidParentheses("(a)())()"));
    }
}
